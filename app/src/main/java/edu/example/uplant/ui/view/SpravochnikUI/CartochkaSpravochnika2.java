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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import edu.example.uplant.R;
import edu.example.uplant.ui.adapters.SpravochnikAdapters.Cartochka2Adapter;
import edu.example.uplant.ui.view_models.SpravochnikViewModel.CartochkaViewModel;

public class CartochkaSpravochnika2 extends Fragment {
    Toolbar toolbar;
    CartochkaViewModel mViewModel;
    private static String STR_VALUE_KEY1 = "key";
    private String mStrValue;
    Cartochka2Adapter adapter;
    private FirebaseAuth mAuth;

    public static CartochkaSpravochnika2 newInstance(String strValue) {
        CartochkaSpravochnika2 fragment = new CartochkaSpravochnika2();
        Bundle args = new Bundle();
        args.putString(STR_VALUE_KEY1, strValue);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_cartochka_spravochnika2, container, false);
        mStrValue = getArguments().getString(STR_VALUE_KEY1);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        RecyclerView recyclerView = view.findViewById(R.id.plantrecycler3);
        adapter = new Cartochka2Adapter(new Cartochka2Adapter.PlantDiff());
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