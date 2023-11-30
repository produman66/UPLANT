package edu.example.uplant.data.data_sources.category;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;

import java.util.List;
import java.util.stream.Collectors;

import edu.example.uplant.MainActivity;
import edu.example.uplant.R;
import edu.example.uplant.data.data_sources.category.models.NapPlantModel;
import edu.example.uplant.data.data_sources.category.repositories.NapPlantRepository;
import edu.example.uplant.data.data_sources.category.room.dao.NapPlantDao;
import edu.example.uplant.data.data_sources.category.room.entites.NapPlant;
import edu.example.uplant.data.data_sources.category.room.root.PlantRoomDatabase;
import edu.example.uplant.ui.view.MyPlantUI.MyPlantNapMain;

public class AlarmReceiver extends BroadcastReceiver {
    private PlantRoomDatabase databaseSource;
    private NapPlantRepository repo;
    @Override
    public void onReceive(Context context, Intent intent) {
        //Получите доступ к базе данных через Room
        NapPlantDao napPlantDao = PlantRoomDatabase.getDatabase(context).napplantDao();
        databaseSource = PlantRoomDatabase.getDatabase(context);
        intent = new Intent(context, MainActivity.class);
        intent.putExtra("FRAGMENT_TO_LOAD", R.id.action_myPlantNapMain);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //Получите текущее время в миллисекундах
        long currentTime = System.currentTimeMillis();


        //Получите список записей, у которых время меньше текущего времени
        LiveData<List<NapPlantModel>> records = Transformations.map(
                databaseSource.napplantDao().getNotifications(currentTime),
                (values) -> values.stream().map(NapPlant::toDomainModel).collect(Collectors.toList())
        );;

        //Обработайте каждую найденную запись
        records.observeForever(new Observer<List<NapPlantModel>>() {
            @Override
            public void onChanged(List<NapPlantModel> napPlantModels) {
                for (NapPlantModel record : napPlantModels) {
                    Log.d("MyBroadcastReceiver", " ПРИШЛО УВЕДОМЛЕНИЕ!!!");
                    //Вызовите уведомление для каждой записи
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "channel_id")
                            .setSmallIcon(R.drawable.little_logo)
                            .setContentTitle(record.getPlantname())
                            .setContentText(record.getDesc())
                            .setContentIntent(pendingIntent)
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                    notificationManager.notify(record.getPlantid(), builder.build());
                }
            }
        });
    }
}
