package cl.bgautier.claptrack.Utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import cl.bgautier.claptrack.R;

public class TouristSpotCardAdapter extends ArrayAdapter<TouristSpot> {

    public TouristSpotCardAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        ViewHolder holder;

        if (contentView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            contentView = inflater.inflate(R.layout.item_tourist_spot_card, parent, false);
            holder = new ViewHolder(contentView);
            contentView.setTag(holder);
        } else {
            holder = (ViewHolder) contentView.getTag();
        }

        TouristSpot spot = getItem(position);

        Glide.with(getContext()).load(spot.url).into(holder.image);

        holder.ivInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Go to info!", Toast.LENGTH_SHORT).show();
            }
        });

        return contentView;
    }

    private static class ViewHolder {
        public ImageView image;
        public ImageView ivInfo;

        public ViewHolder(View view) {
            this.image = (ImageView) view.findViewById(R.id.item_tourist_spot_card_image);
            this.ivInfo = (ImageView) view.findViewById(R.id.iv_info);
        }
    }

}

