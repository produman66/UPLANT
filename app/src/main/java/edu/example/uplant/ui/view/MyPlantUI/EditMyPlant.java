package edu.example.uplant.ui.view.MyPlantUI;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import edu.example.uplant.R;
import edu.example.uplant.ui.adapters.MyPlantAdapter.EditMyPlantAdapter;
import edu.example.uplant.ui.adapters.MyPlantAdapter.PagerMyPlantAdapter;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.EditMyPlantViewHolder;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.MyPlantOpisViewHolder;
import edu.example.uplant.ui.view_models.MyPlantViewModel.MyPlantAddViewModel;
import edu.example.uplant.ui.view_models.MyPlantViewModel.PagerMyPlantViewModel;
import edu.example.uplant.ui.view_models.MyPlantViewModel.UpdateMyPlantViewModel;
import edu.example.uplant.ui.view_models.SpravochnikViewModel.Cartochka4ViewModel;

public class EditMyPlant extends Fragment {
    private final int PICK_IMAGE_REQUEST = 22;
    AppCompatActivity activity;
    Toolbar toolbar;
    PagerMyPlantViewModel mViewModel;
    UpdateMyPlantViewModel mViewModel1;
    EditMyPlantAdapter adapter;
    ImageView imageView;
    RecyclerView recyclerView;
    String Name, Zam, Desc, Poliv, Perec, Udobr, nameImage;
    int id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_my_plant, container, false);
        toolbar = view.findViewById(R.id.toolbar5);
        activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Редактирование карточки");
        toolbar.setNavigationIcon(R.drawable.arrow_back);
        toolbar.getNavigationIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        setHasOptionsMenu(true);
        Bundle args = getArguments();

        id = args.getInt("key");
        nameImage = args.getString("key7");

        recyclerView = view.findViewById(R.id.plantrecycler62);
        adapter = new EditMyPlantAdapter(new EditMyPlantAdapter.PlantDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new PagerMyPlantViewModel(activity.getApplication(), id);
            }
        }).get(PagerMyPlantViewModel.class);
        mViewModel.getAllWords().observe(getActivity(), words -> {
            adapter.submitList(words);
        });
        mViewModel1 = new ViewModelProvider(this).get(UpdateMyPlantViewModel.class);

        Button btn = view.findViewById(R.id.btndelete);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel1.deletePlant(id);
                Fragment fragment = new MyPlantMain();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                Toast.makeText(getActivity(), "Растение удалено", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.action_select, menu); // надуваем меню из ресурсов
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // обрабатываем выбор элементов меню
        switch (item.getItemId()) {
            case R.id.action_select:
                for (int i = 0; i < recyclerView.getChildCount(); i++) {
                    View child = recyclerView.getChildAt(i);
                    EditMyPlantViewHolder viewHolder = (EditMyPlantViewHolder) recyclerView.getChildViewHolder(child);
                    Name = String.valueOf(viewHolder.Name.getText());
                    imageView = viewHolder.image;
                    Zam = viewHolder.Zamet.getText().toString();
                    Desc = viewHolder.wordDesk.getText().toString();
                    Poliv = viewHolder.Poliv.getText().toString();
                    Perec = viewHolder.Peres.getText().toString();
                    Udobr = viewHolder.Udobr.getText().toString();
                }
                if (!Name.equals("") && !Zam.equals("") && !Desc.equals("")  && !Poliv.equals("")  && !Perec.equals("")  && !Udobr.equals("")) {
                    mViewModel1.editPlant(id, Name, Desc, Poliv, Perec, Udobr, Zam, nameImage);
                    Toast.makeText(getActivity(), "Изменения сохранены", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getActivity(), "Заполните все поля", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}