package edu.example.uplant.ui.FirstStart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.example.uplant.databinding.FragmentViewPagerBinding;
import edu.example.uplant.ui.view.FirstStartUI.FirstLaunch;
import edu.example.uplant.ui.view.FirstStartUI.SecondLaunch;
import edu.example.uplant.ui.view.FirstStartUI.ThirdLaunch;

public class ViewPagerFragment extends Fragment {
    FragmentViewPagerBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentViewPagerBinding.inflate(inflater, container, false);
        View view = mBinding.getRoot();


        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new FirstLaunch());
        fragmentList.add(new SecondLaunch());
        fragmentList.add(new ThirdLaunch());

        ViewPagerAdapter adapter = new ViewPagerAdapter(fragmentList, requireActivity().getSupportFragmentManager(), getLifecycle());
        mBinding.viewPager.setAdapter(adapter);


        return view;
    }
}