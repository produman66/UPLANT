package edu.example.uplant;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CorrectRegister extends Fragment {
    private Context context;
    Fragment fragment8;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_correctregister, container, false);
//        fragment8 = new Authorization();
//        Button btn = (Button) view.findViewById(R.id.btncorreg);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.frag, fragment8).addToBackStack(null);
//                transaction.commit();
//            }
//        });
        return view;
    }
}