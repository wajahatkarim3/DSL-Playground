package com.wajahatkarim3.dsl_playground

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.wajahatkarim3.dsl_playground.articles.ArticleBuilder
import retrofit2.Retrofit
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import com.wajahatkarim3.dsl_playground.retrofit.RetrofitCallback
import com.wajahatkarim3.dsl_playground.retrofit.TestApiService
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRetrofit()

        articlePlayground()
        retrofitPlaygroun()
    }

    fun articlePlayground()
    {
       var articleBuilder = ArticleBuilder()

        articleBuilder {
            title = "Hello Title"
            addParagraph {
                body = "My Paragraph Body"
                imageUrl = "hello.image.url.com"
            }
        }

    }

    fun retrofitPlaygroun()
    {
        var call = retrofit.create(TestApiService::class.java).anyApiMethod()
        call.enqueue(
            RetrofitCallback {
                onSuccessCallback{ call, response ->

                }
                onFailureCallback { call, t ->

                }
            }
        )
    }

    fun initRetrofit()
    {
        val gson = GsonBuilder()
                .setLenient()
                .create()

        retrofit = Retrofit.Builder()
                .baseUrl("baseurl/goes/here/com")
                .client(OkHttpClient.Builder().build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

    }

}
