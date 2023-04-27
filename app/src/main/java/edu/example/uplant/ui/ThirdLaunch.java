package edu.example.uplant.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.example.uplant.R;
import edu.example.uplant.databinding.FragmentThirdLaunch3Binding;
import edu.example.uplant.ui.view.Authorization;

public class ThirdLaunch extends Fragment {
    FragmentThirdLaunch3Binding mBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentThirdLaunch3Binding.inflate(inflater, container, false);
        mBinding.thirddalee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Authorization();
                // Переход на второй фрагмент
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, fragment).addToBackStack(null)
                        .commit();
            }
        });
        return mBinding.getRoot();
    }

}