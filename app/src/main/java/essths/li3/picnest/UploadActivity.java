package essths.li3.picnest;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UploadActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 1;

    ImageView uploadPreview;
    Button selectImageButton, uploadButton;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        uploadPreview = findViewById(R.id.uploadPreview);
        selectImageButton = findViewById(R.id.selectImageButton);
        uploadButton = findViewById(R.id.uploadButton);

        selectImageButton.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent,"Select Picture"),PICK_IMAGE);
        });

        uploadButton.setOnClickListener(v -> {
            if(imageUri != null){
                Toast.makeText(this,"Image uploaded (simulated)",Toast.LENGTH_SHORT).show();
                uploadPreview.setImageResource(0);
            }else{
                Toast.makeText(this,"Please select an image",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,@Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==PICK_IMAGE && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            imageUri = data.getData();
            uploadPreview.setImageURI(imageUri);
        }
    }
}
