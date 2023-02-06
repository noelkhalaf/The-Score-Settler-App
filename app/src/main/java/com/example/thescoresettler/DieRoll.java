package com.example.thescoresettler;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class DieRoll extends Fragment {

    private Random random = new Random();

    public DieRoll() {
        super(R.layout.fragment_die_roll);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_die_roll, container, false);
        ImageView roll_image = view.findViewById(R.id.diePlaceholder);
        roll_image.setOnClickListener(rollListener);
        return view;
    }

    private View.OnClickListener rollListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ImageView imageView = v.findViewById(R.id.diePlaceholder);

            int chosenGif = getRandDiceGif();

            Glide.with(getContext()).asGif().load(chosenGif).listener(new RequestListener<GifDrawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                    return false;
                }

                @Override
                public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                    if (resource instanceof GifDrawable) {
                        ((GifDrawable) resource).setLoopCount(1);
                    }
                    return false;
                }
            })
            .into(imageView);
        }
    };

    private int getRandDiceGif() {
        int randomNumber = random.nextInt(6);
        switch (randomNumber) {
            case 0:
                return R.drawable.dice_1;
            case 1:
                return R.drawable.dice_2;
            case 2:
                return R.drawable.dice_3;
            case 3:
                return R.drawable.dice_4;
            case 4:
                return R.drawable.dice_5;
            case 5:
                return R.drawable.dice_6;
            default:
                throw new IllegalStateException("Unexpected value: " + randomNumber);
        }
    }
}