package com.example.intents.interestcalculator;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextView PA;
    TextView Interest_Rate;
    TextView Years;
    EditText PA_bar;
    EditText IR_bar;
    EditText year_bar;
    Button calculate;
    TextView t1;
    RadioButton rb1;
    RadioButton rb2;
    Button button;
    Button button3;
    int year_x,month_x,day_x;
    int year_y,month_y,day_y;
    int sMonth,eMonth;
    private static final String TAG = "your activity name";
static final int DIALOG_ID=0;
    static final int DIALOG_IDI=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PA = (TextView) findViewById(R.id.PA);
        Interest_Rate = (TextView) findViewById(R.id.Interest_Rate);
        Years = (TextView) findViewById(R.id.Years);
        PA_bar = (EditText) findViewById(R.id.PA_bar);
        IR_bar = (EditText) findViewById(R.id.IR_bar);
        year_bar = (EditText) findViewById(R.id.month);
        calculate = (Button) findViewById(R.id.calculate);
        t1 = (TextView) findViewById(R.id.t1);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);



    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioButton:
                if (checked) {

                    calculate.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v) {
                            int num1, num2, num;

                            num1 = Integer.parseInt(PA_bar.getText().toString());
                            num2 = Integer.parseInt(IR_bar.getText().toString());
                            num = Integer.parseInt(year_bar.getText().toString());

                            float num3 = num - (float)(num / 30);
                            Log.d(TAG,"APP IS working"+num3);
                            float si = (num1 * num2 * num3) / 100;
                            String res = String.valueOf(si);
                            t1.setText(res);


                        }
                    });
                }
                break;
            case R.id.radioButton2:
                if (checked) {
                    calculate.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v) {
                            int num1, num2, num;

                            num1 = Integer.parseInt(PA_bar.getText().toString());
                            num2 = Integer.parseInt(IR_bar.getText().toString());
                            num = Integer.parseInt(year_bar.getText().toString());


                            int si = (num1 * num2 * num) / 100;
                            String res = String.valueOf(si);
                            t1.setText(res);


                        }
                    });

                }
                break;
        }
    }

}