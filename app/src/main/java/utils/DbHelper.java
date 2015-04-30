package utils;

import android.content.Context;

import com.lidroid.xutils.DbUtils;

/**
 * Created by shang on 2015/4/30.
 */
public class DbHelper {
     private  static DbUtils dbUtils;
     public static void init(Context context){
          dbUtils=DbUtils.create(context,"pickperson");
     }
    public DbUtils getDbUtils() {
        return dbUtils;
    }


}
