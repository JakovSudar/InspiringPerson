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
            returnPerson()
        }
    }

    private fun returnPerson() {
        val name = newName.text.toString()
        val date = newDate.text.toString()
        val descr = newDescription.text.toString()
        val img = newImage.text.toString()

        if(name.isNotBlank() && date.isNotBlank() && descr.isNotBlank()){
            val resultIntent = Intent()
            resultIntent.putExtra(MainActivity.KEY_NAME,name)
            resultIntent.putExtra(MainActivity.KEY_DATE,date)
            resultIntent.putExtra(MainActivity.KEY_DESCR,descr)
            resultIntent.putExtra(MainActivity.KEY_IMG,img)

            this.setResult(Activity.RESULT_OK,resultIntent)
            this.finish()

        }
        else Toast.makeText(this,"Empty field!",Toast.LENGTH_SHORT).show()
    }
}
