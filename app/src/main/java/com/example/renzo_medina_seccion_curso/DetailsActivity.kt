package com.example.renzo_medina_seccion_curso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        //Creamos nuestro tooblar y lo seteamos
        val toolsbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.mytoolbar)
        setSupportActionBar(toolsbar)
        //Activar Up Botton
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)


        //extraemos nuestros datos enviados desde AdapterProduct
        val name = intent.getStringExtra("Name")
        val image = intent.getIntExtra("Image",0)
        val model = intent.getStringExtra("Model")
        val price = intent.getStringExtra("Price")

        //obtener los id desde el layout
        val textName = findViewById<TextView>(R.id.textName)
        val textImage = findViewById<ImageView>(R.id.image_detail)
        val textModel = findViewById<TextView>(R.id.textModel)
        val textPrice = findViewById<TextView>(R.id.textPrice)


        //seteamos nuestro variables
        textName.text = name
        textModel.text = model
        textPrice.text = "$ ${price.toString()}"
        textImage.setImageResource(image)

    }
}