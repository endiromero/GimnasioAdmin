package com.ice1155.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class EjercicioActivity extends Activity {
	// Handler de imagenes
	private int actionCode;
	private Button btnVer;
	private ImageView imgCuerpo;
	
	// Botones de partes del cuerpo
	private Button deltoides;
	private Button pectorales;
	private Button antebrazo;
	private Button biceps;
	private Button piernas;
	private Button abs;
	private Button gemelos;
	private Button espalda;
	private Button triceps;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ejercicios);

		// Inicializacion de controles
		btnVer = (Button) findViewById(R.id.btnVer);
		imgCuerpo = (ImageView) findViewById(R.id.imgBody);
		
		// Botones de ejercicios
		deltoides = (Button) findViewById(R.id.btnDeltoides);
		pectorales = (Button) findViewById(R.id.btnPectorales);
		antebrazo = (Button) findViewById(R.id.btnAntebrazo);
		biceps = (Button) findViewById(R.id.btnBiceps);
		piernas = (Button) findViewById(R.id.btnPiernas);
		abs = (Button) findViewById(R.id.btnAbs);
		gemelos = (Button) findViewById(R.id.btnGemelos);
		espalda = (Button) findViewById(R.id.btnEspalda);
		triceps = (Button) findViewById(R.id.btnTriceps);
	}

	// Button methods
	public void deltoides(View v) {
		imgCuerpo.setImageResource(R.drawable.cuerpo_deltoide);
		
		deltoides.setBackgroundResource(R.drawable.boton_seleccion);
		pectorales.setBackgroundDrawable(null);
		antebrazo.setBackgroundDrawable(null);
		biceps.setBackgroundDrawable(null);
		piernas.setBackgroundDrawable(null);
		abs.setBackgroundDrawable(null);
		gemelos.setBackgroundDrawable(null);
		espalda.setBackgroundDrawable(null);
		triceps.setBackgroundDrawable(null);
		
		actionCode = 1;

		if (btnVer.getVisibility() == View.INVISIBLE) 
			btnVer.setVisibility(View.VISIBLE);
	}

	public void pectorales(View v) {
		imgCuerpo.setImageResource(R.drawable.cuerpo_pectorales);
		
		deltoides.setBackgroundDrawable(null);
		pectorales.setBackgroundResource(R.drawable.boton_seleccion);
		antebrazo.setBackgroundDrawable(null);
		biceps.setBackgroundDrawable(null);
		piernas.setBackgroundDrawable(null);
		abs.setBackgroundDrawable(null);
		gemelos.setBackgroundDrawable(null);
		espalda.setBackgroundDrawable(null);
		triceps.setBackgroundDrawable(null);
		
		actionCode = 2;

		if (btnVer.getVisibility() == View.INVISIBLE) 
			btnVer.setVisibility(View.VISIBLE);
	}

	public void antebrazo(View v) {
		imgCuerpo.setImageResource(R.drawable.cuerpo_antebrazo);
		
		deltoides.setBackgroundDrawable(null);
		pectorales.setBackgroundDrawable(null);
		antebrazo.setBackgroundResource(R.drawable.boton_seleccion);
		biceps.setBackgroundDrawable(null);
		piernas.setBackgroundDrawable(null);
		abs.setBackgroundDrawable(null);
		gemelos.setBackgroundDrawable(null);
		espalda.setBackgroundDrawable(null);
		triceps.setBackgroundDrawable(null);
		
		actionCode = 3;

		if (btnVer.getVisibility() == View.INVISIBLE) 
			btnVer.setVisibility(View.VISIBLE);
	}

	public void biceps(View v) {
		imgCuerpo.setImageResource(R.drawable.cuerpo_biceps);
		
		deltoides.setBackgroundDrawable(null);
		pectorales.setBackgroundDrawable(null);
		antebrazo.setBackgroundDrawable(null);
		biceps.setBackgroundResource(R.drawable.boton_seleccion);
		piernas.setBackgroundDrawable(null);
		abs.setBackgroundDrawable(null);
		gemelos.setBackgroundDrawable(null);
		espalda.setBackgroundDrawable(null);
		triceps.setBackgroundDrawable(null);
		
		actionCode = 4;

		if (btnVer.getVisibility() == View.INVISIBLE)
			btnVer.setVisibility(View.VISIBLE);
	}

	public void piernas(View v) {
		imgCuerpo.setImageResource(R.drawable.cuerpo_pierna);
		
		deltoides.setBackgroundDrawable(null);
		pectorales.setBackgroundDrawable(null);
		antebrazo.setBackgroundDrawable(null);
		biceps.setBackgroundDrawable(null);
		piernas.setBackgroundResource(R.drawable.boton_seleccion);
		abs.setBackgroundDrawable(null);
		gemelos.setBackgroundDrawable(null);
		espalda.setBackgroundDrawable(null);
		triceps.setBackgroundDrawable(null);
		
		actionCode = 5;

		if (btnVer.getVisibility() == View.INVISIBLE)
			btnVer.setVisibility(View.VISIBLE);
	}

	public void abs(View v) {
		imgCuerpo.setImageResource(R.drawable.cuerpo_abdominales);
		
		deltoides.setBackgroundDrawable(null);
		pectorales.setBackgroundDrawable(null);
		antebrazo.setBackgroundDrawable(null);
		biceps.setBackgroundDrawable(null);
		piernas.setBackgroundDrawable(null);
		abs.setBackgroundResource(R.drawable.boton_seleccion);
		gemelos.setBackgroundDrawable(null);
		espalda.setBackgroundDrawable(null);
		triceps.setBackgroundDrawable(null);
		
		actionCode = 6;

		if (btnVer.getVisibility() == View.INVISIBLE)
			btnVer.setVisibility(View.VISIBLE);
	}

	public void gemelos(View v) {
		imgCuerpo.setImageResource(R.drawable.cuerpo_gemelos);
		
		deltoides.setBackgroundDrawable(null);
		pectorales.setBackgroundDrawable(null);
		antebrazo.setBackgroundDrawable(null);
		biceps.setBackgroundDrawable(null);
		piernas.setBackgroundDrawable(null);
		abs.setBackgroundDrawable(null);
		gemelos.setBackgroundResource(R.drawable.boton_seleccion);
		espalda.setBackgroundDrawable(null);
		triceps.setBackgroundDrawable(null);
		
		actionCode = 7;

		if (btnVer.getVisibility() == View.INVISIBLE)
			btnVer.setVisibility(View.VISIBLE);
	}

	public void espalda(View v) {
		imgCuerpo.setImageResource(R.drawable.cuerpo_espalda);
		
		deltoides.setBackgroundDrawable(null);
		pectorales.setBackgroundDrawable(null);
		antebrazo.setBackgroundDrawable(null);
		biceps.setBackgroundDrawable(null);
		piernas.setBackgroundDrawable(null);
		abs.setBackgroundDrawable(null);
		gemelos.setBackgroundDrawable(null);
		espalda.setBackgroundResource(R.drawable.boton_seleccion);
		triceps.setBackgroundDrawable(null);
		
		actionCode = 8;

		if (btnVer.getVisibility() == View.INVISIBLE)
			btnVer.setVisibility(View.VISIBLE);
	}

	public void triceps(View v) {
		imgCuerpo.setImageResource(R.drawable.cuerpo_triceps);
		
		deltoides.setBackgroundDrawable(null);
		pectorales.setBackgroundDrawable(null);
		antebrazo.setBackgroundDrawable(null);
		biceps.setBackgroundDrawable(null);
		piernas.setBackgroundDrawable(null);
		abs.setBackgroundDrawable(null);
		gemelos.setBackgroundDrawable(null);
		espalda.setBackgroundDrawable(null);
		triceps.setBackgroundResource(R.drawable.boton_seleccion);
		
		actionCode = 9;

		if (btnVer.getVisibility() == View.INVISIBLE)
			btnVer.setVisibility(View.VISIBLE);
	}

	public void ver(View v) {
		// Envia la lista correspondiente a renderizar
		Intent i = new Intent(this, ViewEjerciciosActivity.class);
		switch (actionCode) {
		// Abdominales
		case 1:
			i.putExtra("codigoLista", 1);
			startActivity(i);
			break;

		// Piernas
		case 2:
			i.putExtra("codigoLista", 2);
			startActivity(i);
			break;

		// Gemelos
		case 3:
			i.putExtra("codigoLista", 3);
			startActivity(i);
			break;

		// Pectorales
		case 4:
			i.putExtra("codigoLista", 4);
			startActivity(i);
			break;

		// Espalda
		case 5:
			i.putExtra("codigoLista", 5);
			startActivity(i);
			break;

		// Deltoides
		case 6:
			i.putExtra("codigoLista", 6);
			startActivity(i);
			break;

		// Triceps
		case 7:
			i.putExtra("codigoLista", 7);
			startActivity(i);
			break;

		// Biceps
		case 8:
			i.putExtra("codigoLista", 8);
			startActivity(i);
			break;

		// Antebrazos
		case 9:
			i.putExtra("codigoLista", 9);
			startActivity(i);
			break;
		}
	}
}