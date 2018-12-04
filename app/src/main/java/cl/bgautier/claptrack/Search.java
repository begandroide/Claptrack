package cl.bgautier.claptrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Search extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView editsearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        setupNavigation();

        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
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

}