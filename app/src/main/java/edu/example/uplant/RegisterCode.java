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

public class RegisterCode extends Fragment {
    private Context context;
    Fragment fragment6;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_code, container, false);
//        fragment6 = new NewPassword();
//        Button btn = (Button) view.findViewById(R.id.btncontinue);
//        TextView sent = (TextView) view.findViewById(R.id.sent_code);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.frag, fragment6).addToBackStack(null);
//                transaction.commit();
//            }
//        });
//        sent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Activity activity = getActivity();
//                Toast.makeText(activity, "Код был выслан на почту повторно", Toast.LENGTH_LONG).show();
//            }
//        });
        return view;
    }
}