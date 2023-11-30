package edu.example.uplant.ui.view.SpravochnikUI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import edu.example.uplant.R;
import edu.example.uplant.ui.view_models.SpravochnikViewModel.CartochkaViewModel;
import edu.example.uplant.ui.adapters.SpravochnikAdapters.CartochkaAdapter;


public class CartochkaSpravochnika extends Fragment {
    CartochkaViewModel mViewModel;
    private static final String STR_VALUE_KEY = "key";
    private String mStrValue;
    CartochkaAdapter adapter;
    private FirebaseAuth mAuth;

    public static CartochkaSpravochnika newInstance(String strValue) {
        CartochkaSpravochnika fragment = new CartochkaSpravochnika();
        Bundle args = new Bundle();
        args.putString(STR_VALUE_KEY, strValue);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_cartochka_spravochnika, container, false);
        mStrValue = getArguments().getString(STR_VALUE_KEY);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        RecyclerView recyclerView = view.findViewById(R.id.plantrecycler2);
        adapter = new CartochkaAdapter(new CartochkaAdapter.PlantDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new CartochkaViewModel(activity.getApplication());
            }
        }).get(CartochkaViewModel.class);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String email = user.getEmail();
        mViewModel.getAllWords(mStrValue, email).observe(getActivity(), words -> {
            adapter.submitList(words);
        });
        return view;
    }
}