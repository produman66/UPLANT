package edu.example.uplant.ui.view.MyPlantUI;

import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import edu.example.uplant.R;
import edu.example.uplant.data.data_sources.category.models.NapPlantModel;
import edu.example.uplant.ui.adapters.ButtonClickListener;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.MyPlantAdapter.MyPlantNapMainAdapter;
import edu.example.uplant.ui.view_models.MyPlantViewModel.NewNapominaieViewModel;

public class MyPlantNapMain extends Fragment implements CustomerClickListener, ButtonClickListener {
    private BottomNavigationView bottomNavigationView;
    private FirebaseAuth mAuth;
    String idemail;
    Toolbar toolbar;
    NewNapominaieViewModel mWordViewModel;
    MyPlantNapMainAdapter adapter;
    Fragment fragment11;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_plant_nap_main, container, false);
        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottonNavigation);
        toolbar = view.findViewById(R.id.toolbar2);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Мои растения");


        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        idemail = user.getEmail();


        //Работаем с RecycleView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerAddNap);
        adapter = new MyPlantNapMainAdapter(new MyPlantNapMainAdapter.PlantDiff(), this, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mWordViewModel = new ViewModelProvider(this).get(NewNapominaieViewModel.class);
        mWordViewModel.getPlantEmailTodo(idemail).observe(getActivity(), words -> {
            adapter.submitList(words);
        });








        bottomNavigationView.setSelectedItemId(R.id.plant);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.plant:
                    return true;
                case R.id.book:
                    Navigation.findNavController(view).navigate(R.id.action_global_spravochnikFragment);
                    return true;
                case R.id.favorite:
                    Navigation.findNavController(view).navigate(R.id.action_global_favoriteFragment);
                    return true;
                case R.id.profile1:
                    Navigation.findNavController(view).navigate(R.id.action_global_profileFragment);
                    return true;
            }
            return false;
        });
        MaterialButtonToggleGroup toggleGroup = view.findViewById(R.id.toggle_group);
        toggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                if (isChecked) {
                    MaterialButton activeButton = view.findViewById(checkedId);
                    activeButton.setTextColor(getResources().getColor(R.color.white));
                    activeButton.setBackgroundColor(getResources().getColor(R.color.green_600));
                    Navigation.findNavController(view).navigate(R.id.action_myPlantNapMain2_to_myPlantMain2);
                    for (int i = 0; i < group.getChildCount(); i++) {
                        View view = group.getChildAt(i);
                        if (view instanceof MaterialButton && view.getId() != activeButton.getId()) {
                            MaterialButton button = (MaterialButton) view;
                            button.setTextColor(getResources().getColor(R.color.green_600));
                            button.setBackgroundColor(getResources().getColor(R.color.white));
                            button.setStrokeColor(ColorStateList.valueOf(getResources().getColor(R.color.green_600)));
                            button.setStrokeWidth(4);
                        }
                    }
                }
            }
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().finish();
            }
        });
        return view;
    }

    @Override
    public void onButtonClick(int position) {
        NapPlantModel selectedPlant = adapter.getCurrentList().get(position);
        int id = selectedPlant.getPlantid();
        DialogDone dialog = DialogDone.newInstance(id);
        dialog.show(getFragmentManager(), "dialog_tag");
    }

    @Override
    public void onCustomerClick(int position) {
        NapPlantModel selectedPlant = adapter.getCurrentList().get(position);
        int id = selectedPlant.getPlantid();
        Bundle args = new Bundle();
        args.putInt("key", id);
        NavController navController = NavHostFragment.findNavController(MyPlantNapMain.this);
        navController.navigate(R.id.action_myPlantNapMain2_to_myPlantInfoTodo2, args);
    }

}