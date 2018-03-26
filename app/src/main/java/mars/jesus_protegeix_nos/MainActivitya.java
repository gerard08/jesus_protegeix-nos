package mars.jesus_protegeix_nos;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
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
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MainActivitya extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, RewardedVideoAdListener {
    int add;
    int vaqueta;
    private InterstitialAd anunci;
    private RewardedVideoAd mRewardedVideoAd;
    private AdView mAdView;
    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        check();
        setContentView(R.layout.activity_main_activitya);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        checkInternetPermission();
        ViewFlipper vf = findViewById(R.id.vf);
        vf.setDisplayedChild(2);
        banner();
        TextView title = findViewById(R.id.title);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/IDroid.otf");
        title.setTypeface(face);
        TextView explica = findViewById(R.id.explanation);
        Typeface casual = Typeface.createFromAsset(getAssets(), "fonts/Fonti.ttf");
        explica.setText("Hey, we are Mars developers and we have made this app for everyone that like us hates calculating torque between motors and bars or the robot speed." + "\n" + "If you swipe from the left part of the screen, you will see a menu. There are all the operations that you can do with this aplicattion. There are a few options too, like the share option, the gear tooth option, where you can see how much tooths have each vex gear, and finally an option to remove adds for 5 minutes watching a video.\n \n So, ready, set, let's robotics!");
        explica.setTypeface(casual);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        MobileAds.initialize(this, "ca-app-pub-3420122580859776~5041149632");
        drawer.openDrawer(GravityCompat.START);
        amaga();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        anuncis();
    }

    private void anuncis() {
        ///////////////////////////
        add();
        //////////////////////////7
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        mRewardedVideoAd.loadAd("ca-app-pub-3420122580859776/2237525348",
                new AdRequest.Builder().build());
        //////////////////////////

    }

    private void add() {
        anunci = new InterstitialAd(this);
        anunci.setAdUnitId("ca-app-pub-3420122580859776/2273130464");
        anunci.loadAd(new AdRequest.Builder().build());
    }

    private void call() {
        if (anunci.isLoaded()) {
            anunci.show();
        } else {
            add();
        }
    }

    private void banner() {
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void checkInternetPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 3);
        }
    }

    private void amaga() {

        new CountDownTimer(1100, 1) {


            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
            if (add == 0) {
                banner();
            } else {
            }
            vaqueta = 0;

        } else if (id == R.id.torque) {
            ViewFlipper vf = findViewById(R.id.vf);
            vf.setDisplayedChild(0);
            if (add == 0) {
                banner();
            } else {
            }
            vaqueta = 0;

        } else if (id == R.id.speed) {
            ViewFlipper vf = findViewById(R.id.vf);
            vf.setDisplayedChild(1);
            if (add == 0) {
                banner();
            } else {
            }
            vaqueta = 0;

        } else if (id == R.id.torqueengranatge) {
            ViewFlipper vf = findViewById(R.id.vf);
            vf.setDisplayedChild(4);
            if (add == 0) {
                banner();
            } else {
            }
            vaqueta = 0;

        } else if (id == R.id.nav_share) {
            vaqueta = 0;
            String shareBody = "Hey, try this fantastic robotics calculator app on Play Store" + "\n" + "\n" + "https://play.google.com/store/apps/details?id=mars.jesus_protegeix_nos";
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.share_using)));
        } else if (id == R.id.info) {
            ViewFlipper vf = findViewById(R.id.vf);
            vf.setDisplayedChild(3);
            vaqueta = 0;
            TextView nums = findViewById(R.id.nums);
            TextView nums2 = findViewById(R.id.nums2);
            TextView nums3 = findViewById(R.id.nums3);
            TextView nums4 = findViewById(R.id.nums4);
            TextView nums5 = findViewById(R.id.nums5);
            TextView nums6 = findViewById(R.id.nums6);
            TextView nums7 = findViewById(R.id.nums7);
            TextView nums8 = findViewById(R.id.nums8);
            TextView nums9 = findViewById(R.id.nums9);
            TextView titol = findViewById(R.id.titol);
            Typeface face = Typeface.createFromAsset(getAssets(), "fonts/IDroid.otf");
            nums.setTypeface(face);
            nums2.setTypeface(face);
            nums3.setTypeface(face);
            nums4.setTypeface(face);
            nums5.setTypeface(face);
            nums6.setTypeface(face);
            nums7.setTypeface(face);
            nums8.setTypeface(face);
            nums9.setTypeface(face);
            titol.setTypeface(face);
            if (add == 0) {
                call();
            } else {
                // Toast.makeText(this, "we don't have any ad", Toast.LENGTH_SHORT).show();

            }
        } else if (id == R.id.video) {
            if (mRewardedVideoAd.isLoaded()) {
                mRewardedVideoAd.show();
            } else mRewardedVideoAd.loadAd("ca-app-pub-3420122580859776/2237525348",
                    new AdRequest.Builder().build());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void calcula(View view) {
        EditText mass = findViewById(R.id.massa);
        EditText dis = findViewById(R.id.distancia);
        TextView jaume = findViewById(R.id.jaume);
        String ma = mass.getText().toString();
        String di = dis.getText().toString();
        if (ma.equals("") && di.equals("")) {
            Toast.makeText(this, "You forgot to fill some things", Toast.LENGTH_SHORT).show();
        } else {

            double massa = Double.parseDouble(ma);
            double distance = Double.parseDouble(di);
            double Torque;
            double gravity = 9.8;
            Torque = ((massa * gravity) / distance);
            String nieves = Double.toString(Torque);
            jaume.setText(nieves);
            String speeny;
            speeny = String.format("%.2f", Torque);
            jaume.setText(speeny);
        }

        if (add == 0) {
            call();
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (vaqueta == 0) {
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.openDrawer(GravityCompat.START);
                vaqueta = 1;
            } else if (vaqueta == 1) {
                vaqueta = 0;
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(this);
                }
                builder.setTitle("Exit")
                        .setMessage("Are you sure??")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
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
        }
        return true;
    }

    public void calculs(View view) {

        EditText dent1 = findViewById(R.id.dents1);
        String DN = dent1.getText().toString();
        EditText dent2 = findViewById(R.id.dents2);
        String DI = dent2.getText().toString();
        TextView jaume = findViewById(R.id.sensiu);

        if (DN.equals("") && DI.equals("")) {
            Toast.makeText(this, "You forgot to fill some things", Toast.LENGTH_SHORT).show();
        } else {
            double DN1 = Integer.parseInt(DN);
            double DENT1 = Integer.parseInt(DI);
            double Engranatge;
            Engranatge = (DN1 / DENT1);
            String nieves = Double.toString(Engranatge);
            String speedy;
            speedy = String.format("%.2f", Engranatge);
            jaume.setText(speedy);
        }
        if (add == 0) {
            call();
        } else {
            // Toast.makeText(this, "we don't have any ad", Toast.LENGTH_SHORT).show();

        }
    }

    public void velocidad(View view) {

        EditText vel = findViewById(R.id.velocidadinicial);
        String vv = vel.getText().toString();
        EditText D1 = findViewById(R.id.dentes1);
        String DD = D1.getText().toString();
        EditText D2 = findViewById(R.id.dentes2);
        String dd = D2.getText().toString();
        TextView jaume = findViewById(R.id.jaumet);

        if (vv.equals("") && DD.equals("")) {
            Toast.makeText(this, "You forgot to fill some things", Toast.LENGTH_SHORT).show();
        } else {
            double VEL1 = Integer.parseInt(vv);
            double DENT1 = Integer.parseInt(DD);
            double DENT2 = Integer.parseInt(dd);
            double Velocitat;
            Velocitat = (VEL1 * DENT1 / DENT2);
            String nieves = Double.toString(Velocitat);
            String speety = String.format("%.2f", Velocitat / 60 * 2 * Math.PI);
            jaume.setText(speety + "m/s");
            Toast.makeText(this, "Keep in mind that this is the gear speed, and we're not counting your pieces weigh or the friction", Toast.LENGTH_LONG).show();
        }
        if (add == 0) {
            call();
        } else {
            // Toast.makeText(this, "we don't have any ad", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onRewarded(RewardItem reward) {
        Toast.makeText(this, "Now you'll have 5 minutes without adds", Toast.LENGTH_SHORT).show();

        new CountDownTimer(300000, 1) {


            public void onTick(long millisUntilFinished) {
                add = 1;
            }

            public void onFinish() {
                add = 0;
            }
        }.start();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        Toast.makeText(this, "Thank you for whatching the add!",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdClosed() {
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {
    }

    @Override
    public void onRewardedVideoAdLoaded() {
    }

    @Override
    public void onRewardedVideoAdOpened() {
    }

    @Override
    public void onRewardedVideoStarted() {
    }

    public void onRewardedVideoCompleted() {
    }

    public void info(View view) {
        Uri uri = Uri.parse("https://www.instagram.com/marsdeveloppers/"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void help(View view) {
        Toast.makeText(this, "The normal motors default speed is 100, but on the high speed motors is 160", Toast.LENGTH_LONG).show();
    }
    private void check() {
        if (getIntent().getExtras() != null) {

            for (String key : getIntent().getExtras().keySet()) {
                String value = getIntent().getExtras().getString(key);

                if (key.equals("AnotherActivity") && value.equals("True")) {
                    Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=mars.jesus_protegeix_nos"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        }
    }

}
