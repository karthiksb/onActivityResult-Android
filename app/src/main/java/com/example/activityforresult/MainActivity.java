package com.example.activityforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText num1;
    EditText num2;
    Button result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        num1=(EditText)findViewById(R.id.num1);
        num2=(EditText)findViewById(R.id.num2);
        result=(Button) findViewById(R.id.result);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    int num1_val = Integer.parseInt(num1.getText().toString().trim());

                    int num2_val = Integer.parseInt(num2.getText().toString().trim());

                    int sum=num1_val+num2_val;
                    Intent intent = new Intent(getApplicationContext(), secondActivity.class);
                    Bundle bundle =new Bundle();
                    bundle.putString("sum", String.valueOf(sum));
                    intent.putExtras(bundle);
                    startActivityForResult(intent, 1);}

                catch (
                        Exception exception
                ){}


            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                // Get String data from Intent
                String returnString = data.getStringExtra("keyName");

                // Set text view with string
                TextView textView = (TextView) findViewById(R.id.display);
                textView.setText(returnString);
            }
        }
    }
}