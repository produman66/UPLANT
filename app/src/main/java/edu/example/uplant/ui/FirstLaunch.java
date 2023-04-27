package edu.example.uplant.ui;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import edu.example.uplant.R;
import edu.example.uplant.databinding.FragmentFirstLaunch1Binding;

public class FirstLaunch extends Fragment {
    FragmentFirstLaunch1Binding mBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentFirstLaunch1Binding.inflate(inflater, container, false);
        mBinding.firstdalee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Переход на второй фрагмент
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, new SecondLaunch()).addToBackStack(null)
                        .commit();
            }
        });
        return mBinding.getRoot();
    }

}

