package com.example.assessmentapplication

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun navigateToPage1(v: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun load(v: View) {
        val verticalLayout = DataList as LinearLayout
        val item1 = TextView(this)

        val fileName = "password.txt"
        val dirName = Environment.DIRECTORY_DOCUMENTS
        val myDir = File("sdcard", dirName)

        val myFile = File(myDir, fileName)

        val file = FileReader(myFile)
        val reader = BufferedReader(file)

        val info = file.toString()
        item1.text = info
        verticalLayout.addView(item1)


    }

}