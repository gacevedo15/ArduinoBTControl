package com.example.mecanumcarbtcontrol

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.airbnb.lottie.LottieAnimationView

class CarControllerWithButtons : ComponentActivity() {

    //Variables para controlar el estado del switch
    private var switchONOFF = false
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
        //Controlamos la animación con setOnClickListener
        switchAnimationView.setOnClickListener {
            // Cambiamos el valor del switch y actualizamos la animación correspondiente
            switchONOFF = !switchONOFF
            animationRes = if (switchONOFF) R.raw.switchon else R.raw.switchoff
            switchAnimationView.setAnimation(animationRes)
            switchAnimationView.playAnimation()
            //Toast que muestre "encendido" o "apagado" según el valor del switch
            val toastText = if (switchONOFF) "Encendido" else "Apagado"
            Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show()
            myBluetooth.sendCommand(toastText)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        myBluetooth.closeConnection()
    }

    fun onBack(view: View) {
        finish()
    }

    fun onRotateClockwise(view: View) {
        Toast.makeText(this, "Rotate Clockwise", Toast.LENGTH_SHORT).show()
        myBluetooth.sendCommand("Rotate Clockwise")
    }

    fun onDriftLeft(view: View) {
        Toast.makeText(this, "Drift Left", Toast.LENGTH_SHORT).show()
        myBluetooth.sendCommand("Drift Left")
    }

    fun onDriftRight(view: View) {
        Toast.makeText(this, "Drift Right", Toast.LENGTH_SHORT).show()
        myBluetooth.sendCommand("Drift Right")
    }

    fun onRotateCounterClockwise(view: View) {
        Toast.makeText(this, "Rotate Counter Clockwise", Toast.LENGTH_SHORT).show()
        myBluetooth.sendCommand("Rotate Counter Clockwise")
    }

    fun onUpLeft(view: View) {
        Toast.makeText(this, "Up Left", Toast.LENGTH_SHORT).show()
        myBluetooth.sendCommand("Up Left")
    }

    fun onUp(view: View) {
        Toast.makeText(this, "Up", Toast.LENGTH_SHORT).show()
        myBluetooth.sendCommand("Up")
    }

    fun onUpRight(view: View) {
        Toast.makeText(this, "Up Right", Toast.LENGTH_SHORT).show()
        myBluetooth.sendCommand("Up Right")
    }

    fun onLeft(view: View) {
        Toast.makeText(this, "Left", Toast.LENGTH_SHORT).show()
        myBluetooth.sendCommand("Left")
    }

    fun onAuto(view: View) {
        Toast.makeText(this, "Auto", Toast.LENGTH_SHORT).show()
        myBluetooth.sendCommand("Auto")
    }

    fun onRight(view: View) {
        Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show()
        myBluetooth.sendCommand("Right")
    }

    fun onDownLeft(view: View) {
        Toast.makeText(this, "Down Left", Toast.LENGTH_SHORT).show()
        myBluetooth.sendCommand("Down Left")
    }

    fun onDown(view: View) {
        Toast.makeText(this, "Down", Toast.LENGTH_SHORT).show()
        myBluetooth.sendCommand("Down")
    }

    fun onDownRight(view: View) {
        Toast.makeText(this, "Down Right", Toast.LENGTH_SHORT).show()
        myBluetooth.sendCommand("Down Right")
    }


}