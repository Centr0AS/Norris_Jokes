package com.example.Norris_Jokes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JokeAdapter(private val jokesList: List<JokeItem> ): RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_joke,
            parent,false)

        return JokeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val currentItem = jokesList[position]

        holder.textView.text = currentItem.jokeText
    }

    override fun getItemCount() = jokesList.size


    class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textView: TextView = itemView.findViewById(R.id.joke_text_view)



    }
}