package essths.li3.picnest;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements ImageAdapter.OnItemClickListener {

    RecyclerView imageRecyclerView;
    ImageAdapter imageAdapter;
    List<String> imageList;
    SearchView searchView;
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Welcome toast
        String email = getIntent().getStringExtra("user_email");
        Toast.makeText(this, "Welcome " + (email != null ? email : "guest"), Toast.LENGTH_SHORT).show();

        imageRecyclerView = findViewById(R.id.imageRecyclerView);
        searchView = findViewById(R.id.searchView);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        imageRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Add 15 images
        imageList = new ArrayList<>();
        for(int i=1;i<=15;i++){
            imageList.add("pic"+i); // must match drawable names
        }

        imageAdapter = new ImageAdapter(imageList, this);
        imageRecyclerView.setAdapter(imageAdapter);

        // Search filter
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { return false; }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<String> filtered = new ArrayList<>();
                for(String img: imageList){
                    if(img.toLowerCase().contains(newText.toLowerCase())){
                        filtered.add(img);
                    }
                }
                imageAdapter.updateList(filtered);
                return true;
            }
        });

        // Bottom navigation
        bottomNavigation.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) return true;
            else if (id == R.id.nav_upload) startActivity(new Intent(HomeActivity.this, UploadActivity.class));
            else if (id == R.id.nav_profile) startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
            return false;
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, ImageDetailsActivity.class);
        intent.putExtra("imageName", imageAdapter.getImage(position));
        startActivity(intent);
    }
}
