package edu.example.uplant.data.data_sources.category.repositories;

import android.app.Application;

import edu.example.uplant.data.data_sources.category.models.UserModel;
import edu.example.uplant.data.data_sources.category.room.entites.Users;
import edu.example.uplant.data.data_sources.category.room.root.PlantRoomDatabase;
import edu.example.uplant.ui.adapters.OnResultListener;

public class UserRepository {

    private PlantRoomDatabase database;
    boolean user;

    public UserRepository(Application application) {
        this.database = PlantRoomDatabase.getDatabase(application);
    }

    public void addUser(UserModel newuser) {
        PlantRoomDatabase.databaseWriteExecutor.execute(() -> {
            database.usersDao().insert(new Users(newuser.getEmail(), newuser.getPass()));
        });
    }

    public void isUser(String email, OnResultListener<Boolean> listener) {
        PlantRoomDatabase.databaseWriteExecutor.execute(() -> {
            boolean result = database.usersDao().isUser(email);
            listener.onResult(result);
        });
    }

    public void isLoginAndPass(String email, String pass, OnResultListener<Boolean> listener) {
        PlantRoomDatabase.databaseWriteExecutor.execute(() -> {
            boolean loginSuccessful = database.usersDao().isValidUser(email, pass);
            listener.onResult(loginSuccessful);
        });
    }
}
