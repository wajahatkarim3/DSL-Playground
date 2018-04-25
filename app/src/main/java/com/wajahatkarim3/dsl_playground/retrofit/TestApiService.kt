package com.wajahatkarim3.dsl_playground.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface TestApiService
{
    @GET("anyApiMethod")
    fun anyApiMethod(

    ) : Call<String>
}