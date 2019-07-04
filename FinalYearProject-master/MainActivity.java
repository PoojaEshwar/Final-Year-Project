package com.example.finalyearproject;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private Button btnSubmit;
    private EditText age,salary, budget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }


    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        btnSubmit = (Button) findViewById(R.id.survey_submit);
        age = (EditText) findViewById(R.id.age);
        salary = (EditText) findViewById(R.id.salary);
        budget = (EditText) findViewById(R.id.budget);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, String.valueOf(age.getText())+" "+String.valueOf(salary.getText())+" "+String.valueOf(budget.getText())+" "+String.valueOf(spinner1.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(intent);
                finish();
            }

        });
    }
}
