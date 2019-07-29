package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Números

        bt0.setOnClickListener { agregar("0",true) }
        bt1.setOnClickListener { agregar("1",true) }
        bt2.setOnClickListener { agregar("2",true) }
        bt3.setOnClickListener { agregar("3",true) }
        bt4.setOnClickListener { agregar("4",true) }
        bt5.setOnClickListener { agregar("5",true) }
        bt6.setOnClickListener { agregar("6",true) }
        bt7.setOnClickListener { agregar("7",true) }
        bt8.setOnClickListener { agregar("8",true) }
        bt9.setOnClickListener { agregar("9",true) }

        //Punto

        btPunto.setOnClickListener { agregar(".",true) }


        //Operaciones

        btSumar.setOnClickListener { agregar("+",false) }
        btRestar.setOnClickListener { agregar("-",false) }
        btMultiplicar.setOnClickListener { agregar("*",false) }
        btDivirdir.setOnClickListener { agregar("/",false)}

        // Parentesis

        btOpen.setOnClickListener { open("(")}

        btClose.setOnClickListener { close(")") }

        // Borrar

        btClear.setOnClickListener {
            tvResultado.text=""
            tvEntrada.text=""
        }

        // Borrar 1

        btBorrar1.setOnClickListener {

            val cadena = tvEntrada.text.toString()

            if(cadena.isNotEmpty()){
                tvEntrada.text = cadena.substring(0,cadena.length-1)
            }

            tvResultado.text=""
        }

        //Igual

        btIgual.setOnClickListener {

            try {

                val expression = ExpressionBuilder(tvEntrada.text.toString()).build()
                val resultado = expression.evaluate()

                    tvResultado.text = resultado.toString()

            }catch (error:Exception){
                    tvResultado.text = ""
            }
        }

    }

    fun agregar (string: String,limpiar:Boolean){

        if(tvResultado.text.isNotEmpty()){

            tvEntrada.text= ""
        }

        if(limpiar){

            tvResultado.text= ""
            tvEntrada.append(string)
        }

        else{

            tvEntrada.append(tvResultado.text)
            tvEntrada.append(string)
            tvResultado.text= ""
        }
    }

    fun open (string: String){

        if(tvResultado.text.isNotEmpty()){

            tvEntrada.text= ""
            tvEntrada.append(string)
            tvEntrada.append(tvResultado.text)
            tvResultado.text= ""

        }
        else{
            tvResultado.text= ""
            tvEntrada.append(string)

        }

    }

    fun close (string: String){

        if(tvResultado.text.isNotEmpty()){

        }

        else{
            tvResultado.text= ""
            tvEntrada.append(string)
        }
    }

}