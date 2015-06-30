package com.ice1155.UI;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.json.JSONArray;
import org.json.JSONException;
import org.w3c.dom.Text;

import com.google.gson.Gson;
import com.ice1155.BL.ListEntrenadoresAdapter;
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
import android.widget.AdapterView.OnItemClickListener;
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

	// Botones
	private Button btnDatosP;
	private Button btnPorcenGrasa;
	private Button btnMedidas;
	private Button btnObs;

	// fecha nacimiento missing
	private EditText txtObservaciones;
	private String cedulaEntrenador;
	private RadioButton rbMasc;
	private RadioButton rbFem;
	private ProgressDialog pd;

	// Definidor de post execute
	private int ACTION_CODE = 0;

	// Edad
	private int anoNacimiento;
	private int mesNacimiento;
	private int diaNacimiento;
	private Date fechaNacimiento;

	// Lista de entrenadores
	private ListView lsEntrenadoresC;
	private ArrayList<Entrenador> arr;
	public Entrenador _e;

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
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), R.string.err_unexp,
					Toast.LENGTH_LONG).show();
			e.printStackTrace();
			finish();
		}
	}

	// Button methods
	public void guardar(View v) {
		Entrenador e = new Entrenador();
		// e.setCedula(cedulaEntrenador);

		Calendar cl = new GregorianCalendar();
		cl.set(Calendar.HOUR_OF_DAY, 0);
		cl.set(Calendar.MINUTE, 0);
		cl.set(Calendar.SECOND, 0);

		int edad = Calendar.YEAR - anoNacimiento;

		Date d = cl.getTime();

		boolean sexo = true;
		if (rbMasc.isSelected())
			sexo = true;
		else if (rbFem.isSelected())
			sexo = false;
		try {
			Cliente c = new Cliente(Long.parseLong(txtCedula.getText()
					.toString()), e, txtApellido1.getText().toString(),
					txtApellido2.getText().toString(), txtNombre.getText()
							.toString(), d, fechaNacimiento, edad, sexo,
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
					Double.parseDouble(txtPulso.getText().toString()),
					Double.parseDouble(txtGlucosa.getText().toString()),
					Double.parseDouble(txtMusculo.getText().toString()),
					txtObservaciones.getText().toString());

			String json = gson.toJson(c);
			rc.execute(json, "1");
		} catch (Exception ex) {
			ex.printStackTrace();
			Toast.makeText(getApplicationContext(), R.string.err_unexp,
					Toast.LENGTH_LONG).show();
			finish();
		}
	}

	public void modificar(View v) {

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
						mesNacimiento = selectedmonth;
						diaNacimiento = selectedday;
						fechaNacimiento = new Date(anoNacimiento, mesNacimiento, diaNacimiento);
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
			Entrenador c = gson.fromJson(ja.getString(1), Entrenador.class);
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
				return rh.PUT(Constantes.GUARDAR_CLIENTE, params[0]);

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
			if (response.equals("")) {
				switch (ACTION_CODE) {
				// post clientes
				case 1:

					break;

				// put clientes
				case 2:

					break;

                // get entrenadores
				case 3:
                    ArrayList<Entrenador> arr = new ArrayList<Entrenador>();
                    JSONArray ja = null;
                    try {
                        ja = new JSONArray(response);
                        View header = (View) getLayoutInflater().inflate(R.layout.header, null);
                        lsEntrenadoresC.addHeaderView(header, "", false);
                        lsEntrenadoresC.setAdapter(new ListTrainersAdapter(getApplicationContext(), R.layout.entrenadores_row_layout, convertToEntrenador(ja, arr)));

                        lsEntrenadoresC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                TextView cedula = (TextView) view.findViewById(R.id.lblCedulaEC);
                                TextView nombre = (TextView) view.findViewById(R.id.lblNombreEC);
                                TextView pApe = (TextView) view.findViewById(R.id.lblApe1EC);
                                TextView sApe = (TextView) view.findViewById(R.id.lblApe2EC);

                                lblCedulaE.setText(cedula.getText().toString());
                                lblNombreE.setText(nombre.getText().toString());
                                lblPrimerApellidoE.setText(pApe.getText().toString());
                                lblSegundoApellidoE.setText(sApe.getText().toString());
                            }
                        });

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
					break;
				// error
				default:
					Toast.makeText(activity, R.string.err_unexp,
							Toast.LENGTH_LONG).show();
					finish();
					break;
				}
			} else {
				if (ACTION_CODE == 3) {
					arr = new ArrayList<Entrenador>();
					try {
						JSONArray ja = new JSONArray(response);
						convertToEntrenador(ja, arr);

						ListTrainersAdapter adapter = new ListTrainersAdapter(
								activity.getApplicationContext(),
								R.layout.entrenadores_row_layout, arr);

						lsEntrenadoresC = (ListView) findViewById(R.id.lsEntrenadoresC);
						lsEntrenadoresC.setAdapter(adapter);
						lsEntrenadoresC
								.setOnItemClickListener(new OnItemClickListener() {
									@Override
									public void onItemClick(
											AdapterView<?> parent, View view,
											int position, long id) {
										view.setSelected(true);
										TextView lblCedulaEC = (TextView) findViewById(R.id.lblCedulaEC);
										cedulaEntrenador = lblCedulaEC
												.getText().toString();
									}
								});

					} catch (Exception e) {
						e.printStackTrace();
					}
					activity.maskAsDone();
				} else {
					Toast.makeText(activity,
							"No hay entrenadores registrados...",
							Toast.LENGTH_LONG).show();
				}
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