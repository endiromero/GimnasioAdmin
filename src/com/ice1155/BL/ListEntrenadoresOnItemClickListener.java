package com.ice1155.BL;

import com.ice1155.UI.R;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class ListEntrenadoresOnItemClickListener implements OnItemClickListener {
	private Context context;

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		context = view.getContext();
		
		TextView txtCedPre = (TextView) view.findViewById(R.id.lblCedulaEC);
		EditText txtCedula = (EditText) view.findViewById(R.id.txtCedulaEntrenador);
		txtCedula.setText(""+txtCedPre.getText().toString());
		
		EditText txtNombre = (EditText) view.findViewById(R.id.txtNombreE);
		TextView txtNombrePre = (TextView) view.findViewById(R.id.lblNombreEC);
		txtNombre.setText(txtNombrePre.getText().toString());
		
		EditText txtApe1 = (EditText) view.findViewById(R.id.txtPrimerApellido);
		TextView txtApe1Pre = (TextView) view.findViewById(R.id.lblApe1EC);
		txtApe1.setText(txtApe1Pre.getText().toString());
		
		EditText txtApe2 = (EditText) view.findViewById(R.id.txtSegundoApellidoE);
		TextView txtApe2Pre = (TextView) view.findViewById(R.id.lblApe2EC);
		txtApe2.setText(txtApe2Pre.getText().toString());
	}
}
