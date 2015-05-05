package day10.qianfeng.com.pickperson.Utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import day10.qianfeng.com.pickperson.bean.NearPerson;
import day10.qianfeng.com.pickperson.bean.PositionBlockView;
import day10.qianfeng.com.pickperson.bean.PositionBodyView;

/**
 * Created by Administrator on 2015/5/3 0003.
 */
/*附近的人：http://app.ijianren.com:9898/jr3/locationServices/nearList
localsVerified=9999&pageIndex=1&version=3.0.2&userTags=&lon=116.369683&pageSize=&
clientKey=d5b3b700c7961e6b&sign=44ed729c88a84e01&time=1430301390773&
lat=40.037152&deviceType=android*/

public class HttpUtilsHelper {
   //用Xutil请求
    //网络数据
    private static List<NearPerson> person;
    private  static List<PositionBlockView> position;
    private  static List<PositionBodyView> position_body;
    //获取附近的人
      public static void getNetData(String url ,  final Handler handler,int pageIndex) {
        HttpUtils utils = new HttpUtils();
        RequestParams params = new RequestParams();
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

        NameValuePair pair1 = new BasicNameValuePair("localsVerified", "9999");
        NameValuePair pair2 = new BasicNameValuePair("pageIndex", pageIndex+"");
        NameValuePair pair3 = new BasicNameValuePair("version", "3.0.2");
        NameValuePair pair4 = new BasicNameValuePair("userTags", "");
        NameValuePair pair5 = new BasicNameValuePair("lon", "116.369683");
        NameValuePair pair6 = new BasicNameValuePair("pageSize", "");
        NameValuePair pair7 = new BasicNameValuePair("clientKey", "d5b3b700c7961e6b");

        NameValuePair pair8 = new BasicNameValuePair("sign", "44ed729c88a84e01");
        NameValuePair pair9 = new BasicNameValuePair("time", "1430301390773");
        NameValuePair pair10 = new BasicNameValuePair("lat", "40.037152");
        NameValuePair pair11 = new BasicNameValuePair("deviceType", "android");

        nameValuePairs.add(pair1);
        nameValuePairs.add(pair2);
        nameValuePairs.add(pair3);
        nameValuePairs.add(pair4);

        nameValuePairs.add(pair5);
        nameValuePairs.add(pair6);

        nameValuePairs.add(pair7);
        nameValuePairs.add(pair8);
        nameValuePairs.add(pair9);

        nameValuePairs.add(pair10);
        nameValuePairs.add(pair11);
        params.addBodyParameter(nameValuePairs);
        utils.send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> objectResponseInfo) {
                //为了上拉刷新
                if(person!=null){
                    person.clear();
                }

                //网络请求下来的JSON
                String result = objectResponseInfo.result;

                //解析
                try {
                    JSONObject object=new JSONObject(result);
                    JSONArray users = object.getJSONArray("users");
                    person=new ArrayList<NearPerson>() ;
                    for(int i=0;i<users.length();i++){
                        JSONObject jsonObject = users.getJSONObject(i);

                        NearPerson nearPerson = new NearPerson();
                        nearPerson.setAge(jsonObject.getString("age"));
                        nearPerson.setDetail(jsonObject.getString("userTags"));
                        nearPerson.setDistance(jsonObject.getString("distance"));
                        nearPerson.setIconUrl(jsonObject.getString("avatarLarge"));
                        nearPerson.setNickName(jsonObject.getString("nickName"));
                        nearPerson.setSex(jsonObject.getString("sex"));
                        person.add(nearPerson);
                    }
                    Message message = handler.obtainMessage();
                    message.what=1;
                    message.obj=person;
                    handler.sendMessage(message);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });
    }
//获取精选目的地
public static List<PositionBodyView> getPositionData(String url, final Handler handler ) {
    HttpUtils utils = new HttpUtils();
    RequestParams params = new RequestParams();
    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
/*精选目的地：
http://app.ijianren.com:9898/jr3/destinationServices/indexList
version=3.0.2&lon=116.369683&clientKey=d5b3b700c7961e6b
&sign=7fdf89a5d8985d60&time=1430301990810&lat=40.037152&deviceType=android*/
    NameValuePair pair1 = new BasicNameValuePair("version", "3.0.2");
    NameValuePair pair2 = new BasicNameValuePair("lon", "116.369683");
    NameValuePair pair3 = new BasicNameValuePair("clientKey", "d5b3b700c7961e6b");

    NameValuePair pair4 = new BasicNameValuePair("sign", "7fdf89a5d8985d60");
    NameValuePair pair5 = new BasicNameValuePair("time", "1430301990810");
    NameValuePair pair6 = new BasicNameValuePair("lat", "40.037152");
    NameValuePair pair7 = new BasicNameValuePair("deviceType", "android");

    nameValuePairs.add(pair1);
    nameValuePairs.add(pair2);
    nameValuePairs.add(pair3);
    nameValuePairs.add(pair4);

    nameValuePairs.add(pair5);
    nameValuePairs.add(pair6);

    nameValuePairs.add(pair7);

    params.addBodyParameter(nameValuePairs);
    utils.send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {
        @Override
        public void onSuccess(ResponseInfo<String> objectResponseInfo) {

            //网络请求下来的JSON
            String result = objectResponseInfo.result;
            System.out.println(result);

            //解析
            try {
                JSONObject object=new JSONObject(result);
                JSONArray body = object.getJSONArray("body");


                position_body=new ArrayList<PositionBodyView>();

                for(int i=0;i<body.length();i++){

                    JSONObject jsonObject = body.getJSONObject(i);
                    PositionBodyView bodyview=new PositionBodyView();
                    bodyview.setModuleType( jsonObject.getString("moduleType"));
                    bodyview.setModuleName(jsonObject.getString("moduleName"));
                    JSONArray arr=jsonObject.getJSONArray("block");

                    position= new ArrayList<PositionBlockView>();

                    for (int j=0;j<arr.length();j++){
                        JSONObject obj = arr.getJSONObject(j);
                        PositionBlockView topview=new PositionBlockView();
                        topview.setImgName(obj.getString("imgName"));
                        topview.setSkipId(obj.getString("skipId"));
                        topview.setImgURL(obj.getString("imgURL"));
                        position.add(topview);
                        bodyview.setList(position);
                    }
                    position_body.add(bodyview);
                }

                Message message = handler.obtainMessage();
                message.what=2;
                message.obj=position_body;
                handler.sendMessage(message);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(HttpException e, String s) {
        }
    });
    return null;
}

}
