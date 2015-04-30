package utils;

import android.content.Context;
import android.os.Environment;

import com.lidroid.xutils.BitmapUtils;

/**
 * Created by shang on 2015/4/30.
 */
public class BitmapHelper {
   private static BitmapUtils utils;
    public   static void init(Context context){
        utils=new BitmapUtils(context, Environment.getExternalStorageDirectory()
                .getAbsolutePath()+"/pickperson",1/8.0f,1024*1024*10);
        utils.clearCache();
    }
    public BitmapUtils getUtils(){
        return utils;
    }
}
