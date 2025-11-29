package essths.li3.picnest.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import essths.li3.picnest.database.entities.UserDownload;

@Dao
public interface UserDownloadDao {

    @Insert
    void insertDownload(UserDownload download);

    @Query("SELECT image_id FROM user_downloads WHERE user_id = :userId")
    List<Integer> getDownloadedImages(int userId);
}
