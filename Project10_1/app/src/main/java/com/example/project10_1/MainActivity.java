package com.example.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText userIdInput = (EditText)findViewById(R.id.userIdInput);

        Button btnNewActivity = (Button)findViewById(R.id.btn);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("User", userIdInput.getText().toString());
                startActivityForResult(intent, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView textResult = (TextView) findViewById(R.id.textResult);
        TextView userId = (TextView)findViewById(R.id.userId);
        if(resultCode == RESULT_OK) {
            textResult.setText(data.getStringExtra("Date") + "가 선택됨");
            userId.setText(data.getStringExtra("User") + "이 닉네임");
        }
    }
}
