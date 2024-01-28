package com.example.renzo_medina_seccion_curso

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdapterProduct: BaseAdapter{

    //declar un contexto
    var contexto : Context? = null

    //lista
    var dataList = ArrayList<ItemProduct>()


    //constru
    constructor(
        contexto: Context,
        lista : ArrayList<ItemProduct>,


    ):super(){
        this.contexto = contexto
        this.dataList = lista

    }

    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(p0: Int): Any {
        return dataList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(
        p0: Int,
        p1: View?,
        p2: ViewGroup?)
        : View {

        var vistaDato = p1
        val datos = dataList[p0]

        if (vistaDato == null) {
            val inflator = LayoutInflater.from(contexto)
            vistaDato = inflator.inflate(R.layout.item_produc, null)
        }

        val imagen = vistaDato?.findViewById<View>(R.id.itemImage) as ImageView
        val texto = vistaDato.findViewById<View>(R.id.itemText) as TextView
        imagen.setImageResource(datos.image)
        texto.text = datos.name

        imagen.setOnClickListener {
            val intento = Intent(contexto, DetailsActivity::class.java).apply {
                putExtra("Name", datos.name)
                putExtra("Image", datos.image)
                putExtra("Model", datos.model)
                putExtra("Price", datos.price.toString())
            }
            contexto?.startActivity(intento)
        }
        return vistaDato
    }
}

