package cl.bgautier.claptrack.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;
import android.widget.TextView;

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

public class Search extends AppCompatActivity implements SearchView.OnQueryTextListener, StoreSubscriber<SearchState> {

    SearchView editsearch;
    //private Store<AppState> store = ClapTrackApplication.Companion.getStore();

    public static String Texto=new String();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        setupNavigation();
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);

    }

    /*@Override
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
    }*/

    @Override
    public boolean onQueryTextSubmit(String query) {
        //store.dispatch(new SearchGame(query));
        Texto=query;
        Intent myintent = new Intent(getApplicationContext(),Mainlist.class);
        startActivity(myintent);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        return true;
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
        /*if(searchState != null){
            List<VideoGameObject> games = searchState.getResults();
            if(games != null){
                for(VideoGameObject game : games){
                    Log.i("Game Result", game.getName());
                }
            }
        }*/
    }
}