package com.example.mecanumcarbtcontrol

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity)

        val lottieAnimationView = findViewById<LottieAnimationView>(R.id.AVStart)
        lottieAnimationView.setOnClickListener {
            startAnimationAndNavigateToMainMenu()
        }
    }

    private fun startAnimationAndNavigateToMainMenu() {
        val lottieAnimationView = findViewById<LottieAnimationView>(R.id.AVStart)
        lottieAnimationView.playAnimation()

        lottieAnimationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}

            override fun onAnimationEnd(animation: Animator) {
                navigateToMainMenu()
            }

            override fun onAnimationCancel(animation: Animator) {}

            override fun onAnimationRepeat(animation: Animator) {}
        })
    }

    private fun navigateToMainMenu() {
        val intent = Intent(this, MainMenu::class.java)
        startActivity(intent)
    }
}


