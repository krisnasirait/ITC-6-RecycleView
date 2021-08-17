package com.project.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CryptoDetail extends AppCompatActivity {

    private ImageView imgLogo;
    private TextView tvName, tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_detail);

        imgLogo = findViewById(R.id.crypto_logo);
        tvName = findViewById(R.id.crypto_name);
        tvDesc = findViewById(R.id.crypto_desc);

        imgLogo.setImageResource(getIntent().getIntExtra("cryptoLogo", R.drawable.ada));
        tvName.setText(getIntent().getStringExtra("cryptoName"));
        tvDesc.setText(getIntent().getStringExtra("cryptoDesc"));
    }
}