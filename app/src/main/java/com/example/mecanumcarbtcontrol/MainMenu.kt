package com.example.mecanumcarbtcontrol

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

    }

    fun onCarControllerWithButtons(view: View) {
        val intent = Intent(this, CarControllerWithButtons::class.java)
        startActivity(intent)
    }

    fun onCarControllerWithJoystick(view: View) {
        val intent = Intent(this, CarControllerWithJoystick::class.java)
        startActivity(intent)
    }

}

