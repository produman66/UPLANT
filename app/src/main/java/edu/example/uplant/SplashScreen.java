package edu.example.uplant;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

import edu.example.uplant.databinding.FragmentFirstLaunch1Binding;
import edu.example.uplant.databinding.FragmentRegistrationBinding;
import edu.example.uplant.databinding.FragmentSplashScreenBinding;
import edu.example.uplant.ui.view.MyPlantUI.MyPlantMain;
import edu.example.uplant.ui.view.MyPlantUI.MyPlantNapMain;

public class SplashScreen extends Fragment {
    FragmentSplashScreenBinding mBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = FragmentSplashScreenBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        boolean onBoardingFinished = onBoardingFinished();
        boolean launchMainScreen = launchMainScreen();
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (onBoardingFinished && !launchMainScreen) {
                    Navigation.findNavController(view).navigate(R.id.action_splashScreen_to_authorization);
                } else if (onBoardingFinished && launchMainScreen) {
                    Navigation.findNavController(view).navigate(R.id.action_splashScreen_to_myPlantMain2);
                } else {
                    Navigation.findNavController(view).navigate(R.id.action_splashScreen_to_viewPagerFragment);
                }
            }
        }, 3000);
    }

    //Проверка на первый запуск
    private boolean onBoardingFinished() {
        SharedPreferences sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE);
        return sharedPref.getBoolean("Finished", false);
    }


    //Проверка на авторизован ли пользователь
    private  boolean launchMainScreen() {
        SharedPreferences sharedPref = requireActivity().getSharedPreferences("onAuto", Context.MODE_PRIVATE);
        return sharedPref.getBoolean("Finished", false);
    }
}