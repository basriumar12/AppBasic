package com.blogbasbas.hari2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blogbasbas.hari2.R;

public class PersegiActivity extends AppCompatActivity {
    EditText edtPanjang;
    EditText edtLebar;
    Button btnHitung;
    TextView txtLuas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);
        edtPanjang = (EditText) findViewById(R.id.edt_panjang);
        edtLebar = (EditText) findViewById(R.id.edt_lebar);
        btnHitung = (Button) findViewById(R.id.btn_hitung);
        txtLuas = (TextView) findViewById(R.id.txt_luas);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String panjang = edtPanjang.getText().toString().trim();
                String lebar = edtLebar.getText().toString().trim();

                if (panjang.isEmpty()){
                    edtPanjang.setError("isi kolomnya");
                } else  if (lebar.isEmpty()){
                    edtLebar.setError("isi kolomnya");
                } else {

                    double p = Double.parseDouble(panjang);
                    double l = Double.parseDouble(lebar);
                    double luas = p * l;

                    txtLuas.setText("Luas persegi : " + luas);
                }
            }
        });

    }
}
