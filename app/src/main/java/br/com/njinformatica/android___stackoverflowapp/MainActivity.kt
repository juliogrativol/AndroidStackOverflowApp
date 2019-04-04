package br.com.njinformatica.android___stackoverflowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupListeners()
    }

    private fun setupListeners(){

        btn_ok.setOnClickListener {
            startActivity(Intent(this, QuestionListActivity::class.java).apply {
                putExtra("TAGGED", text_tagged.text.toString())
            })
        }
    }
}
