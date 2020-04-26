package com.example.inspiringperson

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val adapter = PersonAdapter()
    companion object {
        const val REQUEST_PERSON: Int = 5
        const val KEY_NAME: String = "name"
        const val KEY_DESCR: String = "descr"
        const val KEY_DATE: String = "date"
        const val KEY_IMG: String = "img"
        const val DEFAULT_IMG = "https://www.securityindustry.org/wp-content/uploads/sites/3/2018/05/noimage.png"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpUi()
    }

    private fun setUpUi() {
        recycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))
        displayData()
        insertPersonBtn.setOnClickListener{loadInsertActivity()}
    }

    private fun loadInsertActivity() {
        val displayIntent = Intent(this, AddPersonActivity::class.java)
        startActivityForResult(displayIntent, REQUEST_PERSON)
    }

    private fun displayData() {
        recycler.adapter = adapter
        adapter.refreshData(InspiringPersonRepository.persons)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_PERSON -> { if(resultCode==Activity.RESULT_OK)createPerson(data)
            }
        }
    }

    private fun createPerson(data: Intent?) {
        var persons = InspiringPersonRepository.persons

        val newPerson = Person(persons.size,data?.getStringExtra(KEY_NAME)?:"undefined",
            data?.getStringExtra(KEY_DATE)?:"undefined",
            data?.getStringExtra(KEY_DESCR)?:"undefined",
            data?.getStringExtra(KEY_IMG),
            listOf("New users doesn't have quote")
        )

        InspiringPersonRepository.add(newPerson)

        adapter.refreshData(InspiringPersonRepository.persons)

    }


}
