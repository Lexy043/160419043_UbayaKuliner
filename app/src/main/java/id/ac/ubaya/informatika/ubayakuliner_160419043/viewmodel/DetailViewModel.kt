package id.ac.ubaya.informatika.ubayakuliner_160419043.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.ubayakuliner_160419043.model.Review

class DetailViewModel(application: Application): AndroidViewModel(application) {
    val kulinerLD = MutableLiveData<List<Review>>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun detail(id:String){
        queue = Volley.newRequestQueue(getApplication())
        var url = "https://gist.githubusercontent.com/Lexy043/944803415827f9ee2c48b4e3e24ce67a/raw/e114904cbb7b8cb9a58224da68021f15f94c10d5/listKuliner.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val result = Gson().fromJson<Review>(response, Review::class.java)
                kulinerLD.value = listOf(result)
                Log.d("success : ", response.toString())
            },
            { response ->
                Log.d("error : ", response.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

}