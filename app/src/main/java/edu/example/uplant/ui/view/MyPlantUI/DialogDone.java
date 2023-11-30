package edu.example.uplant.ui.view.MyPlantUI;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.example.uplant.R;
import edu.example.uplant.ui.view_models.MyPlantViewModel.NewNapominaieViewModel;

public class DialogDone extends DialogFragment {
    public static DialogDone newInstance(int id) {
        Bundle args = new Bundle();
        args.putInt("id", id);
        DialogDone fragment = new DialogDone();
        fragment.setArguments(args);
        return fragment;
    }
    NewNapominaieViewModel mWordViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dialog_done, container, false);
        Button closeButton = view.findViewById(R.id.closeButton);

        int id = getArguments().getInt("id");
        mWordViewModel = new ViewModelProvider(this).get(NewNapominaieViewModel.class);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWordViewModel.deleteTodo(id);
                dismiss();
            }
        });
        return view;
    }
}