package com.ice1155.UI;

import java.util.ArrayList;

import com.ice1155.BL.ListClientesAdapter;
import com.ice1155.BL.ListClientesOnItemClickListener;
import com.ice1155.DA.Cliente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class ListClientesActivity extends Activity {
	private ArrayList<Cliente> clientes;
	private ListView listaClientes;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clientes_list);

		// Obteniendo los clientes de la pantalla anterior
		Intent extras = getIntent();
		clientes = ((ArrayList<Cliente>) extras
				.getSerializableExtra("listaClientes"));
		if (!clientes.isEmpty()) {
			listaClientes = (ListView) findViewById(R.id.listaClientes);
			renderList(listaClientes);
		} else {
			Toast.makeText(getApplicationContext(), R.string.err_unexp,
					Toast.LENGTH_LONG).show();
			finish();
		}
	}

	// Custom methods
	private void renderList(ListView lv) {
		ListClientesAdapter lca = new ListClientesAdapter(
				ListClientesActivity.this, R.layout.clientes_row_layout, clientes);
		
		lv.setAdapter(lca);
        lv.setOnItemClickListener(new ListClientesOnItemClickListener());
	}
}