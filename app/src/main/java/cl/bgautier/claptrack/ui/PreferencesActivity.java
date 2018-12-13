package cl.bgautier.claptrack.ui;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import cl.bgautier.claptrack.R;

public class PreferencesActivity extends AppCompatActivity {

    private static ArrayList<HashMap<String, String>> list_consoles;
    private static ArrayList<HashMap<String, String>> list_genres;
    private SimpleAdapter adapter;
    private ListView lv_consoles;
    private ListView lv_genres;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferences);
        setupNavigation();
        lv_consoles = findViewById(R.id.lv_consoles);
        lv_genres = findViewById(R.id.lv_genres);
        getConsoles();
        getGenres();
        FloatingActionsMenu fab = findViewById(R.id.menu_fab);

        /*btn_new_event.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), .class);
            startActivity(intent);
        });*/
    }

    private void getGenres() {
        list_genres = new ArrayList<>();
        HashMap<String, String> ayu = new HashMap<>();

        ayu.put("text_item_preferences","Platformer");
        ayu.put("lv_image_preference", Integer.toString(R.drawable.plataformer));

        HashMap<String, String> ayu2 = new HashMap<>();

        ayu2.put("text_item_preferences","Horror");
        ayu2.put("lv_image_preference", Integer.toString(R.drawable.horror));

        HashMap<String, String> ayu3 = new HashMap<>();

        ayu3.put("text_item_preferences","RPG");
        ayu3.put("lv_image_preference", Integer.toString(R.drawable.rpg));


        list_genres.add(ayu);
        list_genres.add(ayu2);
        list_genres.add(ayu3);
        adapter = new SimpleAdapter(this, list_genres, R.layout.listview_item_preferences,
                new String[]{"text_item_preferences", "lv_image_preference"},
                new int[]{R.id.text_item_preferences, R.id.lv_image_preference});
        lv_genres.setAdapter(adapter);

    }

    private void getConsoles() {
        list_consoles = new ArrayList<>();
        HashMap<String, String> ayu = new HashMap<>();

        ayu.put("text_item_preferences","Playstation 4");
        ayu.put("lv_image_preference", Integer.toString(R.drawable.ps4));

        HashMap<String, String> ayu2 = new HashMap<>();

        ayu2.put("text_item_preferences","PC");
        ayu2.put("lv_image_preference", Integer.toString(R.drawable.pc));

        HashMap<String, String> ayu3 = new HashMap<>();

        ayu3.put("text_item_preferences","Xbox One");
        ayu3.put("lv_image_preference", Integer.toString(R.drawable.one));


        list_consoles.add(ayu);
        list_consoles.add(ayu2);
        list_consoles.add(ayu3);
        adapter = new SimpleAdapter(this, list_consoles, R.layout.listview_item_preferences,
                new String[]{"text_item_preferences", "lv_image_preference"},
                new int[]{R.id.text_item_preferences, R.id.lv_image_preference});
        lv_consoles.setAdapter(adapter);
    }


    private void setupNavigation() {
        Toolbar toolbar = findViewById(R.id.toolbar_preferences);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title_preferences);
        mTitle.setText("Preferences");
        setSupportActionBar(toolbar);
        mTitle.setTextSize(24);
        mTitle.setText(mTitle.getText());
        toolbar.setNavigationIcon(null);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
