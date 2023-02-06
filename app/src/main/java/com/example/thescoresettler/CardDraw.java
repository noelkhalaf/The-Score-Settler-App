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

public class CardDraw extends Fragment {

    private Random random = new Random();

    public CardDraw() {
        super(R.layout.fragment_card_draw);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card_draw, container, false);
        ImageView draw_image = view.findViewById(R.id.cardPlaceholder);
        draw_image.setOnClickListener(drawListener);
        return view;
    }

    private View.OnClickListener drawListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ImageView imageView = v.findViewById(R.id.cardPlaceholder);

            int randomNumber = random.nextInt(6);
            int chosenGif;
            switch (randomNumber) {
                case 0:
                    chosenGif = R.drawable.club_1;
                    break;
                case 1:
                    chosenGif = R.drawable.club_2;
                    break;
                case 2:
                    chosenGif = R.drawable.club_3;
                    break;
                case 3:
                    chosenGif = R.drawable.club_4;
                    break;
                case 4:
                    chosenGif = R.drawable.club_5;
                    break;
                case 5:
                    chosenGif = R.drawable.club_6;
                    break;
                case 6:
                    chosenGif = R.drawable.club_7;
                    break;
                case 7:
                    chosenGif = R.drawable.club_8;
                    break;
                case 8:
                    chosenGif = R.drawable.club_9;
                    break;
                case 9:
                    chosenGif = R.drawable.club_10;
                    break;
                case 10:
                    chosenGif = R.drawable.club_11;
                    break;
                case 11:
                    chosenGif = R.drawable.club_12;
                    break;
                case 12:
                    chosenGif = R.drawable.club_13;
                    break;
                case 13:
                    chosenGif = R.drawable.diamond_1;
                    break;
                case 14:
                    chosenGif = R.drawable.diamond_2;
                    break;
                case 15:
                    chosenGif = R.drawable.diamond_3;
                    break;
                case 16:
                    chosenGif = R.drawable.diamond_4;
                    break;
                case 17:
                    chosenGif = R.drawable.diamond_5;
                    break;
                case 18:
                    chosenGif = R.drawable.diamond_6;
                    break;
                case 19:
                    chosenGif = R.drawable.diamond_7;
                    break;
                case 20:
                    chosenGif = R.drawable.diamond_8;
                    break;
                case 21:
                    chosenGif = R.drawable.diamond_9;
                    break;
                case 22:
                    chosenGif = R.drawable.diamond_10;
                    break;
                case 23:
                    chosenGif = R.drawable.diamond_11;
                    break;
                case 24:
                    chosenGif = R.drawable.diamond_12;
                    break;
                case 25:
                    chosenGif = R.drawable.diamond_13;
                    break;
                case 26:
                    chosenGif = R.drawable.heart_1;
                    break;
                case 27:
                    chosenGif = R.drawable.heart_2;
                    break;
                case 28:
                    chosenGif = R.drawable.heart_3;
                    break;
                case 29:
                    chosenGif = R.drawable.heart_4;
                    break;
                case 30:
                    chosenGif = R.drawable.heart_5;
                    break;
                case 31:
                    chosenGif = R.drawable.heart_6;
                    break;
                case 32:
                    chosenGif = R.drawable.heart_7;
                    break;
                case 33:
                    chosenGif = R.drawable.heart_8;
                    break;
                case 34:
                    chosenGif = R.drawable.heart_9;
                    break;
                case 35:
                    chosenGif = R.drawable.heart_10;
                    break;
                case 36:
                    chosenGif = R.drawable.heart_11;
                    break;
                case 37:
                    chosenGif = R.drawable.heart_12;
                    break;
                case 38:
                    chosenGif = R.drawable.heart_13;
                    break;
                case 39:
                    chosenGif = R.drawable.spade_1;
                    break;
                case 40:
                    chosenGif = R.drawable.spade_2;
                    break;
                case 41:
                    chosenGif = R.drawable.spade_3;
                    break;
                case 42:
                    chosenGif = R.drawable.spade_4;
                    break;
                case 43:
                    chosenGif = R.drawable.spade_5;
                    break;
                case 44:
                    chosenGif = R.drawable.spade_6;
                    break;
                case 45:
                    chosenGif = R.drawable.spade_7;
                    break;
                case 46:
                    chosenGif = R.drawable.spade_8;
                    break;
                case 47:
                    chosenGif = R.drawable.spade_9;
                    break;
                case 48:
                    chosenGif = R.drawable.spade_10;
                    break;
                case 49:
                    chosenGif = R.drawable.spade_11;
                    break;
                case 50:
                    chosenGif = R.drawable.spade_12;
                    break;
                case 51:
                    chosenGif = R.drawable.spade_13;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + randomNumber);
            }

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
}