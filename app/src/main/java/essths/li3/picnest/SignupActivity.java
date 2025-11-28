package essths.li3.picnest;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    EditText emailSignup, passwordSignup, usernameSignup;
    Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        emailSignup = findViewById(R.id.email_signup);
        passwordSignup = findViewById(R.id.password_signup);
        usernameSignup = findViewById(R.id.username_signup);
        signupButton = findViewById(R.id.signup_button);

        signupButton.setOnClickListener(v -> {
            // TODO: Add signup logic
            Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}
