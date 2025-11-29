package essths.li3.picnest.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import essths.li3.picnest.database.entities.Image;

@Dao
public interface ImageDao {

    @Insert
    long insertImage(Image image);

    @Query("SELECT * FROM images")
    List<Image> getAllImages();

    @Query("SELECT * FROM images WHERE id = :id")
    Image getImageById(int id);

    @Query("SELECT * FROM images WHERE added_by = :userId")
    List<Image> getImagesByUser(int userId);

    @Update
    void updateImage(Image image);
}
