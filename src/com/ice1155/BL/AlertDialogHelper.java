package com.ice1155.BL;

import com.ice1155.UI.R;
import com.ice1155.UI.R.string;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class AlertDialogHelper {
	private Context ctx;
	private String titulo;
	private String mensaje;

	public AlertDialogHelper(Context ctx, String titulo, String mensaje) {
		set(ctx, titulo, mensaje);
	}

	private void set(Context ctx, String titulo, String mensaje) {
		this.ctx = ctx;
		this.titulo = titulo;
		this.mensaje = mensaje;
	}

	/**
	 * Crea alert dialog con boton de aceptar
	 * 
	 * @return
	 */
	public AlertDialog crearDialogoSimple() {
		AlertDialog alertDialog = null;

		alertDialog = new AlertDialog.Builder(ctx).create();
		alertDialog.setTitle(titulo);
		alertDialog.setMessage(mensaje);
		alertDialog.setCancelable(false);
		alertDialog.setButton(ctx.getString(R.string.alert_aceptar),
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// ((Activity) ctx).finish();
						return;
					}
				});
		alertDialog.show();

		return alertDialog;

	}

	/**
	 * Crea alert dialog con boton de aceptar
	 * 
	 * @return
	 */
	public AlertDialog crearDialogoSimpleConFinish() {
		AlertDialog alertDialog = null;

		alertDialog = new AlertDialog.Builder(ctx).create();
		alertDialog.setTitle(titulo);
		alertDialog.setMessage(mensaje);
		alertDialog.setButton(ctx.getString(R.string.alert_aceptar),
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						((Activity) ctx).finish();
						return;
					}
				});
		alertDialog.show();

		return alertDialog;

	}

}
