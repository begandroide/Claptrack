package cl.bgautier.claptrack.ui;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import cl.bgautier.claptrack.R;

public class WishlistActivity extends AppCompatActivity {

    private static ArrayList<HashMap<String, String>> list_games;
    private SimpleAdapter adapter;
    private ListView lv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wishlist);
        setupNavigation();
        lv = findViewById(R.id.lv_wishlist);
        getGames();
    }

    private void getGames() {
        list_games = new ArrayList<>();
        HashMap<String, String> ayu = new HashMap<>();

        ayu.put("name_game","Red Dead Redemption");
        ayu.put("release_date", "Release Date: 10 Feb,1996");
        ayu.put("tv_platforms", "Platforms: Play4, xboxOne");

        HashMap<String, String> ayu2 = new HashMap<>();

        ayu2.put("name_game","GTA V");
        ayu2.put("release_date", "Release Date: 15 Feb,2016");
        ayu2.put("tv_platforms", "Platforms: Play4, xboxOne");

        HashMap<String, String> ayu3 = new HashMap<>();

        ayu3.put("name_game","Free Fire");
        ayu3.put("release_date", "Release Date: 15 Feb,2018");
        ayu3.put("tv_platforms", "Platforms: Play4, xboxOne, Mobile");


        list_games.add(ayu);
        list_games.add(ayu2);
        list_games.add(ayu3);
        adapter = new SimpleAdapter(this, list_games, R.layout.item_wishlist,
                new String[]{"name_game", "release_date", "tv_platforms"},
                new int[]{R.id.name_game, R.id.release_date, R.id.tv_platforms});
        lv.setAdapter(adapter);

    }


    private void setupNavigation() {
        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_wl);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title_wl);
        mTitle.setText("Claptrack");


        setSupportActionBar(toolbar);
        mTitle.setTextSize(24);
        mTitle.setText(mTitle.getText());
        toolbar.setNavigationIcon(null);
//        drawer = DrawerUtil.getDrawer(this, toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
