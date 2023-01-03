package com.example.bibliotecajava;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
//--------

public class AddItem extends AppCompatActivity {

    TextView tv01, tv02, tv03, tv04, tvIdentifier;
    EditText ed01, ed02, ed03, ed04;
    Spinner spinner;
    ArrayList<EditText> arrayListED = new ArrayList<>();
    ArrayList<TextView> arrayListTV = new ArrayList<>();


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
                Toast.makeText(AddItem.this, "vc clicou no " + i + " item", Toast.LENGTH_SHORT).show();
                defineTexts(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }
    private void defineTexts(int itemListSelected){
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
}