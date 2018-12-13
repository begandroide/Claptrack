package cl.bgautier.claptrack.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import cl.bgautier.claptrack.R;

import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;

import java.util.HashMap;

public class platformActivity extends AppCompatActivity implements GestureDetector.OnGestureListener
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
    private GestureDetector gestureDetector;


    private HashMap<String,Integer> elected;

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


        elected = new HashMap<>();
        elected.put("play3",0);
        elected.put("play4",0);
        elected.put("nintendo_switch",0);
        elected.put("nintendo_3ds",0);
        elected.put("xbox_one",0);
        elected.put("pc",0);

        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.menu.action_bar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //TextView aa= findViewById(R.id.title_menu);
        //aa.setText("Select Yours Platforms");

        gestureDetector = new GestureDetector(platformActivity.this, platformActivity.this);

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
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
                elected.put("play4",1);
                Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_play4.setVisibility(View.INVISIBLE);
                elected.put("play4",0);
            }
        });
        im_play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_play3.setVisibility(View.VISIBLE);
                elected.put("play3",1);
                Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_play3.setVisibility(View.INVISIBLE);
                elected.put("play3",0);
            }
        });
        im_nswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_nswitch.setVisibility(View.VISIBLE);
                elected.put("nintendo_switch",1);
                Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_nswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_nswitch.setVisibility(View.INVISIBLE);
                elected.put("nintendo_switch",0);
            }
        });
        im_threds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_threds.setVisibility(View.VISIBLE);
                elected.put("nintendo_3ds",1);
                Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_threds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_threds.setVisibility(View.INVISIBLE);
                elected.put("nintendo_3ds",0);
            }
        });
        im_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_one.setVisibility(View.VISIBLE);
                elected.put("xbox_one",1);
                Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_one.setVisibility(View.INVISIBLE);
                elected.put("xbox_one",0);
            }
        });
        im_pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_pc.setVisibility(View.VISIBLE);
                elected.put("pc",1);
                Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_pc.setVisibility(View.INVISIBLE);
                elected.put("pc",0);
            }
        });

    }



    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y) {
        if (motionEvent1.getY() - motionEvent2.getY() > 50) {
            //Toast.makeText(MainActivity.this, "You Swiped up!", Toast.LENGTH_LONG).show();
            return true;
        }

        if (motionEvent1.getX() - motionEvent2.getX() > 50 ){
            Toast.makeText(platformActivity.this, "You Swiped Left!", Toast.LENGTH_LONG).show();
            //aqui es necesario guardar los elegidos, estan en hashmaps elected
            Intent intent = new Intent(this, CardStackActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        if (motionEvent2.getX() - motionEvent1.getX() > 50) {
            Toast.makeText(platformActivity.this, "You Swiped Right!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, categoryActivity.class);
            startActivity(intent);
            finish();
            return true;
        } else {
            return true;
        }
    }

    @Override
    public void onLongPress(MotionEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        // TODO Auto-generated method stub
        return gestureDetector.onTouchEvent(motionEvent);
    }

    @Override
    public boolean onDown(MotionEvent arg0) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent e)
    {
        super.dispatchTouchEvent(e);
        return gestureDetector.onTouchEvent(e);
    }

}
