package com.watch.animal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

/**
 * @Author: wliang.
 * @Date: 2016/12/26 0026 11:18
 * @E-mail: wl386123298@qq.com
 */

public class WatchDetailInfoActivity extends AppCompatActivity{
    private int[] imageRes = {R.mipmap.watch_1, R.mipmap.watch_2, R.mipmap.watch_3, R.mipmap.watch_4, R.mipmap.watch_5};
    private int mPosition;
    private ImageView mTitleImage;
    private ImageView mIntroImage_1;
    private ImageView mIntroImage_2;
    private ImageView mIntroImage_3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watch_detail_info_layout);
        mPosition = getIntent().getIntExtra("position", 0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.infoToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTitleImage = (ImageView)findViewById(R.id.infoTitleImage);
        mIntroImage_1 = (ImageView)findViewById(R.id.imageIntro_1);
        mIntroImage_2 = (ImageView)findViewById(R.id.imageIntro_2);
        mIntroImage_3 = (ImageView)findViewById(R.id.imageIntro_3);

        setImagesRes(mTitleImage, mIntroImage_1, mIntroImage_2, mIntroImage_3);
    }


    private void setImagesRes(ImageView ...images){
        for (ImageView image : images) {
            image.setImageResource(imageRes[mPosition]);
        }
    }
}
