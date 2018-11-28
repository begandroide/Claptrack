package cl.bgautier.claptrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class categoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourits_categories);

        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        TextView tv_title_menu = findViewById(R.id.title_menu);
        tv_title_menu.setText("Select Favourite Categories");

        /*Listener only for "jump"  to next Activity
            This must be: User most select favourites categories
            from the GridLayout and go to next activity, i.e election
            of platforms.
        */
        findViewById(R.id.im_not).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), platformActivity.class);
                startActivity(intent);
                //finish();
            }
        });
    }
}
