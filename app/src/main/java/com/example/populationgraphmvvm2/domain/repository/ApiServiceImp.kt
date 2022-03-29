package com.example.populationgraphmvvm2.domain.repository

import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.example.populationgraphmvvm2.data.data_source.ApiService
import com.example.populationgraphmvvm2.domain.model.Data
import org.json.JSONArray
import org.json.JSONTokener
import javax.inject.Inject

class ApiServiceImp @Inject constructor(private val queue: RequestQueue) : ApiService {
    override fun getDataList(): ArrayList<Data> {
        var list = emptyList<Data>() as ArrayList<Data>
        val url = "https://datausa.io/api/data?drilldowns=Nation&measures=Population"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                // Display the first 500 characters of the response string.
                Log.i("Response", "onCreate: ${response}")

                val jsonArray = JSONTokener(response).nextValue() as JSONArray
                for (i in 0 until jsonArray.length()) {

                    val id_N = jsonArray.getJSONObject(i).getString("ID Nation")
                    val id_Y = jsonArray.getJSONObject(i).getInt("ID Year")
                    val nation = jsonArray.getJSONObject(i).getString("Nation")
                    val population = jsonArray.getJSONObject(i).getInt("Population")
                    val sn = jsonArray.getJSONObject(i).getString("Slug Nation")
                    val year = jsonArray.getJSONObject(i).getString("Year")

                    list.add(Data(id_N, id_Y, nation, population, sn, year))

                }


            },
            {
                Log.i("Response", "Error:")

            })

        queue.add(stringRequest)
        return list;

    }
}