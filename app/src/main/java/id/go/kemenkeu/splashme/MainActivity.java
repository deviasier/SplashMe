package id.go.kemenkeu.splashme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener{
    Button kalkulator;
    Button suhu;
    Button berat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kalkulator = (Button) findViewById(R.id.kalkulator);
        suhu = (Button) findViewById(R.id.suhu);
        berat = (Button) findViewById(R.id.berat);

        kalkulator.setOnClickListener(new myClickButton());
        suhu.setOnClickListener(new myClickButton());
        berat.setOnClickListener(new myClickButton());

        BottomNavigationView navView = findViewById(R.id.nav);
        navView.setOnNavigationItemSelectedListener(this);

        Menu menu = navView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_notification,menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_bmi:
                Intent gotoBerat = new Intent(MainActivity.this,BeratActivity.class);
                startActivity(gotoBerat);
                break;
            case R.id.nav_calc:
                Intent gotoKalkulator = new Intent(MainActivity.this,KalkulatorActivity.class);
                startActivity(gotoKalkulator);
                break;
            case R.id.nav_suhu:
                Intent gotoSuhu = new Intent(MainActivity.this,SuhuActivity.class);
                startActivity(gotoSuhu);
                break;
            case R.id.nav_home:
                Intent gotoHome = new Intent(MainActivity.this,MainActivity.class);
                startActivity(gotoHome);
                break;
        }
        return true;
    }


    public class myClickButton implements View.OnClickListener{
        @Override
        public void onClick(View view){
            switch(view.getId()){
                case R.id.kalkulator:
                    Intent gotoKalkulator = new Intent(MainActivity.this,KalkulatorActivity.class);
                    startActivity(gotoKalkulator);
                    break;
                case R.id.suhu:
                    Intent gotoSuhu = new Intent(MainActivity.this,SuhuActivity.class);
                    startActivity(gotoSuhu);
                    break;
                case R.id.berat:
                    Intent gotoBerat = new Intent(MainActivity.this,BeratActivity.class);
                    startActivity(gotoBerat);
                    break;
            }
        }
    }
}
