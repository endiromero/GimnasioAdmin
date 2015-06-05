package com.ice1155.BL;

import com.ice1155.UI.R;
import com.ice1155.UI.RutinaActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ListClientesOnItemClickListener implements OnItemClickListener {
	private long carne;
	private Intent i;
	private Context context;

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		context = view.getContext();
		i = new Intent(context, RutinaActivity.class);

		TextView txtCarne = (TextView) view.findViewById(R.id.txtIdClienteAll);
		carne = Long.valueOf(txtCarne.getText().toString());

		i.putExtra("carne", carne);
		context.startActivity(i);
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	}
}
