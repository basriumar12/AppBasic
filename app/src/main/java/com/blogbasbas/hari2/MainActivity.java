package com.blogbasbas.hari2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.blogbasbas.hari2.activity.InputDataActivity;
import com.blogbasbas.hari2.activity.KalActivity;
import com.blogbasbas.hari2.activity.PersegiActivity;
import com.blogbasbas.hari2.activity.ToastAlertActivity;

public class MainActivity extends AppCompatActivity {
    TextView tvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMain = (TextView) findViewById(R.id.tvMain);



        Intent getData = getIntent();
        tvMain.setText(getData.getStringExtra("nama"));


    }
        //obacck
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("do u want exit ?");
        builder.setCancelable(false);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("this alert has 2 options");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }

        });
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                moveTaskToBack(true);
                System.exit(0);
            }
        }) ;


        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }





    public void persegi(View view) {
        startActivity(new Intent(this, PersegiActivity.class));
    }

    public void kakulator(View view) {
        startActivity(new Intent(this, KalActivity.class));
    }

    public void input(View view) {
        startActivity(new Intent(this, InputDataActivity.class));
    }

    public void customActivity(View view) {
        startActivity(new Intent(this, ToastAlertActivity.class));
    }
}
