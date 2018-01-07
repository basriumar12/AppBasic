package com.blogbasbas.hari2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.blogbasbas.hari2.R;

import java.text.DecimalFormat;

public class KalActivity extends AppCompatActivity {
    private TextView tvOperator;
    private String operator = "tambah";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kal);
        tvOperator = (TextView) findViewById(R.id.tv_operator);

    }

    public void buttonTambah(View view) {
        tvOperator.setText("+");
        operator = "tambah";
    }

    public void buttonKurang(View view) {
        tvOperator.setText("-");
        operator = "kurang";
    }

    public void buttonKali(View view) {
        tvOperator.setText("*");
        operator = "kali";
    }

    public void buttonBagi(View view) {
        tvOperator.setText("/");
        operator = "bagi";
    }

    public void buttonProses(View view) {

        EditText etA = (EditText) findViewById(R.id.et_bilangan_a);
        EditText etB = (EditText) findViewById(R.id.et_bilangan_b);

        String a = etA.getText().toString();
        String b = etB.getText().toString();
        if (a.isEmpty()) {
            etA.setError("isi kolumnya");
        } else if (b.isEmpty()) {
            etB.setError("isi kolumnya");
        } else {



        float hasil;
        float bilanganA = Float.parseFloat(a.toString());
        float bilanganB = Float.parseFloat(b.toString());


        switch (operator) {
            case "kurang":
                hasil = bilanganA - bilanganB;
                break;
            case "kali":
                hasil = bilanganA * bilanganB;
                break;
            case "bagi":
                hasil = bilanganA / bilanganB;
                break;
            default:
                hasil = bilanganA + bilanganB;
                break;
        }

        TextView tvHasil = (TextView) findViewById(R.id.tv_hasil);

        String stringHasil = new DecimalFormat("#.#########").format(hasil);

        tvHasil.setText(stringHasil);

    }
}
}

