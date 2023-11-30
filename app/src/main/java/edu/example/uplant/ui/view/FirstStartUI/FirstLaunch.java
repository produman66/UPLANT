package edu.example.uplant.ui.view.FirstStartUI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.example.uplant.R;
import edu.example.uplant.databinding.FragmentFirstLaunch1Binding;

public class FirstLaunch extends Fragment {
    FragmentFirstLaunch1Binding mBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentFirstLaunch1Binding.inflate(inflater, container, false);

        ViewPager2 viewPager = getActivity().findViewById(R.id.viewPager);

        mBinding.firstdalee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Переход на второй фрагмент
                if (viewPager != null) {
                    viewPager.setCurrentItem(1);
                }
            }
        });
        return mBinding.getRoot();
    }
}

