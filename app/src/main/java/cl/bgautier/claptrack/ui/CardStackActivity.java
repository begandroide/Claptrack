package cl.bgautier.claptrack.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.DiffUtil;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.mikepenz.materialdrawer.Drawer;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;

import org.rekotlin.Store;
import org.rekotlin.StoreSubscriber;

import java.util.ArrayList;
import java.util.List;


import cl.bgautier.claptrack.ClapTrackApplication;
import cl.bgautier.claptrack.R;
import cl.bgautier.claptrack.Utilities.CardStackAdapter;
import cl.bgautier.claptrack.Utilities.DrawerUtil;
import cl.bgautier.claptrack.Utilities.Spot;
import cl.bgautier.claptrack.Utilities.SpotDiffCallback;
import cl.bgautier.claptrack.actions.LoadGameList;
import cl.bgautier.claptrack.models.VideoGameObject;
import cl.bgautier.claptrack.states.AppState;
import cl.bgautier.claptrack.states.GameTrackerState;

public class CardStackActivity extends AppCompatActivity implements CardStackListener, StoreSubscriber<GameTrackerState> {

    private static final String TAG = CardStackActivity.class.getSimpleName();

    private CardStackLayoutManager manager;
    private CardStackAdapter adapter;
    private CardStackView cardStackView;
    private Drawer drawer;
    private Store<AppState> store = ClapTrackApplication.Companion.getStore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_stack);
        setupNavigation();
        store.dispatch(new LoadGameList());
    }

    @Override
    protected void onStart(){
        super.onStart();
        store.subscribe(this, it ->
            it.select(select -> select.getGameTrackerState()));
    }

    @Override
    protected void onStop(){
        super.onStop();
        store.unsubscribe(this);
    }
    @Override
    public void onBackPressed() {
    }

    @Override
    public void onCardDragging(Direction direction, float ratio) {
        Log.d(TAG, "onCardDragging: d = " + direction.name() + ", r = " + ratio);
        if(direction.name().equals("Top")){
            Intent intent = new Intent(this, DescriptionActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            this.startActivity(intent);
        }
    }

    @Override
    public void onCardSwiped(Direction direction) {
        Log.d(TAG, "onCardSwiped: p = " + manager.getTopPosition() + ", d = " + direction);
        if (manager.getTopPosition() == adapter.getItemCount() - 5) {
            paginate();
        }
    }

    @Override
    public void onCardRewound() {
        Log.d(TAG, "onCardRewound: " + manager.getTopPosition());
    }

    @Override
    public void onCardCanceled() {
        Log.d(TAG, "onCardCanceled:" + manager.getTopPosition());
    }

    private void setupNavigation() {
        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        mTitle.setTextSize(24);
        mTitle.setText(toolbar.getTitle());
        toolbar.setNavigationIcon(R.drawable.next); // drawable sirve de dummy para hacer el menu hamburguesa
        drawer = DrawerUtil.getDrawer(this, toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar, menu);

        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Here is the link to the full review: ");
                intent.setType("text/plain");
                this.startActivity(Intent.createChooser(intent, "Send To"));
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    private void setupCardStackView() {
        initialize();
    }



    private void initialize() {
        manager = new CardStackLayoutManager(getApplicationContext(), this);
        manager.setStackFrom(StackFrom.None);
        manager.setVisibleCount(3);
        manager.setTranslationInterval(8.0f);
        manager.setScaleInterval(0.95f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(Direction.HORIZONTAL);
        manager.setCanScrollHorizontal(true);
        manager.setCanScrollVertical(true);
        adapter = new CardStackAdapter(this, createSpots());
        cardStackView = findViewById(R.id.card_stack_view);
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);
    }

    private void paginate() {
        List<Spot> oldList = adapter.getSpots();
        List<Spot> newList = new ArrayList<Spot>() {{
            addAll(adapter.getSpots());
            addAll(createSpots());
        }};
        SpotDiffCallback callback = new SpotDiffCallback(oldList, newList);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);
        adapter.setSpots(newList);
        result.dispatchUpdatesTo(adapter);
    }

    private List<Spot> createSpots() {
        List<Spot> spots = new ArrayList<>();
        spots.add(new Spot("http://images.igdb.com/igdb/image/upload/t_cover_big_2x/xfx1sfcmnhiriut8aibm.jpg"));
        spots.add(new Spot("http://images.igdb.com/igdb/image/upload/t_cover_big_2x/j6etkqnsr5xolxr06ctj.jpg"));
        spots.add(new Spot("http://images.igdb.com/igdb/image/upload/t_cover_big_2x/obrgi1zlum5prc52vcjs.jpg"));
        spots.add(new Spot("http://images.igdb.com/igdb/image/upload/t_cover_big_2x/klrrql6nidmxmmyef7zu.jpg"));
        spots.add(new Spot("http://images.igdb.com/igdb/image/upload/t_cover_big_2x/jfxfycbvrr9bkd1jsv2f.jpg"));

        return spots;
    }

    @Override
    public void newState(GameTrackerState state) {
        List<VideoGameObject> games = state.getGameTrackerList();
        if(games != null){
            for(VideoGameObject game : games){
                Log.i(TAG,  game.getName());
            }
        }
    }
}
