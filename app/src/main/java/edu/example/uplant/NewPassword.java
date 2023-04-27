package edu.example.uplant;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewPassword extends Fragment {
    private Context context;
    Fragment fragment7;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_new_password, container, false);
//        fragment7 = new CorrectRegister();
//        Button btn = (Button) view.findViewById(R.id.btnnewpass);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.frag, fragment7).addToBackStack(null);
//                transaction.commit();
//            }
//        });
        return view;
    }
}