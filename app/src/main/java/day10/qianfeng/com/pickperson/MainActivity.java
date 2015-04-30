package day10.qianfeng.com.pickperson;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import day10.qianfeng.com.pickperson.activity.LaunchPickActivity;
import day10.qianfeng.com.pickperson.customview.TopBarView;


public class MainActivity extends Activity {
    //Text uPS
    private TopBarView topBarView;
    private RadioGroup rg;
    private RadioButton rb_home;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        topBarView=(TopBarView)findViewById(R.id.topbar);
        rg=(RadioGroup)findViewById(R.id.bottom_menu);
        rb_home=(RadioButton)findViewById(R.id.rb_home);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        Log.d("ss","home");
                        topBarView.setLeftImageViewIcon(getResources().getDrawable(R.drawable.search_icon));
                        topBarView.setRigImageView(getResources().getDrawable(R.drawable.edit_icon));
                        topBarView.setTittleText("捡人");
                        topBarView.setOnTobCilck(new TopBarView.TopbarCallBack() {
                            @Override
                            public void leftButtonCallBack(View view) {

                            }

                            @Override
                            public void rightButtonCallBack(View view) {
                                Intent intent=new Intent(MainActivity.this, LaunchPickActivity.class);
                                startActivity(intent);
                            }
                        });
                        break;
                    case R.id.rb_message:
                        topBarView.setLeftImageViewIcon(null);
                        topBarView.setRigImageView(getResources().getDrawable(R.drawable.chat_add));
                        topBarView.setTittleText("消息");
                        break;
                    case R.id.rb_find:
                        topBarView.setTittleText("发现");
                        topBarView.setLeftImageViewIcon(null);
                        topBarView.setRigImageView(null);
                        break;
                    case R.id.rb_me:
                        topBarView.setLeftImageViewIcon(null);
                        topBarView.setRigImageView(getResources().getDrawable(R.drawable.setting_icon));
                        topBarView.setTittleText("我的");
                        break;
                }
            }
        });
        rb_home.setChecked(true);
    }

}
