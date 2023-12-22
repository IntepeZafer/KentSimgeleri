package com.example.landmarkbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.landmarkbook.databinding.RecylerRowBinding;

import java.util.ArrayList;

public class landmarAdapter extends RecyclerView.Adapter<landmarAdapter.landmarkHolder> {
    ArrayList<Landmark> landmarkArrayList;
    public  landmarAdapter(ArrayList<Landmark> landmarkArrayList){
        this.landmarkArrayList = landmarkArrayList;
    }
    @NonNull
    @Override
    public landmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecylerRowBinding recylerRowBinding = RecylerRowBinding.inflate(LayoutInflater.from(parent.getContext()) , parent , false);
        return new landmarkHolder(recylerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull landmarkHolder holder, int position) {
        holder.binding.recylerViewText.setText(landmarkArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext() , DetailsActivity.class);
                //SelectedLandmark = landmarkArrayList.get(position);
                // intent.putExtra("landmark" , landmarkArrayList.get(position));
                Singelton singelton = Singelton.getInstance();
                singelton.setSentLadmark(landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
    }

    public class landmarkHolder extends RecyclerView.ViewHolder{
        private RecylerRowBinding binding;
        public landmarkHolder(RecylerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
