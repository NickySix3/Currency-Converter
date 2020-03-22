package nicholette.androidprojects.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*VARIABLES*/
    RadioGroup to, from;
    RadioButton USDButton1, USDButton2,JMDButton1, JMDButton2,
            EURButton1, EURButton2, CADButton1, CADButton2;
    Button reset, convert;                          //Button that will be used to Reset all calculations and set to NULL
    EditText input;                                 //Input - Where the user will enter information
    TextView output, rate;                          // Output -  the result that will be shown and Rate Used -  to do the calculation



    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*OBJECT CREATION*/
        //RADIO BUTTON GROUP
        to = (RadioGroup) findViewById(R.id.TO);
        from = (RadioGroup) findViewById(R.id.FROM);

        //RADIO BUTTONS
        USDButton1 = (RadioButton) findViewById(R.id.USD1);
        USDButton2 = (RadioButton) findViewById(R.id.USD2);
        JMDButton1 = (RadioButton) findViewById(R.id.JMD1);
        JMDButton2 = (RadioButton) findViewById(R.id.JMD2);
        EURButton1 = (RadioButton) findViewById(R.id.EUR1);
        EURButton2 = (RadioButton) findViewById(R.id.EUR2);
        CADButton1 = (RadioButton) findViewById(R.id.CAD1);
        CADButton2 = (RadioButton) findViewById(R.id.CAD2);

        //EditText
        input = (EditText) findViewById(R.id.Input);

        //TextView
        output = (TextView) findViewById(R.id.Output);
        rate = (TextView) findViewById(R.id.RateUsed);

        //Button
        reset = (Button) findViewById(R.id.Reset);
        convert = (Button) findViewById(R.id.Convert);
        /*END OF OBJECT CREATION*/

        /*ON CLICK COMMANDS*/
        //RESET BUTTON
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               input.setText(null);
                input.setText("0.00");
                output.setText(null);
                output.setText("0.00");
                rate.setText(null);
                rate.setText("0.00");
            }
        });//END OF RESET COMMANd

        //CONVERT BUTTON
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                double num = Integer.parseInt(input.getText().toString());
                double result;


                /*SIMILAR METRICS SELECTED*/
                if ((USDButton1.isChecked() == true) && (USDButton2.isChecked() == true)){
                    output.setText("INVALID");
                } else if ((JMDButton1.isChecked() == true) && (JMDButton2.isChecked() == true)){
                    output.setText("INVALID");
                } else if ((CADButton1.isChecked() == true) && (CADButton2.isChecked() == true)){
                    output.setText("INVALID");
                } else if ((EURButton1.isChecked() == true) && (EURButton2.isChecked() == true)) {
                    output.setText("INVALID");
                }

                /*USD CONVERSIONS*/
                //USD TO JMD
                if ((USDButton1.isChecked() == true) &&  (JMDButton2.isChecked() == true)){
                    result = num * 135.78;
                    output.setText(String.valueOf(result));
                    rate.setText("$135.78");
                }
                //USD TO CAD
                if ((USDButton1.isChecked() == true) && (CADButton2.isChecked() == true)){
                    result = num * 1.42;
                    output.setText(String.valueOf(result));
                    rate.setText("$1.42");
                }
                //USD TO EUR
                if((USDButton1.isChecked() == true) && (EURButton2.isChecked() == true)){
                    result = num * 0.91;
                    output.setText(String.valueOf(result));
                    rate.setText("$0.91");
                }
                /*JMD CONVERSIONS*/
                //JMD TO USD
                if ((JMDButton1.isChecked() == true) && (USDButton2.isChecked() == true)){
                    result = num * 0.0074;
                    output.setText(String.valueOf(result));
                    rate.setText("$0.0074");
                }
                //JMD TO EUR
                if ((JMDButton1.isChecked() == true) && (EURButton2.isChecked() == true)){
                    result = num * 0.0067;
                    output.setText(String.valueOf(result));
                    rate.setText("$0.0067");
                }
                //JMD TO CAD
                if ((JMDButton1.isChecked() == true) && (CADButton2.isChecked() == true)){
                    result = num * 0.010;
                    output.setText(String.valueOf(result));
                    rate.setText("$0.010");
                }
                /*EURO CONVERSIONS*/
                //EURO TO USD
                if((EURButton1.isChecked() == true) && (USDButton2.isChecked() == true)) {
                    result = num * 1.10;
                    output.setText(String.valueOf(result));
                    rate.setText("$1.10");
                }
                //EURO TO JMD
                if ((EURButton1.isChecked() == true) && (JMDButton2.isChecked() == true)){
                    result = num * 149.76;
                    output.setText(String.valueOf(result));
                    rate.setText("$149.76");
                }
                //EURO TO CAD
                if ((EURButton1.isChecked() == true) && (CADButton2.isChecked() == true)){
                    result = num * 1.57;
                    output.setText(String.valueOf(result));
                    rate.setText("$1.57");
                }
                /*CAD CONVERSIONS*/
                //CAD TO USD
                if ((CADButton1.isChecked() == true) && (USDButton2.isChecked() == true)){
                    result = num * 0.70;
                    output.setText(String.valueOf(result));
                    rate.setText("$0.70");
                }
                //CAD TO JMD
                if ((CADButton1.isChecked() == true) && (JMDButton2.isChecked() == true)){
                    result = num * 95.70;
                    output.setText(String.valueOf(result));
                    rate.setText("$95.70");
                }
                //CAD TO EURO
                if ((CADButton1.isChecked() == true) && (EURButton2.isChecked()==true)){
                    result = num * 0.64;
                    output.setText(String.valueOf(result));
                    rate.setText("$0.64");
                }

            }
        });//END OF CONVERT

    }//END OF onCreate
} //END OF CLASS
