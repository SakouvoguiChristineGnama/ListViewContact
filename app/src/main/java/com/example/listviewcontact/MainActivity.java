package com.example.listviewcontact;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  // Les attributs
       ListView listView;
       Button btnajout,btnmodifier,btnsupprimer;
       EditText name;
       ArrayList<String> nameList = new ArrayList<String>();
       ArrayAdapter ListAdapter;
       Integer indexValue;
       String item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        btnajout = findViewById(R.id.ajouter);
        btnmodifier = findViewById(R.id.modifier);
        btnsupprimer = findViewById(R.id.supprimer);
        name = findViewById(R.id.inputName);

        //Selectionner les nameList

        nameList.add("Ham");
        nameList.add("Bread");
        nameList.add("merci");
        nameList.add("Guinee");

        ListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, nameList);
        listView.setAdapter(ListAdapter);

        // Methode Ajouter

        btnajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = name.getText().toString();
                nameList.add(value);
                ListAdapter.notifyDataSetChanged();
                name.setText("");
            }
        });

        // selectionner les namelist modifier
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString() + " a ete selectionne";
                indexValue = i;
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();

            }
        });
        //Mehode Modifier
        btnmodifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = name.getText().toString();
                nameList.set(indexValue, value);
                ListAdapter.notifyDataSetChanged();
            }
        });

        //selectionner les namelist supprimer
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString() + " a ete supprime";
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
                nameList.remove(i);
                ListAdapter.notifyDataSetChanged();
                return true;
            }
        });


    }

}