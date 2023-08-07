package com.example.mecanumcarbtcontrol

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.airbnb.lottie.LottieAnimationView

class CarControllerWithButtons : ComponentActivity() {

    //Variables para controlar el estado del switch
    private var switchONOFF = true
    private lateinit var switchAnimationView: LottieAnimationView
    private var animationRes = if (switchONOFF) R.raw.switchoff else R.raw.switchon

    //Variables para controlar el envío de datos por bluetooth
    lateinit var myBluetooth:BluetoothLibrary


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mecanum_car_controller_with_buttons)

        myBluetooth = BluetoothLibrary(this)
        myBluetooth.onBluetooth()

        // Inicializar la vista de animación Lottie y configurar la animación
        switchAnimationView = findViewById(R.id.AVSwitchONOFF)
        setupSwitchAnimation()

    }

    private fun setupSwitchAnimation() {
        //Controlar la animacion con clickListener
        switchAnimationView.setOnClickListener {
            // Cambiar el valor del switch y actualizar la animación correspondiente
            switchONOFF = !switchONOFF
            animationRes = if (switchONOFF) R.raw.switchoff else R.raw.switchon
            switchAnimationView.setAnimation(animationRes)
            switchAnimationView.playAnimation()
            //Toast que muestre "encendido" o "apagado" según el valor del switch
            val toastText = if (!switchONOFF) "Encendido" else "Apagado"
            Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show()
        }
    }



    override fun onDestroy() {
        super.onDestroy()
    }

    fun onBack(view: View) {
        finish()
    }

    fun onRotateClockwise(view: View) {
        Toast.makeText(this, "Rotate Clockwise", Toast.LENGTH_SHORT).show()
    }

    fun onDriftLeft(view: View) {
        Toast.makeText(this, "Drift Left", Toast.LENGTH_SHORT).show()
    }

    fun onDriftRight(view: View) {
        Toast.makeText(this, "Drift Right", Toast.LENGTH_SHORT).show()
    }

    fun onRotateCounterClockwise(view: View) {
        Toast.makeText(this, "Rotate Counter Clockwise", Toast.LENGTH_SHORT).show()
    }

    fun onUpLeft(view: View) {
        Toast.makeText(this, "Up Left", Toast.LENGTH_SHORT).show()
    }

    fun onUp(view: View) {
        Toast.makeText(this, "Up", Toast.LENGTH_SHORT).show()
        myBluetooth.sendCommand("w")
        //Toast que muestre el comando enviado
        Toast.makeText(this, "w enviado", Toast.LENGTH_SHORT).show()
    }

    fun onUpRight(view: View) {
        Toast.makeText(this, "Up Right", Toast.LENGTH_SHORT).show()
    }

    fun onLeft(view: View) {
        Toast.makeText(this, "Left", Toast.LENGTH_SHORT).show()
    }

    fun onAuto(view: View) {
        Toast.makeText(this, "Auto", Toast.LENGTH_SHORT).show()
    }

    fun onRight(view: View) {
        Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show()
    }

    fun onDownLeft(view: View) {
        Toast.makeText(this, "Down Left", Toast.LENGTH_SHORT).show()
    }

    fun onDown(view: View) {
        Toast.makeText(this, "Down", Toast.LENGTH_SHORT).show()
    }

    fun onDownRight(view: View) {
        Toast.makeText(this, "Down Right", Toast.LENGTH_SHORT).show()
    }


}