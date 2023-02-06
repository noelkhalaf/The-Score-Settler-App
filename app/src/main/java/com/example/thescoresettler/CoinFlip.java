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

public class CoinFlip extends Fragment {

    private Random random = new Random();

    public CoinFlip() {
        super(R.layout.fragment_coin_flip);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coin_flip, container, false);
        ImageView flip_image = view.findViewById(R.id.coinPlaceholder);
        flip_image.setOnClickListener(flipListener);
        return view;
    }

    private View.OnClickListener flipListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ImageView imageView = v.findViewById(R.id.coinPlaceholder);

            int chosenGif = getRandCoinGif();

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

    private int getRandCoinGif() {
        int randomNumber = random.nextInt(2);
        switch (randomNumber) {
            case 0:
                return R.drawable.headsflip;
            case 1:
                return R.drawable.tailsflip;
            default:
                throw new IllegalStateException("Unexpected value: " + randomNumber);
        }
    }
}