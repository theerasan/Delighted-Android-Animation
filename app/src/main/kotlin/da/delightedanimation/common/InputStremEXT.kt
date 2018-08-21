package da.delightedanimation.common

import android.util.Log
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.StringWriter

fun InputStream.toJsonString(): String {
    val writer = StringWriter()
    val buffer = CharArray(1024)

    try {
        val reader = BufferedReader(InputStreamReader(this, "UTF-8"))
        var n: Int = reader.read(buffer)
        while (n != -1) {
            writer.write(buffer, 0, n)
            n = reader.read(buffer)
        }
    } catch (err: Exception) {
        Log.e("Input Stream Error", err.message)
    } finally {
        this.close()
    }

    return writer.toString()
}
