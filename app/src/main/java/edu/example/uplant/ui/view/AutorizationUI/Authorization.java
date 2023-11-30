package edu.example.uplant.ui.view.AutorizationUI;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import edu.example.uplant.R;
import edu.example.uplant.databinding.FragmentAuthorizationBinding;
import edu.example.uplant.ui.view_models.AutorizationViewModel.AuthState;
import edu.example.uplant.ui.view_models.AutorizationViewModel.AuthViewModel;
import edu.example.uplant.ui.view_models.SpravochnikViewModel.PagerViewModel;
import edu.example.uplant.ui.view_models.AutorizationViewModel.UserViewModel;

public class Authorization extends Fragment {
    FragmentAuthorizationBinding mBinding;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    UserViewModel mViewModel;
    AppCompatActivity activity;
    private AuthViewModel authViewModel;
    PagerViewModel mViewModel1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentAuthorizationBinding.inflate(inflater, container, false);
        Window window = getActivity().getWindow();
        activity = (AppCompatActivity) getActivity();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.setStatusBarColor(getContext().getColor(R.color.green_600));
        }
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new UserViewModel(activity.getApplication());
            }
        }).get(UserViewModel.class);

        mViewModel1 = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new PagerViewModel(activity.getApplication(), "");
            }
        }).get(PagerViewModel.class);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Авторизация используя Firebase. Нужен интернет

        mBinding.newacc.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_authorization1_to_registration2);
        });

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().finish();
            }
        });


        authViewModel = new ViewModelProvider(requireActivity()).get(AuthViewModel.class);
        mBinding.btnaut.setOnClickListener(v -> {
            if (TextUtils.isEmpty(mBinding.email.getText().toString())) {
                Toast.makeText(getActivity(), "Введите Email", Toast.LENGTH_SHORT).show();
                return;
            } else if (TextUtils.isEmpty(mBinding.pass.getText().toString())) {
                Toast.makeText(getActivity(), "Введите пароль", Toast.LENGTH_SHORT).show();
                return;
            } else {
                authViewModel.loginUser(mBinding.email.getText().toString(), mBinding.pass.getText().toString());
            }
        });

        authViewModel.getAuthStateLiveData().observe(getViewLifecycleOwner(), authState -> {
            if (authState == AuthState.AUTHENTICATED) {
                // Переход на экран после успешной авторизации
                mViewModel1.newacc();
                Navigation.findNavController(view).navigate(R.id.action_authorization1_to_myPlantMain2);
                launchMainScreen();
            }
        });



        authViewModel.getErrorMessageLiveData().observe(getViewLifecycleOwner(), errorMessage -> {
            if (errorMessage != null) {
                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void launchMainScreen() {
        SharedPreferences sharedPref = requireActivity().getSharedPreferences("onAuto", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Finished", true);
        editor.apply();
    }
}



















//                auth.signInWithEmailAndPassword(mBinding.email.getText().toString(), mBinding.pass.getText().toString())
//                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                            @Override
//                            public void onSuccess(AuthResult authResult) {
//                                //Navigation.findNavController(v).navigate(R.id.action_login_to_myPlant);
//
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Toast.makeText(getActivity(), "Пароль или логин неверный", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//            });






            //Я не нашёл решения как мне используя навграф выйти (я не понимаю, я там намудрил конкретно)
//             в итоге я просто перехватываю кнопкуу назад и выхожу


            //Устанавливаем что пользователь уже просмотрел вступлени



//Авторизация
//                mViewModel.isLogin(mBinding.email.getText().toString(), mBinding.pass.getText().toString(), new OnResultListener<Boolean>() {
//                    @Override
//                    public void onResult(Boolean result) {
//                        if (result) {
//                            activity.runOnUiThread(() -> {
//                                Toast.makeText(getActivity(), "Что-то пошло не так...", Toast.LENGTH_SHORT).show();
//                            });
//                        } else {
//                            activity.runOnUiThread(() -> {
//                                Toast.makeText(getActivity(), "Добро пожаловать!", Toast.LENGTH_SHORT).show();
//                                launchMainScreen();
////                                Bundle args = new Bundle();
////                                args.putString("key", mBinding.email.getText().toString());
////                                NavController navController = NavHostFragment.findNavController(Authorization.this);
////                                navController.navigate(R.id.action_authorization1_to_myPlantMain2, args);
//                            });
//
//                        }
//                    }
//                });