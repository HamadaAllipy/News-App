package pc.example.news.ui.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import pc.example.news.ui.fragments.NewsActivity;
import pc.example.news.ui.fragments.NewsFragment;
import pc.example.news.ui.fragments.SportsFragment;

public class CustomPagerAdapter extends FragmentPagerAdapter {
    public CustomPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return new NewsFragment();
            case 1 :
                return new SportsFragment();
                default: return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 :
                return "News";
            case 1 :
                return "Sports";
                default: return null ;
        }
    }
}
