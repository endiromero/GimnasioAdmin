package com.ice1155.UI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.google.gson.Gson;
import com.ice1155.BL.EntryAdapter;
import com.ice1155.BL.EntryItem;
import com.ice1155.BL.Item;
import com.ice1155.BL.SectionItem;
import com.ice1155.DA.Dia;
import com.ice1155.DA.Ejercicio;
import com.ice1155.DA.ListaPorZona;
import com.ice1155.DA.Rutina;
import com.ice1155.UT.Constantes;
import com.ice1155.UT.RequestHandler;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class RutinaActivity extends Activity {
    private Gson gson = new Gson();

	private ListView expListView;
    private ListView lsRutina;
	private ArrayList<Item> items = new ArrayList<Item>();
	private ListaPorZona lpz;
    private ArrayList<Item> ejercicios = new ArrayList<Item>();

    // request handler
    private RequestHandler rh = new RequestHandler();
    private RutinaHandler handler;

    // dia selector
    private boolean diaUno = false;
    private boolean diaDos = false;
    private boolean diaTres = false;
    private boolean diaCuatro = false;

    // dias
    private ArrayList<EntryItem> dia1 = new ArrayList<EntryItem>();
    private ArrayList<EntryItem> dia2 = new ArrayList<EntryItem>();
    private ArrayList<EntryItem> dia3 = new ArrayList<EntryItem>();
    private ArrayList<EntryItem> dia4 = new ArrayList<EntryItem>();
    private String ejercicio = "";
    private String descripcion = "";

    // id asociado
    private long idAsociado;

    // visual components
    private Button btnUno;
    private Button btnDos;
    private Button btnTres;
    private Button btnCuatro;
    private ProgressBar pbRutina;
    // common routine data
    private EditText txtObjetivo;
    private EditText txtRepeticiones;
    private TextView lblNoRutina;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rutinas);

        try {
            // perfil asociado
            idAsociado = getIntent().getLongExtra("carne", 0);

            // renderizar las listas
            prepareListData(items);

            // Init data
            lsRutina = (ListView) findViewById(R.id.lsRutina);
            expListView = (ListView) findViewById(R.id.elv);
            btnUno = (Button) findViewById(R.id.btnDia1);
            btnDos = (Button) findViewById(R.id.btnDia2);
            btnTres = (Button) findViewById(R.id.btnDia3);
            btnCuatro = (Button) findViewById(R.id.btnDia4);
            txtObjetivo = (EditText) findViewById(R.id.txtObjetivo);
            txtRepeticiones = (EditText) findViewById(R.id.txtRepeticiones);
            lblNoRutina = (TextView) findViewById(R.id.lblNoRutina);
            pbRutina = (ProgressBar) findViewById(R.id.pbRutina);

            // Set headers and data
            EntryAdapter adapter = new EntryAdapter(this, items);
            expListView.setAdapter(adapter);
            expListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (!diaUno && !diaDos && !diaTres && !diaCuatro)
                        Toast.makeText(getApplicationContext(), "Seleccione un día", Toast.LENGTH_SHORT).show();

                    else {
                        TextView tv = (TextView) view.findViewById(R.id.list_item_entry_title);
                        ejercicio = tv.getText().toString();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	// Custom methods
    private void refreshEjercicios (ArrayList<EntryItem> dia1, ArrayList<EntryItem> dia2, ArrayList<EntryItem> dia3,
                                    ArrayList<EntryItem> dia4) {
        lsRutina.setAdapter(null);

        ejercicios.add(new SectionItem("Día 1"));
        for (int i = 0; i < dia1.size(); i++) {
            ejercicios.add(dia1.get(i));
        }

        ejercicios.add(new SectionItem("Día 2"));
        for (int i = 0; i < dia2.size(); i++) {
            ejercicios.add(dia2.get(i));
        }

        ejercicios.add(new SectionItem("Día 3"));
        for (int i = 0; i < dia3.size(); i++) {
            ejercicios.add(dia3.get(i));
        }

        ejercicios.add(new SectionItem("Día 4"));
        for (int i = 0; i < dia4.size(); i++) {
            ejercicios.add(dia4.get(i));
        }

        EntryAdapter ea = new EntryAdapter(this, ejercicios);
        lsRutina.setAdapter(ea);
    }

	private void prepareListData(ArrayList<Item> items) {
		lpz = new ListaPorZona();

		items.add(new SectionItem("ABDOMEN"));
		for (int i = 0; i < lpz.getListAbdomen().length; i++) {
			String name = lpz.getListAbdomen()[i].getItemId() + ". "
					+ lpz.getListAbdomen()[i].getItemName();
			items.add(new EntryItem(name, ""));
		}
		
		items.add(new SectionItem("PIERNAS"));
		for (int i = 0; i < lpz.getListPierna().length; i++) {
			String name = lpz.getListPierna()[i].getItemId() + ". "
					+ lpz.getListPierna()[i].getItemName();
			items.add(new EntryItem(name, ""));
		}
		
		items.add(new SectionItem("GEMELOS"));
		for (int i = 0; i < lpz.getListGemelos().length; i++) {
			String name = lpz.getListGemelos()[i].getItemId() + ". "
					+ lpz.getListGemelos()[i].getItemName();
			items.add(new EntryItem(name, ""));
		}
		
		items.add(new SectionItem("PECTORALES"));
		for (int i = 0; i < lpz.getListPectorales().length; i++) {
			String name = lpz.getListPectorales()[i].getItemId() + ". "
					+ lpz.getListPectorales()[i].getItemName();
			items.add(new EntryItem(name, ""));
		}
		
		items.add(new SectionItem("ESPALDA"));
		for (int i = 0; i < lpz.getListEspalda().length; i++) {
			String name = lpz.getListEspalda()[i].getItemId() + ". "
					+ lpz.getListEspalda()[i].getItemName();
			items.add(new EntryItem(name, ""));
		}
		
		items.add(new SectionItem("DELTOIDES"));
		for (int i = 0; i < lpz.getListDeltoides().length; i++) {
			String name = lpz.getListDeltoides()[i].getItemId() + ". "
					+ lpz.getListDeltoides()[i].getItemName();
			items.add(new EntryItem(name, ""));
		}
		
		items.add(new SectionItem("TRICEPS"));
		for (int i = 0; i < lpz.getListTriceps().length; i++) {
			String name = lpz.getListTriceps()[i].getItemId() + ". "
					+ lpz.getListTriceps()[i].getItemName();
			items.add(new EntryItem(name,""));
		}
		
		items.add(new SectionItem("BICEPS"));
		for (int i = 0; i < lpz.getListBiceps().length; i++) {
			String name = lpz.getListBiceps()[i].getItemId() + ". "
					+ lpz.getListBiceps()[i].getItemName();
			items.add(new EntryItem(name,""));
		}
		
		items.add(new SectionItem("ANTEBRAZO"));
		for (int i = 0; i < lpz.getListAntebrazo().length; i++) {
			String name = lpz.getListAntebrazo()[i].getItemId() + ". "
					+ lpz.getListAntebrazo()[i].getItemName();
			items.add(new EntryItem(name, ""));
		}
	}
	
	// Button methods
	public void agregarEjercicio(View v) {
        if (!diaUno && !diaDos && !diaTres && !diaCuatro)
            Toast.makeText(getApplicationContext(), "Seleccione un día", Toast.LENGTH_SHORT).show();

        else {
            lblNoRutina.setVisibility(View.INVISIBLE);
            /*if (dia1 != null || dia2 != null || dia3 != null || dia4 != null) {
                dia1 = new ArrayList<String>();
                dia2 = new ArrayList<String>();
                dia3 = new ArrayList<String>();
                dia4 = new ArrayList<String>();
            }*/

            if (diaUno) {
                if(!txtRepeticiones.getText().toString().equals("")) {
                    dia1.add(new EntryItem(ejercicio, descripcion));
                    refreshEjercicios(dia1, dia2, dia3, dia4);
                }
                else
                    Toast.makeText(getApplicationContext(), "La descripción o repeticiones son obligatorias",
                            Toast.LENGTH_SHORT).show();


            } else if (diaDos) {
                if(!txtRepeticiones.getText().toString().equals("")) {
                    dia2.add(new EntryItem(ejercicio, descripcion));
                    refreshEjercicios(dia1, dia2, dia3, dia4);
                }
                else
                    Toast.makeText(getApplicationContext(), "La descripción o repeticiones son obligatorias",
                            Toast.LENGTH_SHORT).show();

            } else if (diaTres) {
                if(!txtRepeticiones.getText().toString().equals("")) {
                    dia3.add(new EntryItem(ejercicio, descripcion));
                    refreshEjercicios(dia1, dia2, dia3, dia4);
                }
                else
                    Toast.makeText(getApplicationContext(), "La descripción o repeticiones son obligatorias",
                            Toast.LENGTH_SHORT).show();

            } else {
                if(!txtRepeticiones.getText().toString().equals("")) {
                    dia4.add(new EntryItem(ejercicio, descripcion));
                    refreshEjercicios(dia1, dia2, dia3, dia4);
                }
                else
                    Toast.makeText(getApplicationContext(), "La descripción o repeticiones son obligatorias",
                            Toast.LENGTH_SHORT).show();
            }
        }
	}

    public void crearRutina(View v) {
        if (txtObjetivo.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "El objetivo es necesario para crear la rutina",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            if (!dia1.isEmpty() || !dia2.isEmpty() || !dia3.isEmpty() || !dia4.isEmpty()) {
                handler = new RutinaHandler();

                String objetivo = txtObjetivo.getText().toString();

                // fecha de realizacion de la rutina
                Calendar cl = new GregorianCalendar();
                cl.set(Calendar.HOUR_OF_DAY, 0);
                cl.set(Calendar.MINUTE, 0);
                cl.set(Calendar.SECOND, 0);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
                String fechaString = sdf.format(cl.getTime());

                // dias de la rutina
                ArrayList<Dia> dias = new ArrayList<Dia>();

                ArrayList<Ejercicio> diaUnoE = new ArrayList<Ejercicio>();
                for (int i = 0; i < dia1.size(); i++) {
                    String[] id_nombre = dia1.get(i).title.split("\\.");

                    String[] descripcionO = new String[0];
                    descripcionO[0] = dia2.get(i).subtitle;

                    Ejercicio e = new Ejercicio(descripcionO, id_nombre[0], id_nombre[1]);
                    diaUnoE.add(e);
                }
                dias.add(new Dia(1,diaUnoE));

                if (!dia2.isEmpty()) {
                    ArrayList<Ejercicio> diaDosE = new ArrayList<Ejercicio>();
                    for (int i = 0; i < dia2.size(); i++) {
                        String[] id_nombre = dia2.get(i).title.split("\\.");
                        String idHoja = id_nombre[0].replace(".", "");

                        String[] descripcionO = new String[dia2.get(i).subtitle.length()];
                        descripcionO[0] = dia2.get(i).subtitle;

                        Ejercicio e = new Ejercicio(descripcionO, idHoja, id_nombre[1]);
                        diaUnoE.add(e);
                    }
                    dias.add(new Dia(2,diaDosE));
                }

                if (!dia3.isEmpty()) {
                    ArrayList<Ejercicio> diaTresE = new ArrayList<Ejercicio>();
                    for (int i = 0; i < dia3.size(); i++) {
                        String[] id_nombre = dia3.get(i).title.split("\\.");

                        String[] descripcionO = new String[dia2.get(i).subtitle.length()];
                        descripcionO[0] = dia2.get(i).subtitle;

                        Ejercicio e = new Ejercicio(descripcionO, id_nombre[0], id_nombre[1]);
                        diaUnoE.add(e);
                    }
                    dias.add(new Dia(3,diaTresE));
                }

                if (!dia4.isEmpty()) {
                    ArrayList<Ejercicio> diaCuatroE = new ArrayList<Ejercicio>();
                    for (int i = 0; i < dia4.size(); i++) {
                        String[] id_nombre = dia1.get(i).title.split("\\.");

                        String[] descripcionO = new String[dia2.get(i).subtitle.length()];
                        descripcionO[0] = dia2.get(i).subtitle;

                        Ejercicio e = new Ejercicio(descripcionO, id_nombre[0], id_nombre[1]);
                        diaUnoE.add(e);
                    }
                    dias.add(new Dia(4,diaCuatroE));
                }

                Rutina r = new Rutina(objetivo, "", fechaString, dias);
                String json = gson.toJson(r);

                String aDividir = json.toString();

                char[] arreglo = aDividir.toCharArray();
                arreglo[aDividir.length()-1] = ',';

                String dividido = new String(arreglo);

                String test = dividido +'"'+"perfilAsociado"+'"'+":{"+idAsociado+"}}";

                new RutinaHandler().execute(test);
            }
            else {
                Toast.makeText(getApplicationContext(), "Es necesario al menos un día de ejercicios para crear la rutina",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void diaUno(View v) {
        diaUno = true;
        diaDos = false;
        diaTres = false;
        diaCuatro = false;

        //cambiar icono
        btnUno.setBackgroundResource(R.drawable.boton_dia_1_2);
        btnDos.setBackgroundResource(R.drawable.boton_dia_2);
        btnTres.setBackgroundResource(R.drawable.boton_dia_3);
        btnCuatro.setBackgroundResource(R.drawable.boton_dia_4);
    }

    public void diaDos(View v) {
        diaUno = false;
        diaDos = true;
        diaTres = false;
        diaCuatro = false;

        //cambiar icono
        btnUno.setBackgroundResource(R.drawable.boton_dia_1);
        btnDos.setBackgroundResource(R.drawable.boton_dia_2_2);
        btnTres.setBackgroundResource(R.drawable.boton_dia_3);
        btnCuatro.setBackgroundResource(R.drawable.boton_dia_4);
    }

    public void diaTres(View v) {
        diaUno = false;
        diaDos = false;
        diaTres = true;
        diaCuatro = false;

        //cambiar icono
        btnUno.setBackgroundResource(R.drawable.boton_dia_1);
        btnDos.setBackgroundResource(R.drawable.boton_dia_2);
        btnTres.setBackgroundResource(R.drawable.boton_dia_3_2);
        btnCuatro.setBackgroundResource(R.drawable.boton_dia_4);
    }

    public void diaCuatro(View v) {
        diaUno = false;
        diaDos = false;
        diaTres = false;
        diaCuatro = true;

        //cambiar icono
        btnUno.setBackgroundResource(R.drawable.boton_dia_1);
        btnDos.setBackgroundResource(R.drawable.boton_dia_2);
        btnTres.setBackgroundResource(R.drawable.boton_dia_3);
        btnCuatro.setBackgroundResource(R.drawable.boton_dia_4_2);
    }

    private void startLoader() {
        pbRutina.setVisibility(View.VISIBLE);
        Toast.makeText(getApplicationContext(), "Guardando rutina, por favor espere...", Toast.LENGTH_SHORT).show();
    }

    private void markAsDone() {
        pbRutina.setVisibility(View.INVISIBLE);
    }

    // Asynctask para la creacion de la rutina
    private class RutinaHandler extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            startLoader();
        }

        @Override
        protected String doInBackground(String... params) {
            return rh.POST(Constantes.GUARDAR_RUTINA, params[0]);
        }

        @Override
        protected void onPostExecute(String response) {
            markAsDone();
            if(response != null) {
                if (!response.equals("")) {

                }
                else {
                    Toast.makeText(getApplicationContext(), "Ha ocurrido un error inesperado, asegúrese de que los campos necesarios estén llenos...", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}