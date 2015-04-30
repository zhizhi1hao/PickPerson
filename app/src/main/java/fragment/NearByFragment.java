package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshListView;

import day10.qianfeng.com.pickperson.R;
/**
 * Created by shang on 2015/4/30.
 */
public class NearByFragment extends Fragment {


    private PullToRefreshListView pulltofreshlv;

    public  static NearByFragment newInstance(int position)
    {
        NearByFragment nearByFragment=new NearByFragment();
         return  nearByFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
     View view=inflater.inflate(R.layout.fragment_nearby,null);
     return view;
    }
    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pulltofreshlv = (PullToRefreshListView)view.findViewById(R.id.pf_lv);







    }
}
