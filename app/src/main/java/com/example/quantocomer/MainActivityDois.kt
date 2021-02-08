package com.example.quantocomer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import java.nio.channels.AlreadyBoundException
import java.text.DecimalFormat
import kotlin.math.round

class MainActivityDois : AppCompatActivity() {

    fun alert(msg:String) {
        Toast.makeText(applicationContext,msg,Toast.LENGTH_LONG).show();
    }

    lateinit var caloriasTotais:TextView;
    lateinit var carboidratos:TextView;
    lateinit var gordura:TextView;
    lateinit var proteina:TextView;
    lateinit var btn:Button;
    lateinit var tmbV:TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dois)

        val intent: Intent = Intent(intent)
        val recebe: Bundle? = intent.extras

        carboidratos = findViewById(R.id.Carboidratos)
        gordura = findViewById(R.id.Gorduras)
        proteina = findViewById(R.id.Proteinas)
        caloriasTotais = findViewById(R.id.caloriasTotais)
        tmbV = findViewById(R.id.tmb)




        btn = findViewById(R.id.btnVoltar) as Button;

        if (recebe != null) {

            var qtdProteinaG:Double;
            var qtdCarboidra:Double;
            var qtdGordura:Double;

            val peso = recebe.getDouble("peso");
            val op:Int = recebe.getInt("op")
            val opatvd = recebe.getInt("opatvd")
            val dec = DecimalFormat("###.###")
            val altura:Double = recebe.getDouble("altura")
            val idade:Int = recebe.getInt("idade")
            val sx = recebe.getInt("sx")
            /*Calorias Totais*/

            //Sedentario
            if (opatvd == 1) {
                if (sx == 1) {
                    //MANTER PESO
                    if (op == 1) {
                        val tmbH = (66 + (13.7 * peso) + (5 * altura)) - (6.8 * idade);
                        tmbV.text = round(tmbH).toString()
                        caloriasTotais.text = dec.format(round(tmbH * 1.2)).toString()
                        val calT = round(tmbH * 1.2);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                        //Ganhar
                    } else if (op == 2) {
                        val tmbH = (66 + (13.7 * peso) + (5 * altura)) - (6.8 * idade);
                        tmbV.text = round(tmbH).toString()
                        caloriasTotais.text = dec.format(round(tmbH * 1.2) + (15.011 / 100 * (tmbH * 1.2))).toString()
                        val calT = round(tmbH * 1.2);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    } else if (op == 3) {
                        val tmbH = (66 + (13.7 * peso) + (5 * altura)) - (6.8 * idade);
                        tmbV.text = round(tmbH).toString()
                        caloriasTotais.text = dec.format(round(tmbH * 1.2) - (15.011 / 100 * (tmbH * 1.2))).toString()
                        val calT = round(tmbH * 1.2);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    }
                } else if (sx == 2) {
                    if (op == 1) {
                        val tmbM = (655 + (9.6 * peso) + (1.8 * altura)) - (4.7 * idade);
                        tmbV.text = round(tmbM).toString()
                        caloriasTotais.text = dec.format(round(tmbM * 1.2)).toString()
                        val calT = round(tmbM * 1.2);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    } else if (op == 2) {
                        val tmbM = (655 + (9.6 * peso) + (1.8 * altura)) - (4.7 * idade);
                        tmbV.text = round(tmbM).toString()
                        caloriasTotais.text = dec.format(round(tmbM * 1.2) + (15.011 / 100 * (tmbM * 1.2))).toString()
                        val calT = round(tmbM * 1.2);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    } else if (op == 3) {
                        val tmbM = (655 + (9.6 * peso) + (1.8 * altura)) - (4.7 * idade);
                        tmbV.text = round(tmbM).toString()
                        caloriasTotais.text = dec.format(round(tmbM * 1.2) - (15.011 / 100 * (tmbM * 1.2))).toString()
                        val calT = round(tmbM * 1.2);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    }
                }

                //Atleta infrequente
            } else if (opatvd == 2) {
                if (sx == 1) {
                    //MANTER PESO
                    if (op == 1) {
                        val tmbH = (66 + (13.7 * peso) + (5 * altura)) - (6.8 * idade);
                        tmbV.text = round(tmbH).toString()
                        caloriasTotais.text = dec.format(round(tmbH * 1.375)).toString()
                        val calT = round(tmbH * 1.375);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                        //Ganhar
                    } else if (op == 2) {
                        val tmbH = (66 + (13.7 * peso) + (5 * altura)) - (6.8 * idade);
                        tmbV.text = round(tmbH).toString()
                        caloriasTotais.text = dec.format(round(tmbH * 1.375) + (15.011 / 100 * (tmbH * 1.375))).toString()
                        val calT = round(tmbH * 1.375);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    } else if (op == 3) {
                        val tmbH = (66 + (13.7 * peso) + (5 * altura)) - (6.8 * idade);
                        tmbV.text = round(tmbH).toString()
                        caloriasTotais.text = dec.format(round(tmbH * 1.375) - (15.011 / 100 * (tmbH * 1.375))).toString()
                        val calT = round(tmbH * 1.375);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    }
                } else if (sx == 2) {
                    if (op == 1) {
                        val tmbM = (655 + (9.6 * peso) + (1.8 * altura)) - (4.7 * idade);
                        tmbV.text = round(tmbM).toString()
                        caloriasTotais.text = dec.format(round(tmbM * 1.375)).toString()
                        val calT = round(tmbM * 1.375);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    } else if (op == 2) {
                        val tmbM = (655 + (9.6 * peso) + (1.8 * altura)) - (4.7 * idade);
                        tmbV.text = round(tmbM).toString()
                        caloriasTotais.text = dec.format(round(tmbM * 1.375) + (15.011 / 100 * (tmbM * 1.375))).toString()
                        val calT = round(tmbM * 1.375);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                   } else if (op == 3) {
                        val tmbM = (655 + (9.6 * peso) + (1.8 * altura)) - (4.7 * idade);
                        tmbV.text = round(tmbM).toString()
                        caloriasTotais.text = dec.format(round(tmbM * 1.375) - (15.011 / 100 * (tmbM * 1.375))).toString()
                        val calT = round(tmbM * 1.375);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    }
                }

                //Resistência
            } else if (opatvd == 3) {
                if (sx == 1) {
                    //MANTER PESO
                    if (op == 1) {
                        val tmbH = (66 + (13.7 * peso) + (5 * altura)) - (6.8 * idade);
                        tmbV.text = round(tmbH).toString()
                        caloriasTotais.text = dec.format(round(tmbH * 1.550)).toString()
                        val calT = round(tmbH * 1.550);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                        //Ganhar
                    } else if (op == 2) {
                        val tmbH = (66 + (13.7 * peso) + (5 * altura)) - (6.8 * idade);
                        tmbV.text = round(tmbH).toString()
                        caloriasTotais.text = dec.format(round(tmbH * 1.550) + (15.011 / 100 * (tmbH * 1.550))).toString()
                        val calT = round(tmbH * 1.550);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    } else if (op == 3) {
                        val tmbH = (66 + (13.7 * peso) + (5 * altura)) - (6.8 * idade);
                        tmbV.text = round(tmbH).toString()
                        caloriasTotais.text = dec.format(round(tmbH * 1.550) - (15.011 / 100 * (tmbH * 1.550))).toString()
                        val calT = round(tmbH * 1.550);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    }
                } else if (sx == 2) {
                    if (op == 1) {
                        val tmbM = (655 + (9.6 * peso) + (1.8 * altura)) - (4.7 * idade);
                        tmbV.text = round(tmbM).toString()
                        caloriasTotais.text = dec.format(round(tmbM * 1.550)).toString()
                        val calT = round(tmbM * 1.550);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"

                    } else if (op == 2) {
                        val tmbM = (655 + (9.6 * peso) + (1.8 * altura)) - (4.7 * idade);
                        tmbV.text = round(tmbM).toString()
                        caloriasTotais.text = dec.format(round(tmbM * 1.550) + (15.011 / 100 * (tmbM * 1.550))).toString()
                        val calT = round(tmbM * 1.550);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    } else if (op == 3) {
                        val tmbM = (655 + (9.6 * peso) + (1.8 * altura)) - (4.7 * idade);
                        tmbV.text = round(tmbM).toString()
                        caloriasTotais.text = dec.format(round(tmbM * 1.550) - (15.011 / 100 * (tmbM * 1.550))).toString()
                        val calT = round(tmbM * 1.550);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    }
                }

                //Esportes
            } else if (opatvd == 4) {
                if (sx == 1) {
                    //MANTER PESO
                    if (op == 1) {
                        val tmbH = (66 + (13.7 * peso) + (5 * altura)) - (6.8 * idade);
                        tmbV.text = round(tmbH).toString()
                        caloriasTotais.text = dec.format(round(tmbH * 1.725)).toString()
                        val calT = round(tmbH * 1.725);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                        //Ganhar
                    } else if (op == 2) {
                        val tmbH = (66 + (13.7 * peso) + (5 * altura)) - (6.8 * idade);
                        tmbV.text = round(tmbH).toString()
                        caloriasTotais.text = dec.format(round(tmbH * 1.725) + (15.011 / 100 * (tmbH * 1.725))).toString()
                        val calT = round(tmbH * 1.725);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    } else if (op == 3) {
                        val tmbH = (66 + (13.7 * peso) + (5 * altura)) - (6.8 * idade);
                        tmbV.text = round(tmbH).toString()
                        caloriasTotais.text = dec.format(round(tmbH * 1.725) - (15.011 / 100 * (tmbH * 1.725))).toString()
                        val calT = round(tmbH * 1.725);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    }
                } else if (sx == 2) {
                    if (op == 1) {
                        val tmbM = (655 + (9.6 * peso) + (1.8 * altura)) - (4.7 * idade);
                        tmbV.text = round(tmbM).toString()
                        caloriasTotais.text = dec.format(round(tmbM * 1.725)).toString()
                        val calT = round(tmbM * 1.725);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    } else if (op == 2) {
                        val tmbM = (655 + (9.6 * peso) + (1.8 * altura)) - (4.7 * idade);
                        tmbV.text = round(tmbM).toString()
                        caloriasTotais.text = dec.format(round(tmbM * 1.725) + (15.011 / 100 * (tmbM * 1.725))).toString()
                        val calT = round(tmbM * 1.725);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    } else if (op == 3) {
                        val tmbM = (655 + (9.6 * peso) + (1.8 * altura)) - (4.7 * idade);
                        tmbV.text = round(tmbM).toString()
                        caloriasTotais.text = dec.format(round(tmbM * 1.725) - (15.011 / 100 * (tmbM * 1.725))).toString()
                        val calT = round(tmbM * 1.725);
                        proteina.text = dec.format(round(0.3* calT)).toString() + "Cal\n${dec.format(round((0.3* calT) / 4))}g"
                        carboidratos.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 4))}g"
                        gordura.text = dec.format(round(0.35* calT)).toString() + "Cal\n${dec.format(round((0.35* calT) / 9))}g"
                    }
                }
            }

            btn.setOnClickListener {
                val intent:Intent = Intent(this, MainActivity::class.java);
                startActivity(intent)
            }
          }

    }
}
