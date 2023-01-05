package com.example.bibliotecajava;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

//--------
public class AddItem extends AppCompatActivity {

    TextView tv01, tv02, tv03, tv04, tvIdentifier;
    EditText ed01, ed02, ed03, ed04;
    Spinner spinner;
    Button btn;
    //--------------
    ArrayList<EditText> arrayListED = new ArrayList<>();
    ArrayList<TextView> arrayListTV = new ArrayList<>();
    int selecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_item);
        //-------------
        tv01 = findViewById(R.id.tv01);
        tv02 = findViewById(R.id.tv02);
        tv03 = findViewById(R.id.tv03);
        tv04 = findViewById(R.id.tv04);
        tvIdentifier = findViewById(R.id.tvIdentifier);
        //------------
        ed01 = findViewById(R.id.ed01);
        ed02 = findViewById(R.id.ed02);
        ed03 = findViewById(R.id.ed03);
        ed04 = findViewById(R.id.ed04);
        spinner = findViewById(R.id.spinnerRegisterItem);
        btn = findViewById(R.id.btnAdicionarNaBiblioteca);
        //--------
        arrayListED.add(ed01);
        arrayListED.add(ed02);
        arrayListED.add(ed03);
        arrayListED.add(ed04);
        arrayListTV.add(tv01);
        arrayListTV.add(tv02);
        arrayListTV.add(tv03);
        arrayListTV.add(tv04);
        //--------
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                defineTexts(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //-------
        btn.setOnClickListener(view ->{
            if (verificarConteudio()){
                DataBase dataBase = new DataBase(getApplicationContext());
                Item item = new Item();
                item.setContext(getApplicationContext());
                item.setType(item.getItemList()[selecionado]);
                item.setItemValues(ed01.getText().toString(),ed02.getText().toString(),ed03.getText().toString(),ed04.getText().toString());
                //if (dataBase.updateDataBase() == -1){}
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                if (dataBase.updateDataBase(item) == -1){
                    setResult(RESULT_CANCELED, intent);
                }
                else{
                    setResult(RESULT_OK, intent);
                }
                onBackPressed();
            }
            else{
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void defineTexts(int itemListSelected){
        selecionado = itemListSelected;
        Item item = new Item();
        switch (itemListSelected) {
            case 0: //book
                tvIdentifier.setText(item.getItemList()[0]);
                for (int i = 0; i < 4; i++) {
                    arrayListTV.get(i).setText(item.getBookList()[i]);
                }
                break;
            case 1: // Magazine
                tvIdentifier.setText(item.getItemList()[1]);
                for (int i = 0; i < 4; i++) {
                    arrayListTV.get(i).setText(item.getMagazineList()[i]);
                }
                break;
            case 2: // CD
                tvIdentifier.setText(item.getItemList()[2]);
                for (int i = 0; i < 4; i++) {
                    arrayListTV.get(i).setText(item.getCdList()[i]);
                }
                break;
            case 3: // pokemon
                tvIdentifier.setText(item.getItemList()[3]);
                for (int i = 0; i < 4; i++) {
                    arrayListTV.get(i).setText(item.getPokeList()[i]);
                }
                break;
        }
    }

    private boolean verificarConteudio(){
        boolean verificar = true;
        for (int i = 0; i < arrayListED.size(); i++) {
            if (arrayListED.get(i).getText().toString().isEmpty()){
                verificar = false;
                break;
            }
        }
        return verificar;
    }
}