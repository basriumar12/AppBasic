package com.blogbasbas.hari2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.blogbasbas.hari2.R;

public class ToastAlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_alert);
    }



    public void onCustom(View view) {
        LayoutInflater inflater = getLayoutInflater();
        view = inflater.inflate(R.layout.tampilantoast,null);

        TextView isipesan = (TextView)view.findViewById(R.id.textisipesan);
        isipesan.setText("tampilan custom toast");

        Toast toast = new Toast(ToastAlertActivity.this);
        toast.setView(view);
        toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
    //method alert
    public void onAlert(View v) {
        LayoutInflater inflater = getLayoutInflater();
        v = inflater.inflate(R.layout.tampilanalert,null);
        final EditText edtUser = (EditText)v.findViewById(R.id.edtUsername);
        final TextInputEditText edtPass = (TextInputEditText)v.findViewById(R.id.edtpassword);
        AlertDialog.Builder builder = new AlertDialog.Builder(ToastAlertActivity.this);
        builder.setView(v);
        Button simpan = (Button) v.findViewById(R.id.simpan);
        Button cancel = (Button)v.findViewById(R.id.cancel);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String us = edtUser.getText().toString();
                String pw = edtPass.getText().toString();
                //agar edittext di input tidak bisa kosong
                if (TextUtils.isEmpty(us.trim())){
                    edtUser.setError(getString(R.string.userkosong));
                    edtUser.requestFocus();

                } else if (TextUtils.isEmpty(pw.trim())){
                    edtPass.setError(getString(R.string.passkosong));
                    edtPass.requestFocus();
                } else if (pw.length()<6){
                    edtPass.setError(getString(R.string.karakterlebih5));
                }else {
                    Intent kirimdata = new Intent(ToastAlertActivity.this,TerimaDataActivity.class);
                    kirimdata.putExtra("US", us);
                    kirimdata.putExtra("PW", pw);
                    startActivity(kirimdata);
                    finish();

                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        builder.show();
    }
}
