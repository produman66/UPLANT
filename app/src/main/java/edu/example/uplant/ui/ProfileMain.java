package edu.example.uplant.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.example.uplant.R;
import edu.example.uplant.ui.view.FavoriteUI.FavoriteMain;
import edu.example.uplant.ui.view.MyPlantUI.MyPlantMain;
import edu.example.uplant.ui.view.SpravochnikUI.SpravochnikMain;

public class ProfileMain extends Fragment {
    private Context context;
    Fragment fragment14;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_main, container, false);
        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottonNavigation);
        bottomNavigationView.setSelectedItemId(R.id.profile1);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.plant:
                    fragment14 = new MyPlantMain();
                    FragmentTransaction transaction2 = getFragmentManager().beginTransaction();
                    transaction2.replace(R.id.container, fragment14).addToBackStack(null);
                    transaction2.commit();
                    return true;
                case R.id.book:
                    fragment14 = new SpravochnikMain();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, fragment14).addToBackStack(null);
                    transaction.commit();
                    return true;
                case R.id.favorite:
                    fragment14 = new FavoriteMain();
                    FragmentTransaction transaction1 = getFragmentManager().beginTransaction();
                    transaction1.replace(R.id.container, fragment14).addToBackStack(null);
                    transaction1.commit();
                    return true;
                case R.id.profile1:
                    return true;
            }
            return false;
        });
        return view;
    }
}