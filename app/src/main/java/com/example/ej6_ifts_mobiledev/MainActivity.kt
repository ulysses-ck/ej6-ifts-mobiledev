package com.example.ej6_ifts_mobiledev

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    /* Una organizaci ́on no gubernamental premia a sus colaboradores de acuerdo a la cantidad de donaciones que han
    logrado captar. El supervisor ingresa el nombre del colaborador y la cantidad de donaciones que logr ́o.
    Aquel colaborador que ha logrado donaciones superiores a los $25000, recibe una compensaci ́on “A”. Si recibe
    entre $25000 y $15000 recbie la compensaci ́on “B”. Por otra parte, si consigi ́o menos de $15000 y hasta $5000
    recibir ́a la bonificaci ́on “C”. Finalmente si consigue menos de $5000 no recibe compensaci ́on alguna. Indicar que
    compensaci ́on recibir ́a cada colaborador de acuerdo a las donaciones que logr ́o captar. */

    private lateinit var nameCollaboratorEditText: EditText
    private lateinit var donationsEditText: EditText
    private lateinit var compensationTextView: TextView
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nameCollaboratorEditText = findViewById(R.id.nameCollaboratorEditText)
        donationsEditText = findViewById(R.id.donationsEditText)
        compensationTextView = findViewById(R.id.compensationTextView)
        calculateButton = findViewById(R.id.calculateButton)

        calculateButton.setOnClickListener() {
            val nameCollaborator = nameCollaboratorEditText.text.toString()
            val donations = donationsEditText.text.toString().toDouble()

            val compensation = when {
                donations > 25000 -> "A"
                donations in 15000.0..25000.0 -> "B"
                donations in 5000.0..15000.0 -> "C"
                else -> "None"
            }

            compensationTextView.text = "${nameCollaborator}'s Compensation: ${compensation}"
        }
    }
}