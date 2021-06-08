package np.com.ruchirajkarki.atm_game.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Character.class}, version = 1)
public abstract class CharacterDatabase extends RoomDatabase {
    private static CharacterDatabase INSTANCE;

    public static CharacterDatabase getDbInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CharacterDatabase.class, "charDatabase")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public abstract CharacterDao characterDao();
}
