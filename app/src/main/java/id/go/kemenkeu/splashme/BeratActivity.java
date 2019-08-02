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

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BeratActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener{
    private EditText inputNama;
    private Spinner inputSekolah;
    private EditText inputUmur;
    private EditText inputBerat;
    private EditText inputTinggi;
    private Button btnHitung;



    private String strNama;
    private String strSekolah;
    private Integer intUmur;
    private Double doubleBerat;
    private Double doubleTinggi;
    private String strHasil;
    private Double doubleIdeal;
    private String strIdeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berat);


        inputNama=(EditText) findViewById(R.id.editNama);
        inputSekolah=(Spinner) findViewById(R.id.spinnerSekolah);
        inputUmur=(EditText) findViewById(R.id.editUmur);
        inputBerat=(EditText) findViewById(R.id.editBerat);
        inputTinggi=(EditText) findViewById(R.id.editTinggi);
        btnHitung=(Button)findViewById(R.id.btnHitung);




        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intUmur=Integer.parseInt(inputUmur.getText().toString());
                doubleBerat=Double.parseDouble(inputBerat.getText().toString());
                doubleTinggi=Double.parseDouble(inputTinggi.getText().toString());

                Intent gotoIdeal = new Intent(getApplicationContext(),Ideal.class);
                strIdeal=ideal(doubleBerat,doubleTinggi);
                gotoIdeal.putExtra("Hasilnya",strIdeal);
                startActivity(gotoIdeal);
            }
        });

        BottomNavigationView navView = findViewById(R.id.nav);
        navView.setOnNavigationItemSelectedListener(this);

        Menu menu = navView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);
    }

    private String ideal(double berat, double tinggi){
        doubleIdeal=doubleBerat/(doubleTinggi/100)*(doubleTinggi/100);

        if(doubleIdeal < 18.5){
            strIdeal = "Berat Badan Kurang";
        }else if(doubleIdeal > 18.5 && doubleIdeal < 24.9){
            strIdeal = "Berat Badan Hampir Sesuai";
        }else if(doubleIdeal > 25.0 && doubleIdeal < 29.9){
            strIdeal = "Berat Badan Sesuai";
        }
        else{
            strIdeal = "Berat Badan Keterlaluan";
        }
        return strIdeal;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_bmi:
                Intent gotoBerat = new Intent(BeratActivity.this,BeratActivity.class);
                startActivity(gotoBerat);
                break;
            case R.id.nav_calc:
                Intent gotoKalkulator = new Intent(BeratActivity.this,KalkulatorActivity.class);
                startActivity(gotoKalkulator);
                break;
            case R.id.nav_suhu:
                Intent gotoSuhu = new Intent(BeratActivity.this,SuhuActivity.class);
                startActivity(gotoSuhu);
                break;
            case R.id.nav_home:
                Intent gotoHome = new Intent(BeratActivity.this,MainActivity.class);
                startActivity(gotoHome);
                break;
        }
        return true;
    }


}
