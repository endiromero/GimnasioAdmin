package com.ice1155.UT;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import com.google.gson.Gson;
import com.ice1155.BL.ListEntrenadoresAdapter;
import com.ice1155.BL.ListEntrenadoresOnItemClickListener;
import com.ice1155.DA.Entrenador;
import com.ice1155.UI.EntrenadorActivity;
import com.ice1155.UI.R;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

public class Cargador {
	private Gson gson = new Gson();
	private LoadEntrenadores le;

	public Cargador(EntrenadorActivity ea, ListView lv) {
		le = new LoadEntrenadores(ea, lv);
	}

	public LoadEntrenadores getLe() {
		return le;
	}

	public void setLe(LoadEntrenadores le) {
		this.le = le;
	}

	// Carga todos los entrenadores
	private class LoadEntrenadores extends AsyncTask<String, Void, String> {
		private EntrenadorActivity actividad;
		private ListView lvEntrenadores;
		private ArrayList<Entrenador> arreglo;

		public LoadEntrenadores(EntrenadorActivity actividad,
				ListView lvEntrenadores) {
			this.actividad = actividad;
			this.lvEntrenadores = lvEntrenadores;
		}

		// Entrenador converter
		private ArrayList<Entrenador> convertToEntrenador(JSONArray ja,
				ArrayList<Entrenador> arr) throws JSONException {
			for (int i = 0; i < ja.length(); i++) {
				Entrenador c = gson.fromJson(ja.getString(1), Entrenador.class);
				arr.add(c);
			}
			return arr;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			actividad.startLoader();
		}

		@Override
		protected String doInBackground(String... params) {
			return Constantes.MOSTRAR_TODOS_ENTRENADORES;
		}

		@Override
		protected void onPostExecute(String response) {
			if (response != null) {
				arreglo = new ArrayList<Entrenador>();
				try {
					JSONArray array = new JSONArray(response);
					convertToEntrenador(array, arreglo);

					ListEntrenadoresAdapter lea = new ListEntrenadoresAdapter(
							actividad, R.layout.entrenadores_row_layout,
							arreglo);
					
					lvEntrenadores.setAdapter(lea);
					lvEntrenadores.setOnItemClickListener(new ListEntrenadoresOnItemClickListener());
				} catch (Exception e) {

				}
			} else
				Toast.makeText(actividad, "No hay entrenadores registrados",
						Toast.LENGTH_SHORT).show();
		}
	}
}