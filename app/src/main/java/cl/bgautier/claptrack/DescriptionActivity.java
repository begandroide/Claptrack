package cl.bgautier.claptrack;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import cl.bgautier.claptrack.Utilities.DrawerUtil;

public class DescriptionActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mImageUrls = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);


        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.action_bar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView titulo= findViewById(R.id.Titulo);
        titulo.setText("Red Dead Redemption 2");

        TextView release= findViewById(R.id.Release);
        release.setText("26th Oct 2018 , a month ago");

        TextView study= findViewById(R.id.Study);
        study.setText("Rockstar Studios");


        TextView rating= findViewById(R.id.Rating);
        rating.setText("Rating: M");

        TextView genre= findViewById(R.id.Genre);
        genre.setText("Genre: Adventure, RPG, Shooter");

        TextView platforms= findViewById(R.id.Platforms);
        platforms.setText("Platorms: Xbox One, PlayStation 4");

        TextView versions= findViewById(R.id.Versions);
        versions.setText("Versions: See 3 more versions of this game");

        TextView description= findViewById(R.id.Description);
        description.setText("Developed by the creators of Grand Theft Auto V and Red Dead Redemption, Red Dead Redemption 2 is an epic tale of life in America’s unforgiving heartland. The game's vast and atmospheric world will also provide the foundation for a brand new online multiplayer experience.");


        //TextView aa= findViewById(R.id.title_menu);
        //aa.setText("Claptrack");















    }
}
