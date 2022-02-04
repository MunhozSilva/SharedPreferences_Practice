package com.example.sharedpreferencespractice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.makeText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Verify if the app has been already opened
        if (helloApp()) {
            helloMessage()
            isOldUser()
        }
    }

    // Just to check if is the first time on the app
    private fun helloApp(): Boolean {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        return sharedPref.getBoolean("KEY", true)
    }

    // Show a toast message
    private fun helloMessage() {
        makeText(this, "Hello, welcome to the App!", Toast.LENGTH_SHORT).show()
    }

    // Change the boolean on sharedPreference
    private fun isOldUser() {
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE)
        with (sharedPref.edit()) {
            putBoolean("KEY", false)
            commit()
        }
    }
}