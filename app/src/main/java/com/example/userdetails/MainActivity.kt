package com.example.userdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button)
        //val editTxt = findViewById<EditText>(R.id.editText)
        val editTxt: Int = findViewById<EditText>(R.id.editText).text.toString().toInt()

            button?.setOnClickListener()
        {
            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(API::class.java)
            val retrofitData = retrofitBuilder.getData()
            retrofitData.enqueue(object: Callback<List<UsersDataItem>?>{
                override fun onResponse(
                    call: Call<List<UsersDataItem>?>,
                    response: Response<List<UsersDataItem>?>
                ) {
                    val responseBody = response.body()!!
                    for (data in responseBody){
                        if (data.id == editTxt ){

                        }
                    }
                }

                override fun onFailure(call: Call<List<UsersDataItem>?>, t: Throwable) {

                }
            })
             }

    }

}