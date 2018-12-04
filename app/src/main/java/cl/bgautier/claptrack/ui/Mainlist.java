package cl.bgautier.claptrack.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import cl.bgautier.claptrack.R;

public class Mainlist extends AppCompatActivity {

    int[] images = {R.drawable.foto11, R.drawable.foto2, R.drawable.foto3, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11, R.drawable.foto11};

    String[] version = {"Android Alpha", "Android Beta", "Android Cupcake", "Android Donut", "Android Eclair", "Android Froyo", "Android Gingerbread", "Android Honeycomb", "Android Ice Cream Sandwich", "Android JellyBean", "Android Kitkat", "Android Lollipop", "Android Marshmallow", "Android Nougat"};

    String[] versionNumber = {"1.0", "1.1", "1.5", "1.6", "2.0", "2.2", "2.3", "3.0", "4.0", "4.1", "4.4", "5.0", "6.0", "7.0"};

    ListView lView;
    TextView Titulin;

    ListAdaptera lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.large_list);
        Titulin=findViewById(R.id.Titulo);
        Titulin.setText("Find Text");
        setupNavigation();

        lView = (ListView) findViewById(R.id.androidList);

        lAdapter = new ListAdaptera(Mainlist.this, version, versionNumber, images);

        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(Mainlist.this, version[i]+" "+versionNumber[i], Toast.LENGTH_SHORT).show();

            }
        });

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