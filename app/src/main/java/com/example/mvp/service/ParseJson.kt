package com.example.mvp.service

import com.example.mvp.models.Products
import com.example.mvp.models.ProductsEntry
import com.example.mvp.utils.Constants
import org.json.JSONObject

class ParseJson {
    private fun parseJsonProduct(jsonObject: JSONObject): Products =
        jsonObject.run {
            Products(
                getInt(ProductsEntry.ID),
                getString(ProductsEntry.TITLE),
                getString(ProductsEntry.IMAGE_URL)
            )
        }


    fun parseJsonArray(jsonObject: JSONObject): MutableList<Products> {
        val result: MutableList<Products> = mutableListOf()
        jsonObject.getJSONArray(Constants.GET_DATA).let { array ->
            for (it in 0 until array.length()) {
                result.add(parseJsonProduct(array.getJSONObject(it)))
            }
        }
        return result
    }
}
