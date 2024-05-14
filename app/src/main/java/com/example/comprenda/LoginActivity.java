package com.example.comprenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.comprenda.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    // Datos estáticos para las credenciales de inicio de sesión
    private static final String CORREO_ELECTRONICO_ESTATICO = "dayanna@gmail.com";
    private static final String CONTRASENA_ESTATICA = "comprenda123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configurar OnClickListener para el botón de registro
        binding.btnSignup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad de registro
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        // Configurar OnClickListener para el botón de ingreso
        binding.aLognBtnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos de correo y contraseña ingresados por el usuario
                String email = binding.txtEmail.getText().toString();
                String password = binding.txtPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast toast = new Toast(getApplicationContext());
                    View view = getLayoutInflater().inflate(R.layout.toast_custom, null);
                    toast.setView(view);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    if (email.equals(CORREO_ELECTRONICO_ESTATICO) && password.equals(CONTRASENA_ESTATICA)) {
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);

                    } else {
                        Toast toast = new Toast(getApplicationContext());
                        View view = getLayoutInflater().inflate(R.layout.toast_custom2, null);
                        toast.setView(view);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });
    }
}
