package day10.qianfeng.com.pickperson.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import day10.qianfeng.com.pickperson.R;
import day10.qianfeng.com.pickperson.Utils.BitmapHelper;
import day10.qianfeng.com.pickperson.Utils.FinalUrls;
import day10.qianfeng.com.pickperson.Utils.HttpUtilsHelper;
import day10.qianfeng.com.pickperson.bean.PositionBodyView;

/**
 * Created by Administrator on 2015/5/5 0005.
 */
public class GVadapter_positon extends BaseAdapter {

    private VGHolder holder;
    private List<PositionBodyView> list;
    private Context context;
    private LayoutInflater inflater;
    private int list_num;

    public GVadapter_positon(List<PositionBodyView> list, Context context,int list_num) {
        this.list_num=list_num;
        this.list = list;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.get(1).getList().size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // gv_position=position;
        if (convertView == null) {
            convertView= inflater.inflate(R.layout.gv_item_position,null);
            holder=new VGHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (VGHolder) convertView.getTag();
        }
        BitmapHelper.getBitmapUtils(context);
        String imgURL = list.get(list_num).getList().get(position).getImgURL();
        BitmapHelper.getUtils().display(holder.img, imgURL);
        String imageName =list.get(list_num).getList().get(position).getImgName();
        holder.text.setText(imageName);
        return convertView;
    }
    public  class VGHolder{
          ImageView img;
          TextView text;
          public VGHolder(View v){
          img =(ImageView) v.findViewById(R.id.img_gv_item);
          text= (TextView) v.findViewById(R.id.text_gv_item);

          }
    }
}
