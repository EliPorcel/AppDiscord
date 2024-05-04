package com.example.appdiscord;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;
import android.content.res.Configuration;
import android.content.res.Resources;

public class MainActivity extends AppCompatActivity {

    EditText nombreEditText;
    EditText contraseñaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Llamame), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Buscar los EditText por sus IDs
        nombreEditText = findViewById(R.id.textNameLogin);
        contraseñaEditText = findViewById(R.id.textPasswordLogin);
    }

    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        Resources resources = getResources();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    public void Siguiente(View view) {
        // Obtener el texto ingresado por el usuario en los EditText
        String nombre = nombreEditText.getText().toString();
        String contraseña = contraseñaEditText.getText().toString();

        // Verificar si las credenciales son correctas
        if (nombre.equals("alumno") && contraseña.equals("1234")) {
            // Credenciales correctas, iniciar la siguiente actividad
            Intent siguiente = new Intent(this, segunda.class);
            startActivity(siguiente);
        } else {
            // Credenciales incorrectas, mostrar un mensaje de error
            Toast.makeText(this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            nombreEditText.setText(""); // Borrar el texto del nombre
            contraseñaEditText.setText(""); // Borrar el texto de la contraseña
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Limpiar los EditText cuando se pausa la actividad
        nombreEditText.setText("");
        contraseñaEditText.setText("");
    }
}
