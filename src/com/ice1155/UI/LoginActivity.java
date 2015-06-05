package com.ice1155.UI;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.ice1155.DA.User;
import com.ice1155.UT.Constantes;
import com.ice1155.UT.RequestHandler;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends Activity {
    private static RequestHandler rh;
    private EditText txtUser;
    private EditText txtPwd;
    private ProgressBar pb;
    // JSON handler
    private Gson gson = new Gson();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Inicialización
        init();
        rh = new RequestHandler();
    }

    // Custom methods
    private void init() {
        this.txtUser = (EditText) findViewById(R.id.txtUser);
        this.txtPwd = (EditText) findViewById(R.id.txtPwd);

        this.pb = (ProgressBar) findViewById(R.id.pbLogin);
    }

    // Login handler
    public void login(View v) {
        String user = txtUser.getText().toString();
        String pwd = txtPwd.getText().toString();

        if (user.isEmpty() || pwd.isEmpty()) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.err_emptyTxt), Toast.LENGTH_LONG).show();
        } else {
            LoginExecutioner le = new LoginExecutioner(this);
            le.execute(user, pwd, Constantes.LOGIN);
        }
        // Intent i = new Intent(this, MainMenuActivity.class);
        // startActivity(i);
    }

    private void startLoader() {
        pb.setVisibility(View.VISIBLE);
        Toast.makeText(getApplicationContext(),
                getString(R.string.txtProgressTitle), Toast.LENGTH_LONG).show();
    }

    private void markAsDone() {
        pb.setVisibility(View.INVISIBLE);
    }

    private class LoginExecutioner extends AsyncTask<String, Void, String> {
        LoginActivity activity = null;
        private String password;

        public LoginExecutioner(LoginActivity activity) {
            attach(activity);
        }

        private void detach() {
            activity = null;
        }

        private void attach(LoginActivity activity) {
            this.activity = activity;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            activity.startLoader();
        }

        @Override
        protected String doInBackground(String... params) {
            String json = "";

            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.accumulate("username", params[0]);
                jsonObject.accumulate("password", params[1]);
                password = params[1];
            } catch (JSONException e) {
                e.printStackTrace();
            }
            json = jsonObject.toString();
            return rh.POST(Constantes.LOGIN, json);
        }

        @Override
        protected void onPostExecute(String response) {
            activity.markAsDone();
            if (response != null) {
                if (response.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.err_wrongData), Toast.LENGTH_LONG)
                            .show();
                } else {
                    Constantes.user = gson.fromJson(response, User.class);
                    Constantes.user.setPassword(password);
                    Constantes.accessToken = Constantes.user.getToken();

                    Intent i = new Intent(activity, MainMenuActivity.class);
                    activity.startActivity(i);
                }
            } else
                Toast.makeText(getApplicationContext(), "Ha ocurrido un error inesperado...", Toast.LENGTH_SHORT).show();
        }

    }
}