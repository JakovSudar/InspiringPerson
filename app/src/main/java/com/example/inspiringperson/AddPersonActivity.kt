package com.example.inspiringperson

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_person.*

class AddPersonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)
        setUpUi()
    }

    private fun setUpUi() {
        addBtn.setOnClickListener(){
            createPerson()
        }
    }
    private fun createPerson() {
        val name = newName.text.toString()
        val date = newDate.text.toString()
        val descr = newDescription.text.toString()
        val img = newImage.text.toString()
        val quotes = newQuotes.text.toString().split(";")
        if(name.isNotBlank() && date.isNotBlank() && descr.isNotBlank()){
            val person = Person(InspiringPersonRepository.persons.size,name,date,descr,img, quotes)
            InspiringPersonRepository.add(person)
            this.setResult(Activity.RESULT_OK)
            this.finish()
        }
        else Toast.makeText(this,"Empty field!",Toast.LENGTH_SHORT).show()
    }
}
