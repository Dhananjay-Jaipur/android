package com.example.calculator;

import static java.lang.reflect.Array.set;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class AndroidCalculator extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        Button num0 = findViewById(R.id.num0);
        Button num1 = findViewById(R.id.num1);
        Button num2 = findViewById(R.id.num2);
        Button num3 = findViewById(R.id.num3);
        Button num4 = findViewById(R.id.num4);
        Button num5 = findViewById(R.id.num5);
        Button num6 = findViewById(R.id.num6);
        Button num7 = findViewById(R.id.num7);
        Button num8 = findViewById(R.id.num8);
        Button num9 = findViewById(R.id.num9);

        Button div = findViewById(R.id.div);
        Button mul = findViewById(R.id.mul);
        Button percent = findViewById(R.id.percent);
        Button add = findViewById(R.id.add);
        Button sub = findViewById(R.id.sub);
        Button c = findViewById(R.id.clear);
        Button ac = findViewById(R.id.ac);
        Button equal = findViewById(R.id.equals);

        TextView screen = findViewById(R.id.screen);

        ArrayList<Button> num = new ArrayList<>();
        num.add(num0);
        num.add(num1);
        num.add(num2);
        num.add(num3);
        num.add(num4);
        num.add(num5);
        num.add(num6);
        num.add(num7);
        num.add(num8);
        num.add(num9);
        for (Button b : num) {
            b.setOnClickListener(view -> {
                if (!screen.getText().toString().equals(0)) {
                    screen.setText(screen.getText().toString() + b.getText().toString());
                } else {
                    screen.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> opers = new ArrayList<>();
        opers.add(div);
        opers.add(mul);
        opers.add(add);
        opers.add(sub);

        final String[] o = new String[1];
        final Double[] first = new Double[1];

        for (Button b : opers) {
            b.setOnClickListener(view -> {
                Double firstNum;
                firstNum = Double.parseDouble(screen.getText().toString());
                String operation = b.getText().toString();
                o[0] = operation;
                first[0] = firstNum;
            });
        }

        c.setOnClickListener(view -> {
            String nums = screen.getText().toString();
            if (nums.length() > 1) {
                screen.setText(nums.substring(0, nums.length() - 1));
            } else if (nums.length() == 1 && !nums.equals("0")) {
                screen.setText("0");
            }
        });

        ac.setOnClickListener(view -> {
            first[0] = null;
            screen.setText("0");
        });

        equal.setOnClickListener(view -> {
            Double secNum;
            secNum = Double.parseDouble(screen.getText().toString());
            Double result = null;

            switch (o[0]) {
                case "/":
                    result = first[0] / secNum;
                    break;

                case "*":
                    result = first[0] * secNum;
                    break;

                case "+":
                    result = first[0] + secNum;
                    break;

                case "-":
                    result = first[0] - secNum;
                    break;
            }

            screen.setText(String.valueOf(result));
            first[0] = result;
        });
    }
}