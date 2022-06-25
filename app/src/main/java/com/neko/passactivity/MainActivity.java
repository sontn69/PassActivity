package com.neko.passactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.neko.passactivity.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "1";
    public static final String EXTRA_NUMBER = "2";

    private RecyclerView recyclerView;
    private Item mitem;
    private ArrayList<Item> listitem;
    private ItemAdapter mitemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnThongtin.setOnClickListener(v -> {

            String text = binding.edName.getText().toString();
            int number = Integer.parseInt(binding.edSdt.getText().toString());

            if (text.isEmpty() ) {
                Toast.makeText(this, "Nhap ten di", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra(EXTRA_TEXT, text);
                intent.putExtra(EXTRA_NUMBER, number);
                startActivity(intent);
            }


        });

        binding.item.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            startActivity(intent);
        });


        listitem = new ArrayList<>();
        data();

        mitemAdapter = new ItemAdapter(listitem, this);
        binding.rcv.setAdapter(mitemAdapter);
        binding.rcv.setLayoutManager(new LinearLayoutManager(this));

    }


    private void data(){
        listitem.add(new Item("item1",R.drawable.iron,"ok1"));
        listitem.add(new Item("item2", R.drawable.ic_delete, "ok2"));
        listitem.add(new Item("item3",R.drawable.ic_delete, "ok2"));
        listitem.add(new Item("item4",R.drawable.ic_cpu, "ok3"));
        listitem.add(new Item("item5",R.drawable.ic_cpu, "ok4"));
        listitem.add(new Item("item6",R.drawable.ic_cpu, "ok2"));
        listitem.add(new Item("item7",R.drawable.ic_cpu, "ok2"));
        listitem.add(new Item("item7",R.drawable.ic_cpu, "gdf"));
        listitem.add(new Item("item8",R.drawable.ic_cpu, "dg"));
        listitem.add(new Item("item9",R.drawable.ic_cpu, "dg"));
        listitem.add(new Item("item10",R.drawable.ic_cpu, "ok2"));
        listitem.add(new Item("item11",R.drawable.ic_cpu, "ok2"));
        listitem.add(new Item("item12",R.drawable.ic_delete, "ok2"));
    }




}