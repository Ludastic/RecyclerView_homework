package com.example.lesson6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;

import com.example.lesson6.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<String> data = new ArrayList<>();
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.addBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (String.valueOf(binding.mainEdit.getText()).equals("")) {
                    Toast.makeText(getApplicationContext(), "Вы ничего не ввели!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    data.add(String.valueOf(binding.mainEdit.getText()));
                    Context context = getBaseContext();
                    Adapter adapter = new Adapter(context, data);
                    binding.recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    binding.recyclerView.setAdapter(adapter);
                }
            }
        });
        /*List<String> data = new ArrayList<>();
        data.add("Test_on_Launch");
        Adapter adapter = new Adapter(this, data);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);*/

    }
}