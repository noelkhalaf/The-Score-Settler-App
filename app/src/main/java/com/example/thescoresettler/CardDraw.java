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

            int chosenGif = getRandCardGif();

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

    private int getRandCardGif() {
        int randomNumber = random.nextInt(52);
        switch (randomNumber) {
            case 0:
                return R.drawable.club_1;
            case 1:
                return R.drawable.club_2;
            case 2:
                return R.drawable.club_3;
            case 3:
                return R.drawable.club_4;
            case 4:
                return R.drawable.club_5;
            case 5:
                return R.drawable.club_6;
            case 6:
                return R.drawable.club_7;
            case 7:
                return R.drawable.club_8;
            case 8:
                return R.drawable.club_9;
            case 9:
                return R.drawable.club_10;
            case 10:
                return R.drawable.club_11;
            case 11:
                return R.drawable.club_12;
            case 12:
                return R.drawable.club_13;
            case 13:
                return R.drawable.diamond_1;
            case 14:
                return R.drawable.diamond_2;
            case 15:
                return R.drawable.diamond_3;
            case 16:
                return R.drawable.diamond_4;
            case 17:
                return R.drawable.diamond_5;
            case 18:
                return R.drawable.diamond_6;
            case 19:
                return R.drawable.diamond_7;
            case 20:
                return R.drawable.diamond_8;
            case 21:
                return R.drawable.diamond_9;
            case 22:
                return R.drawable.diamond_10;
            case 23:
                return R.drawable.diamond_11;
            case 24:
                return R.drawable.diamond_12;
            case 25:
                return R.drawable.diamond_13;
            case 26:
                return R.drawable.heart_1;
            case 27:
                return R.drawable.heart_2;
            case 28:
                return R.drawable.heart_3;
            case 29:
                return R.drawable.heart_4;
            case 30:
                return R.drawable.heart_5;
            case 31:
                return R.drawable.heart_6;
            case 32:
                return R.drawable.heart_7;
            case 33:
                return R.drawable.heart_8;
            case 34:
                return R.drawable.heart_9;
            case 35:
                return R.drawable.heart_10;
            case 36:
                return R.drawable.heart_11;
            case 37:
                return R.drawable.heart_12;
            case 38:
                return R.drawable.heart_13;
            case 39:
                return R.drawable.spade_1;
            case 40:
                return R.drawable.spade_2;
            case 41:
                return R.drawable.spade_3;
            case 42:
                return R.drawable.spade_4;
            case 43:
                return R.drawable.spade_5;
            case 44:
                return R.drawable.spade_6;
            case 45:
                return R.drawable.spade_7;
            case 46:
                return R.drawable.spade_8;
            case 47:
                return R.drawable.spade_9;
            case 48:
                return R.drawable.spade_10;
            case 49:
                return R.drawable.spade_11;
            case 50:
                return R.drawable.spade_12;
            case 51:
                return R.drawable.spade_13;
            default:
                throw new IllegalStateException("Unexpected value: " + randomNumber);
        }
    }
}