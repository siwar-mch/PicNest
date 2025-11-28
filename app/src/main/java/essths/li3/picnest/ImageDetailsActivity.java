package essths.li3.picnest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ImageDetailsActivity extends AppCompatActivity {

    ImageView detailImage;
    ImageButton detailLikeButton, detailDownloadButton;
    EditText commentInput;
    Button postCommentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);

        detailImage = findViewById(R.id.detailImage);
        detailLikeButton = findViewById(R.id.detailLikeButton);
        detailDownloadButton = findViewById(R.id.detailDownloadButton);
        commentInput = findViewById(R.id.commentInput);
        postCommentButton = findViewById(R.id.postCommentButton);

        // Get the image name from intent
        String imageName = getIntent().getStringExtra("imageName");
        int resId = getResources().getIdentifier(imageName, "drawable", getPackageName());
        detailImage.setImageResource(resId);

        // Like button click
        detailLikeButton.setOnClickListener(v -> {
            Toast.makeText(this, "Liked!", Toast.LENGTH_SHORT).show();
            // Optional: add animation here
        });

        // Download button click
        detailDownloadButton.setOnClickListener(v -> {
            Toast.makeText(this, "Image downloaded (simulated)", Toast.LENGTH_SHORT).show();
            // TODO: Implement actual saving to device
        });

        // Post comment button click
        postCommentButton.setOnClickListener(v -> {
            String comment = commentInput.getText().toString().trim();
            if(!comment.isEmpty()){
                Toast.makeText(this, "Comment posted: " + comment, Toast.LENGTH_SHORT).show();
                commentInput.setText("");
            } else {
                Toast.makeText(this, "Please enter a comment", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
