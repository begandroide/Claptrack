package cl.bgautier.claptrack.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import cl.bgautier.claptrack.R;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;

public class platformActivity extends AppCompatActivity
{
    private Button btn_play4;
    private Button btn_play3;
    private Button btn_nswitch;
    private Button btn_threds;
    private Button btn_one;
    private Button btn_pc;
    private ImageView im_play4;
    private ImageView im_play3;
    private ImageView im_nswitch;
    private ImageView im_threds;
    private ImageView im_one;
    private ImageView im_pc;
    private Toolbar mToolbar;
    private Drawer drawer;

    private void obtainPlatormsViews() {
        btn_play4 = findViewById(R.id.btn_play4);
        btn_play3= findViewById(R.id.btn_play3);
        btn_nswitch= findViewById(R.id.btn_nswitch);
        btn_threds = findViewById(R.id.btn_threds);
        btn_one= findViewById(R.id.btn_one);
        btn_pc= findViewById(R.id.btn_pc);

        im_play4 = findViewById(R.id.im_play4);
        im_play3= findViewById(R.id.im_play3);
        im_nswitch= findViewById(R.id.im_nswitch);
        im_threds = findViewById(R.id.im_threds);
        im_one= findViewById(R.id.im_one);
        im_pc= findViewById(R.id.im_pc);

        btn_play4.setVisibility(View.INVISIBLE);
        btn_play3.setVisibility(View.INVISIBLE);
        btn_nswitch.setVisibility(View.INVISIBLE);
        btn_threds.setVisibility(View.INVISIBLE);
        btn_one.setVisibility(View.INVISIBLE);
        btn_pc.setVisibility(View.INVISIBLE);

        mToolbar = findViewById(R.id.toolbar_plat);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourites_platforms);

        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.menu.action_bar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //TextView aa= findViewById(R.id.title_menu);
        //aa.setText("Select Yours Platforms");

        findViewById(R.id.btn_finalize_welcome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CardStackActivity.class);
                startActivity(intent);
                finish();
            }
        });

        obtainPlatormsViews();
        setOnclickAll();
        setToolbar();

    }

    public void setToolbar(){
        TextView tv_fav_cat = findViewById(R.id.toolbar_title_plat);
        tv_fav_cat.setText("Select Your Platforms");

        setSupportActionBar(mToolbar);
        tv_fav_cat.setTextSize(24);
        tv_fav_cat.setText(tv_fav_cat.getText());
        mToolbar.setNavigationIcon(null);
        //drawer = DrawerUtil.getDrawer(this, mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);

        return true;
    }

    private void setOnclickAll() {
        im_play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_play4.setVisibility(View.VISIBLE);
                Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_play4.setVisibility(View.INVISIBLE);
            }
        });
        im_play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_play3.setVisibility(View.VISIBLE);
                Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_play3.setVisibility(View.INVISIBLE);
            }
        });
        im_nswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_nswitch.setVisibility(View.VISIBLE);
                Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_nswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_nswitch.setVisibility(View.INVISIBLE);
            }
        });
        im_threds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_threds.setVisibility(View.VISIBLE);
                Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_threds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_threds.setVisibility(View.INVISIBLE);
            }
        });
        im_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_one.setVisibility(View.VISIBLE);
                Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_one.setVisibility(View.INVISIBLE);
            }
        });
        im_pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_pc.setVisibility(View.VISIBLE);
                Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_pc.setVisibility(View.INVISIBLE);
            }
        });

    }
}
