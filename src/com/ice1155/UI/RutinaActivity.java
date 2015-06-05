package com.ice1155.UI;

import java.util.ArrayList;

import com.ice1155.BL.EntryAdapter;
import com.ice1155.BL.EntryItem;
import com.ice1155.BL.Item;
import com.ice1155.BL.SectionItem;
import com.ice1155.DA.ListaPorZona;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class RutinaActivity extends Activity {
	private ListView expListView;
	private ArrayList<Item> items = new ArrayList<Item>();
	private ListaPorZona lpz;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rutinas);
		
		prepareListData(items);
		// Init data
		expListView = (ListView) findViewById(R.id.elv);
				
		// Set headers and data
		EntryAdapter adapter = new EntryAdapter(this, items);
		expListView.setAdapter(adapter);
		
	}

	// Custom methods
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
		
	}
	
}