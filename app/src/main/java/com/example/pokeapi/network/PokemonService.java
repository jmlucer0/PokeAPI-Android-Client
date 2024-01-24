package com.example.pokeapi.network;


import com.example.pokeapi.model.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {

    @GET("pokemon/{pokemonName}")
    Call<Pokemon> getPokemonDetails(@Path("pokemonName") String pokemonName);

}
