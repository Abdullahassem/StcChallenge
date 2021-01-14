package com.abdullah.android.stc

import android.content.Context
import android.content.Intent
import android.content.res.AssetManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class PoliticianAdapter(val context: Context,val politicians:List<Politician>):
        RecyclerView.Adapter<PoliticianAdapter.ViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_politicians,parent,false))
        }
        inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
            fun bind(politician:Politician) {







                itemView.findViewById<TextView>(R.id.name).text=politician.name
                itemView.findViewById<TextView>(R.id.position).text=politician.role
                itemView.findViewById<TextView>(R.id.department).text=politician.team




                if(politician.admin == "Republican")
                Glide.with(context).load(R.drawable.republican)
                    .override(300,300)
                    .centerCrop()
                    .circleCrop()
                    .into(itemView.findViewById(R.id.image))
                else
                    Glide.with(context).load(R.drawable.democrat)
                        .override(300, 300)
                        .centerCrop()
                        .circleCrop()
                        .into(itemView.findViewById(R.id.image))



                itemView.findViewById<TextView>(R.id.cardView).setOnClickListener {
                    var intent = Intent (context,PoliticianInfo::class.java)
                    intent.putExtra("name",politician.name)
                    intent.putExtra("team",politician.team)
                    intent.putExtra("address",politician.address)
                    intent.putExtra("zip",politician.zipCode)
                    intent.putExtra("city",politician.city)
                    intent.putExtra("country",politician.country)
                    intent.putExtra("role",politician.role)
                    context.startActivity(intent)
                }


            }
        }

        override fun onBindViewHolder(holder: PoliticianAdapter.ViewHolder, position: Int) {
            val politician=politicians[position]
            holder.bind(politician)
        }

        override fun getItemCount(): Int {
            return politicians.size
        }
    }