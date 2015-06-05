package com.ice1155.UI;

import com.ice1155.BL.AlertDialogHelper;
import com.ice1155.BL.ArrayAdapterItem;
import com.ice1155.BL.OnItemClickListenerListViewItem;
import com.ice1155.DA.ListaPorZona;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ViewEjerciciosActivity extends Activity {
	// Alert dialog helper
	private AlertDialogHelper adh;

	// Variable con las listas de ejercicios
	private ListaPorZona lpz;
	
	// Controles
	private ListView lv;
	private ArrayAdapterItem aai;
	private TextView lblZona;
	public static TextView descripcion;
	public static ImageView imgEjercicio;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ejercicios_details);

		// Extras para cargar la lista correcta
		Intent extras = getIntent();
		if (extras != null) {
			// Inicializacion de controles
			init();
			
			// Switch para renderizar la lista correcta
			aai = renderList(extras.getIntExtra("codigoLista", 0));
		} else {
			adh = new AlertDialogHelper(getApplicationContext(),
					getString(R.string.title_error),
					getString(R.string.err_unexp));

			adh.crearDialogoSimpleConFinish();
		}
		
		lv = (ListView) findViewById(R.id.lsEjercicios);
		lv.setAdapter(aai);
		lv.setDivider(new ColorDrawable(Color.parseColor("#FFFFFF")));
		lv.setDividerHeight(1);
		lv.setOnItemClickListener(new OnItemClickListenerListViewItem());
	}

	@Override
	public void onBackPressed() {
		this.finish();
	}

	// Custom methods
	private void init() {
		lpz = new ListaPorZona();
		lblZona = (TextView) findViewById(R.id.lblNombreZona);
		descripcion = (TextView) findViewById(R.id.lblDescripcion); 
		imgEjercicio = (ImageView) findViewById(R.id.imgEjercicio);
	}

	private ArrayAdapterItem renderList(int idLista) {
		// Renderiza la lista correcta
		switch (idLista) {
		// Lista de deltoides
		case 1:
			lblZona.setText("Deltoides");
			return new ArrayAdapterItem(getApplicationContext(),
					R.layout.row_layout_ejercicios, lpz.getListDeltoides());

			// Lista de pectorales
		case 2:
			lblZona.setText("Pectorales");
			return new ArrayAdapterItem(getApplicationContext(),
					R.layout.row_layout_ejercicios, lpz.getListPectorales());

			// Lista de antebrazo
		case 3:
			lblZona.setText("Antebrazo");
			return new ArrayAdapterItem(getApplicationContext(),
					R.layout.row_layout_ejercicios, lpz.getListAntebrazo());

			// Lista de biceps
		case 4:
			lblZona.setText("Biceps");
			return new ArrayAdapterItem(getApplicationContext(),
					R.layout.row_layout_ejercicios, lpz.getListBiceps());

			// Lista de piernas
		case 5:
			lblZona.setText("Piernas");
			return new ArrayAdapterItem(getApplicationContext(),
					R.layout.row_layout_ejercicios, lpz.getListPierna());

			// Lista de abs
		case 6:
			lblZona.setText("Abdomen");
			return new ArrayAdapterItem(getApplicationContext(),
					R.layout.row_layout_ejercicios, lpz.getListAbdomen());

			// Lista de gemelos
		case 7:
			lblZona.setText("Gemelos");
			return new ArrayAdapterItem(getApplicationContext(),
					R.layout.row_layout_ejercicios, lpz.getListGemelos());

			// Lista de espalda
		case 8:
			lblZona.setText("Espalda");
			return new ArrayAdapterItem(getApplicationContext(),
					R.layout.row_layout_ejercicios, lpz.getListEspalda());

			// Lista de triceps
		case 9:
			lblZona.setText("Triceps");
			return new ArrayAdapterItem(getApplicationContext(),
					R.layout.row_layout_ejercicios, lpz.getListTriceps());

		default:
			return null;
		}

	}
}