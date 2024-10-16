package com.oceanbrasil.oceanrickandmortygame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CharacterAdapter
    (private val characters: List<Character>)
    : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>()
{
        class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val nameTextView: TextView = view.findViewById(R.id.character_name)
            val statusTextView: TextView = view.findViewById(R.id.character_status)
            val imageView: ImageView = view.findViewById(R.id.character_image)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.nameTextView.text = character.name
        holder.statusTextView.text = character.status
        Glide.with(holder.itemView).load(character.image).into(holder.imageView);
    }
}