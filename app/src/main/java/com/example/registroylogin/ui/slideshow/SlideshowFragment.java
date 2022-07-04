package com.example.registroylogin.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.registroylogin.databinding.FragmentSlideshowBinding;
import com.example.registroylogin.ui.DTO.pokemones;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textSlideshow;
        //slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        final Button btnActualizar = binding.btnActualizar;
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            final EditText edtcodigo2 = binding.edtCodigo;
            final EditText edtcodigo = binding.edtNombre;
            @Override
            public void onClick(View view) {
                find(edtcodigo.getText().toString());
                find2(edtcodigo2.getText().toString());
                edtcodigo.getText().clear();
                edtcodigo2.getText().clear();
            }
        });

        return root;
    }

    private void find(String codigo){
        final TextView texto1 = binding.txtInfo1;
        final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        //Peticiones
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
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
                        texto1.setText(elementos.getName());


                    }else{
                        Toast.makeText(getActivity(), "No se encontro el ID del pokemon: "+ codigo, Toast.LENGTH_LONG).show();
                    }
                }catch (Exception ex){

                }
            }

            @Override
            public void onFailure(Call<pokemones> call, Throwable t) {

            }
        });
    }

    private void find2(String codigo2){
        final TextView texto2 = binding.txtInfo2;
        final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        //Peticiones
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/berry-flavor/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pokemonesAPI personajesAPI = retrofit.create(pokemonesAPI.class);
        Call<pokemones> call = personajesAPI.find(codigo2);
        call.enqueue(new Callback<pokemones>() {
            @Override
            public void onResponse(Call<pokemones> call, Response<pokemones> response) {
                try {
                    if (response.isSuccessful()){
                        pokemones elementos = response.body();
                        texto2.setText(elementos.getName());

                    }else{
                        Toast.makeText(getActivity(), "No se encontro el ID de la baya: "+ codigo2, Toast.LENGTH_LONG).show();
                    }
                }catch (Exception ex){

                }
            }

            @Override
            public void onFailure(Call<pokemones> call, Throwable t) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}