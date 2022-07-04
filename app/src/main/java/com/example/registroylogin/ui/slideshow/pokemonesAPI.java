package com.example.registroylogin.ui.slideshow;

import com.example.registroylogin.ui.DTO.pokemones;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface pokemonesAPI {
    @GET("{id}")
    Call<pokemones> find(@Path("id") String id);

}
