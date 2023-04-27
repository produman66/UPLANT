package edu.example.uplant.ui.view.MyPlantUI;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import edu.example.uplant.R;

public class EditNameNewCartochka extends Fragment {
    private static final String STR_VALUE_KEY = "key";
    private String mStrValue, mStrValue1;

    Toolbar toolbar;
    EditText text;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_edit_name_new_cartochka, container, false);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        toolbar = view.findViewById(R.id.toolbar23);
        activity.setSupportActionBar(toolbar);
        mStrValue = getArguments().getString(STR_VALUE_KEY);
        mStrValue1 = getArguments().getString("key1");
        Drawable icon = getResources().getDrawable(R.drawable.arrow_back);
        activity.getSupportActionBar().setTitle("Название");
        text = view.findViewById(R.id.nameplant);
        text.setText(mStrValue);
        DrawableCompat.setTint(icon, ContextCompat.getColor(getActivity(), R.color.white));
        toolbar.setNavigationIcon(icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        Button btn = view.findViewById(R.id.btnadd1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new MyPlantOpisEdit();
                Bundle args = new Bundle();
                args.putString("key1", String.valueOf(text.getText()));
                args.putString("key", mStrValue);
                args.putString("key2", mStrValue1);
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