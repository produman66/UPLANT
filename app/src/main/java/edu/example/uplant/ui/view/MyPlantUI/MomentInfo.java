package edu.example.uplant.ui.view.MyPlantUI;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.example.uplant.R;
import edu.example.uplant.ui.adapters.MyPlantAdapter.MomentInfoAdapter;
import edu.example.uplant.ui.adapters.MyPlantAdapter.MyPlantTodoInfoAdapter;
import edu.example.uplant.ui.view_models.MyPlantViewModel.NewMomentViewModel;
import edu.example.uplant.ui.view_models.MyPlantViewModel.NewNapominaieViewModel;

public class MomentInfo extends Fragment {

    NewMomentViewModel mWordViewModel;
    MomentInfoAdapter adapter;
    int id;

    public static MomentInfo newInstance(int id) {
        MomentInfo fragment = new  MomentInfo();
        Bundle args = new Bundle();
        args.putInt("key", id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_moment_info, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar15);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Фотогаллерея");
        Drawable icon = getResources().getDrawable(R.drawable.arrow_back);
        DrawableCompat.setTint(icon, ContextCompat.getColor(getActivity(), R.color.white));
        toolbar.setNavigationIcon(icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

       id = getArguments().getInt("key");

        RecyclerView recyclerView = view.findViewById(R.id.recyclerInfoMoment);
        adapter = new MomentInfoAdapter(new MomentInfoAdapter.PlantDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mWordViewModel = new ViewModelProvider(this).get(NewMomentViewModel.class);
        setHasOptionsMenu(true);
        mWordViewModel.getInfoMoment(id).observe(getActivity(), words -> {
            adapter.submitList(words);
        });
        return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.delete_menu, menu); // надуваем меню из ресурсов
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // обрабатываем выбор элементов меню
        switch (item.getItemId()) {
            case R.id.action_delete:
                mWordViewModel.deleteMoment(id);
                NavController navController = NavHostFragment.findNavController(MomentInfo.this);
                navController.popBackStack();
                Toast.makeText(getActivity(), "Момент удалён", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}