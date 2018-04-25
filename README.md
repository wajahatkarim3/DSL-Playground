# DSL-Playground
An experimental playground to learn about DSL in kotlin

### Retrofit

Before DSL, (Traditional Way)

```kotlin
  var call = retrofit.create(MyApiService::class.java).anyTestApi("param1", "param2")
  call.enqueue(object : Callback<String>{
    
        override fun onResponse(call: Call<String>?, response: Response<String>?) {
            // Do anything with response here
        }
        
        override fun onFailure(call: Call<String>?. throwable: Throwable?){
            throwable?.printStackTrace()
            // Do anything here with error
        }
  })
```

After Kotlin DSL by adding [RetrofitCallback](https://github.com/wajahatkarim3/DSL-Playground/blob/master/app/src/main/java/com/wajahatkarim3/dsl_playground/retrofit/RetrofitCallback.kt) class in your project

```kotlin
    var call = retrofit.create(MyApiService::class.java).anyTestApi("param1", "param2")
    call.enqueue( RetrofitCallback {
        
        onSuccessCallback { call, response ->
            // Do anything with response here
        }
        
        onFailureCallback { call, throwable ->
            throwable?.printStackTrace()
            // Do anything here with error
        }
    })
```
