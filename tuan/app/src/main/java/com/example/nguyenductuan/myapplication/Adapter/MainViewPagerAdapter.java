package com.example.nguyenductuan.myapplication.Adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;

/**
 * Created by Nguyen Duc Tuan on 13-Oct-19.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {
  private ArrayList<Fragment> arrayFragment = new ArrayList<>();
  private ArrayList<String> arraytitle = new ArrayList<>();


    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return arrayFragment.get(position);
    }

    @Override
    public int getCount() {
        return arrayFragment.size();
    }
    public void addFragment (Fragment fragment, String title)
    {
        arrayFragment.add(fragment);
        arraytitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arraytitle.get(position);
    }
}
