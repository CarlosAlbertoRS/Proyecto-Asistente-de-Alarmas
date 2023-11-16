package com.example.proyasyst_test.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.proyasyst_test.R;

public class OnBoardingAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public OnBoardingAdapter(Context context){
        this.context = context;
    }

    int titles[] = {
            R.string.titulo1,
            R.string.titulo2,
            R.string.titulo3,
            R.string.titulo4
    };

    int subtitles[] = {
            R.string.subtitulo1,
            R.string.subtitulo2,
            R.string.subtitulo3,
            R.string.subtitulo4
    };

    int images[] = {
            R.drawable.img_logoc,
            R.drawable.alarma1,
            R.drawable.img_abeja,
            R.drawable.asyst_icon12
    };

    int bg[] = {
            R.drawable.bg2,
            R.drawable.bg3,
            R.drawable.bg1,
            R.drawable.bg4
    };
    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
    layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    View v = layoutInflater.inflate(R.layout.slide,container,false);

        ImageView image = v.findViewById(R.id.slideImg);
        TextView title = v.findViewById(R.id.slidesubTitle);
        TextView subtitle = v.findViewById(R.id.slidesubTitle);
        ConstraintLayout layout = v.findViewById(R.id.slideLayout);

        image.setImageResource(images[position]);
        title.setText(titles[position]);
        subtitle.setText(subtitles[position]);
        layout.setBackgroundResource(position);

        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
