package com.example.renzo_medina_seccion_curso

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.constraintlayout.widget.ConstraintSet.Layout

class MainActivity : AppCompatActivity() {

    //creación de lista
    var listData = ArrayList<ItemProduct>()
    var adaptador: AdapterProduct? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listData.add(ItemProduct("Cámara de seguridad Anran", R.drawable.product_01, "N50W1584 Wireless con resolución de 5MP visión nocturna incluida blanca", 45.488f))
        listData.add(ItemProduct("Cámara de seguridad Hikvision ", R.drawable.product_02, "DS-2CE16D0T-EXIPF 2.8mm con resolución de 2MP visión nocturna incluida blanca", 11.921f))
        listData.add(ItemProduct("Cámara de seguridad Shenzhen ", R.drawable.product_03, "A9 Mini con resolución de 1080p visión nocturna incluida negra", 3.966f))
        listData.add(ItemProduct("Kit Profesional Hikvision ", R.drawable.product_04, "8 Camara Exterior Fhd 1080p Dd 1tb", 247.499f))
        listData.add(ItemProduct("Cable Para Camaras Seguridad", R.drawable.product_05, "Cctv Video Y Poder Bnc 30 Mts", 6.899f))
        listData.add(ItemProduct("Dvr 16 Canales Dahua", R.drawable.product_06, "Full Hd Lite P2p Camaras Fivehibrid", 89.999f))
        listData.add(ItemProduct("Cámara De Seguridad Wifi ", R.drawable.product_07, "Ezviz 5mp Uhd Exterior Color Ip", 69.999f))
        listData.add(ItemProduct("Cámara de seguridad Camara S588M ", R.drawable.product_08, "Profesional Solar con resolución de 3MP visión nocturna incluida negra", 140.542f))
        listData.add(ItemProduct("Balun Rj45 A ", R.drawable.product_09, "Bnc Para Camaras Hd Seguridad Cctv", 4.899f))
        listData.add(ItemProduct("Mini Cámara De Cuerpo ", R.drawable.product_10, "Brathird 32gb Mini Spy Nanny Cam 1080p", 15.326f))

        adaptador = AdapterProduct(this,listData)

        val lis_details = findViewById<View>(R.id.listdetails)  as ListView

        lis_details.adapter = adaptador


        //registramos el menu contextual
        registerForContextMenu(lis_details)
    }
    //crea el menu
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        val inflatormenu = menuInflater
        inflatormenu.inflate(R.menu.menu_contextual, menu)
    }
    //cuando se haga clic en las opciones
    @Suppress("UNREACHABLE_CODE")
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val posicion = info.position
        val nombre = listData[posicion]

        when (item.itemId){
            //opcion de eliminación
            R.id.option1 ->{
                listData.remove(nombre)
                adaptador?.notifyDataSetChanged()
               return true
            }
            //opción de ver los precios
            R.id.option2 ->{
                makeText(this, "Valor: $ ${nombre.price}", Toast.LENGTH_LONG).show()
                return true
            }
        }
         return super.onContextItemSelected(item)
    }

}