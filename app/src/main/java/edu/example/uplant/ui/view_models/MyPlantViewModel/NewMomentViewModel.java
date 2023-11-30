package edu.example.uplant.ui.view_models.MyPlantViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.models.MomentModel;
import edu.example.uplant.data.data_sources.category.models.NapPlantModel;
import edu.example.uplant.data.data_sources.category.repositories.MomentRepository;
import edu.example.uplant.data.data_sources.category.repositories.NapPlantRepository;

public class NewMomentViewModel extends AndroidViewModel {

    private MomentRepository repo;

    private LiveData<List<MomentModel>> mItems;

    private LiveData<List<MomentModel>> infoMoment;

    public NewMomentViewModel(@NonNull Application application) {
        super(application);
        this.repo = new MomentRepository(application);
    }

    public void addMoment(int id, int idcateg, String desc, String date, long time, String url) {
        repo.addMoment(new MomentModel(id, idcateg, desc, date, time, url));
    }

    public LiveData<List<MomentModel>> getmItems(int idcateg){
        mItems = repo.getPlantMoment(idcateg);
        return mItems;
    }

    public void deleteMoment(int id){
        repo.deleteMoment(id);
    }


    public LiveData<List<MomentModel>> getInfoMoment(int id){
        infoMoment = repo.getInfoMoment(id);
        return infoMoment;
    }
}
