package com.ice1155.UI;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.ice1155.BL.ListClientesAdapter;
import com.ice1155.BL.ListClientesOnItemClickListener;
import com.ice1155.DA.Cliente;
import com.ice1155.UT.Constantes;
import com.ice1155.UT.RequestHandler;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.*;
import org.json.JSONArray;
import org.json.JSONException;

public class ListClientesActivity extends Activity {
	private ListView listaClientes;
	private RequestHandler rh = new RequestHandler();
	private Gson gson = new Gson();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clientes_list);

		// obtengo la info de clientes
		new LoadClientes().execute(Constantes.MOSTRAR_TODOS_CLIENTES);
	}

	private void startLoader() {}

	private void markAsDone() {}

	// Asynctask
	private class LoadClientes extends AsyncTask<String, Void, String> {
		private MainMenuActivity activity = null;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			startLoader();
		}

		@Override
		protected String doInBackground(String... params) {
			return rh.GET(params[0]);
		}

		@Override
		protected void onPostExecute(String response) {
			markAsDone();
			if (response != null) {
				ArrayList<Cliente> arr = new ArrayList<Cliente>();
				try {
					JSONArray ja = new JSONArray(response);
					convertToCliente(ja, arr);

					ListClientesAdapter lca = new ListClientesAdapter(
							ListClientesActivity.this, R.layout.clientes_row_layout, arr);

					lv.setAdapter(lca);
					lv.setOnItemClickListener(new ListClientesOnItemClickListener());

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
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