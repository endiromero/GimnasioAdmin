package com.ice1155.UI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.ice1155.DA.Cliente;
import com.ice1155.DA.Entrenador;
import com.ice1155.UT.Constantes;
import com.ice1155.UT.RequestHandler;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ClienteActivity extends Activity {
	private RequestHandler rh = new RequestHandler();
	private Gson gson = new Gson();
	private RequestCliente rc;

	private RelativeLayout rlDatos;
	private RelativeLayout rlPorcen;
	private RelativeLayout rlMedidas;
	private RelativeLayout rlObs;

	// Data
	private EditText txtNombre;
	private EditText txtApellido1;
	private EditText txtApellido2;
	private EditText txtCedula;
	private EditText txtTriceps;
	private EditText txtSubes;
	private EditText txtSupra;
	private EditText txtAbdominal;
	private EditText txtGastro;
	private EditText txtPechoH;
	private EditText txtPorcenGrasa;
	private EditText txtPorcenMasaMusc;
	private EditText txtImc;
	private EditText txtindVice;
	private EditText txtKcal;
	private EditText txtPresion;
	private EditText txtPulso;
	private EditText txtGlucosa;
	private EditText txtEstatura;
	private EditText txtPeso;
	private EditText txtPecho;
	private EditText txtEspalda;
	private EditText txtUmbilical;
	private EditText txtCaderas;
	private EditText txtMusloDer;
	private EditText txtMusloIzq;
	private EditText txtBrazoDer;
	private EditText txtBrazoIzq;
	private EditText txtAnteDer;
	private EditText txtAnteIzq;
	private EditText txtGastroDer;
	private EditText txtGastroIzq;
	private EditText txtMusculo;

    // data entrenadores
    private TextView lblCedulaE;
    private TextView lblNombreE;
    private TextView lblPrimerApellidoE;
    private TextView lblSegundoApellidoE;

    private String cedulaEntrenador;
    private String nombreEntrenador;
    private String pApellido;
    private String sApellido;

	// Botones
	private Button btnDatosP;
	private Button btnPorcenGrasa;
	private Button btnMedidas;
	private Button btnObs;

	// fecha nacimiento missing
	private EditText txtObservaciones;
	private RadioButton rbMasc;
	private RadioButton rbFem;
	private ProgressDialog pd;

	// Definidor de post execute
	private int ACTION_CODE = 0;

	// Edad
	private int anoNacimiento;
	private Date fechaNacimiento = new Date();

	// Lista de entrenadores
	private ListView lsEntrenadoresC;
	private ArrayList<Entrenador> arr;
	public Entrenador _e;

    // data para edit
    private int code;
    private Cliente c;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clientes);

		// request handler
		rc = new RequestCliente(this);

		// obteniendo los contenedores
		rlDatos = (RelativeLayout) findViewById(R.id.llDatosPersonales);
		rlPorcen = (RelativeLayout) findViewById(R.id.llPorcenGrasa);
		rlMedidas = (RelativeLayout) findViewById(R.id.llMedidas);
		rlObs = (RelativeLayout) findViewById(R.id.llObservaciones);

		try {
			init();

            code = getIntent().getIntExtra("code", -1);
            c = (Cliente) getIntent().getSerializableExtra("cliente");
            if (c != null && (code == 1)) {
                txtCedula.setText(""+c.getCarne());
                //entrenador
                txtApellido1.setText(c.getprimer_apellido());
                txtApellido2.setText(c.getsegundo_apellido());
                txtNombre.setText(c.getNombre());
                //fecha
                //fecha nacimiento
                //edad
                if(c.isSexo()) {
                    rbMasc.setSelected(true);
                    rbFem.setSelected(false);
                }
                else {
                    rbMasc.setSelected(true);
                    rbFem.setSelected(false);
                }

                txtEstatura.setText(""+c.getEstatura());
                txtPeso.setText(""+c.getPesoKgs());
                txtPecho.setText(""+c.getPecho());
                txtEspalda.setText(""+c.getEspalda());
                txtUmbilical.setText(""+c.getUmbilical());
                txtCaderas.setText(""+c.getCaderas());
                txtMusloDer.setText(""+c.getMusloDer());
                txtMusloIzq.setText(""+c.getMusloIzq());
                txtBrazoDer.setText(""+c.getBrazoDer());
                txtBrazoIzq.setText(""+c.getBrazoIzq());
                txtAnteDer.setText(""+c.getAntebrazoDer());
                txtAnteIzq.setText(""+c.getAntebrazoIzq());
                txtGastroDer.setText(""+c.getGastroDer());
                txtGastroIzq.setText(""+c.getGastroIzq());
                txtTriceps.setText(""+c.getTricepsPorG());
                txtSubes.setText(""+c.getSubescapularPorG());
                txtSupra.setText(""+c.getSupraPorG());
                txtAbdominal.setText(""+c.getAbdominalPorG());
                txtGastro.setText(""+c.getGastroPorG());
                txtPechoH.setText(""+c.getPechoPorG());
                txtPorcenGrasa.setText(""+c.getPorcentajeGrasa());
                txtPorcenMasaMusc.setText(""+c.getPorcenMasaMuscPorG());
                txtImc.setText(""+c.getImcPorG());
                txtindVice.setText(""+c.getIndVicePorG());
                txtKcal.setText(""+c.getCalReposoPorG());
                txtPresion.setText(""+c.getPresionPorG());
                txtPulso.setText(""+c.getPulsoPorG());
                txtGlucosa.setText(""+c.getGlucosaPorG());
                txtMusculo.setText(""+c.getMusculoPorG());
                txtObservaciones.setText(c.getObservaciones());
            }
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), R.string.err_unexp,
					Toast.LENGTH_LONG).show();
			e.printStackTrace();
			finish();
		}
	}

	// Button methods
	public void guardar(View v) {
        // edit
        if (code == 1) {
            Entrenador ent = new Entrenador(cedulaEntrenador, nombreEntrenador, pApellido, sApellido);
            String e = gson.toJson(ent);

            Calendar cl = new GregorianCalendar();
            cl.set(Calendar.HOUR_OF_DAY, 0);
            cl.set(Calendar.MINUTE, 0);

            int edad = Calendar.getInstance().get(Calendar.YEAR) - anoNacimiento;

            Date d = cl.getTime();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
            String fechaString = sdf.format(cl.getTime());
            String fechaNac = sdf.format(fechaNacimiento);

            boolean sexo = true;
            if (rbMasc.isSelected())
                sexo = true;
            else if (rbFem.isSelected())
                sexo = false;
            try {
                Cliente c = new Cliente(Long.parseLong(txtCedula.getText()
                        .toString()), ent, txtApellido1.getText().toString(),
                        txtApellido2.getText().toString(), txtNombre.getText()
                        .toString(), fechaString, fechaNac, edad, sexo,
                        Double.parseDouble(txtEstatura.getText().toString()),
                        Double.parseDouble(txtPeso.getText().toString()),
                        Double.parseDouble(txtPecho.getText().toString()),
                        Double.parseDouble(txtEspalda.getText().toString()),
                        Double.parseDouble(txtUmbilical.getText().toString()),
                        Double.parseDouble(txtCaderas.getText().toString()),
                        Double.parseDouble(txtMusloDer.getText().toString()),
                        Double.parseDouble(txtMusloIzq.getText().toString()),
                        Double.parseDouble(txtBrazoDer.getText().toString()),
                        Double.parseDouble(txtBrazoIzq.getText().toString()),
                        Double.parseDouble(txtAnteDer.getText().toString()),
                        Double.parseDouble(txtAnteIzq.getText().toString()),
                        Double.parseDouble(txtGastroDer.getText().toString()),
                        Double.parseDouble(txtGastroIzq.getText().toString()),
                        Double.parseDouble(txtTriceps.getText().toString()),
                        Double.parseDouble(txtSubes.getText().toString()),
                        Double.parseDouble(txtSupra.getText().toString()),
                        Double.parseDouble(txtAbdominal.getText().toString()),
                        Double.parseDouble(txtGastro.getText().toString()),
                        Double.parseDouble(txtPechoH.getText().toString()),
                        Double.parseDouble(txtPorcenGrasa.getText().toString()),
                        Double.parseDouble(txtPorcenMasaMusc.getText().toString()),
                        Double.parseDouble(txtImc.getText().toString()),
                        Double.parseDouble(txtindVice.getText().toString()),
                        Double.parseDouble(txtKcal.getText().toString()),
                        Double.parseDouble(txtPresion.getText().toString()),
                        txtPulso.getText().toString(),
                        Double.parseDouble(txtGlucosa.getText().toString()),
                        Double.parseDouble(txtMusculo.getText().toString()),
                        txtObservaciones.getText().toString());

                JSONObject json = new JSONObject();
                json.accumulate("segundoApellido", c.getsegundo_apellido());
                json.accumulate("primerApellido", c.getprimer_apellido());
                json.accumulate("observaciones", c.getObservaciones());
                json.accumulate("nombre", c.getNombre());
                json.accumulate("fechaNacimiento", c.getFechaNacimiento());
                json.accumulate("fechaMedicion", d);
                json.accumulate("entrenador", c.getentrenador_id());
                json.accumulate("sexo" ,c.isSexo());
                json.accumulate("umbilical", c.getUmbilical());
                json.accumulate("calReposoPorG",c.getCalReposoPorG());
                json.accumulate("espalda",c.getEspalda());
                json.accumulate("estatura", c.getEstatura());
                json.accumulate("caderas", c.getCaderas());
                json.accumulate("brazoIzq", c.getBrazoIzq());
                json.accumulate("gastroIzq", c.getGastroIzq());
                json.accumulate("gastroPorG", c.getGastroPorG());
                json.accumulate("glucosaPorG", c.getGlucosaPorG());
                json.accumulate("imcPorG", c.getImcPorG());
                json.accumulate("indVicePorG", c.getIndVicePorG());
                json.accumulate("musculoPorG", c.getMusculoPorG());
                json.accumulate("musloDer", c.getMusloDer());
                json.accumulate("musloIzq", c.getMusloIzq());
                json.accumulate("brazoDer", c.getBrazoDer());
                json.accumulate("antebrazoIzq", c.getAntebrazoIzq());
                json.accumulate("pecho", c.getPecho());
                json.accumulate("pechoPorG", c.getPechoPorG());
                json.accumulate("pesoKgs", c.getPesoKgs());
                json.accumulate("porcenMasaMuscPorG", c.getPorcenMasaMuscPorG());
                json.accumulate("porcentajeGrasa", c.getPorcentajeGrasa());
                json.accumulate("presionPorG", c.getPresionPorG());
                json.accumulate("antebrazoDer", c.getAntebrazoDer());
                json.accumulate("pulsoPorG", c.getPulsoPorG());
                json.accumulate("abdominalPorG", c.getAbdominalPorG());
                json.accumulate("carne", c.getCarne());
                json.accumulate("subescapularPorG", c.getSubescapularPorG());
                json.accumulate("supraPorG", c.getSupraPorG());
                json.accumulate("tricepsPorG", c.getTricepsPorG());
                json.accumulate("edad", c.getEdad());

                String aDividir = json.toString();

                char[] arreglo = aDividir.toCharArray();
                arreglo[aDividir.length()-1] = ',';

                String dividido = new String(arreglo);

                String test = dividido + '"'+"entrenador"+'"'+":"+e+"}";

                rc.execute(test, "2");
            } catch (Exception ex) {
                ex.printStackTrace();
                Toast.makeText(getApplicationContext(), R.string.err_unexp,
                        Toast.LENGTH_LONG).show();
                finish();
            }
        }

		Entrenador ent = new Entrenador(cedulaEntrenador, nombreEntrenador, pApellido, sApellido);
        String e = gson.toJson(ent);

        Calendar cl = new GregorianCalendar();
		cl.set(Calendar.HOUR_OF_DAY, 0);
		cl.set(Calendar.MINUTE, 0);
		cl.set(Calendar.SECOND, 0);

		int edad = Calendar.getInstance().get(Calendar.YEAR) - anoNacimiento;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
        String fechaString = sdf.format(cl.getTime());
        String fechaNac = sdf.format(fechaNacimiento);

		boolean sexo = true;
		if (rbMasc.isSelected())
			sexo = true;
		else if (rbFem.isSelected())
			sexo = false;
		try {
			Cliente c = new Cliente(Long.parseLong(txtCedula.getText()
					.toString()), ent, txtApellido1.getText().toString(),
					txtApellido2.getText().toString(), txtNombre.getText()
							.toString(), fechaString, fechaNac, edad, sexo,
					Double.parseDouble(txtEstatura.getText().toString()),
					Double.parseDouble(txtPeso.getText().toString()),
					Double.parseDouble(txtPecho.getText().toString()),
					Double.parseDouble(txtEspalda.getText().toString()),
					Double.parseDouble(txtUmbilical.getText().toString()),
					Double.parseDouble(txtCaderas.getText().toString()),
					Double.parseDouble(txtMusloDer.getText().toString()),
					Double.parseDouble(txtMusloIzq.getText().toString()),
					Double.parseDouble(txtBrazoDer.getText().toString()),
					Double.parseDouble(txtBrazoIzq.getText().toString()),
					Double.parseDouble(txtAnteDer.getText().toString()),
					Double.parseDouble(txtAnteIzq.getText().toString()),
					Double.parseDouble(txtGastroDer.getText().toString()),
					Double.parseDouble(txtGastroIzq.getText().toString()),
					Double.parseDouble(txtTriceps.getText().toString()),
					Double.parseDouble(txtSubes.getText().toString()),
					Double.parseDouble(txtSupra.getText().toString()),
					Double.parseDouble(txtAbdominal.getText().toString()),
					Double.parseDouble(txtGastro.getText().toString()),
					Double.parseDouble(txtPechoH.getText().toString()),
					Double.parseDouble(txtPorcenGrasa.getText().toString()),
					Double.parseDouble(txtPorcenMasaMusc.getText().toString()),
					Double.parseDouble(txtImc.getText().toString()),
					Double.parseDouble(txtindVice.getText().toString()),
					Double.parseDouble(txtKcal.getText().toString()),
					Double.parseDouble(txtPresion.getText().toString()),
					txtPulso.getText().toString(),
					Double.parseDouble(txtGlucosa.getText().toString()),
					Double.parseDouble(txtMusculo.getText().toString()),
					txtObservaciones.getText().toString());

            JSONObject json = new JSONObject();
            json.accumulate("segundoApellido", c.getsegundo_apellido());
            json.accumulate("primerApellido", c.getprimer_apellido());
            json.accumulate("observaciones", c.getObservaciones());
            json.accumulate("nombre", c.getNombre());
            json.accumulate("fechaNacimiento", c.getFechaNacimiento());
            json.accumulate("fechaMedicion", c.getFechaMed());
            json.accumulate("sexo" ,c.isSexo());
            json.accumulate("umbilical", c.getUmbilical());
            json.accumulate("calReposoPorG",c.getCalReposoPorG());
            json.accumulate("espalda",c.getEspalda());
            json.accumulate("estatura", c.getEstatura());
            json.accumulate("caderas", c.getCaderas());
            json.accumulate("brazoIzq", c.getBrazoIzq());
            json.accumulate("gastroIzq", c.getGastroIzq());
            json.accumulate("gastroDer", c.getGastroDer());
            json.accumulate("gastroPorG", c.getGastroPorG());
            json.accumulate("glucosaPorG", c.getGlucosaPorG());
            json.accumulate("imcPorG", c.getImcPorG());
            json.accumulate("indVicePorG", c.getIndVicePorG());
            json.accumulate("musculoPorG", c.getMusculoPorG());
            json.accumulate("musloDer", c.getMusloDer());
            json.accumulate("musloIzq", c.getMusloIzq());
            json.accumulate("muslosPorG", 0.0);
            json.accumulate("brazoDer", c.getBrazoDer());
            json.accumulate("antebrazoIzq", c.getAntebrazoIzq());
            json.accumulate("pecho", c.getPecho());
            json.accumulate("pechoPorG", c.getPechoPorG());
            json.accumulate("pesoKgs", c.getPesoKgs());
            json.accumulate("porcenMasaMuscPorG", c.getPorcenMasaMuscPorG());
            json.accumulate("porcentajeGrasa", c.getPorcentajeGrasa());
            json.accumulate("presionPorG", c.getPresionPorG());
            json.accumulate("antebrazoDer", c.getAntebrazoDer());
            json.accumulate("pulsoPorG", c.getPulsoPorG());
            json.accumulate("abdominalPorG", c.getAbdominalPorG());
            json.accumulate("carne", c.getCarne());
            json.accumulate("subescapularPorG", c.getSubescapularPorG());
            json.accumulate("supraPorG", c.getSupraPorG());
            json.accumulate("tricepsPorG", c.getTricepsPorG());
            json.accumulate("edad", c.getEdad());

            String aDividir = json.toString();

            char[] arreglo = aDividir.toCharArray();
            arreglo[aDividir.length()-1] = ',';

            String dividido = new String(arreglo);

            String test = dividido + '"'+"entrenador"+'"'+":"+e+"}";

			rc.execute(test, "1");
		} catch (Exception ex) {
			ex.printStackTrace();
			Toast.makeText(getApplicationContext(), R.string.err_unexp,
					Toast.LENGTH_LONG).show();
			finish();
		}
	}

	public void mostrarDatosPersonales(View v) {
		rlDatos.setVisibility(View.VISIBLE);

		btnDatosP.setBackgroundResource(R.drawable.boton_seleccion);
		btnPorcenGrasa.setBackgroundDrawable(null);
		btnMedidas.setBackgroundDrawable(null);
		btnObs.setBackgroundDrawable(null);

		rlPorcen.setVisibility(View.INVISIBLE);
		rlMedidas.setVisibility(View.INVISIBLE);
		rlObs.setVisibility(View.INVISIBLE);
	}

	public void mostrarPorcenGrasa(View v) {
		rlDatos.setVisibility(View.INVISIBLE);
		rlPorcen.setVisibility(View.VISIBLE);

		btnDatosP.setBackgroundDrawable(null);
		btnPorcenGrasa.setBackgroundResource(R.drawable.boton_seleccion);
		btnMedidas.setBackgroundDrawable(null);
		btnObs.setBackgroundDrawable(null);

		rlMedidas.setVisibility(View.INVISIBLE);
		rlObs.setVisibility(View.INVISIBLE);
	}

	public void mostrarMedidas(View v) {
		rlDatos.setVisibility(View.INVISIBLE);
		rlPorcen.setVisibility(View.INVISIBLE);
		rlMedidas.setVisibility(View.VISIBLE);

		btnDatosP.setBackgroundDrawable(null);
		btnPorcenGrasa.setBackgroundDrawable(null);
		btnMedidas.setBackgroundResource(R.drawable.boton_seleccion);
		btnObs.setBackgroundDrawable(null);

		rlObs.setVisibility(View.INVISIBLE);
	}

	public void mostrarObservaciones(View v) {
		rlDatos.setVisibility(View.INVISIBLE);
		rlPorcen.setVisibility(View.INVISIBLE);
		rlMedidas.setVisibility(View.INVISIBLE);
		rlObs.setVisibility(View.VISIBLE);

		btnDatosP.setBackgroundDrawable(null);
		btnPorcenGrasa.setBackgroundDrawable(null);
		btnMedidas.setBackgroundDrawable(null);
		btnObs.setBackgroundResource(R.drawable.boton_seleccion);
	}

	public void showDatepicker(View v) {
		Calendar mcurrentDate = Calendar.getInstance();
		int mYear = mcurrentDate.get(Calendar.YEAR);
		int mMonth = mcurrentDate.get(Calendar.MONTH);
		int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

		DatePickerDialog mDatePicker = new DatePickerDialog(this,
				new OnDateSetListener() {
					public void onDateSet(DatePicker datepicker,
							int selectedyear, int selectedmonth, int selectedday) {
                        anoNacimiento = selectedyear;
						fechaNacimiento = new Date();
                        fechaNacimiento.setYear(selectedyear);
                        fechaNacimiento.setMonth(selectedmonth);
                        fechaNacimiento.setDate(selectedday);
					}
				}, mYear, mMonth, mDay);
		mDatePicker.setTitle("Ingrese la fecha de nacimiento");
		mDatePicker.setCancelable(true);
		mDatePicker.show();
	}

	// Misc. methods
	private void init() {
		txtNombre = (EditText) findViewById(R.id.txtNombreC);
		txtApellido1 = (EditText) findViewById(R.id.txtPrimerApellido);
		txtApellido2 = (EditText) findViewById(R.id.txtSegundoApellido);
		txtCedula = (EditText) findViewById(R.id.txtIdentificacion);
		txtTriceps = (EditText) findViewById(R.id.txtTriceps);
		txtSubes = (EditText) findViewById(R.id.txtSubes);
		txtSupra = (EditText) findViewById(R.id.txtSupra);
		txtAbdominal = (EditText) findViewById(R.id.txtAbdominal);
		txtGastro = (EditText) findViewById(R.id.txtGastro);
		txtPechoH = (EditText) findViewById(R.id.txtPechoH);
		txtPorcenGrasa = (EditText) findViewById(R.id.txtPorcenGrasa);
		txtPorcenMasaMusc = (EditText) findViewById(R.id.txtPorcenMasaMusc);
		txtImc = (EditText) findViewById(R.id.txtImc);
		txtindVice = (EditText) findViewById(R.id.txtIndVice);
		txtKcal = (EditText) findViewById(R.id.txtKcal);
		txtPresion = (EditText) findViewById(R.id.txtPresion);
		txtPulso = (EditText) findViewById(R.id.txtPulso);
		txtGlucosa = (EditText) findViewById(R.id.txtGlucosa);
		txtEstatura = (EditText) findViewById(R.id.txtEstatura);
		txtPeso = (EditText) findViewById(R.id.txtPeso);
		txtPecho = (EditText) findViewById(R.id.txtPecho);
		txtEspalda = (EditText) findViewById(R.id.txtEspalda);
		txtUmbilical = (EditText) findViewById(R.id.txtUmbilical);
		txtCaderas = (EditText) findViewById(R.id.txtCaderas);
		txtMusloDer = (EditText) findViewById(R.id.txtMusloDer);
		txtMusloIzq = (EditText) findViewById(R.id.txtMusloIzq);
		txtBrazoDer = (EditText) findViewById(R.id.txtBrazoDer);
		txtBrazoIzq = (EditText) findViewById(R.id.txtBrazoIzq);
		txtAnteDer = (EditText) findViewById(R.id.txtAnteDer);
		txtAnteIzq = (EditText) findViewById(R.id.txtAnteIzq);
		txtGastroDer = (EditText) findViewById(R.id.txtGastroDer);
		txtGastroIzq = (EditText) findViewById(R.id.txtGastroIzq);
		txtObservaciones = (EditText) findViewById(R.id.txtObservaciones);
		txtMusculo = (EditText) findViewById(R.id.txtMusculo);

		rbMasc = (RadioButton) findViewById(R.id.rbMasculino);
		rbFem = (RadioButton) findViewById(R.id.rbFemenino);
		// fecha nacimiento missing

		btnDatosP = (Button) findViewById(R.id.btnDatosPersonales);
		btnPorcenGrasa = (Button) findViewById(R.id.btnPorcenGrasa);
		btnMedidas = (Button) findViewById(R.id.btnMedidas);
		btnObs = (Button) findViewById(R.id.btnObservaciones);

		// Entrenadores
		lsEntrenadoresC = (ListView) findViewById(R.id.lsEntrenadoresC);
        lblCedulaE = (TextView) findViewById(R.id.lblCedulaEC);
        lblNombreE = (TextView) findViewById(R.id.lblNombreEC);
        lblPrimerApellidoE = (TextView) findViewById(R.id.lblApe1EC);
        lblSegundoApellidoE = (TextView) findViewById(R.id.lblApe2EC);

        new RequestCliente(this).execute("dummy","3");
	}

	// Entrenador converter
	private ArrayList<Entrenador> convertToEntrenador(JSONArray ja,
			ArrayList<Entrenador> arr) throws JSONException {
		for (int i = 0; i < ja.length(); i++) {
			Entrenador c = gson.fromJson(ja.getString(i), Entrenador.class);
			arr.add(c);
		}
		return arr;
	}

	protected void startLoader() {
		pd = ProgressDialog.show(this, "Cargando", "Por favor espere...", true);
	}

	protected void maskAsDone() {
		if (pd != null)
			pd.dismiss();
	}

	private class RequestCliente extends AsyncTask<String, Void, String> {
        private ClienteActivity activity;

        public RequestCliente(ClienteActivity activity) {
            this.activity = activity;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            activity.startLoader();
        }

        @Override
        protected String doInBackground(String... params) {
            switch (params[1]) {
                case "1":
                    ACTION_CODE = 1;
                    return rh.POST(Constantes.GUARDAR_CLIENTE, params[0]);
                case "2":
                    ACTION_CODE = 2;
                    return rh.PUT(Constantes.EDITAR_CLIENTE, params[0]);

                case "3":
                    ACTION_CODE = 3;
                    return rh.GET(Constantes.MOSTRAR_TODOS_ENTRENADORES);

                default:
                    return "";
            }
        }

        @Override
        protected void onPostExecute(String response) {
            activity.maskAsDone();
                switch (ACTION_CODE) {
                    // post clientes
                    case 1:
                        if (response != null ){
                            if(response.equals("")) {
                                Toast.makeText(getApplicationContext(),"Ha ocurrido un error inesperado, asegúrese de que todos los campos estén llenos", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Éxito! Cliente creado satisfactoriamente!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        break;

                    // put clientes
                    case 2:
                        if (response != null ){
                            if(response.equals("")) {
                                Toast.makeText(getApplicationContext(), "Ha ocurrido un error inesperado, asegúrese de que todos los campos estén llenos", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Éxito! Cliente editado satisfactoriamente", Toast.LENGTH_SHORT).show();
                            }
                        }
                        break;

                    // get entrenadores
                    case 3:
                        if (response != null) {
                        ArrayList<Entrenador> arr = new ArrayList<Entrenador>();
                        JSONArray ja = null;
                        try {
                            ja = new JSONArray(response);
                            View header = (View) getLayoutInflater().inflate(R.layout.header, null);
                            lsEntrenadoresC.addHeaderView(header, "", false);
                            lsEntrenadoresC.setAdapter(new ListTrainersAdapter(activity, R.layout.entrenadores_row_layout, convertToEntrenador(ja, arr)));

                            lsEntrenadoresC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    TextView tv = (TextView) view.findViewById(R.id.lblCedulaEC);
                                    TextView nombre = (TextView) view.findViewById(R.id.lblNombreEC);
                                    TextView pApellidot = (TextView) view.findViewById(R.id.lblApe1EC);
                                    TextView sApellidot = (TextView) view.findViewById(R.id.lblApe2EC);

                                    cedulaEntrenador = tv.getText().toString();
                                    nombreEntrenador = nombre.getText().toString();
                                    pApellido = pApellidot.getText().toString();
                                    sApellido = sApellidot.getText().toString();

                                    Toast.makeText(getApplicationContext(), "Entrenador seleccionado: "+nombreEntrenador, Toast.LENGTH_LONG).show();
                                }
                            });

                        } catch (Exception e) {
                            e.printStackTrace();
                        }}
                        else {
                            Toast.makeText(getApplicationContext(), "No hay entrenadores registrados aun...", Toast.LENGTH_SHORT).show();
                        }
                        break;
            }
        }
    }

    //adapter para los entrenadores
    private class ListTrainersAdapter extends ArrayAdapter<Entrenador> {
        private Context context;
        private int resource;
        private ArrayList<Entrenador> objects;

        public ListTrainersAdapter(Context context, int resource, ArrayList<Entrenador> objects) {
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
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(resource, parent, false);

                holder = new EntrenadorHolder();
                holder.lblApe1EC = (TextView) row.findViewById(R.id.lblApe1EC);
                holder.lblApe2EC = (TextView) row.findViewById(R.id.lblApe2EC);
                holder.lblCedulaEC = (TextView) row.findViewById(R.id.lblCedulaEC);
                holder.lblNombreEC = (TextView) row.findViewById(R.id.lblNombreEC);

                row.setTag(holder);
            } else {
                holder = (EntrenadorHolder) row.getTag();
            }

            Entrenador c = objects.get(position);
            holder.lblCedulaEC.setText("" + c.getCedula().toString());
            holder.lblApe2EC.setText(c.getSegundoApellido());
            holder.lblApe1EC.setText(c.getPrimerApellido());
            holder.lblNombreEC.setText(c.getNombre());

            return row;
        }

        private class EntrenadorHolder {
            TextView lblCedulaEC;
            TextView lblNombreEC;
            TextView lblApe1EC;
            TextView lblApe2EC;
        }
    }
}