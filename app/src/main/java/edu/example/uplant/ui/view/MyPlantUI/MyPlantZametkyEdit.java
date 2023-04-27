package edu.example.uplant.ui.view.MyPlantUI;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
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
import android.widget.Toast;

import edu.example.uplant.R;
import edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository.AddPlantRepository;
import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;

public class MyPlantZametkyEdit extends Fragment {
    public String desc, poliv, peresad, udobr, name, nameOriginal, ImageOriginal;
    EditText text;
    Toolbar toolbar;
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_plant_zametky_e, container, false);
        text = view.findViewById(R.id.zametky);
        desc = getArguments().getString("desc");
        poliv = getArguments().getString("poliv");
        peresad = getArguments().getString("perec");
        udobr = getArguments().getString("udobr");
        name = getArguments().getString("name");
        nameOriginal = getArguments().getString("key");
        ImageOriginal = getArguments().getString("key1");
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        toolbar = view.findViewById(R.id.toolbar29);
        activity.setSupportActionBar(toolbar);
        Drawable icon = getResources().getDrawable(R.drawable.arrow_back);
        activity.getSupportActionBar().setTitle("Добавление заметок");
        DrawableCompat.setTint(icon, ContextCompat.getColor(getActivity(), R.color.white));
        toolbar.setNavigationIcon(icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        button = view.findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt = String.valueOf(text.getText());
                new AddPlantTask(getActivity().getApplication(), name, desc, poliv, peresad, udobr, ImageOriginal, txt).execute();
                Fragment fragment = new MyPlantMain();
//                args.putStringArrayList("textList", new ArrayList<>(textList));
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                Toast.makeText(getActivity().getApplicationContext(), "Растение добавлено", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
    private static class AddPlantTask extends AsyncTask<Void, Void, Void> {
        private Application application;
        private String name;
        private String desc;
        private String poliv;
        private String peresad;
        private String udobr;
        private String nameimage;
        private String zametky;

        public AddPlantTask(Application application, String name, String desc, String poliv, String peresad, String udobr, String nameimage, String zametky) {
            this.application = application;
            this.name = name;
            this.desc = desc;
            this.poliv = poliv;
            this.peresad = peresad;
            this.udobr = udobr;
            this.nameimage = nameimage;
            this.zametky = zametky;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            AddPlantRepository repo = new AddPlantRepository(application, name, desc, poliv, peresad, udobr, nameimage, zametky);
            repo.addPlant(new AddPlant(name, desc, poliv, peresad, udobr, nameimage, zametky));
            return null;
        }
    }
}