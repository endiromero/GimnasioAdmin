package com.ice1155.UI;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.ice1155.DA.Cliente;
import com.ice1155.UT.Constantes;
import com.ice1155.UT.RequestHandler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import org.json.JSONArray;
import org.json.JSONException;

public class ListClientesActivity extends Activity {
	private ListView listaClientes;
	private ProgressBar pbClientes;
    private ArrayList<Cliente> arr = new ArrayList<Cliente>();

    // cliente seleccionado
    public static Cliente c = null;

	private RequestHandler rh = new RequestHandler();
	private Gson gson = new Gson();
    private int code;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clientes_list);

		// obtengo la info de clientes
		listaClientes = (ListView) findViewById(R.id.listaClientes);
		pbClientes = (ProgressBar) findViewById(R.id.pbListaClientes);
		new LoadClientes(arr).execute(Constantes.MOSTRAR_TODOS_CLIENTES);

        code = getIntent().getIntExtra("code", 0);
        listaClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (code) {
                    case 0:
                        TextView nombre = (TextView) view.findViewById(R.id.txtNombreClienteAll);

                        Intent i = new Intent(getApplicationContext(), RutinaActivity.class);
                        c = arr.get(position);
                        i.putExtra("carne", c.getId());
                        i.putExtra("nombre", nombre.getText().toString());
                        startActivity(i);
                        break;

                    case 1:
                        c = arr.get(position);
                        Intent i2 = new Intent(getApplicationContext(), ClienteActivity.class);
                        i2.putExtra("code", 1);
                        startActivity(i2);
                        break;
                }
            }
        });
	}

	private void startLoader() {
		pbClientes.setVisibility(View.VISIBLE);
	}

	private void markAsDone() {
		pbClientes.setVisibility(View.INVISIBLE);
	}

	// Asynctask
	private class LoadClientes extends AsyncTask<String, Void, String> {
        private ArrayList<Cliente> arr;

        public LoadClientes(ArrayList<Cliente> arr) {
            this.arr = arr;
        }

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
				try {
					JSONArray ja = new JSONArray(response);
					convertToCliente(ja, arr);

					ListCliRutAdapter lca = new ListCliRutAdapter(
							ListClientesActivity.this, R.layout.clientes_row_layout, arr);

					listaClientes.setAdapter(lca);
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

	// adapter de clientes
	private class ListCliRutAdapter extends ArrayAdapter<Cliente> {
		private Context context;
		private int resource;
		private ArrayList<Cliente> objects;

		public ListCliRutAdapter(Context context, int resource, ArrayList<Cliente> objects) {
			super(context, resource, objects);
			this.context = context;
			this.resource = resource;
			this.objects = objects;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View row = convertView;
			ClienteHolder holder = null;

			if (row == null) {
				LayoutInflater inflater = ((Activity) context).getLayoutInflater();
				row = inflater.inflate(resource, parent, false);

				holder = new ClienteHolder();
				holder.id = (TextView) row.findViewById(R.id.txtIdClienteAll);
				holder.txtNombre = (TextView) row
						.findViewById(R.id.txtNombreClienteAll);

				row.setTag(holder);
			} else {
				holder = (ClienteHolder) row.getTag();
			}

			Cliente c = objects.get(position);
			holder.id.setText(c.getCarne() + "");
			holder.txtNombre.setText(c.getNombre());

			return row;
		}

		private class ClienteHolder {
			TextView id;
			TextView txtNombre;
		}
	}
}