package cl.bgautier.claptrack;

import android.content.Intent;
import android.graphics.ColorFilter;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class categoryActivity extends AppCompatActivity {

    private Button btn_cate_adv;
    private Button btn_cate_rpg;
    private Button btn_cate_platformer;
    private Button btn_cate_horror;
    private Button btn_cate_sports;
    private ImageView im_cate_adv;
    private ImageView im_cate_rpg;
    private ImageView im_cate_platformer;
    private ImageView im_cate_horror;
    private ImageView im_cate_sports;

    private void obtainCategoriesViews() {
        btn_cate_adv = findViewById(R.id.btn_cate_adv);
        btn_cate_rpg = findViewById(R.id.btn_cate_rpg);
        btn_cate_platformer = findViewById(R.id.btn_cate_platformer);
        btn_cate_horror = findViewById(R.id.btn_cate_horror);
        btn_cate_sports = findViewById(R.id.btn_cate_sports);
        im_cate_adv = findViewById(R.id.im_adv);
        im_cate_rpg = findViewById(R.id.im_cate_rpg);
        im_cate_platformer = findViewById(R.id.im_cate_platformer);
        im_cate_horror = findViewById(R.id.im_cate_horror);
        im_cate_sports = findViewById(R.id.im_cate_sports);

        btn_cate_adv.setVisibility(View.INVISIBLE);
        btn_cate_rpg.setVisibility(View.INVISIBLE);
        btn_cate_platformer.setVisibility(View.INVISIBLE);
        btn_cate_horror.setVisibility(View.INVISIBLE);
        btn_cate_sports.setVisibility(View.INVISIBLE);
    }

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

        obtainCategoriesViews();
        setOnclickAll();
    }

    private void setOnclickAll()
    {
        im_cate_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_adv.setVisibility(View.VISIBLE);
                Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_cate_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_adv.setVisibility(View.INVISIBLE);
            }
        });

        im_cate_rpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_rpg.setVisibility(View.VISIBLE);
                Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_cate_rpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_rpg.setVisibility(View.INVISIBLE);
            }
        });
        im_cate_platformer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_platformer.setVisibility(View.VISIBLE);
                Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_cate_platformer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_platformer.setVisibility(View.INVISIBLE);
            }
        });
        im_cate_horror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_horror.setVisibility(View.VISIBLE);
                Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_cate_horror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_horror.setVisibility(View.INVISIBLE);
            }
        });
        im_cate_sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_sports.setVisibility(View.VISIBLE);
                Toast.makeText(getBaseContext(),"lo presionaste", Toast.LENGTH_LONG);
            }
        });
        btn_cate_sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cate_sports.setVisibility(View.INVISIBLE);
            }
        });


    }



}
