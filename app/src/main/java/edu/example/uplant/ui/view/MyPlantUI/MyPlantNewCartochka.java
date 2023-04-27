package edu.example.uplant.ui.view.MyPlantUI;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.example.uplant.R;
import edu.example.uplant.ui.adapters.MyPlantAdapter.MyPlantNewCartochkaAdapter;
import edu.example.uplant.ui.view_models.MyPlantViewModel.MyPlantNewCartochkaViewModel;

public class MyPlantNewCartochka extends Fragment {
    MyPlantNewCartochkaViewModel mViewModel;
    private static final String STR_VALUE_KEY = "key";
    private String mStrValue, mStrValue1;
    MyPlantNewCartochkaAdapter adapter;
    Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_plant_new_cartochka, container, false);
        mStrValue = getArguments().getString(STR_VALUE_KEY);
        mStrValue1 = getArguments().getString("key1");
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        RecyclerView recyclerView = view.findViewById(R.id.plantrecycler6);
        adapter = new MyPlantNewCartochkaAdapter(new MyPlantNewCartochkaAdapter.PlantDiff());
        recyclerView.setAdapter(adapter);
        toolbar = view.findViewById(R.id.toolbar22);
        activity.setSupportActionBar(toolbar);
        Drawable icon = getResources().getDrawable(R.drawable.arrow_back);
        activity.getSupportActionBar().setTitle("Добавить растение");
        DrawableCompat.setTint(icon, ContextCompat.getColor(getActivity(), R.color.white));
        toolbar.setNavigationIcon(icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MyPlantNewCartochkaViewModel(activity.getApplication(), mStrValue);
            }
        }).get(MyPlantNewCartochkaViewModel.class);
        mViewModel.getAllWords().observe(getActivity(), words -> {
            adapter.submitList(words);
        });
        Button button = view.findViewById(R.id.btnadd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new EditNameNewCartochka();
                Bundle args = new Bundle();
                args.putString("key", mStrValue);
                args.putString("key1", mStrValue1);
                fragment.setArguments(args);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment);
                transaction.addToBackStack(null); // Добавляем транзакцию в backstack
                transaction.commit();
            }
        });
        return view;
    }
}