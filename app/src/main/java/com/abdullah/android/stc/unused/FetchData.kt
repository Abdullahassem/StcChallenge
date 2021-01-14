package com.abdullah.android.stc.unused

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abdullah.android.stc.Objects
import com.abdullah.android.stc.Politician
import com.abdullah.android.stc.Requests
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class FetchData {
    val retrofit:Retrofit=Retrofit.Builder()
        .baseUrl("https://api.jsonbin.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val requests: Requests =retrofit.create(Requests::class.java)

    fun fetchData():LiveData<List<Politician>>{
        val responseLiveData:MutableLiveData<List<Politician>> = MutableLiveData()

        requests.fetch().enqueue(
            object:Callback<Objects>{
                override fun onResponse(call: Call<Objects>, response: Response<Objects>) {
                    responseLiveData.value=response.body()?.objects
                }

                override fun onFailure(call: Call<Objects>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            }
        )
        return responseLiveData
    }
}