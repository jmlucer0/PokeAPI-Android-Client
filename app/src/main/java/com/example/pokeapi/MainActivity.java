package com.example.pokeapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.pokeapi.adapter.PokemonAdapter;
import com.example.pokeapi.model.Pokemon;
import com.example.pokeapi.network.ApiClient;
import com.example.pokeapi.network.PokemonService;
import com.example.pokeapi.network.PokemonService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter;
    private PokemonService pokemonService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        pokemonAdapter = new PokemonAdapter(new ArrayList<>());
        recyclerView.setAdapter(pokemonAdapter);


        pokemonService = ApiClient.getPokemonService();

        // Ejemplo de cómo realizar una solicitud a la API
        Call<Pokemon> call = pokemonService.getPokemonDetails("2");
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Procesar el Pokémon obtenido
                    Pokemon pokemon = response.body();
                    Log.d("MainActivity", "Pokemon obtenido: " + pokemon.getName());
                    // Agregar el Pokémon al adaptador
                    pokemonAdapter.addPokemon(pokemon);
                } else {
                    Log.e("MainActivity", "Error en la llamada a la API: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e("MainActivity", "Error en la llamada a la API", t);
            }
        });
    }

}