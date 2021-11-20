package com.example.bottomnavigation20072021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottomnavigation20072021.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;
    List<Fragment> mListFragment;
    MainViewPagerAdapter mMainViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mListFragment = new ArrayList<>();
        mListFragment.add(new HomeFragment());
        mListFragment.add(new DashBoardFragment());
        mListFragment.add(new NotificationFragment());

        mMainViewPagerAdapter = new MainViewPagerAdapter(this,mListFragment);

        mBinding.viewPager2.setAdapter(mMainViewPagerAdapter);

        mBinding.bottomMain.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_item_home:
                        mBinding.viewPager2.setCurrentItem(0);
                        break;
                    case R.id.menu_item_dashboard:
                        mBinding.viewPager2.setCurrentItem(1);
                        break;
                    case R.id.menu_item_notification:
                        mBinding.viewPager2.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });

        mBinding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mBinding.bottomMain.getMenu().findItem(R.id.menu_item_home).setChecked(true);
                        break;
                    case 1:
                        mBinding.bottomMain.getMenu().findItem(R.id.menu_item_dashboard).setChecked(true);
                        break;
                    case 2:
                        mBinding.bottomMain.getMenu().findItem(R.id.menu_item_notification).setChecked(true);
                        break;
                }
                super.onPageSelected(position);
            }
        });



    }
}