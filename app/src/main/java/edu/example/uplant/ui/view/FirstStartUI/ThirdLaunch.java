package edu.example.uplant.ui.view.FirstStartUI;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.example.uplant.R;
import edu.example.uplant.databinding.FragmentThirdLaunch3Binding;

public class ThirdLaunch extends Fragment {
    FragmentThirdLaunch3Binding mBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentThirdLaunch3Binding.inflate(inflater, container, false);
        ViewPager2 viewPager = getActivity().findViewById(R.id.viewPager);

        mBinding.thirddalee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_viewPagerFragment1_to_authorization1);
                onBoardingFinished();
            }
        });
        return mBinding.getRoot();
    }


    //Устанавливаем что пользователь уже просмотрел вступление
    private void onBoardingFinished() {
        SharedPreferences sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Finished", true);
        editor.apply();
    }

}