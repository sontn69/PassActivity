package com.neko.passactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.neko.passactivity.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);

        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        int number = intent.getIntExtra(MainActivity.EXTRA_NUMBER, 0);

        binding.tvName.setText("Name: " + text);
        binding.tvSdt.setText("SDT: " + number);
        binding.tvThongtin.setText("Thong tin");


        binding.tvSdt.setOnClickListener(view -> Toast.makeText(MainActivity2.this, "SDT may la :", Toast.LENGTH_SHORT).show());
        binding.tvThongtin.setOnClickListener(v -> Toast.makeText(this, "hien thi thong tin", Toast.LENGTH_SHORT).show());
    }
}