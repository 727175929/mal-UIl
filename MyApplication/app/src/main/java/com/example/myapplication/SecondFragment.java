package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by zhouwei on 16/12/23.
 */

public class SecondFragment extends Fragment {
    private ImageButton heart;
    private boolean flag = true;


    public static Fragment newInstance(){
         SecondFragment fragment = new SecondFragment();
         return fragment;
     }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment_layout,null);
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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
