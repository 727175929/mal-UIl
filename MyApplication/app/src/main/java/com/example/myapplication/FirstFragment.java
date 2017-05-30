package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

/**
 * Created by zhouwei on 16/12/23.
 */

public class FirstFragment extends Fragment {
    private RollPagerView rollPagerView;
    private ImageButton heart;
    private boolean flag = true;
     public static Fragment newInstance(){
         FirstFragment fragment = new FirstFragment();
         return fragment;
     }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment_layout,null);
        rollPagerView = (RollPagerView)view.findViewById(R.id.rollViewpager);
        rollPagerViewSet(); //设置切换时间动画效果

        heart = (ImageButton)view.findViewById(R.id.po_image0);
        heart.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if(flag) {
                    heart.setImageDrawable(getResources().getDrawable(R.drawable.pressed_heart));
                    Toast.makeText(getActivity(),"收藏成功", Toast.LENGTH_SHORT).show();

                    flag = false;
                }else{
                    heart.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                    Toast.makeText(getActivity(),"取消收藏", Toast.LENGTH_SHORT).show();
                    flag = true;
                }
            }
        });

        return view;
    }

    private void rollPagerViewSet() {
        rollPagerView.setPlayDelay(1000);//*播放间隔
        rollPagerView.setAnimationDurtion(500);//透明度
        rollPagerView.setAdapter(new rollViewpagerAdapter());//配置适配器
    }

    private class rollViewpagerAdapter extends StaticPagerAdapter {

        private int[] res={R.drawable.sp1_1
                ,R.drawable.sp1_2,
                R.drawable.sp1_3,
                R.drawable.sp1_4};

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView imageView=new ImageView(container.getContext());
            imageView.setImageResource(res[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            return imageView;
        }

        @Override
        public int getCount() {
            return res.length;
        }
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
