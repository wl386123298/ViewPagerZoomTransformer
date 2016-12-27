package com.watch.animal;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @Author: wliang.
 * @Date: 2016/12/22 0022 16:16
 * @E-mail: wl386123298@qq.com
 */

public class ParallaxTransformer implements ViewPager.PageTransformer {
    private float parallaxCoefficient;
    private float distanceCoefficient;
    private static final float MIN_SCALE = 2f;

    ParallaxTransformer(float parallaxCoefficient, float distanceCoefficient) {
        this.parallaxCoefficient = parallaxCoefficient;
        this.distanceCoefficient = distanceCoefficient;
    }


    @Override
    public void transformPage(View page, float position) {
        float scrollXOffset = page.getWidth() * parallaxCoefficient;

        ViewGroup pageViewWrapper = (ViewGroup) page;
        for (int i = 0; i < pageViewWrapper.getChildCount(); i++) {
            View view = pageViewWrapper.getChildAt(i);
            Log.e("IDDDD", position + "");
            if (view.getId() != -1) {
                if (view.findViewById(view.getId()) instanceof TextView) {
                    view.findViewById(view.getId())
                            .setTranslationX(scrollXOffset * position);
                }

                if (view.findViewById(view.getId()) instanceof ImageView) {

                    // Use the default slide transition when moving to the left page
                    float scaleFactor = MIN_SCALE
                            + (1 - MIN_SCALE) * (1 - Math.abs(position));
                    view.findViewById(view.getId()).setScaleX(scaleFactor);
                    view.findViewById(view.getId()).setScaleY(scaleFactor);

                    // Scale the page down (between MIN_SCALE and 1)

                    /*view.findViewById(view.getId()).setScaleX(1);
                    view.findViewById(view.getId()).setScaleY(1);
                    */
                }
            }

        }


        scrollXOffset *= distanceCoefficient;
    }
}
