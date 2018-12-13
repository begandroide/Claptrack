package cl.bgautier.claptrack.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import cl.bgautier.claptrack.R;

public class PreferencesActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferences);
        setupNavigation();
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
