package edu.example.uplant.data.data_sources.category.repositories;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import edu.example.uplant.ui.view_models.AutorizationViewModel.AuthState;

public class AuthAppRepository {
    private FirebaseAuth firebaseAuth;
    private MutableLiveData<FirebaseUser> userLiveData;
    private MutableLiveData<String> errorMessageLiveData;
    private MutableLiveData<AuthState> authStateLiveData;

    public AuthAppRepository() {
        firebaseAuth = FirebaseAuth.getInstance();
        userLiveData = new MutableLiveData<>();
        errorMessageLiveData = new MutableLiveData<>();
        authStateLiveData = new MutableLiveData<>();

        // Добавьте слушатель состояния аутентификации Firebase
        firebaseAuth.addAuthStateListener(auth -> {
            FirebaseUser user = auth.getCurrentUser();
            if (user != null) {
                // Пользователь аутентифицирован
                userLiveData.postValue(user);
                authStateLiveData.postValue(AuthState.AUTHENTICATED);
            } else {
                // Пользователь не аутентифицирован
                userLiveData.postValue(null);
                authStateLiveData.postValue(AuthState.UNAUTHENTICATED);
            }
        });
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
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Регистрация успешна, пользователь аутентифицирован
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        userLiveData.postValue(user);
                        authStateLiveData.postValue(AuthState.AUTHENTICATED);
                    } else {
                        // Возникла ошибка при регистрации
                        errorMessageLiveData.postValue(task.getException().getMessage());
                    }
                });
    }

    public void loginUser(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Авторизация успешна, пользователь аутентифицирован
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        userLiveData.postValue(user);
                        authStateLiveData.postValue(AuthState.AUTHENTICATED);
                    } else {
                        // Возникла ошибка при авторизации
                        errorMessageLiveData.postValue(task.getException().getMessage());
                    }
                });
    }

    public void logoutUser() {
        firebaseAuth.signOut();
    }

}
