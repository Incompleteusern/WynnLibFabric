package io.github.nbcss.wynnlib.registry

import com.google.gson.JsonObject
import io.github.nbcss.wynnlib.items.Powder

object PowderRegistry: Registry<Powder>() {
    override fun read(data: JsonObject): Powder? = try {
        Powder(data)
    }catch (e: Exception){
        e.printStackTrace()
        null
    }
}