package com.ice1155.BL;

import java.util.ArrayList;

import com.ice1155.DA.Cliente;
import com.ice1155.UI.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListClientesAdapter extends ArrayAdapter<Cliente> {
	private Context context;
	private int resource;
	private ArrayList<Cliente> objects;

	public ListClientesAdapter(Context context, int resource, ArrayList<Cliente> objects) {
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