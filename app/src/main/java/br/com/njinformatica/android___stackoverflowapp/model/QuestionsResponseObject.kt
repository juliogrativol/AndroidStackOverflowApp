package br.com.njinformatica.android___stackoverflowapp.model

import com.google.gson.annotations.SerializedName

class QuestionsResponseObject(@SerializedName("items")
                              var items: List<Item>) {
}

class Item(var is_answered:Boolean, var title:String, var link:String, var creation_date:Long, var tags : List<String>) {

}

