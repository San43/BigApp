package fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bigapp.bigappcompany.R;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

import adapter.AlbumAdapter;

/**
 * Created by Others on 5/21/2017.
 */

public class HomeFragment extends Fragment
{
    ViewPager albumViewpager,albumListViewpager;
    AlbumAdapter albumAdapter;
    CirclePageIndicator circlePageIndicator;
    TabLayout albumTabLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        albumViewpager = (ViewPager) view.findViewById(R.id.album_viewpager);
        albumListViewpager = (ViewPager) view.findViewById(R.id.albumlist_viewpager);
        setupViewPager(albumListViewpager);

        circlePageIndicator = (CirclePageIndicator)  view.findViewById(R.id.circle_indicator) ;
        albumTabLayout= (TabLayout) view.findViewById(R.id.album_tablayout);

        albumAdapter = new AlbumAdapter(getActivity());
        albumViewpager.setAdapter(albumAdapter);

        circlePageIndicator.setViewPager(albumViewpager);

        albumTabLayout.setupWithViewPager(albumListViewpager);
        setupTabWithIcons();
        return  view;
    }
    private void setupViewPager(ViewPager albumListViewpager)
    {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getFragmentManager());
        viewPagerAdapter.addFragment(new VideosFragment(),"VIDEOS");
        viewPagerAdapter.addFragment(new VideosFragment(),"IMAGES");
        viewPagerAdapter.addFragment(new VideosFragment(),"MILESTONE");
        albumListViewpager.setAdapter(viewPagerAdapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter
    {

        private ArrayList<Fragment> mFragmentList = new ArrayList<>();
        private ArrayList<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment,String title)
        {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    private void setupTabWithIcons()
    {

        TextView tabOne = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.albumlist_tab, null);
        tabOne.setText("VIDEOS");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.video_selector, 0, 0);
        albumTabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.albumlist_tab, null);
        tabTwo.setText("IMAGES");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.album_selector, 0, 0);
        albumTabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.albumlist_tab, null);
        tabThree.setText("MILESTONE");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.milestone_selector, 0, 0);
        albumTabLayout.getTabAt(2).setCustomView(tabThree);

    }
}
