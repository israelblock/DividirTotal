package com.example.israe.dividirtotal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Objects;

public class MainActivity extends Activity {

    private EditText comanda;
    private EditText pessoas;
    private TextView resultado;
    private CheckBox dezporcento;
    private Double guardaValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comanda = findViewById(R.id.comanda);
        pessoas = findViewById(R.id.pessoas);
        resultado = findViewById(R.id.resultado);
        dezporcento = findViewById(R.id.dezporcento);
        guardaValor = null;

        dezporcento.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!Objects.equals(comanda.getText().toString(), "")) {
                    if (isChecked == true) {
                        double novaComanda = Double.parseDouble(comanda.getText().toString());
                        guardaValor = novaComanda;
                        novaComanda = (novaComanda + (novaComanda * 0.1));
                        comanda.setText(new DecimalFormat(".00").format(novaComanda));

                    }
                    if (isChecked == false) {
                        comanda.setText(new DecimalFormat(".00").format(guardaValor));
                    }
                } else {
                    Toast.makeText(MainActivity.this, "O campo de valor precisa estar preenchido ", Toast.LENGTH_LONG).show();
                    dezporcento.setChecked(false);
                }
            }
        });

    }

    public void calcula(View v) {
        String total = comanda.getText().toString();
        String p = pessoas.getText().toString();

        if (v.getId() == R.id.calcular) {
            if (!Objects.equals(total, "")&& !Objects.equals(p, "") ) {

                Double vTotal = Double.parseDouble(total);
                Double qPessoas = Double.parseDouble(p);

                DecimalFormat mFormat = new DecimalFormat(".00");

                Double valorPorPessoa = vTotal / qPessoas;

                if(qPessoas == 0) {
                    Toast.makeText(MainActivity.this, "Não é possível dividir por 0 pessoas", Toast.LENGTH_LONG).show();
                    resultado.setText("");
                }else {
                    resultado.setText("O valor por pessoa é de R$" + mFormat.format(valorPorPessoa));
                }
            }else{
                Toast.makeText(MainActivity.this, "Os campos precisam ser preenchidos com valores maiores que 0", Toast.LENGTH_LONG).show();
            }
        }
    }
}

