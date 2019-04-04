package br.com.njinformatica.android___stackoverflowapp.provider

import br.com.njinformatica.android___stackoverflowapp.api.StackOverflowAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by jthomaz on 29/03/2019.
 */
object  RetrofitProvider {
    private const val BASE_URL = "https://api.stackexchange.com/2.2/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val stackOverflowAPI = retrofit.create(StackOverflowAPI::class.java)
}