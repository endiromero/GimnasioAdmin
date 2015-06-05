package com.ice1155.BL;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.ice1155.DA.Entrenador;
import com.ice1155.UI.R;

public class ListEntrenadoresAdapter extends ArrayAdapter<Entrenador> {
	private Context context;
	private int resource;
	private ArrayList<Entrenador> objects;

	public ListEntrenadoresAdapter(Context context, int resource,
			ArrayList<Entrenador> objects) {
		super(context, resource, objects);
		this.context = context;
		this.resource = resource;
		this.objects = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		EntrenadorHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(resource, parent, false);

			holder = new EntrenadorHolder();
			holder.id = (TextView) row.findViewById(R.id.lblCedulaEC);
			holder.txtNombre = (TextView) row.findViewById(R.id.lblNombreEC);

			row.setTag(holder);
		} else {
			holder = (EntrenadorHolder) row.getTag();
		}

		Entrenador c = objects.get(position);
		holder.id.setText(c.getCedula() + "");
		holder.txtNombre.setText(c.getNombre() + " " + c.getPrimerApellido()
				+ " " + c.getSegundoApellido());

		return row;
	}

	private class EntrenadorHolder {
		TextView id;
		TextView txtNombre;
	}

}
