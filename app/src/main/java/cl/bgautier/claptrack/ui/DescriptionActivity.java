package cl.bgautier.claptrack.ui;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.mikepenz.materialdrawer.Drawer;

import java.util.ArrayList;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import cl.bgautier.claptrack.R;
import cl.bgautier.claptrack.Utilities.DrawerUtil;

public class DescriptionActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private Drawer drawer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);
        setupNavigation();

        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.action_bar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView titulo= findViewById(R.id.Titulo);
        titulo.setText("Game name");

        TextView release= findViewById(R.id.Release);
        release.setText("Day Month Year , diff release date");

        TextView study= findViewById(R.id.Study);
        study.setText("Developer company");


        TextView rating= findViewById(R.id.Rating);
        rating.setText("Rating: X");

        TextView genre= findViewById(R.id.Genre);
        genre.setText("Genre: Genre 1, Genre 2, Genre 3");

        TextView platforms= findViewById(R.id.Platforms);
        platforms.setText("Platorms: Plataform 1, Plataform 2");

        TextView versions= findViewById(R.id.Versions);
        versions.setText("Versions: Show versions available");

        TextView description= findViewById(R.id.Description);
        description.setText("Description Description Description Description Description Description Description Description Description");


        //TextView aa= findViewById(R.id.title_menu);
        //aa.setText("Claptrack");

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
}
