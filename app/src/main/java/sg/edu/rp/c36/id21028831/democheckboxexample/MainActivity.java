package sg.edu.rp.c36.id21028831.democheckboxexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox discount;
    Button check;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        discount=findViewById(R.id.discount);
        check=findViewById(R.id.check);
        output=findViewById(R.id.output);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyActivity", "Inside onClick()");
                if (discount.isChecked()){
                    double pay=calcPay(100,20);
                    output.setText("The discount is given. You need to pay "+pay);
                }else{
                    double pay=calcPay(100,0);
                    output.setText("The discount is not given. You need to pay "+pay);
                }
                Toast.makeText(MainActivity.this, "Button check", Toast.LENGTH_LONG).show();
            }
        });

    }


    private double calcPay(double price, double discount){
        double pay=price*(1-discount/100);
        return pay;
    }
}