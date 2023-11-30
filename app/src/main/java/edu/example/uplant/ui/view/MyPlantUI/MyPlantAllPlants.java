package edu.example.uplant.ui.view.MyPlantUI;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

import edu.example.uplant.R;
import edu.example.uplant.data.data_sources.category.models.MyPlantModel;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.SpravochnikAdapters.MyPlantListAdapter;
import edu.example.uplant.ui.view_models.SpravochnikViewModel.MyPlantViewModel;

public class MyPlantAllPlants extends Fragment implements CustomerClickListener, SearchView.OnQueryTextListener {
    Toolbar toolbar;
    MyPlantViewModel mViewModel;
    MyPlantListAdapter adapter;
    private FirebaseAuth mAuth;
    String email;
    SearchView searchView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_plant_all_plants, container, false);
        Bundle args = getArguments();
        String strValue = args.getString("key");
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        email = user.getEmail();


        toolbar = view.findViewById(R.id.toolbar13);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        RecyclerView recyclerView = view.findViewById(R.id.plantrecycler13);
        adapter = new MyPlantListAdapter(new MyPlantListAdapter.PlantDiff(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        Drawable icon = getResources().getDrawable(R.drawable.arrow_back);
        DrawableCompat.setTint(icon, ContextCompat.getColor(getActivity(), R.color.white));
        toolbar.setNavigationIcon(icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).popBackStack();
            }
        });
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MyPlantViewModel(getActivity().getApplication(), args.getInt("key1"), email);
            }
        }).get(MyPlantViewModel.class);
        activity.getSupportActionBar().setTitle(strValue);
        mViewModel.getAllWords().observe(getActivity(), words -> {
            adapter.submitList(words);
        });

        searchView = view.findViewById(R.id.search_text1);
        searchView.setOnQueryTextListener(this);
        return view;
    }
    @Override
    public void onCustomerClick(int position) {
        MyPlantModel selectedPlant = adapter.getCurrentList().get(position);
        Bundle args = new Bundle();
        args.putString("key", selectedPlant.getPlantname());
        args.putString("key1", selectedPlant.getNameimage());
        NavController navController = NavHostFragment.findNavController(MyPlantAllPlants.this);
        navController.navigate(R.id.action_myPlantAllPlants2_to_myPlantNewCartochka2, args);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText != null) {
            searchDatabase(newText);
        }
        return true;
    }

    private void searchDatabase(String newText) {
        String searchQuery = "%" + newText + "%";
        mViewModel.getSearch(searchQuery, email).observe(this, new Observer<List<MyPlantModel>>() {
            @Override
            public void onChanged(List<MyPlantModel> list) {
                adapter.submitList(list);
            }
        });
    }
}