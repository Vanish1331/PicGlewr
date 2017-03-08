package forpeeps.picgluewr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		 getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) { // если нажали на
            case android.R.id.home:
                DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawwr_main);
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
