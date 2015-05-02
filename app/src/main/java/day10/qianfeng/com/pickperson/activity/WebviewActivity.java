package day10.qianfeng.com.pickperson.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import day10.qianfeng.com.pickperson.R;

public class WebviewActivity extends ActionBarActivity {

    private String  url;
    //private TextView view;
    private WebView web;
    private ProgressBar pro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
       // view=(TextView) findViewById(R.id.url222);
        web=(WebView) findViewById(R.id.show222);
        pro=(ProgressBar) findViewById(R.id.pro);

        Intent intent=getIntent();
        url=intent.getStringExtra("url");
        //view.setText(url);
        // 得到一个WebSettings对象,用来设置这个WebView控件.
        WebSettings settings = web.getSettings();
        // 设置这个WebView是否可以执行JavaScript脚本程序.
        settings.setJavaScriptEnabled(true);
        // 设置WebView是否使用自带的缩放机制
        settings.setBuiltInZoomControls(true);
        // 设置WebView在网页上显示缩放工具
        //settings.setDisplayZoomControls(true);
        // 加载要显示内容的URI地址.

        web.loadUrl(url);

        // 如果不设置这个setWebViewClient():程序就会调用设备自带的浏览器来浏览该网页.
        // 如果设置了,我们所看到的每个网页都会在我们程序内部显示出来.

        // 用来控制WebView控件是否可以接收一些的请求或者通知.
        web.setWebViewClient(new WebViewClient() {

            // 2个参数:①.view:就是WebView本身;
            // ②.URL:是我们新加载的那个网页的URL
            // 返回值:true表示主应用程序想要离开当前页面,并且自己处理那个URL;
            // false:反之...
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String u) {

                view.loadUrl(u);
                // 加上这个功能后,存在一个问题:返回键的问题.
                // 按返回键直接退出程序了!
                // 解决办法:处理返回键.

                return true;
            }
        });


        //进度条
        web.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                if(newProgress==100)
                {
                    pro.setVisibility(View.INVISIBLE);
                }
                else
                {
                    pro.setProgress(newProgress);
                }


            }});
    }
    // 处理所有按键事件的方法
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {

            Toast.makeText(this, "返回键" + keyCode, Toast.LENGTH_LONG).show();
            web.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
