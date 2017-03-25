package forpeeps.picgluewr;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {





    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView = (ImageView) findViewById(R.id.image_view);
        final ImageView imageView1 = (ImageView) findViewById(R.id.image_view1);
        final ImageView imageView2 = (ImageView) findViewById(R.id.image_view2);
        final Context context = this;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BloomActivity.class);
                startActivity(intent);

                finish();
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, BloomActivity.class);
                startActivity(intent1);

                finish();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(context, BloomActivity.class);
                startActivity(intent2);

                finish();
            }
        });




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawwr_main);
        NavigationView navigationView = (NavigationView) findViewById(R.id.delly);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawss:
                        Intent intent = new Intent(MainActivity.this, BloomActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawer(Gravity.START);
                        break;
                    case R.id.animation:
                        Intent intent1 = new Intent(MainActivity.this, AnimationActivity.class);
                        startActivity(intent1);
                        drawerLayout.closeDrawer(Gravity.START);
                        break;
                    case R.id.lels:
                        Intent intent2 = new Intent(MainActivity.this, Stuff_Activity.class);
                        startActivity(intent2);
                        drawerLayout.closeDrawer(Gravity.START);
                        break;
                    case R.id.smash:
                        Intent intentsettings = new Intent(MainActivity.this, Settings.class);
                        startActivity(intentsettings);
                        drawerLayout.closeDrawer(Gravity.START);
                        break;

                }
                return true;
            }
        });
    }
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if
                        (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else {

                    drawerLayout.openDrawer(GravityCompat.START);
                }








                return true;
            default:
                return true;
        }
    }









}
