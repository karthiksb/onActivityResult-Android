package com.example.activityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class secondActivity extends AppCompatActivity {
    Button redirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        redirect=(Button) findViewById(R.id.redirect);

        redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle =getIntent().getExtras();

                String sum= bundle.getString("sum");
                Toast.makeText(getApplicationContext(),sum,Toast.LENGTH_LONG).show();

                int val= Integer.parseInt(bundle.getString("sum"));


                String flag;

                if (val%2==0){
                    flag="even";
                }
                else {
                    flag="odd";
                }

                Intent intent = new Intent();
                intent.putExtra("keyName", flag);
                setResult(RESULT_OK, intent);

                    finish();
            }
        });



    }
}