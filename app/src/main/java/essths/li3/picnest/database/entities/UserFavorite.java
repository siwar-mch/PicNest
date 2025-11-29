package essths.li3.picnest.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(
        tableName = "user_favorites",
        primaryKeys = {"user_id", "image_id"},
        foreignKeys = {
                @ForeignKey(entity = User.class,
                        parentColumns = "id",
                        childColumns = "user_id",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Image.class,
                        parentColumns = "id",
                        childColumns = "image_id",
                        onDelete = ForeignKey.CASCADE)
        }
)
public class UserFavorite {

    @ColumnInfo(name = "user_id")
    public int userId;

    @ColumnInfo(name = "image_id")
    public int imageId;

    public UserFavorite(int userId, int imageId) {
        this.userId = userId;
        this.imageId = imageId;
    }
}
