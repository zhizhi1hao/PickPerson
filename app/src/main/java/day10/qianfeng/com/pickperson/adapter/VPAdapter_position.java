package day10.qianfeng.com.pickperson.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import day10.qianfeng.com.pickperson.fragment.PositionVPFragment;

/**
 * Created by Administrator on 2015/5/4 0004.
 */
public class VPAdapter_position extends FragmentPagerAdapter{
    public VPAdapter_position(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return PositionVPFragment.getPosition(position);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
