package edu.example.uplant.ui.view.SpravochnikUI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.example.uplant.R;
import edu.example.uplant.ui.view_models.SpravochnikViewModel.Cartochka3ViewModel;
import edu.example.uplant.ui.adapters.SpravochnikAdapters.Cartochka3Adapter;

public class CartochkaSpravochnika3 extends Fragment {
    Toolbar toolbar;
    Cartochka3ViewModel mViewModel;
    private static String STR_VALUE_KEY2 = "key";
    private String mStrValue;
    Cartochka3Adapter adapter;

    public static CartochkaSpravochnika3 newInstance(String strValue) {
        CartochkaSpravochnika3 fragment = new CartochkaSpravochnika3();
        Bundle args = new Bundle();
        args.putString(STR_VALUE_KEY2, strValue);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_cartochka_spravochnika3, container, false);
        mStrValue = getArguments().getString(STR_VALUE_KEY2);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        RecyclerView recyclerView = view.findViewById(R.id.plantrecycler4);
        adapter = new Cartochka3Adapter(new Cartochka3Adapter.PlantDiff());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new Cartochka3ViewModel(getActivity().getApplication(), mStrValue);
            }
        }).get(Cartochka3ViewModel.class);

        mViewModel.getAllWords().observe(getActivity(), words -> {
            adapter.submitList(words);
        });
        return view;
    }
}