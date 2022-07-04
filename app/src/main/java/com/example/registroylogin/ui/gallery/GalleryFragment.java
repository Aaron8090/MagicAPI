package com.example.registroylogin.ui.gallery;

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

import com.example.registroylogin.databinding.FragmentGalleryBinding;
import com.example.registroylogin.ui.DTO.usuario;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textGallery;
        //galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        final Button BtnRegistro = binding.btnRegistrar;
        BtnRegistro.setOnClickListener(new View.OnClickListener() {
            final EditText EtName = binding.nombre;
            final EditText EtApPat = binding.apPat;
            final EditText EtApMat = binding.apMat;
            final EditText EtEmail = binding.Correo;
            final EditText EtPass = binding.Contrasenia;
            final EditText EtValidate = binding.ConfirmacionC;
            final EditText Fecha = binding.FechaNa;
            final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            @Override
            public void onClick(View view) {
                String nombre = EtName.getText().toString().trim();
                String apellidoPaterno = EtApPat.getText().toString().trim();
                String apellidoMaterno = EtApMat.getText().toString().trim();
                String correo = EtEmail.getText().toString().trim();
                String contrasenia = EtPass.getText().toString().trim();
                String contrasenia2 = EtValidate.getText().toString().trim();
                String fechaNacimiento = Fecha.getText().toString().trim();

                if(nombre.isEmpty() || apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty() || correo.isEmpty() || contrasenia.isEmpty() || contrasenia2.isEmpty() || fechaNacimiento.isEmpty()){
                    Toast.makeText(getContext(), "Faltan datos para poder registrarte", Toast.LENGTH_SHORT).show();
                    return;
                }

                logging.setLevel(HttpLoggingInterceptor.Level.BODY);

                final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
                httpClient.addInterceptor(logging);
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl("https://jnmlvuvn.lucusvirtual.es/api/auth/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();
                registroAPI register = retrofit.create(registroAPI.class);
                Call<usuario> call = register.REGISTRO_CALL(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, contrasenia2, fechaNacimiento);
                call.enqueue(new Callback<usuario>() {
                    @Override
                    public void onResponse(Call<usuario> call, Response<usuario> response) {
                        if(response.isSuccessful() && response.body() != null){
                            EtName.getText().clear();
                            EtApPat.getText().clear();
                            EtApMat.getText().clear();
                            EtEmail.getText().clear();
                            EtPass.getText().clear();
                            EtValidate.getText().clear();
                            Fecha.getText().clear();
                            usuario user = response.body();
                            if (user.getEstatus().toString().equals("Error")){
                                Toast.makeText(getContext(), "Registrado", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getContext(), "Verifica tus datos", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<usuario> call, Throwable t) {
                        Toast.makeText(getContext(), "Error al registrar", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}