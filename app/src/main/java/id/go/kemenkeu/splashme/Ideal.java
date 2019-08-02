package id.go.kemenkeu.splashme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Ideal extends AppCompatActivity {
    private TextView outoutHasil;
    private String value1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideal);

        outoutHasil=(TextView)findViewById(R.id.viewHasil);



        Intent a = getIntent();
        String x = a.getStringExtra("Hasilnya");
        outoutHasil.setText(x);
    }
}
