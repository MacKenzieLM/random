package com.example.assessmentapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        
        val datetime = Calendar.getInstance().time
        val date0 = datetime.toString()
        val Datetime = dateTime as TextView
        Datetime.text = date0

    }

    var fullNumber = ""
    var userDescription = ""


    fun change(v: View) {
        val randomInteger1 = (0..9).random().toString()
        val randomInteger2 = (0..9).random().toString()
        val randomInteger3 = (0..9).random().toString()
        val randomInteger4 = (0..9).random().toString()
        val randomInteger5 = (0..9).random().toString()
        val randomInteger6 = (0..9).random().toString()
        val randomInteger7 = (0..9).random().toString()
        val randomInteger8 = (0..9).random().toString()

        val int1 = randomInteger1 + randomInteger2
        val int2 = randomInteger3 + randomInteger4
        val int3 = randomInteger5 + randomInteger6
        val int4 = randomInteger7 + randomInteger8


        val num1 = bubbleOne as TextView
        num1.text = int1

        val num2 = bubbleTwo as TextView
        num2.text = int2

        val num3 = bubbleThree as TextView
        num3.text = int3

        val num4 = bubbleFour as TextView
        num4.text = int4

        fullNumber = int1 + "-" + int2 + "-" + int3 + "-" + int4
    }

    fun navigateToPage2(v: View) {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    fun generate(v: View) {
        val fileName = "password.txt"
        val dirName = Environment.DIRECTORY_DOCUMENTS
        val myDir = File("sdcard", dirName)

        val datetime = Calendar.getInstance().time
        val date0 = datetime.toString()

        userDescription = textDescription.text.toString()

        val contentToWrite = "Date Saved: " + date0 + "\n" +
         "Description: " + userDescription + "\n" +
         "Passcode: " + fullNumber + "\n\n"

        if(!myDir.exists())
            myDir.mkdirs()


        val myFile = File(myDir, fileName)

        try {
            val fileWriter = FileWriter(myFile, true)
            fileWriter.append(contentToWrite)
            fileWriter.flush()
            fileWriter.close()
        }
            catch (e: IOException) {
            e.printStackTrace()
        }
        Snackbar.make(v, "Data Saved", Snackbar.LENGTH_SHORT).show()
    }
}
