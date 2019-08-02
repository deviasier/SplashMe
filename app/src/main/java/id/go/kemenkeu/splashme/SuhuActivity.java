package id.go.kemenkeu.splashme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SuhuActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener{
    //inisialisasi/binding awal dari layout
    Spinner spinAsal;
    Spinner spinTujuan;
    EditText editSuhu;
    TextView viewHasil;
    Button btnKonversi;


    Integer integerSuhu;
    String suhuAsal;
    String suhuTujuan;
    Double doubleSuhu;
    Double doubleHitung;
    String hasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suhu);

        //set id
        spinAsal = findViewById(R.id.spinAsal);
        spinTujuan = findViewById(R.id.spinTujuan);
        editSuhu = findViewById(R.id.editSuhu);
        viewHasil = findViewById(R.id.viewHasil);
        btnKonversi = findViewById(R.id.btnKonversi);



        btnKonversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suhuAsal = spinAsal.getSelectedItem().toString();
                suhuTujuan = spinTujuan.getSelectedItem().toString();
                doubleSuhu= Double.parseDouble(editSuhu.getText().toString());

                viewHasil.setText(hitung(suhuAsal,suhuTujuan,doubleSuhu));
            }
        });

        BottomNavigationView navView = findViewById(R.id.nav);
        navView.setOnNavigationItemSelectedListener(this);

        Menu menu = navView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

    }

    public String hitung(String suhuAsal,String suhuTujuan,Double doubleSuhu){

        if(suhuAsal.equals("Celcius") && suhuTujuan.equals("Kelvin")){
            doubleHitung = doubleSuhu + 273.15;
        }
        else if (suhuAsal.equals("Celcius") && suhuTujuan.equals("Fahrenheit")){
            doubleHitung = (doubleSuhu*1.8) + 32;
        }
        else if (suhuAsal.equals("Celcius") && suhuTujuan.equals("Celcius")){
            doubleHitung = doubleSuhu;
        }
        return doubleHitung.toString();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_bmi:
                Intent gotoBerat = new Intent(SuhuActivity.this,BeratActivity.class);
                startActivity(gotoBerat);
                break;
            case R.id.nav_calc:
                Intent gotoKalkulator = new Intent(SuhuActivity.this,KalkulatorActivity.class);
                startActivity(gotoKalkulator);
                break;
            case R.id.nav_suhu:
                Intent gotoSuhu = new Intent(SuhuActivity.this,SuhuActivity.class);
                startActivity(gotoSuhu);
                break;
            case R.id.nav_home:
                Intent gotoHome = new Intent(SuhuActivity.this,MainActivity.class);
                startActivity(gotoHome);
                break;
        }
        return true;
    }
}
