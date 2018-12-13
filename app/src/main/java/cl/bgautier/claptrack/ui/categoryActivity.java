package cl.bgautier.claptrack.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import cl.bgautier.claptrack.R;
import cl.bgautier.claptrack.Utilities.DrawerUtil;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;

import java.util.HashMap;

public class categoryActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private Toolbar mToolbar;
    private Button btn_cate_shooter;
    private Button btn_cate_adv;
    private Button btn_cate_rpg;
    private Button btn_cate_platformer;
    private Button btn_cate_horror;
    private Button btn_cate_sports;
    private ImageView im_cate_shooter;
    private ImageView im_cate_adv;
    private ImageView im_cate_rpg;
    private ImageView im_cate_platformer;
    private ImageView im_cate_horror;
    private ImageView im_cate_sports;
    private Drawer drawer;
    GestureDetector gestureDetector;

    private HashMap<String,Integer>  elected;

    private void obtainCategoriesViews() {
        btn_cate_shooter = findViewById(R.id.btn_cate_shooter);
        btn_cate_adv = findViewById(R.id.btn_cate_adv);
        btn_cate_rpg = findViewById(R.id.btn_cate_rpg);
        btn_cate_platformer = findViewById(R.id.btn_cate_platformer);
        btn_cate_horror = findViewById(R.id.btn_cate_horror);
        btn_cate_sports = findViewById(R.id.btn_cate_sports);
        im_cate_shooter = findViewById(R.id.im_cate_shooter);
        im_cate_adv = findViewById(R.id.im_adv);
        im_cate_rpg = findViewById(R.id.im_cate_rpg);
        im_cate_platformer = findViewById(R.id.im_cate_platformer);
        im_cate_horror = findViewById(R.id.im_cate_horror);
        im_cate_sports = findViewById(R.id.im_cate_sports);

        btn_cate_shooter.setVisibility(View.INVISIBLE);
        btn_cate_adv.setVisibility(View.INVISIBLE);
        btn_cate_rpg.setVisibility(View.INVISIBLE);
        btn_cate_platformer.setVisibility(View.INVISIBLE);
        btn_cate_horror.setVisibility(View.INVISIBLE);
        btn_cate_sports.setVisibility(View.INVISIBLE);

        mToolbar = findViewById(R.id.toolbar_cat);
    }

        @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourits_categories);

        elected = new HashMap<>();
        elected.put("shooter",0);
        elected.put("adventure",0);
        elected.put("rpg",0);
        elected.put("platformer",0);
        elected.put("horror",0);
        elected.put("sports",0);

        gestureDetector = new GestureDetector(categoryActivity.this, categoryActivity.this);

        obtainCategoriesViews();
        setOnclickAll();
        setToolbar();

    }

    public void setToolbar(){
        TextView tv_fav_cat = findViewById(R.id.toolbar_title_cat);
        tv_fav_cat.setText("Select Favourite Categories");

        setSupportActionBar(mToolbar);
        tv_fav_cat.setTextSize(24);
        tv_fav_cat.setText(tv_fav_cat.getText());
        mToolbar.setNavigationIcon(null);
        drawer = DrawerUtil.getDrawer(this, mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


    }


    private void setOnclickAll()
    {
        im_cate_shooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_shooter.setVisibility(View.VISIBLE);
                elected.put("shooter",1);
               // Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG).show();
            }
        });
        btn_cate_shooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_shooter.setVisibility(View.INVISIBLE);
                elected.put("shooter",0);
            }
        });
        im_cate_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_adv.setVisibility(View.VISIBLE);
                elected.put("adventure",1);
                //Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG).show();
            }
        });
        btn_cate_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_adv.setVisibility(View.INVISIBLE);
                elected.put("adventure",0);
            }
        });

        im_cate_rpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_rpg.setVisibility(View.VISIBLE);
                elected.put("rpg",1);
                //Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_cate_rpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_rpg.setVisibility(View.INVISIBLE);
                elected.put("rpg",0);
            }
        });
        im_cate_platformer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_platformer.setVisibility(View.VISIBLE);
                elected.put("platformer",1);
                //Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_cate_platformer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_platformer.setVisibility(View.INVISIBLE);
                elected.put("platformer",0);
            }
        });
        im_cate_horror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_horror.setVisibility(View.VISIBLE);
                elected.put("horror",1);
                //Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_cate_horror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_horror.setVisibility(View.INVISIBLE);
                elected.put("horror",0);
            }
        });
        im_cate_sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_sports.setVisibility(View.VISIBLE);
                elected.put("sports",1);
                //Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_cate_sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_sports.setVisibility(View.INVISIBLE);
                elected.put("sports",0);
            }
        });


    }


    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y) {
        if (motionEvent1.getY() - motionEvent2.getY() > 50) {
            //Toast.makeText(MainActivity.this, "You Swiped up!", Toast.LENGTH_LONG).show();
            return true;
        }

        if (motionEvent1.getX() - motionEvent2.getX() > 30 ){
            Toast.makeText(categoryActivity.this, "You Swiped Left!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, platformActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        if (motionEvent2.getX() - motionEvent1.getX() > 30) {
            Toast.makeText(categoryActivity.this, "You Swiped Right!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
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
