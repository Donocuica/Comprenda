package com.example.comprenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.comprenda.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;

    // Datos estáticos para las credenciales de inicio de sesión
    private static final String CORREO_ELECTRONICO_ESTATICO = "dayanna@gmail.com";
    private static final String CONTRASENA_ESTATICA = "comprenda123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configurar OnClickListener para el botón de login
        binding.btnLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad de login
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // Configurar OnClickListener para el botón de ingreso en la actividad de registro
        binding.aSignupBtnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos de correo y contraseña ingresados por el usuario
                String email = binding.txtEmail.getText().toString();
                String password = binding.txtPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    // Mostrar un Toast si los campos están vacíos
                    Toast.makeText(SignupActivity.this, "Ingresa tus datos", Toast.LENGTH_SHORT).show();
                } else {
                    // Si los campos no están vacíos
                    if (email.equals(CORREO_ELECTRONICO_ESTATICO) && password.equals(CONTRASENA_ESTATICA)) {
                        // Mostrar un Toast indicando que ya tiene cuenta
                        Toast.makeText(SignupActivity.this, "Ya tiene cuenta", Toast.LENGTH_SHORT).show();
                        // Aquí puedes iniciar la actividad de Home directamente
                        Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
                        startActivity(intent);
                    } else {
                        // Mostrar un Toast indicando que la cuenta se ha creado exitosamente
                        Toast.makeText(SignupActivity.this, "Cuenta creada exitosamente", Toast.LENGTH_SHORT).show();
                        // Aquí puedes iniciar la actividad de Home
                        Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

    }
}
