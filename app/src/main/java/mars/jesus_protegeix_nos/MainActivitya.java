package mars.jesus_protegeix_nos;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivitya extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitya);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewFlipper vf = findViewById(R.id.vf);
        vf.setDisplayedChild(2);
        TextView title=findViewById(R.id.title);
        Typeface face= Typeface.createFromAsset(getAssets(),"fonts/IDroid.otf");
        title.setTypeface(face);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        anima();
        //amaga();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
private void anima(){

    new CountDownTimer(500, 1) {


        public void onTick(long millisUntilFinished) {

        }

        public void onFinish() {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.openDrawer(GravityCompat.START);
            amaga();
        }
    }.start();
}
    private void amaga(){

        new CountDownTimer(500, 1) {


            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        }.start();
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activitya, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            ViewFlipper vf = findViewById(R.id.vf);
            vf.setDisplayedChild(2);
        } else if (id == R.id.torque) {
            ViewFlipper vf = findViewById(R.id.vf);
           vf.setDisplayedChild(0);
        } else if (id == R.id.speed) {
            ViewFlipper vf = findViewById(R.id.vf);
            vf.setDisplayedChild(1);
        } else if (id == R.id.torqueengranatge) {

        } else if (id == R.id.nav_share) {
            String shareBody = "Hey, try this fantastic robotics calculator app on Play Store";
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.share_using)));
        } else if (id == R.id.info) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void calcula(View view){
        EditText mass=findViewById(R.id.massa);
        EditText dis=findViewById(R.id.distancia);
        TextView jaume = findViewById(R.id.jaume);
        String ma = mass.getText().toString();
        String di = dis.getText().toString();
        if(ma.equals("") && di.equals("")){
            Toast.makeText(this, "Has deixat camps buits borinot", Toast.LENGTH_SHORT).show();
        }
        else {

            double massa = Double.parseDouble(ma);
            double distance = Double.parseDouble(di);
            double Torque;
            double gravity = 9.8;
            Torque = ((massa * gravity) / distance);
            String nieves = Double.toString(Torque);
            jaume.setText(nieves);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(this);
            }
            builder.setTitle("Sortir")
                    .setMessage("Segur que vols sortir??")
                    .setPositiveButton("si", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                          finish();
                        }
                    })
                    .setNegativeButton("no", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
