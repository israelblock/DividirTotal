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

public class MainActivity extends Activity {

    private EditText comanda;
    private EditText pessoas;
    private TextView resultado;
    private CheckBox dezporcento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comanda = findViewById(R.id.comanda);
        pessoas = findViewById(R.id.pessoas);
        resultado = findViewById(R.id.resultado);
        dezporcento = findViewById(R.id.dezporcento);

        dezporcento.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int people = Integer.parseInt(pessoas.getText().toString());
                if(comanda!=null && people > 0){
                    if(isChecked==true){
                        double novaComanda = Double.parseDouble(comanda.getText().toString());
                        novaComanda = (novaComanda + (novaComanda * 0.1));
                        comanda.setText(new DecimalFormat(".00").format(novaComanda));
                    }if(isChecked==false){
                        double novaComanda = Double.parseDouble(comanda.getText().toString());
                        novaComanda = (novaComanda - (novaComanda * 0.1));
                        comanda.setText(new DecimalFormat(".00").format(novaComanda));
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Os campos precisam ser preenchidos com valores maiores que 0", Toast.LENGTH_LONG).show();
                }


            }
        });

    }

    public void calcula(View v) {
        String total = comanda.getText().toString();
        String p = pessoas.getText().toString();

        if (v.getId() == R.id.calcular) {

            Double vTotal = Double.parseDouble(total);
            Double qPessoas = Double.parseDouble(p);

            DecimalFormat mFormat = new DecimalFormat(".00");

            Double valorPorPessoa = vTotal / qPessoas;

            resultado.setText("O valor por pessoa é de R$" + mFormat.format(valorPorPessoa));
        }
    }
}

