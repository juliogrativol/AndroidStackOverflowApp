package br.com.njinformatica.android___stackoverflowapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.njinformatica.android___stackoverflowapp.R
import br.com.njinformatica.android___stackoverflowapp.model.Item
import java.text.SimpleDateFormat
import java.util.*

class QuestionAdapter(param: (Any) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var items = listOf<Item>()

    override fun getItemCount() = items.size

    fun setData(list: List<Item>){
        items = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val card = LayoutInflater.from(parent.context)
            .inflate(R.layout.question_card, parent,false)
        return NewsViewHolder(card)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        val sdf= SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

        if (holder is NewsViewHolder){
            holder.titleTextView.text = item.title
            holder.isAnswered.text = item.is_answered.toString()
            holder.linkTextView.text = item.link
            holder.tagsTextView.text = item.tags.toString()
            holder.dataTextView.text = sdf.format(Date(item.creation_date))
        }
    }

    inner class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val titleTextView = itemView.findViewById<TextView>(R.id.text_candidate)
        val isAnswered = itemView.findViewById<TextView>(R.id.text_respondido)
        val linkTextView = itemView.findViewById<TextView>(R.id.text_link)
        val tagsTextView = itemView.findViewById<TextView>(R.id.text_tags)
        val dataTextView = itemView.findViewById<TextView>(R.id.text_data)
    }
}