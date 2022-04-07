package id.ac.ubaya.informatika.ubayakuliner_160419043.viewmodel

import android.os.Bundle
import android.app.Application
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.ubayakuliner_160419043.R
import id.ac.ubaya.informatika.ubayakuliner_160419043.model.Review

class ListViewModel(application: Application): AndroidViewModel(application){
    val reviewLD = MutableLiveData<List<Review>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        loadingLD.value = true
        loadingErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Review>>() { }.type
                val result = Gson().fromJson<List<Review>>(it, sType)
                reviewLD.value = result

                loadingLD.value = false
                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                loadingErrorLD.value = false
                loadingLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)

        val review1 = Review(
            "Kantin Keluwih",
            "Di dekat fakultas Teknik",
            "Kantin yang sering disebut kantin teknik yang sering ramai pada jam siang.",
            "https://media-cdn.tripadvisor.com/media/photo-s/1a/b8/46/6d/london-stock.jpg"
        )

        reviewLD.value = arrayListOf<Review>(review1)
        loadingErrorLD.value = false
        loadingLD.value = true
    }
}