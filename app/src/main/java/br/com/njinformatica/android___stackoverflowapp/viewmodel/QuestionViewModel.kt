package br.com.njinformatica.android___stackoverflowapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.njinformatica.android___stackoverflowapp.api.StackOverflowAPI
import br.com.njinformatica.android___stackoverflowapp.model.Item
import br.com.njinformatica.android___stackoverflowapp.model.QuestionsResponseObject
import br.com.njinformatica.android___stackoverflowapp.provider.RetrofitProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionViewModel : ViewModel() {
    val message: MutableLiveData<String> = MutableLiveData()
    val isLoading = MutableLiveData<Boolean>()
    val questionList = MutableLiveData<List<Item>>()

    val easyVoteApi: StackOverflowAPI = RetrofitProvider.stackOverflowAPI

    fun getData(tagged: String){
        isLoading.value = true

        val call = easyVoteApi.getItems("desc", "activity", tagged, "stackoverflow")
        call.enqueue(object : Callback<QuestionsResponseObject> {
            override fun onFailure(call: Call<QuestionsResponseObject>, t: Throwable) {
                isLoading.value = false
            }
            override fun onResponse(call: Call<QuestionsResponseObject>, response: Response<QuestionsResponseObject>) {
                if (response.isSuccessful){
                    response.body()?.let {questionsResponseObject->
                        if (questionsResponseObject.items.size > 0)
                            questionList.value = questionsResponseObject.items
                        else
                            message.value = "Não foram encontradas questões."
                    }
                }else{
                    message.value = "Falha ao obter questões."
                }

                isLoading.value = false
            }
        })
    }
}