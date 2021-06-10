package paan.fahmi.bmicalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText weight, height;
    TextView resulttext;
    String calculation, category, risk, statement;
    Button calculate;
    ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        resulttext = findViewById(R.id.result);
        calculate = findViewById(R.id.calculate);
        profile = findViewById(R.id.imageButton);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String S1 = weight.getText().toString();
                String S2 = height.getText().toString();

                float weightValue = Float.parseFloat(S1);
                float heightValue = Float.parseFloat(S2) / 100;

                float bmi = weightValue / (heightValue * heightValue);


                if(bmi < 18.4){
                    category = "Underweight";
                    risk= "Malnutrition risk";
                }else if(bmi >= 18.5 && bmi <= 24.9){
                    category = "Normal Weigh";
                    risk = "Low risk";

                }else if (bmi >= 25 && bmi <= 29.9){
                    category = "Overweight";
                    risk= "Enhanced risk";
                }else if (bmi >= 30 && bmi <= 34.9){
                    category = "Moderately obese";
                    risk= "Medium risk";
                }else if (bmi >= 35 && bmi <= 39.9){
                    category = "Severely obese";
                    risk= "High risk";
                }else{
                    category = "Very severely obese";
                    risk="Very high risk";
                }

                calculation = "Result              : " + bmi + "\n"
                              +"Category is     : " + category + "\n"
                              +"Health Risk is : "+risk;

                resulttext.setText(calculation);
            }
        });
    }





}