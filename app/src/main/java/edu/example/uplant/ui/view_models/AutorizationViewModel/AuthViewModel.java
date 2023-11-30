package edu.example.uplant.ui.view_models.AutorizationViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseUser;

import edu.example.uplant.data.data_sources.category.repositories.AuthAppRepository;
import edu.example.uplant.ui.view_models.AutorizationViewModel.AuthState;

public class AuthViewModel extends ViewModel {
    public AuthAppRepository authAppRepository;
    public MutableLiveData<FirebaseUser> userLiveData;
    public MutableLiveData<String> errorMessageLiveData;
    private MutableLiveData<AuthState> authStateLiveData;

    public AuthViewModel() {
        authAppRepository = new AuthAppRepository();
        userLiveData = authAppRepository.getUserLiveData();
        errorMessageLiveData = authAppRepository.getErrorMessageLiveData();
        authStateLiveData = authAppRepository.getAuthStateLiveData();
    }
    public MutableLiveData<AuthState> getAuthStateLiveData() {
        return authStateLiveData;
    }

    public MutableLiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }

    public MutableLiveData<String> getErrorMessageLiveData() {
        return errorMessageLiveData;
    }

    public void registerUser(String email, String password) {
        authAppRepository.registerUser(email, password);
    }

    public void loginUser(String email, String password) {
        authAppRepository.loginUser(email, password);
    }

    public void logoutUser() {
        authAppRepository.logoutUser();
    }
}
