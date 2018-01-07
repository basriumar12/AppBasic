package com.blogbasbas.hari2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.blogbasbas.hari2.R;

public class InputDataActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        editText= (EditText) findViewById(R.id.edtInput);
        textView= (TextView) findViewById(R.id.tvInput);

        button= (Button) findViewById(R.id.btnInput);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edt = editText.getText().toString();
                if (edt.isEmpty()){
                    editText.setError("kolom harus di isi");
                } else {
                    Toast.makeText(InputDataActivity.this, "Succses", Toast.LENGTH_SHORT).show();
                 textView.setText("datanya " +edt);

                }

            }
        });
    }
}
