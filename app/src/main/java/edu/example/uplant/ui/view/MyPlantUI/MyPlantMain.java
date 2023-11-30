package edu.example.uplant.ui.view.MyPlantUI;

import android.content.res.ColorStateList;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import edu.example.uplant.data.data_sources.category.models.AddPlantModel;
import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;
import edu.example.uplant.R;
import edu.example.uplant.ui.adapters.ButtonClickListener;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.MyPlantAdapter.MyPlantAddAdapter;
import edu.example.uplant.ui.view_models.MyPlantViewModel.MyPlantAddViewModel;
import edu.example.uplant.ui.view_models.MyPlantViewModel.UpdateMyPlantViewModel;

public class MyPlantMain extends Fragment implements CustomerClickListener, ButtonClickListener{
    private BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    MyPlantAddViewModel mWordViewModel1;
    UpdateMyPlantViewModel mWordViewModel;
    MyPlantAddAdapter adapter;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_plant_main, container, false);

        //Добавляем тулбар
        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottonNavigation);
        toolbar = view.findViewById(R.id.toolbar2);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Мои растения");

        //Работаем с кнопкой
        ImageView cartinka = view.findViewById(R.id.add1);
        cartinka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_myPlantMain2_to_myPlantCategory2);
            }
        });

        //Работаем с RecycleView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerAdd);
        adapter = new MyPlantAddAdapter(new MyPlantAddAdapter.PlantDiff(), this, this);
        recyclerView.setAdapter(adapter);


        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String email = user.getEmail();


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mWordViewModel = new ViewModelProvider(this).get(UpdateMyPlantViewModel.class);
        mWordViewModel.getPlant(email).observe(getActivity(), words -> {
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
                    Navigation.findNavController(view).navigate(R.id.action_myPlantMain2_to_myPlantNapMain2);
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


        //Я не нашёл решения как мне используя навграф выйти (я не понимаю, я там намудрил конкретно)
//             в итоге я просто перехватываю кнопкуу назад и выхожу
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().finish();
            }
        });
        return view;
    }
    @Override
    public void onCustomerClick(int position) {
        AddPlantModel selectedPlant = adapter.getCurrentList().get(position);
        Bundle args = new Bundle();
        args.putString("key", selectedPlant.getName());
        args.putInt("key1", selectedPlant.getId());
        args.putString("key2", selectedPlant.getDesc());
        args.putString("key3", selectedPlant.getPoliv());
        args.putString("key4", selectedPlant.getPeresad());
        args.putString("key5", selectedPlant.getUdobr());
        args.putString("key6", selectedPlant.getZametky());
        args.putString("key7", selectedPlant.getNameimage());
        NavController navController = NavHostFragment.findNavController(MyPlantMain.this);
        navController.navigate(R.id.action_myPlantMain2_to_pagerMyPlant, args);
    }

    @Override
    public void onButtonClick(int position) {
        AddPlantModel selectedPlant = adapter.getCurrentList().get(position);
        Bundle args = new Bundle();
        args.putString("key", selectedPlant.getName());
        args.putInt("key1", selectedPlant.getId());
        NavController navController = NavHostFragment.findNavController(MyPlantMain.this);
        navController.navigate(R.id.action_myPlantMain2_to_newNapominanieDemo2, args);
    }

}







































