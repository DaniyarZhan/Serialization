package com.example.serialization;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setTextSize(26);
        textView.setPadding(16,16,16,16);
        Bundle arguments = getIntent().getExtras();

        User user;
        if (arguments!=null) {
            user = arguments.getParcelable(User.class.getSimpleName());

            textView.setText("Имя: " + user.getName() + "\nОрганизация: " + user.getCompany() +
                    "\nВозраст: " + String.valueOf(user.getAge()) + "\nТелефон: " + user.getNumber());
        }
        setContentView(textView);
    }
}