package com.wajahatkarim3.dsl_playground.retrofit

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitCallback<T>(initMethod: RetrofitCallback<T>.() -> Unit) : Callback<T> {

    private var onFailureCallback: (call: Call<T>?, throwable: Throwable?) -> Unit = { _, _ -> }
    private var onSuccessCallback: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        onFailureCallback(call, t)
    }

    override fun onResponse(call: Call<T>?, response: Response<T>?) {

    }

    fun onFailureCallback( function: (call: Call<T>?, throwable: Throwable?) -> Unit)
    {
        onFailureCallback = function
    }

    fun onSuccessCallback( function: (call: Call<T>?, response: Response<T>?) -> Unit)
    {
        onSuccessCallback = function
    }

    init {
        initMethod()
    }


}