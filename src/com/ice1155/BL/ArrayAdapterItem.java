package com.ice1155.BL;

import com.ice1155.DA.ObjectItem;
import com.ice1155.UI.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ArrayAdapterItem extends ArrayAdapter<ObjectItem> {
	private Context context;
	private int layoutResourceId;
	private ObjectItem data[] = null;
	
	public ArrayAdapterItem(Context mContext, int layoutResourceId, ObjectItem[] data) {
		super(mContext, layoutResourceId, data);
		
		this.layoutResourceId = layoutResourceId;
		this.context = mContext;
		this.data = data;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(context);
			convertView = inflater.inflate(layoutResourceId, parent, false);
		}
		
		ObjectItem objectItem = data[position];
		
		TextView txtNombreEjercicio = (TextView) convertView.findViewById(R.id.txtNombreEjercicio);
		TextView txtIdEjercicio = (TextView) convertView.findViewById(R.id.txtIdEjercicio);
		
		txtNombreEjercicio.setText(objectItem.getItemName());
		txtIdEjercicio.setText(""+objectItem.getItemId());
		
		return convertView;
	}
}
