package edu.example.uplant.ui.view_models.AutorizationViewModel;

import static android.view.View.combineMeasuredStates;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import edu.example.uplant.data.data_sources.category.models.UserModel;
import edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository;
import edu.example.uplant.data.data_sources.category.repositories.UserRepository;
import edu.example.uplant.ui.adapters.OnResultListener;

public class UserViewModel extends AndroidViewModel {

    private UserRepository mRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        try {
            mRepository = new UserRepository(application);

        } catch (Exception e) {
            // обработка исключения
            Log.e(TAG, "Error while creating MyPlantViewModel object", e);
            throw new RuntimeException("Error while creating MyPlantViewModel object", e);
        }
    }

    public void isUser(String email, OnResultListener<Boolean> listener){
        mRepository.isUser(email, listener);
    }

    public void addUser(String email, String pass){
        mRepository.addUser(new UserModel(email,pass));
    }

    public void isLogin(String email, String pass, OnResultListener<Boolean> listener){
        mRepository.isLoginAndPass(email, pass, listener);
    }


}
