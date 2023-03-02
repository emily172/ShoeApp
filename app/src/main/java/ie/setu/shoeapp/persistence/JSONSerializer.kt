package ie.setu.shoeapp.persistence


import android.os.Environment
import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver

import ie.setu.shoeapp.models.ShoeModel
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class JSONSerializer(private val file: File) : Serializer {
    @Throws(Exception::class)
    override fun read(): Any {
        val xStream = XStream(JettisonMappedXmlDriver())
        xStream.allowTypes(arrayOf(ShoeModel::class.java))
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)
        val theFile: File = File(path, "/$file")
        val inputStream = xStream.createObjectInputStream(FileReader(theFile))
        val obj = inputStream.readObject() as Any
        inputStream.close()
        return obj
    }

    @Throws(Exception::class)
    override fun write(obj: Any?) {
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)
        val theFile: File = File(path, "/$file")
        val xStream = XStream(JettisonMappedXmlDriver())
        val outputStream = xStream.createObjectOutputStream(FileWriter(theFile))
        outputStream.writeObject(obj)
        outputStream.close()
    }
}

