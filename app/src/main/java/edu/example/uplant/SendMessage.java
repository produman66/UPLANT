package edu.example.uplant;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMessage extends Fragment {
    EditText theme, text;
    Button btn;
    String otEmail;

    private FirebaseAuth mAuth;

    //Нашёл этот логин
    public static final String sEmailId = "testsend98765@yandex.com";

    //Нашел этот пароль
    public static final String sPassword = "pvrywitttiavqidc";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send_message, container, false);


        Toolbar toolbar = view.findViewById(R.id.toolbar13);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Связь с разрабом");
        Drawable icon = getResources().getDrawable(R.drawable.arrow_back);
        DrawableCompat.setTint(icon, ContextCompat.getColor(getActivity(), R.color.white));
        toolbar.setNavigationIcon(icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).popBackStack();
            }
        });



        theme = view.findViewById(R.id.theme);
        text = view.findViewById(R.id.textemail);
        btn = view.findViewById(R.id.btnmessage);



        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            otEmail = user.getEmail();
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = "bezrukovvv891@gmail.com";
                String message = text.getText().toString();
                String title = theme.getText().toString();
                String object = "MyPlant";

                String fm = "Отправитель: "+ otEmail + "\n" + "Растение: " + title + "\n" + "Описание: " + message;

                JavaMailAPI javaMailAPI = new JavaMailAPI(SendMessage.this.getContext(), mail, object, fm);
                javaMailAPI.execute();
                Navigation.findNavController(v).navigate(R.id.action_sendMessage_to_correctRegister);
            }
        });
        return view;
    }
}






