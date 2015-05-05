package day10.qianfeng.com.pickperson.fragment;



import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import day10.qianfeng.com.pickperson.R;
import day10.qianfeng.com.pickperson.Utils.BitmapHelper;
import day10.qianfeng.com.pickperson.Utils.FinalUrls;
import day10.qianfeng.com.pickperson.Utils.HttpUtilsHelper;
import day10.qianfeng.com.pickperson.bean.PositionBodyView;

public class PositionVPFragment extends Fragment {
    private List<PositionBodyView> list;
    private int position;
    private ImageView img1,img2,img3;
    private Handler handler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==2){
                List<PositionBodyView> list1= (List<PositionBodyView>) msg.obj;
                list.addAll(list1);
                switch (position){
                    case 0:
                        for (int i=1;i<4;i++){
                            String str= list.get(0).getList().get(i).getImgURL();
                            switch (i){
                                case 1:
                                    BitmapHelper.getUtils().display(img1,str);
                                    break;
                                case 2:
                                    BitmapHelper.getUtils().display(img2,str);
                                    break;
                                case 3:
                                    BitmapHelper.getUtils().display(img3,str);
                                    break;
                            }
                        }
                        break;
                    case 1:
                        for (int j=4;j<7;j++){
                            String str= list.get(0).getList().get(j).getImgURL();
                            switch (j){
                                case 4:
                                    BitmapHelper.getUtils().display(img1,str);

                                    break;
                                case 5:
                                    BitmapHelper.getUtils().display(img2,str);
                                    break;
                                case 6:
                                    BitmapHelper.getUtils().display(img3,str);
                                    break;
                            }
                        }
                        break;
                }


            }
        }
    };
public static final String KEY="position";
    public  static PositionVPFragment getPosition(int position){

        PositionVPFragment vpFragment=new PositionVPFragment();
        Bundle bundle=new Bundle();
        bundle.putInt(KEY,position);
        vpFragment.setArguments(bundle);
        return  vpFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       list=new ArrayList<PositionBodyView>();
        BitmapHelper.getBitmapUtils(getActivity());
        HttpUtilsHelper.getPositionData(FinalUrls.PositonURl, handler);
         position =getArguments().getInt(KEY);
        View view = inflater.inflate(R.layout.position_vp_fragment, container, false);
         img1=(ImageView) view.findViewById(R.id.img_vp1);
         img2 = (ImageView) view.findViewById(R.id.img_vp2);
         img3 = (ImageView) view.findViewById(R.id.img_vp3);


        return view;
    }

}
