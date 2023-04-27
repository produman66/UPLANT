package edu.example.uplant.ui.view;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import edu.example.uplant.R;
import edu.example.uplant.databinding.FragmentAuthorizationBinding;
import edu.example.uplant.ui.view.MyPlantUI.MyPlantMain;

public class Authorization extends Fragment {
    FragmentAuthorizationBinding mBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentAuthorizationBinding.inflate(inflater, container, false);
        Window window = getActivity().getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.setStatusBarColor(getContext().getColor(R.color.green_600));
        }
        mBinding.btnaut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Переход на второй фрагмент
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, new MyPlantMain()).addToBackStack(null)
                        .commit();
            }
        });
        return mBinding.getRoot();
    }

}