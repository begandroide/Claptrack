package cl.bgautier.claptrack.Utilities;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;


import cl.bgautier.claptrack.R;

public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Spot> spots;

    public CardStackAdapter(Context context, List<Spot> spots) {
        this.inflater = LayoutInflater.from(context);
        this.spots = spots;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_spot, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Spot spot = spots.get(position);
        Glide.with(holder.image)
                .load(spot.url)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return spots.size();
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        ViewHolder(View view) {
            super(view);
            this.image = view.findViewById(R.id.item_image);
        }
    }

}
