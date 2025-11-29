package essths.li3.picnest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    RecyclerView profileUploadsRecycler, profileFavoritesRecycler;
    ImageAdapter uploadsAdapter, favoritesAdapter;
    List<String> uploadedImages, favoriteImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileUploadsRecycler = findViewById(R.id.profileUploadsRecycler);
        profileFavoritesRecycler = findViewById(R.id.profileFavoritesRecycler);

        profileUploadsRecycler.setLayoutManager(new GridLayoutManager(this,3));
        profileFavoritesRecycler.setLayoutManager(new GridLayoutManager(this,3));

        uploadedImages = new ArrayList<>();
        favoriteImages = new ArrayList<>();

        for(int i=1;i<=8;i++) uploadedImages.add("sample_image"+i);
        for(int i=9;i<=15;i++) favoriteImages.add("sample_image"+i);

        //uploadsAdapter = new PinsAdapter(uploadedImages, position -> {});
        //favoritesAdapter = new PinsAdapter(favoriteImages, position -> {});

        profileUploadsRecycler.setAdapter(uploadsAdapter);
        profileFavoritesRecycler.setAdapter(favoritesAdapter);
    }
}
