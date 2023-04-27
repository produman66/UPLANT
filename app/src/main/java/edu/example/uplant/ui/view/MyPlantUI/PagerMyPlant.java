package edu.example.uplant.ui.view.MyPlantUI;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import edu.example.uplant.R;
import edu.example.uplant.ui.view_models.MyPlantViewModel.PagerMyPlantViewModel;

public class PagerMyPlant extends Fragment {
    Toolbar toolbar;
    PagerMyPlantViewModel mViewModel;
    int intValue;
    String strValue, desc, poliv, peres, udobr, zam, nameimage;
    AppCompatActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pager_my_plant, container, false);
        Bundle args = getArguments();
        intValue = args.getInt("key1");
        strValue = args.getString("key");
        desc = args.getString("key2");
        poliv = args.getString("key3");
        peres = args.getString("key4");
        udobr = args.getString("key5");
        zam = args.getString("key6");
        nameimage = args.getString("key7");
        toolbar = view.findViewById(R.id.toolbar2);
        activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_back);
        toolbar.getNavigationIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        SectionsPagerAdapter pagerAdapter =
                new SectionsPagerAdapter(getChildFragmentManager(), intValue);
        ViewPager pager = (ViewPager) view.findViewById(R.id.pager1);
        pager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs1);
        tabLayout.setupWithViewPager(pager);
        activity.getSupportActionBar().setTitle(strValue);
        setHasOptionsMenu(true);
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new PagerMyPlantViewModel(activity.getApplication(), intValue);
            }
        }).get(PagerMyPlantViewModel.class);
        return view;
    }
    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        private final String[] PAGE_TITLES = {
                getResources().getText(R.string.home).toString(),
                getResources().getText(R.string.napom).toString(),
                getResources().getText(R.string.moment).toString(),
        };
        private int mStrValue;

        public SectionsPagerAdapter(FragmentManager fm, int intValue) {
            super(fm);
            mStrValue = intValue;
        }
        @Override
        public int getCount() {
            return PAGE_TITLES.length;
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return MyPlantCartochka.newInstance(mStrValue);
                case 1:
                    return new MyPlantCartochka2();
                case 2:
                    return new MyPlantCartochka3();
            }
            return null;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return PAGE_TITLES[position];
        }
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_redactor, menu); // надуваем меню из ресурсов
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // обрабатываем выбор элементов меню
        switch (item.getItemId()) {
            case R.id.action_edit:
                Fragment fragment = new EditMyPlant();
                Bundle args = new Bundle();
                args.putInt("key", intValue);
                fragment.setArguments(args);
//                args.putString("key1", strValue);
//                args.putString("key2", desc);
//                args.putString("key3", poliv);
//                args.putString("key4", peres);
//                args.putString("key5", udobr);
//                args.putString("key6", zam);
                args.putString("key7", nameimage);
//                args.putStringArrayList("textList", new ArrayList<>(textList));
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}