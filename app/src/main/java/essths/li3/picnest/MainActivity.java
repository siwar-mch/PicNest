package essths.li3.picnest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText emailEditText, passwordEditText;
    Button loginButton;
    TextView signUpRedirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email_login);
        passwordEditText = findViewById(R.id.password_login);
        loginButton = findViewById(R.id.login_button);
        signUpRedirect = findViewById(R.id.signup_redirect);

        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Simple fake validation
            if(email.equals("user@example.com") && password.equals("1234")){
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("user_email", email);
                startActivity(intent);
            } else {
                Toast.makeText(this,"Wrong email or password",Toast.LENGTH_SHORT).show();
            }
        });

        signUpRedirect.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Sign Up clicked (not implemented)", Toast.LENGTH_SHORT).show();
        });
    }
}
