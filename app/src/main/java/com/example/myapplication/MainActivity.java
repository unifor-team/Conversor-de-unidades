package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
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

        conversor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // aqui ele obtem o texto e converte a string para uma double com parsedouble.
                double input = Double.parseDouble(valorDoAtributo.getText().toString());
                // aqui ele obtem o item selecionado e converte para uma string
                String deMedida1 = medida1.getSelectedItem().toString();
                String paraMedida2 = medida2.getSelectedItem().toString();
                double result = conversoDeMedidas(input,deMedida1,paraMedida2);
                resultado.setText(String.valueOf(result));

            }
        });

        }

        private double conversoDeMedidas(double valor, String deMedida1, String paraMedida2){
            double valorEmMetros = valor;
            switch (deMedida1) {
                case "centímetros":
                    valorEmMetros = valor / 100.0;
                    break;
                case "quilômetros":
                    valorEmMetros = valor * 1000.0;
                    break;
                case "milhas":
                    valorEmMetros = valor * 1609.34;
                    break;
            }
            switch (paraMedida2){
                case "centímetros":
                    return valorEmMetros = valor * 100.0;
                case "quilômetros":
                    return valorEmMetros = valor / 1000.0;
                case "milhas":
                    return valorEmMetros = valor / 1609.34;

                    //aqui retorna o valor de origem pois não vai ser possivel converter
                default:
                    return valorEmMetros;
            }
        }
    }
