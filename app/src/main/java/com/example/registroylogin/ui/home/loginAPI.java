package com.example.registroylogin.ui.home;

import com.example.registroylogin.ui.DTO.usuario;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface loginAPI {
    @FormUrlEncoded
    @POST ("verificarCredenciales")
    Call<usuario> LOGIN_CALL(
            @Field("correo") String correo,
            @Field("contrasenia") String contrasenia
    );

}
