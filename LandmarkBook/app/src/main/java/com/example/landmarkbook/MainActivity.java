package com.example.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // landmarkArrayList
        landmarkArrayList = new ArrayList<>();

        // Landmark Class Object Created
        Landmark pisaTower = new Landmark("Pisa Tower" , "İtaly" , R.drawable.restwo);
        Landmark eiffelTower = new Landmark("Eiffel Tower" , "France" , R.drawable.resone);
        Landmark colleseum = new Landmark("Colleseum" , "Roma" , R.drawable.resfours);
        Landmark londonBridge = new Landmark("London Bridge" , "United Kingdom" , R.drawable.resthree);

        // element add to array
        landmarkArrayList.add(pisaTower);
        landmarkArrayList.add(eiffelTower);
        landmarkArrayList.add(colleseum);
        landmarkArrayList.add(londonBridge);
        binding.myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        landmarAdapter landmarAdapter = new landmarAdapter(landmarkArrayList);
        binding.myRecyclerView.setAdapter(landmarAdapter);


        /*
            ArrayAdapter arrayAdapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1 ,
                    landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList())
            );
            binding.listView.setAdapter(arrayAdapter);
            binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MainActivity.this , DetailsActivity.class);
                    intent.putExtra("landmark" , landmarkArrayList.get(position));
                    startActivity(intent);
                }
            });
        */
    }
}