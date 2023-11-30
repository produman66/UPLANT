package edu.example.uplant.ui.view.MyPlantUI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import edu.example.uplant.R;
import edu.example.uplant.data.data_sources.category.models.MomentModel;
import edu.example.uplant.data.data_sources.category.models.NapPlantModel;
import edu.example.uplant.ui.adapters.ButtonClickListener;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.MyPlantAdapter.MyPlantNapMainAdapter;
import edu.example.uplant.ui.adapters.MyPlantAdapter.NewMomentAdapter;
import edu.example.uplant.ui.view_models.MyPlantViewModel.NewMomentViewModel;
import edu.example.uplant.ui.view_models.MyPlantViewModel.NewNapominaieViewModel;

public class MyPlantCartochka3 extends Fragment implements CustomerClickListener, ButtonClickListener {
    NewMomentViewModel mWordViewModel;
    NewMomentAdapter adapter;

    public static MyPlantCartochka3 newInstance(int id) {
        MyPlantCartochka3 fragment = new  MyPlantCartochka3();
        Bundle args = new Bundle();
        args.putInt("key", id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_plant_cartochka3, container, false);

        int id = getArguments().getInt("key");

        ImageView cartinka = view.findViewById(R.id.add3);
        cartinka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putInt("id", id);
                NavController navController = NavHostFragment.findNavController(MyPlantCartochka3.this);
                navController.navigate(R.id.action_pagerMyPlant_to_newMoment2, args);
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recyclerAddMoment);
        adapter = new NewMomentAdapter(new NewMomentAdapter.PlantDiff(), this, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        mWordViewModel = new ViewModelProvider(this).get(NewMomentViewModel.class);
        mWordViewModel.getmItems(id).observe(getActivity(), words -> {
            adapter.submitList(words);
        });
        return view;
    }

    @Override
    public void onCustomerClick(int position) {
        MomentModel selectedMoment = adapter.getCurrentList().get(position);
        int id = selectedMoment.getId();
        Bundle args = new Bundle();
        args.putInt("key", id);
        NavController navController = NavHostFragment.findNavController(MyPlantCartochka3.this);
        navController.navigate(R.id.action_pagerMyPlant_to_momentInfo2, args);
    }

    @Override
    public void onButtonClick(int position) {
        MomentModel selectedMoment = adapter.getCurrentList().get(position);
        int id = selectedMoment.getId();
        Bundle args = new Bundle();
        args.putInt("key", id);
        NavController navController = NavHostFragment.findNavController(MyPlantCartochka3.this);
        navController.navigate(R.id.action_pagerMyPlant_to_momentInfo2, args);
    }
}