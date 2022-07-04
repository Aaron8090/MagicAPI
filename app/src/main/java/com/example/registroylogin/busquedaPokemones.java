package com.example.registroylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.registroylogin.ui.DTO.pokemones;
import com.example.registroylogin.ui.slideshow.pokemonesAPI;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class busquedaPokemones extends AppCompatActivity {

    EditText edtCodigo;
    EditText edtNombre;
    TextView txtInfo1;
    TextView txtInfo2;
    TextView txtInfo3;
    Button btnActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_pokemones);

        edtCodigo=findViewById(R.id.edtCodigo);
        edtNombre=findViewById(R.id.edtNombre);
        txtInfo1=findViewById(R.id.txtInfo1);
        txtInfo2=findViewById(R.id.txtInfo2);
        txtInfo3=findViewById(R.id.txtInfo3);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                find(edtCodigo.getText().toString());
            }
        });
    }

    private void find(String codigo){
        //Peticiones
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/pokemon/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pokemonesAPI personajesAPI = retrofit.create(pokemonesAPI.class);
        Call<pokemones> call = personajesAPI.find(codigo);
        call.enqueue(new Callback<pokemones>() {
            @Override
            public void onResponse(Call<pokemones> call, Response<pokemones> response) {
                try {
                    if (response.isSuccessful()){
                        pokemones elementos = response.body();
                        txtInfo1.setText(elementos.getName());

                    }else{
                        Toast.makeText(busquedaPokemones.this, "No se encontro el ID: "+ codigo, Toast.LENGTH_LONG).show();
                    }
                }catch (Exception ex){

                }
            }

            @Override
            public void onFailure(Call<pokemones> call, Throwable t) {

            }
        });
    }

}