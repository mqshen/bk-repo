package com.tencent.bkrepo.git.server

import java.io.IOException
import java.io.OutputStream
import java.util.zip.GZIPOutputStream
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.eclipse.jgit.util.HttpSupport
import org.eclipse.jgit.util.TemporaryBuffer

open class SmartOutputStream(
    private val req: HttpServletRequest,
    private val rsp: HttpServletResponse,
    private val compressStream: Boolean
) : TemporaryBuffer(LIMIT) {
    private var startedOutput = false

    @Throws(IOException::class)
    override fun overflow(): OutputStream {
        startedOutput = true
        var out: OutputStream = rsp.outputStream
        if (compressStream && acceptsGzipEncoding(req)) {
            rsp.setHeader(HttpSupport.HDR_CONTENT_ENCODING, HttpSupport.ENCODING_GZIP)
            out = GZIPOutputStream(out)
        }
        return out
    }

    @Throws(IOException::class)
    override fun close() {
        super.close()

        if (!startedOutput) {
            // If output hasn't started yet, the entire thing fit into our
            // buffer. Try to use a proper Content-Length header, and also
            // deflate the response with gzip if it will be smaller.
            if (256 < length() && acceptsGzipEncoding(req)) {
                if (gzipWriteResponse()) {
                    return
                }
            }
            writeResponse(this)
        }
    }

    @Throws(IOException::class)
    private fun writeResponse(out: TemporaryBuffer) {
        // The Content-Length cannot overflow when cast to an int, our
        // hardcoded LIMIT constant above assures us we wouldn't store
        // more than 2 GiB of content in memory.
        rsp.setContentLength(out.length().toInt())
        rsp.outputStream.use { os ->
            out.writeTo(os, null)
            os.flush()
        }
    }

    override fun flush() {
        doFlush()
    }

    private fun gzipWriteResponse(): Boolean {
        val gzbuf: TemporaryBuffer = Heap(LIMIT)
        try {
            GZIPOutputStream(gzbuf).use { gzip -> this.writeTo(gzip, null) }
            if (gzbuf.length() < length()) {
                rsp.setHeader(HttpSupport.HDR_CONTENT_ENCODING, HttpSupport.ENCODING_GZIP)
                writeResponse(gzbuf)
                return true
            }
        } catch (err: IOException) {
            // Most likely caused by overflowing the buffer, meaning
            // its larger if it were compressed. Discard compressed
            // copy and use the original.
        }
        return false
    }

    private fun acceptsGzipEncoding(req: HttpServletRequest): Boolean {
        return acceptsGzipEncoding(req.getHeader(HttpSupport.HDR_ACCEPT_ENCODING))
    }

    private fun acceptsGzipEncoding(accepts: String?): Boolean {
        if (accepts == null) return false
        var b = 0
        while (b < accepts.length) {
            val comma = accepts.indexOf(',', b)
            val e = if (0 <= comma) comma else accepts.length
            val term = accepts.substring(b, e).trim { it <= ' ' }
            if (term == HttpSupport.ENCODING_GZIP) return true
            b = e + 1
        }
        return false
    }

    companion object {
        private const val LIMIT = 32 * 1024
    }
}
