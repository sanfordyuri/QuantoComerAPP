package com.example.quantocomer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    fun alert(msg:String) {
      Toast.makeText(applicationContext,msg,Toast.LENGTH_LONG).show();
    }

    lateinit var campoPeso: EditText;
    lateinit var btt: Button;
    lateinit var btt2: Button;
    lateinit var manter:RadioButton;
    lateinit var ganhar:RadioButton;
    lateinit var perder:RadioButton;
    lateinit var sedentario: RadioButton;
    lateinit var atletaInfrequente: RadioButton
    lateinit var resistenciaa: RadioButton
    lateinit var esportes: RadioButton
    lateinit var altura:EditText;
    lateinit var idade:EditText;
    lateinit var masculino:RadioButton;
    lateinit var feminino:RadioButton;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manter = findViewById(R.id.Manter);
        ganhar = findViewById(R.id.resistencia);
        perder = findViewById(R.id.Perder);

        masculino = findViewById(R.id.Masculino)
        feminino = findViewById(R.id.Feminino)

        sedentario = findViewById(R.id.Sedentario)
        atletaInfrequente = findViewById(R.id.atletaInfrequente)
        resistenciaa = findViewById(R.id.resistenciaa)
        esportes = findViewById(R.id.Esportes)

        campoPeso = findViewById(R.id.peso);
        campoPeso = findViewById(R.id.peso) as EditText;
        btt = findViewById(R.id.btn);

        altura = findViewById(R.id.altura)
        idade = findViewById(R.id.idade)


        btt.setOnClickListener {

            var sx = 0
            try {
                var op:Int = 0
                var opatvd:Int = 0

                if (!(manter.isChecked || ganhar.isChecked || perder.isChecked)) {
                    alert("Você deve preencher tudo!")
                } else {
                    if (!(sedentario.isChecked || atletaInfrequente.isChecked || resistenciaa.isChecked || esportes.isChecked)) {
                        alert("Você deve preencher tudo!")
                    } else {
                        if (!(masculino.isChecked || feminino.isChecked)) {
                            alert("Você deve preencher tudo!")
                        } else {

                            if (masculino.isChecked) {
                                sx = 1
                            } else if (feminino.isChecked) {
                                sx = 2
                            }

                            if (manter.isChecked) {
                                op = 1
                            } else if (ganhar.isChecked) {
                                op = 2
                            } else if (perder.isChecked) {
                                op = 3
                            } else {
                                println("Selecione uma opção")
                            }
                            if (sedentario.isChecked) {
                                opatvd = 1
                            } else if(atletaInfrequente.isChecked) {
                                opatvd = 2
                            } else if (resistenciaa.isChecked) {
                                opatvd = 3
                            } else if (esportes.isChecked) {
                                opatvd = 4
                            } else {
                                println("Selecione uma opção")
                            }

                            val intent:Intent = Intent(this, MainActivityDois::class.java);
                            val peso:Double = campoPeso.text.toString().toDouble();
                            val b = Bundle()
                            b.putDouble("peso", peso);
                            b.putInt("op", op)
                            b.putInt("opatvd", opatvd)
                            b.putInt("idade", idade.text.toString().toInt())
                            b.putDouble("altura", altura.text.toString().toDouble())
                            b.putInt("sx", sx)
                            intent.putExtras(b)
                            startActivity(intent)
                        }
                    }
                }
            } catch (e: NumberFormatException) {
                alert("Você deve preencher tudo!")
            }
        }

    }
}
