package edu.example.uplant.ui.view.MyPlantUI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import edu.example.uplant.R;
import edu.example.uplant.data.data_sources.category.models.NapPlantModel;
import edu.example.uplant.ui.adapters.ButtonClickListener;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.MyPlantAdapter.MyPlantNapMainAdapter;
import edu.example.uplant.ui.view_models.MyPlantViewModel.NewNapominaieViewModel;

public class MyPlantCartochka2 extends Fragment implements CustomerClickListener, ButtonClickListener {

    NewNapominaieViewModel mWordViewModel;
    MyPlantNapMainAdapter adapter;



    public static MyPlantCartochka2 newInstance(int strValue, String name) {
        MyPlantCartochka2 fragment = new  MyPlantCartochka2();
        Bundle args = new Bundle();
        args.putString("key1", name);
        args.putInt("key", strValue);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_plant_cartochka2, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerAddNapCartochka);
        adapter = new MyPlantNapMainAdapter(new MyPlantNapMainAdapter.PlantDiff(), this, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        int id = getArguments().getInt("key");
        String name = getArguments().getString("key1");

        mWordViewModel = new ViewModelProvider(this).get(NewNapominaieViewModel.class);
        mWordViewModel.getPlantTodo(id).observe(getActivity(), words -> {
            adapter.submitList(words);
        });

        ImageView cartinka = view.findViewById(R.id.add2);
        cartinka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString("key", name);
                args.putInt("key1", id);
                NavController navController = NavHostFragment.findNavController(MyPlantCartochka2.this);
                navController.navigate(R.id.action_pagerMyPlant_to_newNapominanieDemo2, args);
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
        NavController navController = NavHostFragment.findNavController(MyPlantCartochka2.this);
        navController.navigate(R.id.action_pagerMyPlant_to_myPlantInfoTodo2, args);
    }
}