package com.example.pokeapi.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokeapi.R;
import com.example.pokeapi.model.Pokemon;

public class PokemonViewHolder extends RecyclerView.ViewHolder {

    private TextView pokemonNameTextView;

    public PokemonViewHolder(@NonNull View itemView) {
        super(itemView);
        pokemonNameTextView = itemView.findViewById(R.id.textPokemonName);
    }

    public void bind(Pokemon pokemon) {
        pokemonNameTextView.setText(pokemon.getName());
    }
}

