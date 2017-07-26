package com.example.intents.interestcalculator;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;

import java.util.Calendar;


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
    TextView t2;
    TextView textView2;
    TextView textView3;
    EditText editText;
    TextView textView4;
    private int year_x, month_x, day_x;
    private static final String TAG = "MyActivity";
    static final int Date_id = 0;
    Calendar c = Calendar.getInstance();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        year_x = c.get(Calendar.YEAR);
        month_x = c.get(Calendar.MONTH);
        day_x = c.get(Calendar.DAY_OF_MONTH);
        editText = (EditText) findViewById(R.id.editText);


        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(Date_id);
            }
        });
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
        t2=(TextView)findViewById(R.id.textView);
        editText=(EditText)findViewById(R.id.editText);
        textView4=(TextView) findViewById(R.id.textView4);
        textView2=(TextView)findViewById(R.id.textView2);
        textView3=(TextView)findViewById(R.id.textView3);

    }


    private void updateLabel() {

        editText.setText(new StringBuilder()

                .append(day_x).append("/").append(month_x + 1).append("/").append(year_x).append(" "));
    }


    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int month, int day) {
            year_x = year;
            month_x = month;
            day_x = day;
            updateLabel();
        }


    };

    @Override
    protected Dialog onCreateDialog(int id) {

        switch (id) {

            case Date_id:
                return new DatePickerDialog(this, mDateSetListener, year_x, month_x, day_x);

        }
        return null;


    }

    private void updateDisplay(){
        int num8 = Integer.parseInt(year_bar.getText().toString());

        t2.setText(new StringBuilder()

                .append(day_x).append("-").append(month_x + 1+num8).append("-")
                .append(year_x).append("   "));

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