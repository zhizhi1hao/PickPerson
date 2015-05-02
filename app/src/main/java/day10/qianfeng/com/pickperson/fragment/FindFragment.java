package day10.qianfeng.com.pickperson.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import day10.qianfeng.com.pickperson.R;
import day10.qianfeng.com.pickperson.activity.CaptureActivity;
import day10.qianfeng.com.pickperson.activity.WebviewActivity;

/**
 */
public class FindFragment extends Fragment implements View.OnClickListener {
    //附近的人
    private LinearLayout layout_nearPerson;
    //扫一扫二维码
    private LinearLayout layout_2dimension;
    //精选目的地
    private LinearLayout layout_position;

    //打工旅行
    private ImageButton imgbtn_trip;
    //捡人包车
    private ImageButton imgbtn_car;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_find, container, false);
        layout_2dimension = (LinearLayout) view.findViewById(R.id.layout_scanner_two);
        layout_nearPerson = (LinearLayout) view.findViewById(R.id.layout_nearperson);
        layout_position = (LinearLayout) view.findViewById(R.id.layout_position);
        imgbtn_trip= (ImageButton) view.findViewById(R.id.img_trip);
        imgbtn_car= (ImageButton) view.findViewById(R.id.img_car);
        layout_2dimension.setOnClickListener(this);
        layout_nearPerson.setOnClickListener(this);
        layout_position.setOnClickListener(this);
        imgbtn_car.setOnClickListener(this);
        imgbtn_trip.setOnClickListener(this);
        return view;
    }
    //扫一扫二维码的点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //捡人包车
            case R.id.img_car:

                Intent intent=new Intent(getActivity(),WebviewActivity.class);
                intent.putExtra("url","http://shop.ijianren.com:8080/jrwpay/shop/queryShopInfo.do");
                startActivity(intent);

                break;
            case R.id.img_trip:
                Intent intent1=new Intent(getActivity(),WebviewActivity.class);
                intent1.putExtra("url","http://www.ijianren.com:9999/fx/0404/shouye.html");
                startActivity(intent1);

                break;
            case R.id.layout_nearperson:
                Toast.makeText(getActivity(), "1", Toast.LENGTH_LONG).show();
            break;
            case R.id.layout_position:
                Toast.makeText(getActivity(), "2", Toast.LENGTH_LONG).show();
                break;
            case R.id.layout_scanner_two:
                Toast.makeText(getActivity(), "扫一扫", Toast.LENGTH_LONG).show();
                startActivityForResult(new Intent(getActivity(), CaptureActivity.class), 1111);
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 222) {
            String result = data.getStringExtra("result");
            Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
            //String iii="http://www.baidu.com";
            Intent intent=new Intent(getActivity(),WebviewActivity.class);
            intent.putExtra("url",result);
            startActivity(intent);
        }
    }

}
