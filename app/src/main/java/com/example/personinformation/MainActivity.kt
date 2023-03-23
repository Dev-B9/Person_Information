package com.example.personinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var informationUser: TextView? = null


    var nameUser: EditText?=null
    var ageUser: EditText?=null
    var dniUser: EditText?=null
    var telUser: EditText?=null
    var dirUser: EditText?=null
    var emailUser: EditText?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarComponentes()
    }

    private fun iniciarComponentes() {

        nameUser = findViewById(R.id.PersonName)
        ageUser = findViewById(R.id.PersonAge)
        dniUser = findViewById(R.id.PersonDni)
        telUser = findViewById(R.id.PersonTel)
        dirUser = findViewById(R.id.PersonDir)
        emailUser = findViewById(R.id.PersonEmail)

        val miBtn: Button = findViewById(R.id.btnShow)
        miBtn.setOnClickListener{showInfo()}

    }

    private fun showInfo() {
        var ageInformation = ""
        informationUser = findViewById(R.id.showInfoUser)

        var name = nameUser?.text.toString()
        var age = ageUser?.text.toString().toInt()
        var dni = dniUser?.text.toString()
        var tel = telUser?.text.toString()
        var dir = dirUser?.text.toString()
        var email = emailUser?.text.toString()


        if(age <0){
            Toast.makeText(this,"Ingrese Una Edad Valida", Toast.LENGTH_SHORT).show()
            age=0
        }
        else if(age >=0 && age <= 15){
            ageInformation ="$name es un Infante"
        }else if(age>15 && age <=18){
            ageInformation ="$name es un Adolescente"
        }else if(age>18 && age <=65){
            ageInformation ="$name es un Adulto"
        }else if(age >65){
            ageInformation ="$name es un Adulto Mayor"
        }

        Toast.makeText(this,"$ageInformation", Toast.LENGTH_SHORT).show()

        informationUser!!.text ="Bienvenido: $name \n" +
                "Edad: $age\n" +
                "Documento: $dni\n" +
                "Telefono: $tel\n" +
                "Direccion: $dir\n" +
                "Email: $email"

    }
}