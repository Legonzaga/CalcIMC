package com.infnet.calcimc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Dashboard : AppCompatActivity(    ) {

    var h: Double = 0.0
    var w: Double = 0.0
    var diagnostico: String = ""

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        var intent = getIntent()

        var extra = intent.getExtras()

        var email = extra?.get("user_email").toString()

        findViewById<TextView>(R.id.txtEmail).setText(email)


        var btn = findViewById<Button>(R.id.btn_calcular)

        btn?.setOnClickListener {

            var h = findViewById<EditText>(R.id.txtAltura).text.toString().toFloat()
            var w = findViewById<EditText>(R.id.txtPeso).text.toString().toFloat()

            this.calcular(h.toFloat(), w.toFloat())

            var diagnostico = findViewById<TextView>(R.id.txtDiagnostico)
            diagnostico.setText(this.diagnostico.toString())
        }
    }


    fun calcular(h: Float, w: Float) {

        var height = h / 100;

        var imc = w / height * height

        when(imc) {
            in 16.0f..16.9f -> this.diagnostico = "Queda de cabelo, infertilidade, ausência menstrual"
            in 17.0f..18.4f -> this.diagnostico = "Fadiga, stress, ansiedade"
            in 18.5f..24.9f -> this.diagnostico = "Menor risco de doenças cardíacas e vasculares"
            in 25.0f..29.9f -> this.diagnostico = "Fadiga, má circulação, varizes"
            in 25.0f..34.9f -> this.diagnostico = "Diabetes, angina, infarto, aterosclerose"
            in 35.0f..40.9f -> this.diagnostico = "Apneia do sono, falta de ar"
            else -> this.diagnostico = "Refluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC"

        }

    }



}