package day10.qianfeng.com.pickperson.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

import day10.qianfeng.com.pickperson.MainActivity;
import day10.qianfeng.com.pickperson.R;
import day10.qianfeng.com.pickperson.Utils.BitmapHelper;
import day10.qianfeng.com.pickperson.Utils.FinalUrls;
import day10.qianfeng.com.pickperson.Utils.HttpUtilsHelper;
import day10.qianfeng.com.pickperson.adapter.GVadapter_positon;
import day10.qianfeng.com.pickperson.adapter.VPAdapter_position;
import day10.qianfeng.com.pickperson.bean.PositionBlockView;
import day10.qianfeng.com.pickperson.bean.PositionBodyView;

public class PositionActivity extends ActionBarActivity {

    private  GVadapter_positon gvadapter1,gvadapter2,gvadapter3;
    private ImageView images[]=new ImageView[2];
    private ImageView imagetop,imagebuttom,dot1,dot2;
    private GridView gv1,gv2,gv3;
    private List<PositionBodyView>  list;
   private Handler handler=new Handler() {
    @Override
    public void handleMessage(Message msg) {
        if (msg.what==2){
           List<PositionBodyView> list1= (List<PositionBodyView>) msg.obj;
           list.addAll(list1);
            //第一张图片
            BitmapHelper.getUtils().display(imagetop,list.get(0).getList().get(0).getImgURL());
          //下载最后一张图片
            BitmapHelper.getUtils().display(imagebuttom,list.get(4).getList().get(0).getImgURL());

            Log.d("size------->",list.get(1).getList().size()+"");
             gvadapter1 = new GVadapter_positon(list, PositionActivity.this,1);
             gvadapter2 = new GVadapter_positon(list, PositionActivity.this,2);
             gvadapter3 = new GVadapter_positon(list ,PositionActivity.this,3);
            gv1.setAdapter(gvadapter1);
            gv2.setAdapter(gvadapter2);
            gv3.setAdapter(gvadapter3);
        }
    }
};
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position);
        //初始化
        BitmapHelper.getBitmapUtils(this);

        list=new ArrayList<PositionBodyView>();
        imagetop= (ImageView) findViewById(R.id.top_image);
        imagebuttom= (ImageView) findViewById(R.id.position_bottom);
        viewPager = ((ViewPager) findViewById(R.id.vp_position));
        gv1= (GridView) findViewById(R.id.gv1_position);
        gv2= (GridView) findViewById(R.id.gv2_position);
        gv3= (GridView) findViewById(R.id.gv3_position);
        //获取解析的结果
        HttpUtilsHelper.getPositionData(FinalUrls.PositonURl,handler);
        viewPager.setAdapter(new VPAdapter_position(getSupportFragmentManager()));
        //初始化小圆点
        initImageDot();
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                for(int i=0;i<images.length;i++){

                    if(i==position){
                        images[i].setImageResource(R.drawable.dot_green);
                    }else {
                        images[i].setImageResource(R.drawable.dot_gray);
                    }
                }
            }
            @Override
            public void onPageSelected(int position) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
//GridVIew 的赋值

//        gvadapter1.notifyDataSetChanged();
//        gvadapter2.notifyDataSetChanged();
//        gvadapter3.notifyDataSetChanged();
    }


    public void initImageDot(){
        dot1= (ImageView) findViewById(R.id.positiom_dot1);
        dot2= (ImageView) findViewById(R.id.position_dot2);
        images[0]=dot1;
        images[1]=dot2;

    }


}
