package cl.bgautier.claptrack.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cl.bgautier.claptrack.R;


public class ListAdaptera extends BaseAdapter {

    Context context;
    private final List<String> values;
    private final List<String> numbers;
    private final List<String> generos;
    private final List<Integer> images;

    public ListAdaptera(Context context, List<String> values, List<String> numbers,List<String> generos, List<Integer> images){
        //super(context, R.layout.single_list_app_item, utilsArrayList);
        this.context = context;
        this.values = values;
        this.numbers = numbers;
        this.generos=generos;
        this.images = images;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.single_list_items, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.aNametxt);
            viewHolder.txtVersion = (TextView) convertView.findViewById(R.id.aVersiontxt);
            viewHolder.txtVersiona = (TextView) convertView.findViewById(R.id.aVersiontxta);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.appIconIV);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }



        viewHolder.txtName.setText(values.get(position));
        viewHolder.txtVersion.setText("Developer: "+numbers.get(position));
        viewHolder.txtVersiona.setText("Genre: "+generos.get(position));
        viewHolder.icon.setImageResource(images.get(position));

        return convertView;
    }



    private static class ViewHolder {

        TextView txtName;
        TextView txtVersion;
        TextView txtVersiona;
        ImageView icon;

    }

}