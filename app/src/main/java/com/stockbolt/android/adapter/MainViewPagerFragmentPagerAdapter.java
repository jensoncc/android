package com.stockbolt.android.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.stockbolt.android.R;
import com.stockbolt.android.data.FeedRepository;
import com.stockbolt.android.feed.FeedFragment;
import com.stockbolt.android.feed.FeedPresenter;



/**
 * Created by Jenson on 11/5/2017.
 */

public class MainViewPagerFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;

    private Context context;
    public static final int FRAGMENT_CITY_GUIDE = 0;
    public static final int FRAGMENT_EAT = 1;
    public static final int FRAGMENT_SHOP = 2;

    public MainViewPagerFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int pageIndex) {
        switch (pageIndex) {
            case FRAGMENT_CITY_GUIDE:
                FeedFragment feedFragment = FeedFragment.newInstance(String.valueOf(pageIndex), "");
                FeedPresenter feedPresenter = new FeedPresenter(feedFragment, new FeedRepository());
                feedFragment.setPresenter(feedPresenter);
                return feedFragment;

            case FRAGMENT_EAT:
                FeedFragment feedFragment2 = FeedFragment.newInstance(String.valueOf(pageIndex), "");
                FeedPresenter feedPresenter2 = new FeedPresenter(feedFragment2, new FeedRepository());
                feedFragment2.setPresenter(feedPresenter2);
                return feedFragment2;

            case FRAGMENT_SHOP:
                FeedFragment feedFragment3 = FeedFragment.newInstance(String.valueOf(pageIndex), "");
                FeedPresenter feedPresenter3 = new FeedPresenter(feedFragment3, new FeedRepository());
                feedFragment3.setPresenter(feedPresenter3);
                return feedFragment3;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        Resources resource = context.getResources();
        String tabTitles[] = new String[]{resource.getString(R.string.tab1), resource.getString(R.string.tab2), resource.getString(R.string.tab3)};
        return tabTitles[position];
    }
}
