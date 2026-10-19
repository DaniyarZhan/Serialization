package com.example.serialization;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        EditText nameText = findViewById(R.id.name);
        EditText companyText = findViewById(R.id.company);
        EditText ageText = findViewById(R.id.age);
        EditText numberText = findViewById(R.id.number);

        String name = nameText.getText().toString().trim();
        String company = companyText.getText().toString().trim();
        String ageStr = ageText.getText().toString().trim();
        String number = numberText.getText().toString().trim();

        while (true) {
            if (name.isEmpty()) {
                nameText.setError("Введите имя");
                nameText.requestFocus();
            }
            if (company.isEmpty()) {
                companyText.setError("Введите организацию");
                companyText.requestFocus();
            }
            if (ageStr.isEmpty()) {
                ageText.setError("Введите возраст");
                ageText.requestFocus();
            }
            if (number.isEmpty()) {
                numberText.setError("Введите телефон");
                numberText.requestFocus();
            }
            if (!name.isEmpty() && !company.isEmpty() && !ageStr.isEmpty() && !number.isEmpty())
                break;
            return;
        }
        int age = Integer.parseInt(ageStr);
        User user = new User(name, company, age, number);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(User.class.getSimpleName(), user);
        startActivity(intent);
    }
}