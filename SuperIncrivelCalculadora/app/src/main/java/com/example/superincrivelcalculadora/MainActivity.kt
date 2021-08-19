package com.example.superincrivelcalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etValor1: EditText = findViewById(R.id.etValor1)
        val etValor2: EditText = findViewById(R.id.etValor2)
        val tvResultadoCalculo: TextView = findViewById(R.id.tvResultadoCalculo)

        val btSoma: Button = findViewById(R.id.btSoma)
        val btSubtracao: Button = findViewById(R.id.btSubtracao)
        val btMultiplicacao: Button = findViewById(R.id.btMultiplicacao)
        val btDivisao: Button = findViewById(R.id.btDivisao)

        btSoma.setOnClickListener() {
            tvResultadoCalculo.text = calcular(R.id.btSoma, etValor1.text.toString().toDouble(), etValor2.text.toString().toDouble()).toString()
        }

        btSubtracao.setOnClickListener() {
            tvResultadoCalculo.text = calcular(R.id.btSubtracao, etValor2.text.toString().toDouble(), etValor1.text.toString().toDouble()).toString()
        }

        btMultiplicacao.setOnClickListener() {
            tvResultadoCalculo.text = calcular(R.id.btMultiplicacao, etValor1.text.toString().toDouble(), etValor2.text.toString().toDouble()).toString()
        }

        btDivisao.setOnClickListener() {
            tvResultadoCalculo.text = calcular(R.id.btDivisao, etValor2.text.toString().toDouble(), etValor1.text.toString().toDouble()).toString()
        }
    }

    fun calcular(idOperacao: Int, valor1: Double, valor2: Double): Double {
        val resultado = when (idOperacao) {
            R.id.btSoma -> valor1.plus(valor2)
            R.id.btDivisao -> valor1.div(valor2)
            R.id.btMultiplicacao -> valor1.times(valor2)
            else -> valor1.minus(valor2)
        }
        return resultado
    }
}