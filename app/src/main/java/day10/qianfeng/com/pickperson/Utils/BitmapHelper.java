package day10.qianfeng.com.pickperson.Utils;

import android.content.Context;

import com.lidroid.xutils.BitmapUtils;

/**
 * Created by Administrator on 2015/5/3 0003.
 */
public class BitmapHelper {
    private static BitmapUtils utils;
    public static void getBitmapUtils(Context context){
        if (utils == null) {
            utils = new BitmapUtils(context);
        }


    }
    public static BitmapUtils getUtils(){
        return utils;
    }
}
