package br.com.njinformatica.android___stackoverflowapp.api

import br.com.njinformatica.android___stackoverflowapp.model.QuestionsResponseObject
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by jthomaz on 29/03/2019.
 */
interface StackOverflowAPI {

    @GET("questions")
    fun getItems(@Query("order") order: String, @Query("sort") sort: String, @Query("tagged") tagged: String, @Query("site") site: String ): Call<QuestionsResponseObject>
}