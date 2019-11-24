package com.example.project10_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Button btnReturn = (Button) findViewById(R.id.btn2);

        Button btnThird = (Button) findViewById(R.id.btn3);
        btnThird.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(intent);
            }
        });

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);
        RadioButton radio2 = (RadioButton) findViewById(R.id.radio2);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radio1:
                        finish();
                        break;
                    case R.id.radio2:
                        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

        final DatePicker date = (DatePicker) findViewById(R.id.datePicker);
        final TextView dateText = (TextView) findViewById(R.id.dateresult);

        date.init(date.getYear(), date.getMonth(), date.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateText.setText(String.format("%d/%d/%d", year, monthOfYear + 1, dayOfMonth));
            }
        });

        Intent inIntent = getIntent();
        final String getUserId = inIntent.getStringExtra("User");
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Date", dateText.getText().toString());
                outIntent.putExtra("User", getUserId);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
