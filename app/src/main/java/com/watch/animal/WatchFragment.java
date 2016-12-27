package com.watch.animal;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * @Author: wliang.
 * @Date: 2016/12/22 0022 14:55
 * @E-mail: wl386123298@qq.com
 */

public class WatchFragment extends Fragment implements View.OnClickListener {
    private int[] imageRes = {R.mipmap.watch_1, R.mipmap.watch_2, R.mipmap.watch_3, R.mipmap.watch_4, R.mipmap.watch_5};
    private int position;
    private ImageView mImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.watch_item_layout, container ,false);
        mImage = (ImageView)view.findViewById(R.id.itemImage);

        view.findViewById(R.id.itemBug).setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mImage.setImageResource(imageRes[position]);
    }

    public void setPosition(int position){
        this.position = position;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), WatchDetailInfoActivity.class);
        intent.putExtra("position", position);
        ActivityOptions transitionActivityOptions = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(getActivity(), mImage , "infoImageShare");
            startActivity(intent, transitionActivityOptions.toBundle());
        }else {
            startActivity(intent);
        }

    }
}
