package edu.example.uplant.ui.view_models.MyPlantViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.models.NapPlantModel;
import edu.example.uplant.data.data_sources.category.repositories.NapPlantRepository;

public class NewNapominaieViewModel extends AndroidViewModel {
    private NapPlantRepository repo;

    private LiveData<List<NapPlantModel>> mItems;

    private LiveData<List<NapPlantModel>> personPlant;


    private LiveData<List<NapPlantModel>> emailPlant;

    private LiveData<List<NapPlantModel>> infoTodo;


    private LiveData<List<NapPlantModel>> currentTime;




    public NewNapominaieViewModel(@NonNull Application application) {
        super(application);
        this.repo = new NapPlantRepository(application);
        mItems = repo.getDatabaseDataAllTodo();
    }

    public void addNapPlant(int id, String idemail, int idcateg, String plantname, String getDesc, long time) {
        repo.addTodo(new NapPlantModel(id, idemail, idcateg, plantname, getDesc, time));
    }

    public LiveData<List<NapPlantModel>> getmItems(){
        return mItems;
    }

    public void deleteTodo(int id){
        repo.deleteTodo(id);
    }

    public LiveData<List<NapPlantModel>> getPlantTodo(int id){
        personPlant = repo.getPlantTodo(id);
        return personPlant;
    }

    public LiveData<List<NapPlantModel>> getPlantEmailTodo(String idemail){
        emailPlant = repo.getDatabaseDataEmail(idemail);
        return emailPlant;
    }

    public LiveData<List<NapPlantModel>> getInfoTodo(int id){
        infoTodo = repo.getInfoTodo(id);
        return infoTodo;
    }






}
