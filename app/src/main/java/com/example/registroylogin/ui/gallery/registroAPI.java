package com.example.registroylogin.ui.gallery;

import com.example.registroylogin.ui.DTO.usuario;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface registroAPI {
    @FormUrlEncoded
    @POST("registroForm")
    Call<usuario> REGISTRO_CALL(
            @Field("nombre") String nombre,
            @Field("apellidoPaterno") String apellidoPaterno,
            @Field("apellidoMaterno") String apellidoMaterno,
            @Field("correo") String correo,
            @Field("contrasenia") String contrasenia,
            @Field("contrasenia2") String contrasenia2,
            @Field("fechaNacimiento") String fechaNacimiento
    );

}
