package com.example.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.landmarkbook.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    // binding created
    private ActivityDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        // Landmark landmark = SelectedLandmark;
        Singelton singelton = Singelton.getInstance();
        Landmark selectedLandMark = singelton.getSentLadmark();
        binding.nameText.setText(selectedLandMark.name);
        binding.countryText.setText(selectedLandMark.country);
        binding.imageView.setImageResource(selectedLandMark.image);
    }
}