package edu.example.uplant.ui.view.SpravochnikUI;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import edu.example.uplant.R;
import edu.example.uplant.ui.view_models.SpravochnikViewModel.PagerViewModel;

public class PagerFragment extends Fragment {
    Toolbar toolbar;
    PagerViewModel mViewModel;
    String strValue;
    AppCompatActivity activity;
    FirebaseAuth mAuth;
    String email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        Bundle args = getArguments();
        strValue = args.getString("key");
        toolbar = view.findViewById(R.id.toolbar1);
        activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        email = user.getEmail();

        toolbar.setNavigationIcon(R.drawable.arrow_back);
        ToggleButton toggleButton = view.findViewById(R.id.toggle_button);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // код, который выполнится, если кнопка переключена в состояние "включено"
                    mViewModel.onFavoriteButtonClicked(strValue, email);
                    Toast.makeText(getActivity(), "Добавлено в избранное", Toast.LENGTH_SHORT).show();

                } else {
                    mViewModel.onFavoriteButtonClicked(strValue, email);
                    Toast.makeText(getActivity(), "Удалено из избранного", Toast.LENGTH_SHORT).show();
                }
            }
        });
        toolbar.getNavigationIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).popBackStack();
            }
        });
        SectionsPagerAdapter pagerAdapter =
                new SectionsPagerAdapter(getChildFragmentManager(), strValue);
        ViewPager pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
        activity.getSupportActionBar().setTitle(strValue);
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new PagerViewModel(activity.getApplication(), strValue);
            }
        }).get(PagerViewModel.class);
        return view;
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        private final String[] PAGE_TITLES = {
                getResources().getText(R.string.home).toString(),
                getResources().getText(R.string.stores).toString(),
                getResources().getText(R.string.pizza).toString(),
                getResources().getText(R.string.pizza).toString()
        };
        private String mStrValue;
        private ArrayList<String> PAGE_TITLES1;

        public SectionsPagerAdapter(FragmentManager fm, String strValue) {
            super(fm);
            mStrValue = strValue;
            PAGE_TITLES1= new ArrayList<>();
            PAGE_TITLES1.add(getResources().getText(R.string.home).toString());
            PAGE_TITLES1.add(getResources().getText(R.string.stores).toString());
            PAGE_TITLES1.add(getResources().getText(R.string.pizza).toString());
            PAGE_TITLES1.add(getResources().getText(R.string.udobr).toString());
            PAGE_TITLES1.add(getResources().getText(R.string.razmnozhenie).toString());
            PAGE_TITLES1.add(getResources().getText(R.string.obrezka).toString());
            PAGE_TITLES1.add(getResources().getText(R.string.zashita).toString());
            PAGE_TITLES1.add(getResources().getText(R.string.svet).toString());
            PAGE_TITLES1.add(getResources().getText(R.string.temp).toString());
            PAGE_TITLES1.add(getResources().getText(R.string.vlazh).toString());
        }

        @Override
        public int getCount() {
            return PAGE_TITLES1.size();
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return CartochkaSpravochnika.newInstance(mStrValue);
                case 1:
                    return CartochkaSpravochnika2.newInstance(mStrValue);
                case 2:
                    return CartochkaSpravochnika3.newInstance(mStrValue);
                case 3:
                    return CartochkaSpravochnika4.newInstance(mStrValue);
                case 4:
                    return CartochkaSpravochnika5.newInstance(mStrValue);
                case 5:
                    return CartochkaSpravochnika6.newInstance(mStrValue);
                case 6:
                    return CartochkaSpravochnika7.newInstance(mStrValue);
                case 7:
                    return CartochkaSpravochnika8.newInstance(mStrValue);
                case 8:
                    return CartochkaSpravochnika9.newInstance(mStrValue);
                case 9:
                    return CartochkaSpravochnika10.newInstance(mStrValue);

            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return PAGE_TITLES1.get(position);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_favorite, menu); // надуваем меню из ресурсов
        super.onCreateOptionsMenu(menu, inflater);
    }
}