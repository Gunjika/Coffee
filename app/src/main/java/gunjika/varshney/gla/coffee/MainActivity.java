package gunjika.varshney.gla.coffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1,button2,button3,button4;
    TextView tv_quant;
    CheckBox checkbox3,checkbox4;
    int coffee=0;
    int total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.buttonminus);
        button2 = findViewById(R.id.buttonplus);
        button3 = findViewById(R.id.buttonorder);
        button4 = findViewById(R.id.buttonreset);
        tv_quant = findViewById(R.id.tv_quant);
        checkbox3 = findViewById(R.id.checkBox3);
        checkbox4 = findViewById(R.id.checkBox4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(coffee>0)
                {
                    coffee--;
                }
                tv_quant.setText(String.valueOf(coffee));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffee++;
                tv_quant.setText(String.valueOf(coffee));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total=coffee*10;
                if(checkbox3.isChecked() && coffee>0)
                {
                    total=total+5*coffee;
                }
                if (checkbox4.isChecked() && coffee>0)
                {
                    total=total+5*coffee;
                }
                if(coffee>0)
                {
                    if(checkbox3.isChecked()&&checkbox4.isChecked())
                    {
                        Toast.makeText(MainActivity.this, " You Have Selected"+String.valueOf(coffee)+" Coffee With Whipped Cream and  Chocolate. Your Bill Is: "+String.valueOf(total), Toast.LENGTH_SHORT).show();
                    }
                    else if (checkbox3.isChecked())
                    {
                        Toast.makeText(MainActivity.this, " You Have Selected " + String.valueOf(coffee) + " Coffee With Whipped Cream. Your Bill Is: " + String.valueOf(total), Toast.LENGTH_SHORT).show();
                    }
                    else if (checkbox4.isChecked())
                    {
                        Toast.makeText(MainActivity.this, " You Have Selected " + String.valueOf(coffee) + " Coffee With Chocolate. Your Bill Is: " + String.valueOf(total), Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "No Coffee is selected.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total=0;
                coffee=0;
                tv_quant.setText(String.valueOf(coffee));
                checkbox3.setChecked(false);
                checkbox4.setChecked(false);
            }
        });
    }
}
