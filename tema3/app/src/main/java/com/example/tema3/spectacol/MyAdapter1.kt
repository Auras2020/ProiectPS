package com.example.tema3.spectacol

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tema3.R
import com.example.tema3.model.SpectacolItem

class MyAdapter1(val context: Context, val userList: List<SpectacolItem>):
    RecyclerView.Adapter<MyAdapter1.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var nume1 : TextView
        var tip_muzica : TextView
        var data1 : TextView
        var pret : TextView
        var artisti : TextView
        var interval_orar : TextView

        init {
            nume1 = itemView.findViewById(R.id.spectacolNume)
            tip_muzica = itemView.findViewById(R.id.spectacolTipMuzica)
            data1 = itemView.findViewById(R.id.even1)
            pret = itemView.findViewById(R.id.spectacolLocatie)
            artisti = itemView.findViewById(R.id.spectacolArtisti)
            interval_orar = itemView.findViewById(R.id.spectacolIntervalOrar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.activity_spectacolview, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        ("nume: " + userList[position].nume).also { holder.nume1.text = it }
        ("tip muzica: " + userList[position].tip_muzica).also { holder.tip_muzica.text = it }
        ("data: " + userList[position].data).also { holder.data1.text = it }
        ("pret: " +  userList[position].pret).also { holder.pret.text = it }
        ("artisti: " + userList[position].artisti).also { holder.artisti.text = it }
        ("interval orar: " + userList[position].interval_orar).also { holder.interval_orar.text = it }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}