package edu.example.uplant.ui.view.AutorizationUI;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import edu.example.uplant.R;
import edu.example.uplant.databinding.FragmentRegistrationBinding;
import edu.example.uplant.ui.view_models.AutorizationViewModel.AuthViewModel;
import edu.example.uplant.ui.view_models.SpravochnikViewModel.PagerViewModel;
import edu.example.uplant.ui.view_models.AutorizationViewModel.UserViewModel;

public class Registration extends Fragment{
    FragmentRegistrationBinding mBinding;
    private AuthViewModel authViewModel;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    UserViewModel mViewModel;
    AppCompatActivity activity;
    PagerViewModel mViewModel1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentRegistrationBinding.inflate(inflater, container, false);
        View view = mBinding.getRoot();
        activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(mBinding.toolbar15);
        Drawable icon = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_green_24);
        DrawableCompat.setTint(icon, ContextCompat.getColor(getActivity(), R.color.green_600));
        mBinding.toolbar15.setNavigationIcon(icon);
        mBinding.toolbar15.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).popBackStack();
            }
        });
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
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        authViewModel = new ViewModelProvider(requireActivity()).get(AuthViewModel.class);

        mBinding.btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mBinding.email.getText().toString())) {
                    Toast.makeText(getActivity(), "Введите Email", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(mBinding.name.getText().toString())) {
                    Toast.makeText(getActivity(), "Введите имя", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(mBinding.pass.getText().toString())) {
                    Toast.makeText(getActivity(), "Введите пароль", Toast.LENGTH_SHORT).show();
                    return;
                } else if (mBinding.pass.getText().toString().length() < 6) {
                    Toast.makeText(getActivity(), "Введите пароль, более 6 символов", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    authViewModel.registerUser(mBinding.email.getText().toString(), mBinding.pass.getText().toString());
                }
            }
        });

        authViewModel.getErrorMessageLiveData().observe(getViewLifecycleOwner(), errorMessage -> {
            if (errorMessage != null) {
                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show();
            }
        });

        authViewModel.getUserLiveData().observe(getViewLifecycleOwner(), user -> {
            if (user != null) {
                mViewModel.addUser(mBinding.email.getText().toString(), mBinding.pass.getText().toString());
                Toast.makeText(getActivity(), "Успешная регистрация", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_registration2_to_myPlantMain2);
                mViewModel1.newacc();
                launchMainScreen();
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























//Регистрация пользователя используя Firebase
//                auth.createUserWithEmailAndPassword(mBinding.email.getText().toString(), mBinding.pass.getText().toString())
//                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                            @Override
//                            public void onSuccess(AuthResult authResult) {
//                                UserModel user = new UserModel(mBinding.email.getText().toString(), mBinding.pass.getText().toString());
//                                users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                                        .setValue(user)
//                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                            @Override
//                                            public void onSuccess(Void unused) {
//                                                mViewModel.addUser(mBinding.email.getText().toString(), mBinding.pass.getText().toString());
////                                                Toast.makeText(getActivity(), "Успешная регистрация", Toast.LENGTH_SHORT).show();
//                                                Navigation.findNavController(v).popBackStack();
//                                            }
//                                        });
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        // Обработка ошибки
//                        Toast.makeText(getActivity(), "Ошибка при регистрации: " + e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//                Navigation.findNavController(v).popBackStack();








//Локальная регистрация пользователя
//                mViewModel.isUser(mBinding.email.getText().toString(), new OnResultListener<Boolean>() {
//                    @Override
//                    public void onResult(Boolean result) {
//                        if (result) {
//                            activity.runOnUiThread(() -> {
//                                Toast.makeText(getActivity(), "Этот email уже используется, попробуйте другой", Toast.LENGTH_SHORT).show();
//                            });
//                        } else {
//                            mViewModel.addUser(mBinding.email.getText().toString(), mBinding.pass.getText().toString());
//                            activity.runOnUiThread(() -> {
//                                Toast.makeText(getActivity(), "Регистрация прошла успешно!", Toast.LENGTH_SHORT).show();
//                                Navigation.findNavController(v).popBackStack();
//                            });
//                        }
//                    }
//                });