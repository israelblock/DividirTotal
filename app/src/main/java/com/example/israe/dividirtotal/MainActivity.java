package com.example.israe.dividirtotal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

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

    }

    public void calcula(View v) {
        String total = comanda.getText().toString();
        String p = pessoas.getText().toString();

        if (v.getId() == R.id.calcular) {
            if (dezporcento.isChecked()) {

                float vTotal = Float.parseFloat(total);
                float vTotal2 = (float) (vTotal + (vTotal * 0.1));
                float qPessoas = Float.parseFloat(p);

                float valorPorPessoa = vTotal2 / qPessoas;
                resultado.setText("O valor por pessoa é de " + String.valueOf(valorPorPessoa));
            } else {
                float vTotal = Float.parseFloat(total);
                float qPessoas = Float.parseFloat(p);

                float valorPorPessoa = vTotal / qPessoas;
                resultado.setText("O valor por pessoa é de " + String.valueOf(valorPorPessoa));
            }
        }
    }
}
