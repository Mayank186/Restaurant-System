package com.example.a8866352155.beaconrestaurant;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by 8866352155 on 3/26/2017.
 */
public class CustomPagerAdapter extends PagerAdapter {
    Context mContext;
    int[] mResources = {
            R.drawable.khaman,
            R.drawable.patra,
            R.drawable.patra,
            R.drawable.khaman,

    };
    LayoutInflater mLayoutInflater;

    public CustomPagerAdapter(Context mContext) {
        this.mContext = mContext;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.slider_model_all, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        imageView.setImageResource(mResources[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}