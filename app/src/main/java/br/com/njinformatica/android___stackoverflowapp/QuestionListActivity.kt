package br.com.njinformatica.android___stackoverflowapp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.njinformatica.android___stackoverflowapp.adapter.QuestionAdapter
import br.com.njinformatica.android___stackoverflowapp.viewmodel.QuestionViewModel
import kotlinx.android.synthetic.main.activity_question_list.*

class QuestionListActivity : AppCompatActivity() {

    private lateinit var questionViewModel: QuestionViewModel
    private lateinit var tagged : String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_list)
        tagged = intent.getStringExtra("TAGGED")

        questionViewModel = ViewModelProviders.of(this)
            .get(QuestionViewModel::class.java)

        setupRecyclerView()
        subscribe()
    }

    private fun setupRecyclerView(){
        val columns = if(resources.configuration.orientation
            == Configuration.ORIENTATION_PORTRAIT) 1
        else 1

        session_candidate_rc_list.layoutManager = StaggeredGridLayoutManager(columns,
            StaggeredGridLayoutManager.VERTICAL)//LinearLayoutManager(this)
        session_candidate_rc_list.adapter = QuestionAdapter{ question->

        }
        questionViewModel.getData(tagged)
    }

    private fun subscribe() {
        questionViewModel.message.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        questionViewModel.questionList.observe(this, Observer {list->
            val adapter = session_candidate_rc_list.adapter as? QuestionAdapter
            adapter?.setData(list)
        })

        questionViewModel.isLoading.observe(this, Observer {
            if (it){
                progressBarCandidateList.visibility = View.VISIBLE
            } else {
                progressBarCandidateList.visibility = View.GONE
            }
        })
    }
}
