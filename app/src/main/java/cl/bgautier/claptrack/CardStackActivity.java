package cl.bgautier.claptrack;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.mikepenz.materialdrawer.Drawer;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;

import java.util.ArrayList;
import java.util.List;



import cl.bgautier.claptrack.Utilities.CardStackAdapter;
import cl.bgautier.claptrack.Utilities.DrawerUtil;
import cl.bgautier.claptrack.Utilities.Spot;
import cl.bgautier.claptrack.Utilities.SpotDiffCallback;

public class CardStackActivity extends AppCompatActivity implements CardStackListener {

    private static final String TAG = CardStackActivity.class.getSimpleName();

    private CardStackLayoutManager manager;
    private CardStackAdapter adapter;
    private CardStackView cardStackView;
    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_stack);
        setupNavigation();
        setupCardStackView();
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void onCardDragging(Direction direction, float ratio) {
        Log.d("CardStackView", "onCardDragging: d = " + direction.name() + ", r = " + ratio);
    }

    @Override
    public void onCardSwiped(Direction direction) {
        Log.d("CardStackView", "onCardSwiped: p = " + manager.getTopPosition() + ", d = " + direction);
        if (manager.getTopPosition() == adapter.getItemCount() - 5) {
            paginate();
        }
    }

    @Override
    public void onCardRewound() {
        Log.d("CardStackView", "onCardRewound: " + manager.getTopPosition());
    }

    @Override
    public void onCardCanceled() {
        Log.d("CardStackView", "onCardCanceled:" + manager.getTopPosition());
    }

    private void setupNavigation() {
        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        mTitle.setTextSize(24);
        mTitle.setText(toolbar.getTitle());
        drawer = DrawerUtil.getDrawer(this, toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

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
}
