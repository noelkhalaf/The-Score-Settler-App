package com.example.thescoresettler;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class RangeNum extends Fragment {

    private EditText firstNum_text, secondNum_text;
    private TextView resultingNum;
    private Button randomizeButton;
    private Random random = new Random();

    public RangeNum() {
        super(R.layout.fragment_range_num);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_range_num, container, false);
        firstNum_text = view.findViewById(R.id.firstNum);
        secondNum_text = view.findViewById(R.id.secondNum);
        randomizeButton = view.findViewById(R.id.randomizeButton);
        resultingNum = view.findViewById(R.id.resultingNum);
        randomizeButton.setOnClickListener(rangeListener);
        return view;
    }

    private View.OnClickListener rangeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String firstNum_string = firstNum_text.getText().toString();
            String secondNum_string = secondNum_text.getText().toString();
            boolean lower_missing = TextUtils.isEmpty(firstNum_string);
            boolean upper_missing = TextUtils.isEmpty(secondNum_string);

            if (lower_missing && upper_missing) {
                Toast.makeText(getContext(), "Both bounds missing", Toast.LENGTH_SHORT).show();
                firstNum_text.setHintTextColor(Color.parseColor("#FF0000"));
                secondNum_text.setHintTextColor(Color.parseColor("#FF0000"));
            } else if (lower_missing && !upper_missing) {
                Toast.makeText(getContext(), "Lower bound missing", Toast.LENGTH_SHORT).show();
                firstNum_text.setHintTextColor(Color.parseColor("#FF0000"));
            } else if (!lower_missing && upper_missing) {
                Toast.makeText(getContext(), "Upper bound missing", Toast.LENGTH_SHORT).show();
                secondNum_text.setHintTextColor(Color.parseColor("#FF0000"));
            } else {
                firstNum_text.setHintTextColor(Color.parseColor("#DFCF3C"));
                secondNum_text.setHintTextColor(Color.parseColor("#DFCF3C"));
                int firstNum = Integer.parseInt(firstNum_string);
                int secondNum = Integer.parseInt(secondNum_string);
                int randomNumber = getRandRange(firstNum, secondNum);
                resultingNum.setText(Integer.toString(randomNumber));
            }
        }
    };

    private int getRandRange(int num1, int num2) {
        if (num1 > num2) {
            return (int) ((Math.random() * (num2 - num1)) + num1);
        } else {
            return (int) ((Math.random() * (num1 - num2)) + num2);
        }
    }
}