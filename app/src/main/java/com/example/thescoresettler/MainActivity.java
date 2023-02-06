package com.example.thescoresettler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView list_button, range_button, coin_button, die_button, card_button;
    private int selected;

    public MainActivity() {
        super(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .setReorderingAllowed(true)
//                    .add(R.id.content, CoinFlip.class, null)
//                    .commit();
//        }
        selected = R.id.coinButton;
        list_button = findViewById(R.id.listButton);
        range_button = findViewById(R.id.rangeButton);
        coin_button = findViewById(R.id.coinButton);
        die_button = findViewById(R.id.dieButton);
        card_button = findViewById(R.id.cardButton);

        list_button.setOnClickListener(this);
        range_button.setOnClickListener(this);
        coin_button.setOnClickListener(this);
        die_button.setOnClickListener(this);
        card_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.listButton:
                changeMargin(list_button, R.id.listButton);
                break;
            case R.id.rangeButton:
                changeMargin(range_button, R.id.rangeButton);
                break;
            case R.id.coinButton:
                changeMargin(coin_button, R.id.coinButton);
                changeFragment(new CoinFlip());
                break;
            case R.id.dieButton:
                changeMargin(die_button, R.id.dieButton);
                changeFragment(new DieRoll());
                break;
            case R.id.cardButton:
                changeMargin(card_button, R.id.cardButton);
                changeFragment(new CardDraw());
                break;
        }
    }

    private void changeMargin(ImageView imageView, int button_id) {
        if (selected != button_id) {
            ViewGroup.MarginLayoutParams marginParams_button = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            marginParams_button.setMargins(0,0,0,0);
            imageView.requestLayout();
            ViewGroup.MarginLayoutParams marginParams_selected = (ViewGroup.MarginLayoutParams) findViewById(selected).getLayoutParams();
            marginParams_selected.setMargins(50,50,50,50);
            findViewById(selected).requestLayout();
            selected = button_id;
        }
    }

    private void changeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.commit();
    }
}