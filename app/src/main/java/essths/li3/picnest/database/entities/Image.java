package essths.li3.picnest.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "images",
        foreignKeys = @ForeignKey(
                entity = User.class,
                parentColumns = "id",
                childColumns = "added_by",
                onDelete = ForeignKey.CASCADE
        )
)
public class Image {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String description;

    @ColumnInfo(name = "added_by")
    public int addedBy;

    @ColumnInfo(name = "nb_likes")
    public int nbLikes;

    public Image(String name, String description, int addedBy, int nbLikes) {
        this.name = name;
        this.description = description;
        this.addedBy = addedBy;
        this.nbLikes = nbLikes;
    }
}
