package edu.example.uplant.ui.view.ProfileUI;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import edu.example.uplant.R;
import edu.example.uplant.ui.view_models.AutorizationViewModel.AuthState;
import edu.example.uplant.ui.view_models.AutorizationViewModel.AuthViewModel;

public class ProfileMain extends Fragment {
    private FirebaseAuth mAuth;
    private TextView mEmailTextView;
    private AuthViewModel authViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_main, container, false);

        mAuth = FirebaseAuth.getInstance();
        mEmailTextView = view.findViewById(R.id.email);

        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            String email = user.getEmail();
            mEmailTextView.setText(email);
        }


        authViewModel = new ViewModelProvider(requireActivity()).get(AuthViewModel.class);
        Button btn = view.findViewById(R.id.btnaut);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchMainScreen();
                logoutUser();
                Toast.makeText(getActivity(), "Вы вышли из аккаунта", Toast.LENGTH_SHORT).show();
            }
        });

        authViewModel.getAuthStateLiveData().observe(getViewLifecycleOwner(), authState -> {
            if (authState == AuthState.UNAUTHENTICATED) {
                Navigation.findNavController(view).navigate(R.id.action_profileMain2_to_authorization1);
            }
        });

        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottonNavigation);
        bottomNavigationView.setSelectedItemId(R.id.profile1);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.plant:
                    Navigation.findNavController(view).navigate(R.id.action_global_myPlantFragment);
                    return true;
                case R.id.book:
                    Navigation.findNavController(view).navigate(R.id.action_global_spravochnikFragment);
                    return true;
                case R.id.favorite:
                    Navigation.findNavController(view).navigate(R.id.action_global_favoriteFragment);
                    return true;
                case R.id.profile1:
                    return true;
            }
            return false;
        });






        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Navigation.findNavController(view).navigate(R.id.action_global_myPlantFragment);
            }
        });

        return view;
    }
    private void launchMainScreen() {
        SharedPreferences sharedPref = requireActivity().getSharedPreferences("onAuto", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Finished", false);
        editor.apply();
    }

    private void logoutUser() {
        authViewModel.logoutUser();
    }
}