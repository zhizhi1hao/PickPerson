package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;

import day10.qianfeng.com.pickperson.R;

/**
 * Created by shang on 2015/4/30.
 */
public class HomeFragment extends Fragment {
    private RadioGroup homeRadiogroup;
    private int[] rbs=new int[3];
    private View[]views=new View[3];
    private ViewPager homeVp;
    //vp的页面个数 固定值
    public static final int NUM=3;
    private HomeVpAdapter homeVpAdapter;

    //返回当前对象的静态方法
    public static HomeFragment newInstance(int position) {
        HomeFragment homeFragment=new HomeFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("position",position);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_home,null);
        init(view);

        homeVpAdapter = new HomeVpAdapter(getChildFragmentManager());
        //设置适配器
        homeVp.setAdapter(homeVpAdapter);
          //ViewPager设置页面监听
        homeVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
             homeRadiogroup.check(rbs[position]);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        //radioGroup设置改变监听
        homeRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 for(int i=0;i<rbs.length;i++)  {
                     if(checkedId==rbs[i])
                     {
                         homeVp.setCurrentItem(i);
                         views[i].setVisibility(View.VISIBLE);
                     }
                     else
                     {
                         views[i].setVisibility(View.INVISIBLE);
                     }
                 }
            }
        });
        return view;
    }






//初始化
 public void init(View view)
 {
     homeRadiogroup = ((RadioGroup) view.findViewById(R.id.home_radiogroup));
    views[0]=view.findViewById(R.id.viewline_near);
     views[1]=view.findViewById(R.id.viewline_rec);
     views[2]=view.findViewById(R.id.viewling_comhere);
     homeVp = ((ViewPager) view.findViewById(R.id.home_vp));
     //radiosButton 初始化 放入rbs
     rbs[0]=R.id.rb_near;
     rbs[1]=R.id.rb_rec;
     rbs[2]=R.id.rb_comehere;
 }

    class HomeVpAdapter extends FragmentPagerAdapter
    {
        public HomeVpAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return NearByFragment.newInstance(position);
        }
        @Override
        public int getCount() {
            return NUM ;
        }
    }



}
