package com.example.tema3.bilet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tema3.R
import com.example.tema3.model.BiletItem

class MyAdapter2 (val context: Context, val userList: List<BiletItem>):
    RecyclerView.Adapter<MyAdapter2.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var numar : TextView
        var numeClient : TextView
        var numeEven : TextView

        init {
            numar = itemView.findViewById(R.id.nrBilet)
            numeClient = itemView.findViewById(R.id.numeClient)
            numeEven = itemView.findViewById(R.id.even1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.activity_biletview, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        ("numar bilet: " + userList[position].numarBilet).also { holder.numar.text = it }
        ("nume client: " + userList[position].client).also { holder.numeClient.text = it }
        ("nume eveniment: " + userList[position].event).also { holder.numeEven.text = it }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}