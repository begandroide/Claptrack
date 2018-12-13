package cl.bgautier.claptrack.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.yuyakaido.android.cardstackview.*;

import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mikepenz.materialdrawer.Drawer;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.rekotlin.Store;
import org.rekotlin.StoreSubscriber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;


import cl.bgautier.claptrack.ClapTrackApplication;
import cl.bgautier.claptrack.R;
import cl.bgautier.claptrack.Utilities.DrawerUtil;
import cl.bgautier.claptrack.Utilities.MyCardContainerView;
import cl.bgautier.claptrack.Utilities.TouristSpot;
import cl.bgautier.claptrack.Utilities.TouristSpotCardAdapter;
import cl.bgautier.claptrack.actions.LoadGameList;
import cl.bgautier.claptrack.actions.NextGame;
import cl.bgautier.claptrack.models.VideoGameObject;
import cl.bgautier.claptrack.states.AppState;
import cl.bgautier.claptrack.states.GameTrackerState;

public class CardStackActivity extends AppCompatActivity implements StoreSubscriber<GameTrackerState> {

    private static final String TAG = CardStackActivity.class.getSimpleName();

    private ProgressBar progressBar;
    private CardStackView cardStackView;
    private TouristSpotCardAdapter adapter;
    private Drawer drawer;
    private Store<AppState> store = ClapTrackApplication.Companion.getStore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_stack);
        setupNavigation();
        setup();
        reload();
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

    private TouristSpotCardAdapter createTouristSpotCardAdapter() {
        final TouristSpotCardAdapter adapter = new TouristSpotCardAdapter(getApplicationContext());
        adapter.addAll(createTouristSpots());
        return adapter;
    }

    private void setup() {
        progressBar = (ProgressBar) findViewById(R.id.activity_main_progress_bar);

        cardStackView = (CardStackView) findViewById(R.id.activity_main_card_stack_view);
        cardStackView.setCardContainerViewClass(MyCardContainerView.class);
        cardStackView.setCardEventListener(new CardStackView.CardEventListener() {
            @Override
            public void onCardDragging(float percentX, float percentY) {
                Log.d("CardStackView", "onCardDragging");
            }

            @Override
            public void onCardSwiped(SwipeDirection direction) {
                Log.d("CardStackView", "onCardSwiped: " + direction.toString());
                Log.d("CardStackView", "topIndex: " + cardStackView.getTopIndex());
                if (cardStackView.getTopIndex() == adapter.getCount() - 5) {
                    Log.d("CardStackView", "Paginate: " + cardStackView.getTopIndex());
                    paginate();
                }
                store.dispatch(new NextGame());
            }

            @Override
            public void onCardReversed() {
                Log.d("CardStackView", "onCardReversed");
            }

            @Override
            public void onCardMovedToOrigin() {
                Log.d("CardStackView", "onCardMovedToOrigin");
            }

            @Override
            public void onCardClicked(int index) {
                Log.d("CardStackView", "onCardClicked: " + index);
                Intent intent = new Intent(getApplicationContext(), DescriptionActivity.class);
                startActivity(intent);
            }
        });
    }

    private void reload() {
        cardStackView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(() -> {
            adapter = createTouristSpotCardAdapter();
            cardStackView.setAdapter(adapter);
            cardStackView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }, 1000);
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

    public void swipeLeft() {
        List<TouristSpot> spots = extractRemainingTouristSpots();
        if (spots.isEmpty()) {
            return;
        }

        View target = cardStackView.getTopView();

        ValueAnimator rotation = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("rotation", -10f));
        rotation.setDuration(200);
        ValueAnimator translateX = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("translationX", 0f, -2000f));
        ValueAnimator translateY = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("translationY", 0f, 500f));
        translateX.setStartDelay(100);
        translateY.setStartDelay(100);
        translateX.setDuration(500);
        translateY.setDuration(500);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(rotation, translateX, translateY);

        cardStackView.swipe(SwipeDirection.Left, set);

        store.dispatch(new NextGame());
    }

    public void swipeRight() {
        List<TouristSpot> spots = extractRemainingTouristSpots();
        if (spots.isEmpty()) {
            return;
        }

        View target = cardStackView.getTopView();

        ValueAnimator rotation = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("rotation", 10f));
        rotation.setDuration(200);
        ValueAnimator translateX = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("translationX", 0f, 2000f));
        ValueAnimator translateY = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("translationY", 0f, 500f));
        translateX.setStartDelay(100);
        translateY.setStartDelay(100);
        translateX.setDuration(500);
        translateY.setDuration(500);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(rotation, translateX, translateY);

        cardStackView.swipe(SwipeDirection.Right, set);
        store.dispatch(new NextGame());
    }

    private void reverse() {
        cardStackView.reverse();
    }

    private void paginate() {
        cardStackView.setPaginationReserved();
        adapter.addAll(createTouristSpots());
        adapter.notifyDataSetChanged();
    }

    private List<TouristSpot> createTouristSpots() {
        List<TouristSpot> spots = new ArrayList<>();
        //spots.add(new TouristSpot("http://images.igdb.com/igdb/image/upload/t_cover_big_2x/xfx1sfcmnhiriut8aibm.jpg"));
        /*spots.add(new TouristSpot("http://images.igdb.com/igdb/image/upload/t_cover_big_2x/j6etkqnsr5xolxr06ctj.jpg"));
        spots.add(new TouristSpot("http://images.igdb.com/igdb/image/upload/t_cover_big_2x/obrgi1zlum5prc52vcjs.jpg"));
        spots.add(new TouristSpot("http://images.igdb.com/igdb/image/upload/t_cover_big_2x/klrrql6nidmxmmyef7zu.jpg"));
        spots.add(new TouristSpot("http://images.igdb.com/igdb/image/upload/t_cover_big_2x/jfxfycbvrr9bkd1jsv2f.jpg"));*/

        return spots;
    }

    private LinkedList<TouristSpot> extractRemainingTouristSpots() {
        LinkedList<TouristSpot> spots = new LinkedList<>();
        for (int i = cardStackView.getTopIndex(); i < adapter.getCount(); i++) {
            spots.add(adapter.getItem(i));
        }
        return spots;
    }

    private void addLast(String name, String genre, String ranking, String url) {
        LinkedList<TouristSpot> spots = extractRemainingTouristSpots();
        spots.addLast(new TouristSpot(name, genre , ranking, "http://images.igdb.com/igdb/image/upload/t_cover_big_2x/"+url+".jpg"));
        adapter.clear();
        adapter.addAll(spots);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void newState(GameTrackerState state) {
        List<VideoGameObject> games = state.getGameTrackerList();
        int index = state.getCurrentGameIndex();

        if(games != null){
            String genre = "No Information";
            try{
                genre = games.get(index).getGenres().get(0).getName();
            }catch (Exception msg){
                Log.d(TAG, String.valueOf(msg));
            }

            String rank = games.get(index).getRating().toString();

            addLast( StringUtils.abbreviate(games.get(index).getName(), 15),
                    genre , rank.substring(0, Math.min(rank.length(), 2)), games.get(index).getCover().getCloudinary_id());

            //Log.i(TAG,  games.get(index).getName());
            //Log.i(TAG,  games.get(index).getGenres().get(0).getName()); //Agregar try Catch
            //Log.i(TAG, games.get(index).getCover().getCloudinary_id());
            //Log.i(TAG, games.get(index).getRating().toString());
        }
    }
}
