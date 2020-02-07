package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    var lista: RecyclerView? = null
    var adaptador:AdaptadorCustom? = null
    var layouManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val platillos = ArrayList<Platillo>()

        platillos.add(Platillo("Chiles en su Salsa", 250.0, 3.5F, R.drawable.chiles900))
        platillos.add(Platillo("Lasaña Rica", 100.0, 3.5F, R.drawable.platillo))
        platillos.add(Platillo("Tacos de Carne", 50.0, 3.5F, R.drawable.platillo2))
        platillos.add(Platillo("Pajaro Desmechado", 350.0, 3.5F, R.drawable.platillo3))
        platillos.add(Platillo("Tocos con Arroz", 254.0, 3.5F, R.drawable.platillo4))
        platillos.add(Platillo("Sushi con Huevo", 210.0, 3.5F, R.drawable.platillo5))
        platillos.add(Platillo("Tacos con Frijol", 400.0, 3.5F, R.drawable.platillo6))
        platillos.add(Platillo("Hamburguesa de Carne al Vapor", 478.0, 3.5F, R.drawable.platillo7))
        platillos.add(Platillo("Tacos Detodito", 349.0, 3.5F, R.drawable.platillo8))
        platillos.add(Platillo("Hamburguesa con Carne de Cerdo", 102.0, 3.5F, R.drawable.platillo9))

        lista = findViewById(R.id.lista)
        lista?.setHasFixedSize(true)

        layouManager = LinearLayoutManager(this)
        lista?.layoutManager = layouManager

        adaptador = AdaptadorCustom (platillos, object:ClickListener{
            override fun onClick(vista: View, index: Int) {
                Toast.makeText(applicationContext, platillos.get(index).nombre, Toast.LENGTH_SHORT).show()
            }
        })
        lista?.adapter = adaptador as AdaptadorCustom

       // val swipeToRefresh = findViewById<SwipeRefreshLayout>(R.id.swipeToRefresh)
        //swipeToRefresh.setOnRefreshListener {
          //  Log.d("REFRESH", "La Informacion se esta Actualizando..")
       // }
    }
}
