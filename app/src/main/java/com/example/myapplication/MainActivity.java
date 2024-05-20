package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText valorDoAtributo;
    private Spinner medida1, medida2;
    private Button conversor;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle instanciaSalva) {
        super.onCreate(instanciaSalva);
        setContentView(R.layout.activity_main);

            valorDoAtributo = findViewById(R.id.input_valor);
            medida1 = findViewById(R.id.spinner_unidade1);
            medida2 = findViewById(R.id.spinner_unidade2);
            conversor = findViewById(R.id.convert_button);
            resultado = findViewById(R.id.result_text);

        }
    }
