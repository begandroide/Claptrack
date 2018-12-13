package cl.bgautier.claptrack.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;


import com.example.eduardopozo.claptrack.actions.SearchGame;

import org.rekotlin.Store;
import org.rekotlin.StoreSubscriber;


import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import cl.bgautier.claptrack.ClapTrackApplication;
import cl.bgautier.claptrack.R;
import cl.bgautier.claptrack.models.VideoGameObject;
import cl.bgautier.claptrack.states.AppState;
import cl.bgautier.claptrack.states.SearchState;

public class Mainlist extends AppCompatActivity implements StoreSubscriber<SearchState> {

    private Store<AppState> store = ClapTrackApplication.Companion.getStore();

    List <Integer> images = new ArrayList<>();
    List <String> version = new ArrayList<>();
    List <String> generos = new ArrayList<>();

    List <String> versionNumber = new ArrayList<>();
    ImageView imageView;
    //int[] images = {R.drawable.foto11, R.drawable.foto2, R.drawable.foto3, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11};

    //String[] version = {"Android Alpha", "Android Beta", "Android Cupcake", "Android Donut", "Android Eclair", "Android Froyo", "Android Gingerbread", "Android Honeycomb", "Android Ice Cream Sandwich", "Android JellyBean", "Android Kitkat", "Android Lollipop", "Android Marshmallow", "Android Nougat"};

    //String[] versionNumber = {"1.0", "1.1", "1.5", "1.6", "2.0", "2.2", "2.3", "3.0", "4.0", "4.1", "4.4", "5.0", "6.0", "7.0"};

    ListView lView;
    TextView Titulin;



    ListAdaptera lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.large_list);
        Titulin=findViewById(R.id.Titulo);
        Titulin.setText(Search.Texto);


        setupNavigation();
        store.dispatch(new SearchGame(Search.Texto));



    }

    @Override
    protected void onStart(){
        super.onStart();
        store.subscribe(this, it ->
                it.select(select -> select.getSearchState())
        );
    }

    @Override
    protected void onStop(){
        super.onStop();
        store.unsubscribe(this);
    }
    private void setupNavigation() {
        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_desc);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title_desc);
        mTitle.setText("Claptrack");


        setSupportActionBar(toolbar);
        mTitle.setTextSize(24);
        mTitle.setText(mTitle.getText());
        toolbar.setNavigationIcon(null);
//        drawer = DrawerUtil.getDrawer(this, toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    @Override
    public void newState(SearchState searchState) {
        System.out.println("Entre aca");


        if(searchState != null){
            List<VideoGameObject> games = searchState.getResults();
            if(games != null){
                for(VideoGameObject game : games){
                    try {
                        game.getDevelopers().get(0).getName();
                        images.add(R.drawable.foto11);
                        generos.add(game.getGenres().get(0).getName());
                        versionNumber.add(game.getDevelopers().get(0).getName());
                        version.add(game.getName());
                        Log.i("Game Result", game.getName());
                    }
                    catch (Exception e){
                        System.out.println("jeje");
                    }

                }
            }
        }
        lView = (ListView) findViewById(R.id.androidList);

        lAdapter = new ListAdaptera(Mainlist.this, version, versionNumber, generos, images);

        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(Mainlist.this, version.get(i)+" "+versionNumber.get(i)+" "+generos.get(i), Toast.LENGTH_SHORT).show();

            }
        });
    }
}