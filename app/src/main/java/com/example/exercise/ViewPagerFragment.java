package com.example.exercise;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ViewPagerFragment extends Fragment {


    ViewPager2 viewPager2;

    List<LoadData>load;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myview=inflater.inflate(R.layout.fragment_view_pager, container, false);

       viewPager2=myview.findViewById(R.id.imageviewsss);


       if (getArguments()!=null){

           Uri imageuri=Uri.parse(getArguments().getString("imageuri"));
           String text=getArguments().getString("text");
           load.add(new LoadData(imageuri,text));


           Log.i("TAG","IMAGE"+imageuri);
       }


       Adapter adapter=new Adapter(getActivity(),load);
       viewPager2.setAdapter(adapter);






        return myview;
    }
}