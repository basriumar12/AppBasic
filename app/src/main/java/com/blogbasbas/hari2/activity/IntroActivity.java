package com.blogbasbas.hari2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blogbasbas.hari2.MainActivity;
import com.blogbasbas.hari2.R;

public class IntroActivity extends AppCompatActivity {

    Button btnIntro;
    EditText edtIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        edtIntro = (EditText) findViewById(R.id.edtIntro);
        btnIntro = (Button) findViewById(R.id.btnIntro);
        btnIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edt = edtIntro.getText().toString();
                if(edt.isEmpty()){
                    edtIntro.setError("Data Tidak Bisa Kosong");
                } else {

                    Intent kirimData = new Intent(IntroActivity.this, MainActivity.class);
                    kirimData.putExtra("nama", edt);
                    startActivity(kirimData);

                    finish();


                }



            }
        });
    }
}
