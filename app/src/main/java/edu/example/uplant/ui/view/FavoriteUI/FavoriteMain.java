package edu.example.uplant.ui.view.FavoriteUI;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import edu.example.uplant.R;
import edu.example.uplant.data.data_sources.category.models.MyPlantModel;
import edu.example.uplant.ui.view.SpravochnikUI.PagerFragment;
import edu.example.uplant.ui.view.SpravochnikUI.SpravochnicSearch;
import edu.example.uplant.ui.view_models.FavoriteViewModel.FavoriteViewModel;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.FavoriteAdapters.FavoriteAdapter;

public class FavoriteMain extends Fragment implements CustomerClickListener {
    private FavoriteViewModel mWordViewModel;
    FavoriteAdapter adapter;
    FirebaseAuth mAuth;
    String email;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_main, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.plantrecycler7);
        Toolbar toolbar = view.findViewById(R.id.toolbar2);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Избранное");
        adapter = new FavoriteAdapter(new FavoriteAdapter.PlantDiff(), this);
        recyclerView.setAdapter(adapter);


        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        email = user.getEmail();


        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mWordViewModel = new ViewModelProvider(this).get(FavoriteViewModel.class);
        mWordViewModel.getFav(email).observe(getActivity(), words -> {
            adapter.submitList(words);
        });
        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottonNavigation);
        bottomNavigationView.setSelectedItemId(R.id.favorite);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.plant:
                    Navigation.findNavController(view).navigate(R.id.action_global_myPlantFragment);
                    return true;
                case R.id.book:
                    Navigation.findNavController(view).navigate(R.id.action_global_spravochnikFragment);
                    return true;
                case R.id.favorite:
                    return true;
                case R.id.profile1:
                    Navigation.findNavController(view).navigate(R.id.action_global_profileFragment);
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
    public void onCustomerClick(int position) {
        MyPlantModel selectedPlant = adapter.getCurrentList().get(position);
        Bundle args = new Bundle();
        args.putString("key", selectedPlant.getPlantname());
        NavController navController = NavHostFragment.findNavController(FavoriteMain.this);
        navController.navigate(R.id.action_favoriteMain2_to_pagerFragment2, args);
    }
}