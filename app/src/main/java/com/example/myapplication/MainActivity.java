package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
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

        // aqui ele busca o ID definido la no arquivo activiy_main.xml, e aplica no atributo.
            valorDoAtributo = findViewById(R.id.input_valor);
            medida1 = findViewById(R.id.spinner_unidade1);
            medida2 = findViewById(R.id.spinner_unidade2);
            conversor = findViewById(R.id.convert_button);
            resultado = findViewById(R.id.result_text);

        // cria um array de caracteres para ser exibido, depois criamos um metodo que cria um novo array adapter
        // R.Array."name fornecido la em Strings.xml", simple_spinner é fornecido pelo proprio android.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_unidades, android.R.layout.simple_spinner_item);

// outro metodo do arrayadapter para exibir os itens do spinner quando dropdown é aberto
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //e aqui aplicando nas variaveis

        medida1.setAdapter(adapter);
        medida2.setAdapter(adapter);

        }
    }
