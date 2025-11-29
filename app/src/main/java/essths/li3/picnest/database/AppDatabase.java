package essths.li3.picnest.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import essths.li3.picnest.database.dao.*;
import essths.li3.picnest.database.entities.*;


@Database(
        entities = {
                User.class,
                Image.class,
                UserFavorite.class,
                UserDownload.class
        },
        version = 1
)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract UserDao userDao();
    public abstract ImageDao imageDao();
    public abstract UserFavoriteDao userFavoriteDao();
    public abstract UserDownloadDao userDownloadDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "picnest_db"
            ).fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
