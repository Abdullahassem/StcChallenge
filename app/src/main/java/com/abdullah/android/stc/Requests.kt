package com.abdullah.android.stc

import retrofit2.http.GET
import retrofit2.Call

interface Requests{
    @GET("b/60001f6b68f9f835a3df0803")
    fun fetch():Call<Objects>
}