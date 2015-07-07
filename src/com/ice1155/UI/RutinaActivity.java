package com.ice1155.UI;

import java.util.ArrayList;
import java.util.List;

import com.ice1155.BL.EntryAdapter;
import com.ice1155.BL.EntryItem;
import com.ice1155.BL.Item;
import com.ice1155.BL.SectionItem;
import com.ice1155.DA.ListaPorZona;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class RutinaActivity extends Activity {
	private ListView expListView;
    private ListView lsRutina;
	private ArrayList<Item> items = new ArrayList<Item>();
	private ListaPorZona lpz;
    private ArrayList<Item> ejercicios = new ArrayList<Item>();

    // dia selector
    private boolean diaUno = false;
    private boolean diaDos = false;
    private boolean diaTres = false;
    private boolean diaCuatro = false;

    // visual components
    private Button btnUno;
    private Button btnDos;
    private Button btnTres;
    private Button btnCuatro;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rutinas);

        try {
            // renderizar las listas
            refreshEjercicios(ejercicios);
            prepareListData(items);

            // Init data
            lsRutina = (ListView) findViewById(R.id.lsRutina);
            expListView = (ListView) findViewById(R.id.elv);
            btnUno = (Button) findViewById(R.id.btnDia1);
            btnDos = (Button) findViewById(R.id.btnDia2);
            btnTres = (Button) findViewById(R.id.btnDia3);
            btnCuatro = (Button) findViewById(R.id.btnDia4);

            // Set headers and data
            EntryAdapter adapter = new EntryAdapter(this, items);
            expListView.setAdapter(adapter);

            EntryAdapter ea = new EntryAdapter(this, ejercicios);
            lsRutina.setAdapter(ea);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	// Custom methods
    private void refreshEjercicios(ArrayList<Item> items) {
        items.add(new SectionItem("Día 1"));
        items.add(new SectionItem("Día 2"));
        items.add(new SectionItem("Día 3"));
        items.add(new SectionItem("Día 4"));
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
		if (diaUno) {

        }
        else if(diaDos) {

        }
        else if (diaTres) {

        }
        else {

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
}