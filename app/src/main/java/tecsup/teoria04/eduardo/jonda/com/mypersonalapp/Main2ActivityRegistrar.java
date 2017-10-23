package tecsup.teoria04.eduardo.jonda.com.mypersonalapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import tecsup.teoria04.eduardo.jonda.com.mypersonalapp.models.User;

public class Main2ActivityRegistrar extends AppCompatActivity {

    Button btnRe;
    private SharedPreferences sharedPreferences;

    private EditText usernameInput, passwordInput, nameInput;
    private ProgressBar progressBar;
    private View loginPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_registrar);

        btnRe = (Button)findViewById(R.id.btnregistrar);
        usernameInput = (EditText)findViewById(R.id.username_input);
        passwordInput = (EditText)findViewById(R.id.password_input);
        nameInput = (EditText)findViewById(R.id.name_input);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        loginPanel = findViewById(R.id.login_panel);

    }

    public void callLogin(View view){
        loginPanel.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();
        String name = nameInput.getText().toString();

        if(username.isEmpty() || password.isEmpty() || name.isEmpty()){
            Toast.makeText(this, "Falta completar los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Registro
        User user2 = UserRepository.create(username, password,name);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // guardando en SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean success = editor
                .putString("username", user2.getUsername())
                .putString("fullname",user2.getFullname())
                .putBoolean("islogged", true)
                .commit();

        // ir a Dashboard(home)
        goDashboard();
    }

    private void goDashboard(){
        startActivity(new Intent(this, DashboardActivity.class));
        finish();
    }
}
