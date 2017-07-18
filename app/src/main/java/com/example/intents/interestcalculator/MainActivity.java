package com.example.intents.interestcalculator;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
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
    TextView t2;
    TextView textView2;
    TextView textView3;
    int year_x,month_x,day_x;
    static final int DATE_DIALOG_ID = 0;
    private static final String TAG = "MyActivity";

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
        button = (Button) findViewById(R.id.button);
        t2=(TextView)findViewById(R.id.textView);
        textView2=(TextView)findViewById(R.id.textView2);
        textView3=(TextView)findViewById(R.id.textView3);
    }
    public void start_date(View v){
     showDialog(DATE_DIALOG_ID);
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        if(id==DATE_DIALOG_ID)
                return new DatePickerDialog(this, mDateSetListener, year_x, month_x, day_x);
        return null;
    }

    private void updateDisplay(){
      int num8 = Integer.parseInt(year_bar.getText().toString());

        t2.setText(new StringBuilder()

                .append(day_x).append("-").append(month_x + 1+num8).append("-")
                .append(year_x).append("   "));

    }



    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    year_x = year;
                    month_x = monthOfYear;
                    day_x = dayOfMonth;


                }
            };






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
                            float si = (num1 * num2 * num) / 100;
                            String res = String.valueOf(si);
                            t1.setText(res);
                            t2.setText(new StringBuilder()

                                    .append(day_x-num).append("-").append(month_x +1+num).append("-")
                                    .append(year_x).append("   "));


                        }
                    });
                }
                break;
            case R.id.radioButton2:
                if (checked) {
                    calculate.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v) {
                            int num1, num2,num;

                            num1 = Integer.parseInt(PA_bar.getText().toString());
                            num2 = Integer.parseInt(IR_bar.getText().toString());
                            num = Integer.parseInt(year_bar.getText().toString());


                            float si = (num1 * num2 * num) / 100;
                            String res = String.valueOf(si);
                            t1.setText(res);
                            updateDisplay();

                        }
                    });

                }
                break;
        }
    }

}