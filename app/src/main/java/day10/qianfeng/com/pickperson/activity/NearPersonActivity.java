package day10.qianfeng.com.pickperson.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import day10.qianfeng.com.pickperson.R;
import day10.qianfeng.com.pickperson.Utils.BitmapHelper;
import day10.qianfeng.com.pickperson.Utils.FinalUrls;
import day10.qianfeng.com.pickperson.Utils.HttpUtilsHelper;
import day10.qianfeng.com.pickperson.adapter.NearPeasonLVadapter;
import day10.qianfeng.com.pickperson.bean.NearPerson;

public class NearPersonActivity extends ActionBarActivity {
    private static int pageIndex=1;
    private PullToRefreshListView listView;
    private List<NearPerson> list;
    private NearPeasonLVadapter adapter;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==1) {
                //刷新完成
                listView.onRefreshComplete();
                List<NearPerson> list1= ((List<NearPerson>) msg.obj);
                list.addAll(list1);
                adapter.notifyDataSetChanged();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_person);
        //初始化
        BitmapHelper.getBitmapUtils(this);
        list=new ArrayList<NearPerson>();
        listView= (PullToRefreshListView) findViewById(R.id.list_nearperson);
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        adapter = new NearPeasonLVadapter(this, list);
        listView.setAdapter(adapter);
        //JSON字符串
         HttpUtilsHelper.getNetData(FinalUrls.nearPerson, handler, 1);
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //上啦刷新
                HttpUtilsHelper.getNetData(FinalUrls.nearPerson,handler,1);
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                pageIndex++;
                HttpUtilsHelper.getNetData(FinalUrls.nearPerson,handler,pageIndex);


            }
        });


    }

}


