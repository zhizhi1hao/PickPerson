package day10.qianfeng.com.pickperson.adapter;

import android.content.Context;
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
import day10.qianfeng.com.pickperson.bean.NearPerson;

/**
 * Created by Administrator on 2015/5/3 0003.
 */
public class NearPeasonLVadapter extends BaseAdapter {
    private List<NearPerson> list;
    private Context context;
    private LayoutInflater inflater;

    public NearPeasonLVadapter(Context context, List<NearPerson> list) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
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

        final ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.nearperson_lv_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //赋值

        NearPerson nearPerson = list.get(position);
        holder.nickname.setText(nearPerson.getNickName());
        if("f".equals(nearPerson.getSex())){
            holder.sex.setImageResource(R.drawable.male);
        }else if("m".equals(nearPerson.getSex())){
            holder.sex.setImageResource(R.drawable.female);
        }
        BitmapHelper.getUtils().display(holder.icon,nearPerson.getIconUrl());

        holder.age.setText(nearPerson.getAge());
        holder.distance.setText(nearPerson.getDistance());
        holder.detail.setText(nearPerson.getDistance());

        return convertView;
    }

    public class ViewHolder {
        ImageView icon, sex;
        TextView nickname, distance, detail, age;

        public ViewHolder(View convertView) {
            icon = (ImageView) convertView.findViewById(R.id.near_person_icon);
            nickname = (TextView) convertView.findViewById(R.id.near_person_nickname);
            distance = (TextView) convertView.findViewById(R.id.near_person_dis);
            age = (TextView) convertView.findViewById(R.id.near_person_age);
            sex = (ImageView) convertView.findViewById(R.id.near_person_age_bg);
            detail = (TextView) convertView.findViewById(R.id.near_person_dis);
        }
    }
}
