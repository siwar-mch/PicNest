package essths.li3.picnest.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import essths.li3.picnest.database.entities.UserFavorite;
@Dao
public interface UserFavoriteDao {

    @Insert
    void likeImage(UserFavorite userFavorite);

    @Delete
    void unlikeImage(UserFavorite userFavorite);

    @Query("SELECT image_id FROM user_favorites WHERE user_id = :userId")
    List<Integer> getUserFavorites(int userId);

    @Query("SELECT COUNT(*) FROM user_favorites WHERE image_id = :imageId")
    int countLikes(int imageId);
}
