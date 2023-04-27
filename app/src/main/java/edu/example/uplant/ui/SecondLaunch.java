package edu.example.uplant.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.example.uplant.R;
import edu.example.uplant.databinding.FragmentSecondLaunch2Binding;

public class SecondLaunch extends Fragment {
    FragmentSecondLaunch2Binding mBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentSecondLaunch2Binding.inflate(inflater, container, false);
        mBinding.secdalee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ThirdLaunch();
                // Переход на второй фрагмент
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, fragment).addToBackStack(null)
                        .commit();
            }
        });
        return mBinding.getRoot();
    }
}