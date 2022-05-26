package com.example.tema3.film

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tema3.R
import com.example.tema3.model.FilmItem

class MyAdapter(val context: Context, val userList: List<FilmItem>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var nume : TextView
        var gen : TextView
        var varsta : TextView
        var tip : TextView
        var data : TextView
        var capacitate : TextView
        var pret : TextView
        var regizor : TextView
        var actori : TextView

        init {
            nume = itemView.findViewById(R.id.filmNume)
            gen = itemView.findViewById(R.id.filmGen)
            varsta = itemView.findViewById(R.id.filmVarsta)
            tip = itemView.findViewById(R.id.filmTip)
            data = itemView.findViewById(R.id.filmData)
            capacitate = itemView.findViewById(R.id.filmCapacitate)
            pret = itemView.findViewById(R.id.filmPret)
            regizor = itemView.findViewById(R.id.filmRegizor)
            actori = itemView.findViewById(R.id.filmActori)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.activity_filmview, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        ("nume: " + userList[position].nume).also { holder.nume.text = it }
        ("gen: " + userList[position].gen).also { holder.gen.text = it }
        ("varsta: " +  userList[position].varsta).also { holder.varsta.text = it }
        ("tip: " +  userList[position].tip).also { holder.tip.text = it }
        ("data: " + userList[position].data).also { holder.data.text = it }
        ("capacitate: " +  userList[position].capacitate).also { holder.capacitate.text = it }
        ("pret: " +  userList[position].pret).also { holder.pret.text = it }
        ("regizor: " + userList[position].regizor).also { holder.regizor.text = it }
        ("actori: " + userList[position].actori).also { holder.actori.text = it }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}