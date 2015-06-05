package com.ice1155.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
	private final int SPLASH_TIME = 2000;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.splash);
		/*
		 * Handler que quitará el splash screen después del SPLASH_TIME y creará
		 * un intent de la actividad principal.
		 */
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				/* Creamos un Intent que lanzará nuestra Actividad principal */
				Intent miIntent = new Intent(SplashActivity.this,
						LoginActivity.class);
				SplashActivity.this.startActivity(miIntent);
				SplashActivity.this.finish();
			}
		}, SPLASH_TIME);
	}
}