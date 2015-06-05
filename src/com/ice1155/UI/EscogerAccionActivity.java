package com.ice1155.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EscogerAccionActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.escoger_accion_cliente);
	}

	// Button methods
	public void nuevoCliente(View v) {
		Intent i = new Intent(this, ClienteActivity.class);
		startActivity(i);
	}
	
	public void modificarCliente(View v) {
		//Intent i = new Intent(this, ListClientesActivity.class);
	}
}
