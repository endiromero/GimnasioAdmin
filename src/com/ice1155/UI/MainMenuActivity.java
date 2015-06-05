package com.ice1155.UI;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import com.google.gson.Gson;
import com.ice1155.DA.Cliente;
import com.ice1155.UT.Constantes;
import com.ice1155.UT.RequestHandler;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainMenuActivity extends Activity {
	private Gson gson = new Gson();
	private ProgressBar pb;
	private LoadClientes lc;
	private RequestHandler rh = new RequestHandler();
	public Cliente _cliente;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);

		pb = (ProgressBar) findViewById(R.id.pbMM);
		lc = new LoadClientes(this);
	}

	// Button methods
	public void goEjercicio(View v) {
		Intent iE = new Intent(this, EjercicioActivity.class);
		this.startActivity(iE);
	}

	public void goCliente(View v) {
		Intent iC = new Intent(this, EscogerAccionActivity.class);
		this.startActivity(iC);
	}

	public void goEntrenador(View v) {
		Intent iEn = new Intent(this, EntrenadorActivity.class);
		this.startActivity(iEn);
	}

	public void goRutina(View v) {
		lc.execute(Constantes.MOSTRAR_TODOS_CLIENTES);
	}

	// Misc. methods
	private void startLoader() {
		Toast.makeText(getApplicationContext(),
				"Cargando, por favor espere...", Toast.LENGTH_LONG).show();
		pb.setVisibility(View.VISIBLE);
	}

	private void markAsDone() {
		pb.setVisibility(View.INVISIBLE);
	}

	// Asynctask
	private class LoadClientes extends AsyncTask<String, Void, String> {
		private MainMenuActivity activity = null;

		protected LoadClientes(MainMenuActivity mma) {
			this.activity = mma;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			activity.startLoader();
		}

		@Override
		protected String doInBackground(String... params) {
			return rh.GET(params[0]);
		}

		@Override
		protected void onPostExecute(String response) {
			if (response != null) {
				ArrayList<Cliente> arr = new ArrayList<Cliente>();
				try {
					JSONArray ja = new JSONArray(response);					
					
					Intent i = new Intent(activity.getApplicationContext(), ListClientesActivity.class);
					i.putExtra("listaClientes", convertToCliente(ja, arr));
					startActivity(i);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			markAsDone();
		}
	}

	// Cliente converter
	private ArrayList<Cliente> convertToCliente(JSONArray ja, ArrayList<Cliente> arr)
			throws JSONException {
		for (int i = 0; i < ja.length(); i++) {
			Cliente c = gson.fromJson(ja.getString(i), Cliente.class);
			arr.add(c);
		}
		return arr;
	}
}
