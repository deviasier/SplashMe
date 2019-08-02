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
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class KalkulatorActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;

    Button btnTambah;
    Button btnKurang;
    Button btnKali;
    Button btnBagi;

    Button btnDecimal;
    Button btnSamadengan;
    Button btnClear;
    Button btnCorrection;

    EditText textFormula;
    TextView textHasil;

    public Double varA;
    public Double varB;
    public String oprT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        varA=0.0;
        varB=0.0;
        oprT="";
        textHasil= findViewById(R.id.textHasil);

        btn0=findViewById(R.id.nol);
        btn1=findViewById(R.id.satu);
        btn2=findViewById(R.id.dua);
        btn3=findViewById(R.id.tiga);
        btn4=findViewById(R.id.empat);
        btn5=findViewById(R.id.lima);
        btn6=findViewById(R.id.enam);
        btn7=findViewById(R.id.tujuh);
        btn8=findViewById(R.id.delapan);
        btn9=findViewById(R.id.sembilan);


        btnTambah=findViewById(R.id.tambah);
        btnKurang=findViewById(R.id.kurang);
        btnKali=findViewById(R.id.kali);
        btnBagi=findViewById(R.id.bagi);
        btnDecimal=findViewById(R.id.plusmin);
        btnSamadengan=findViewById(R.id.samadengan);
        btnClear=findViewById(R.id.ce);
        btnCorrection=findViewById(R.id.correction);



        btn0.setOnClickListener(new MyClickHandler());
        btn1.setOnClickListener(new MyClickHandler());
        btn2.setOnClickListener(new MyClickHandler());
        btn3.setOnClickListener(new MyClickHandler());
        btn4.setOnClickListener(new MyClickHandler());
        btn5.setOnClickListener(new MyClickHandler());
        btn6.setOnClickListener(new MyClickHandler());
        btn7.setOnClickListener(new MyClickHandler());
        btn8.setOnClickListener(new MyClickHandler());
        btn9.setOnClickListener(new MyClickHandler());
        btnDecimal.setOnClickListener(new MyClickHandler());
        btnClear.setOnClickListener(new MyClickHandler());
        btnCorrection.setOnClickListener(new MyClickHandler());

        btnTambah.setOnClickListener(new ExecHandle());
        btnKurang.setOnClickListener(new ExecHandle());
        btnKali.setOnClickListener(new ExecHandle());
        btnBagi.setOnClickListener(new ExecHandle());
        btnSamadengan.setOnClickListener(new ExecHandle());

        BottomNavigationView navView = findViewById(R.id.nav);
        navView.setOnNavigationItemSelectedListener(this);

        Menu menu = navView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

    }


    public class MyClickHandler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            textFormula= findViewById(R.id.textFormula);
            String s = textFormula.getText().toString();
            Integer inputInt;

            if(s.equals("0")){
                switch (v.getId()) {
                    case R.id.tujuh:
                        textFormula.setText("7");
                        break;
                    case R.id.delapan:
                        textFormula.setText("8");
                        break;
                    case R.id.sembilan:
                        textFormula.setText("9");
                        break;
                    case R.id.empat:
                        textFormula.setText("4");
                        break;
                    case R.id.lima:
                        textFormula.setText("5");
                        break;
                    case R.id.enam:
                        textFormula.setText("6");
                        break;
                    case R.id.satu:
                        textFormula.setText("1");
                        break;
                    case R.id.dua:
                        textFormula.setText("2");
                        break;
                    case R.id.tiga:
                        textFormula.setText("3");
                        break;
                }
            }else {
                switch (v.getId()) {
                    case R.id.ce:
                        textFormula.setText("0");
                        break;
                    case R.id.correction:
                        if (textFormula.getText().toString().length() <= 1) {
                            textFormula.setText("0");
                        } else {
                            textFormula.setText(textFormula.getText().toString().substring(0,textFormula.getText().toString().length()-1));
                        }
                        break;
                    case R.id.plusmin:
                        textFormula.setText(textFormula.getText() + "+/-");
                        break;
                    case R.id.kurang:
                        //inputInt=Integer.parseInt(textFormula.getText().toString());
                        textFormula.setText(textFormula.getText() + "-");
                        break;
                    case R.id.tambah:
                        textFormula.setText(textFormula.getText() + "+");
                        break;
                    case R.id.kali:
                        textFormula.setText(textFormula.getText() + "X");
                        break;
                    case R.id.samadengan:
                        textFormula.setText(textFormula.getText() + "=");
                        break;

                    case R.id.tujuh:
                        textFormula.setText(textFormula.getText() + "7");
                        break;
                    case R.id.delapan:
                        textFormula.setText(textFormula.getText() + "8");
                        break;
                    case R.id.sembilan:
                        textFormula.setText(textFormula.getText() + "9");
                        break;
                    case R.id.empat:
                        textFormula.setText(textFormula.getText() + "4");
                        break;
                    case R.id.lima:
                        textFormula.setText(textFormula.getText() + "5");
                        break;
                    case R.id.enam:
                        textFormula.setText(textFormula.getText() + "6");
                        break;
                    case R.id.satu:
                        textFormula.setText(textFormula.getText() + "1");
                        break;
                    case R.id.dua:
                        textFormula.setText(textFormula.getText() + "2");
                        break;
                    case R.id.tiga:
                        textFormula.setText(textFormula.getText() + "3");
                        break;

                    case R.id.nol:
                        textFormula.setText(textFormula.getText() + "0");
                        break;
                }
            }
            int textLength=textFormula.getText().length();
            textFormula.setSelection(textLength,textLength);
        }

        public Integer hitung(String input1, String input2){
            return 1;
        }
    }


    public class ExecHandle implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            textFormula = findViewById(R.id.textFormula);
            String s = textFormula.getText().toString();

            if(oprT.equals("")){
                switch (v.getId()){
                    case R.id.tambah:
                        oprT="Tambah";
                        varA =Double.parseDouble(s);
                        break;
                    case R.id.ce:
                        varA=0.0;
                        varB=0.0;
                        oprT="";
                        textHasil.setText("0.0");
                }
            }else{
                switch (v.getId()) {
                    case R.id.samadengan:
                        switch (oprT) {
                            case "TAMBAH":
                                varB = Double.parseDouble(s);
                                Double hasil = varA + varB;
                                textHasil.setText(hasil.toString());
                        }
                        varA = 0.0;
                        varB = 0.0;
                        oprT ="";
                        textHasil.setText("0.0");
                        textFormula.setText("0.0");
                        break;
                }
            }

            varB=0.0;
            varB=0.0;
            oprT="";

        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_bmi:
                Intent gotoBerat = new Intent(KalkulatorActivity.this,BeratActivity.class);
                startActivity(gotoBerat);
                break;
            case R.id.nav_calc:
                Intent gotoKalkulator = new Intent(KalkulatorActivity.this,KalkulatorActivity.class);
                startActivity(gotoKalkulator);
                break;
            case R.id.nav_suhu:
                Intent gotoSuhu = new Intent(KalkulatorActivity.this,SuhuActivity.class);
                startActivity(gotoSuhu);
                break;
            case R.id.nav_home:
                Intent gotoHome = new Intent(KalkulatorActivity.this,MainActivity.class);
                startActivity(gotoHome);
                break;
        }
        return true;
    }
}
