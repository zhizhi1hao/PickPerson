package day10.qianfeng.com.pickperson.activity;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.View;

import day10.qianfeng.com.pickperson.R;
import day10.qianfeng.com.pickperson.fragment.FindFragment;

public class FindActivity extends ActionBarActivity {

    private View button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container_find);

    }

    public void clickToFind(View view) {

        button = findViewById(R.id.btn_test);
        button.setVisibility(View.GONE);
        //目的--》得到FragmentTransaction
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        // 创建Fragment对象

        FindFragment fragment = new FindFragment();
        // 参数1：要放置Fragment的ViewGroup 参数2：Fragment对象
        transaction.replace(R.id.container, fragment);
        // 提交
        transaction.commit();
    }

}
