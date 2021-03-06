package np.com.ruchirajkarki.atm_game.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CharacterDao {
    @Query("SELECT * FROM characters")
    List<Character> getAll();

    @Query("SELECT * FROM characters WHERE charID IN (:charIDs)")
    List<Character> loadAllByIDs(int[] charIDs);

    @Query("SELECT * FROM characters WHERE charName LIKE :name")
    Character findByName(String name);

    @Query("SELECT * FROM characters WHERE charID LIKE :charID")
    Character findByID(int charID);

    @Insert
    void insertAll(Character... characters);

    @Insert
    void insertOne(Character character);

    @Update
    void update(Character character);

    @Delete
    void delete(Character character);

    @Query("DELETE FROM characters")
    void deleteAllEntries();

    @Query("SELECT count(*) FROM characters")
    Integer howManyCharacters();

    @Query("SELECT charName FROM characters")
    List<String> getAllNames();

    @Query("UPDATE characters SET hackedStatus = :hackedStatus WHERE charID = :charID")
    void updateHackedStatus(Boolean hackedStatus, int charID);

    @Query("SELECT charID FROM characters")
    List<Integer> getAllIDs();

}
