package com.ice1155.UI;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ice1155.DA.Entrenador;
import com.ice1155.UT.Constantes;
import com.ice1155.UT.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EntrenadorActivity extends Activity {
    private EditText txtCedula;
    private EditText txtNombre;
    private EditText txtPrimerApellido;
    private EditText txtSegundoApellido;
    private ProgressBar pb;
    private RequestHandler rh;
    private EntrenadorExecutioner ee;
    private ListView lvEntrenadores;

    // Para post execute
    private int ACTION_CODE = 0;
    private Gson gson = new Gson();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrenadores);

        // Init
        init();
    }

    // Button method
    public void guardar(View v) {
        String cedula = txtCedula.getText().toString();
        String nombre = txtNombre.getText().toString();
        String primerA = txtPrimerApellido.getText().toString();
        String segundoA = txtSegundoApellido.getText().toString();

        if (!cedula.isEmpty()) {
            if (!nombre.isEmpty()) {
                if (!primerA.isEmpty()) {
                    if (!segundoA.isEmpty()) {
                        ACTION_CODE = 1;
                        ee = new EntrenadorExecutioner(this);
                        ee.execute(cedula, nombre, primerA, segundoA);
                    }
                    else {
                        ACTION_CODE = 1;
                        ee = new EntrenadorExecutioner(this);
                        ee.execute(cedula, nombre, primerA, "");
                    }
                } else
                    Toast.makeText(getApplicationContext(),
                            "El primer apellido es obligatorio!",
                            Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(getApplicationContext(),
                        "El nombre es obligatorio!", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(getApplicationContext(),
                    "La cédula es obligatoria!!", Toast.LENGTH_LONG).show();

    }

    public void modificar(View v) {
        String cedula = txtCedula.getText().toString();
        String nombre = txtNombre.getText().toString();
        String primerA = txtPrimerApellido.getText().toString();
        String segundoA = txtSegundoApellido.getText().toString();

        if (!cedula.isEmpty()) {
            if (!nombre.isEmpty()) {
                if (!primerA.isEmpty()) {
                    ee = new EntrenadorExecutioner(this);
                    ee.execute(cedula, nombre, primerA, segundoA);
                    ACTION_CODE = 3;
                } else
                    Toast.makeText(getApplicationContext(),
                            "El primer apellido es obligatorio!",
                            Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(getApplicationContext(),
                        "El nombre es obligatorio!", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(getApplicationContext(),
                    "La cédula es obligatoria!!", Toast.LENGTH_LONG).show();

    }

    // Misc methods
    public void startLoader() {
        pb.setVisibility(View.VISIBLE);
        Toast.makeText(getApplicationContext(),
                "Cargando, por favor espere...", Toast.LENGTH_LONG).show();
    }

    public void markAsDone() {
        pb.setVisibility(View.INVISIBLE);
    }

    // Misc methods
    private void init() {
        txtCedula = (EditText) findViewById(R.id.txtCedulaEntrenador);
        txtNombre = (EditText) findViewById(R.id.txtNombreE);
        txtPrimerApellido = (EditText) findViewById(R.id.txtPrimerApellidoE);
        txtSegundoApellido = (EditText) findViewById(R.id.txtSegundoApellidoE);
        pb = (ProgressBar) findViewById(R.id.pbEntrenador);
        lvEntrenadores = (ListView) findViewById(R.id.lsEntrenadores);

        rh = new RequestHandler();

        loadTrainers();
    }

    private void loadTrainers() {
        ACTION_CODE = 2;
        ee = new EntrenadorExecutioner(this);
        EntrenadorExecutioner ee2 = new EntrenadorExecutioner(this);
        ee2.execute("dummy");
    }

    // Entrenador converter
    private ArrayList<Entrenador> convertToEntrenador(JSONArray ja, ArrayList<Entrenador> arr)
            throws JSONException {
        for (int i = 0; i < ja.length(); i++) {
            Entrenador c = gson.fromJson(ja.getString(i), Entrenador.class);
            arr.add(c);
        }
        return arr;
    }

    private class EntrenadorExecutioner extends AsyncTask<String, Void, String> {
        private EntrenadorActivity activity = null;

        public EntrenadorExecutioner(EntrenadorActivity activity) {
            attach(activity);
        }

        private void attach(EntrenadorActivity activity) {
            this.activity = activity;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            activity.startLoader();
        }

        @Override
        protected String doInBackground(String... params) {
            switch (ACTION_CODE) {
                case 1:
                    JSONObject json = new JSONObject();
                    try {
                        json.accumulate("cedula", params[0]);
                        json.accumulate("nombre", params[1]);
                        json.accumulate("primerApellido", params[2]);
                        json.accumulate("segundoApellido", params[3]);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return rh.POST(Constantes.GUARDAR_ENTRENADOR, json.toString());

                case 2:
                    return rh.GET(Constantes.MOSTRAR_TODOS_ENTRENADORES);

                case 3:
                    JSONObject jsonPut = new JSONObject();
                    try {
                        jsonPut.accumulate("cedula", params[0]);
                        jsonPut.accumulate("nombre", params[1]);
                        jsonPut.accumulate("primerApellido", params[2]);
                        jsonPut.accumulate("segundoApellido", params[3]);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return rh.PUT(Constantes.EDITAR_ENTRENADOR, jsonPut.toString());

                default:
                    Toast.makeText(getApplicationContext(), "Ha ocurrido un error inesperado...", Toast.LENGTH_SHORT).show();
                    return "ERROR";
            }
        }

        @Override
        protected void onPostExecute(String response) {
            activity.markAsDone();
            if (!response.equals("")) {
                switch (ACTION_CODE) {
                    //post
                    case 1:
                        markAsDone();
                        //loadTrainers();
                        Toast.makeText(getApplicationContext(), "Entrenador creado con éxito!", Toast.LENGTH_SHORT).show();
                        break;

                    //get
                    case 2:
                        ArrayList<Entrenador> arr = new ArrayList<Entrenador>();
                        JSONArray ja = null;
                        try {
                            ja = new JSONArray(response);
                            View header = (View) getLayoutInflater().inflate(R.layout.header, null);
                            lvEntrenadores.addHeaderView(header, "", false);
                            lvEntrenadores.setAdapter(new ListTrainersAdapter(activity, R.layout.entrenadores_row_layout, convertToEntrenador(ja, arr)));

                            lvEntrenadores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    TextView cedula = (TextView) view.findViewById(R.id.lblCedulaEC);
                                    TextView nombre = (TextView) view.findViewById(R.id.lblNombreEC);
                                    TextView pApe = (TextView) view.findViewById(R.id.lblApe1EC);
                                    TextView sApe = (TextView) view.findViewById(R.id.lblApe2EC);

                                    txtCedula.setText(cedula.getText().toString());
                                    txtNombre.setText(nombre.getText().toString());
                                    txtPrimerApellido.setText(pApe.getText().toString());
                                    txtSegundoApellido.setText(sApe.getText().toString());
                                }
                            });

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        break;

                    //put
                    case 3:
                        markAsDone();
                        //loadTrainers();
                        Toast.makeText(getApplicationContext(), "Entrenador editado con éxito!", Toast.LENGTH_SHORT).show();
                        break;

                }
            } else
                Toast.makeText(getApplicationContext(),
                        getString(R.string.err_unexp), Toast.LENGTH_LONG)
                        .show();
        }
    }

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
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
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