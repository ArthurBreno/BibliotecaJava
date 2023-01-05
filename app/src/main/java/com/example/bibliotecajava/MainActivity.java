package com.example.bibliotecajava;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> activityResultLauncher;
    RecyclerView recyclerView;

    TextView tvLibrary;
    LinearLayout layout;
    Button button;
    ArrayList<Integer> listaId = new ArrayList<>();
    ArrayList<String> listaData = new ArrayList<>();
    ArrayList<String> listaPara01 = new ArrayList<>();
    ArrayList<String> listaPara02 = new ArrayList<>();
    ArrayList<String> listaPara03 = new ArrayList<>();
    ArrayList<String> listaPara04 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //---------
        button = findViewById(R.id.btnCriarCoisa);
        recyclerView = findViewById(R.id.view);
        restartActivity();


        button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AddItem.class);
            activityResultLauncher.launch(intent);
        });
        //tvLibrary = findViewById(R.id.tvLibrary);
        //layout = findViewById(R.id.linerLayout);



    }
    private void restartActivity(){
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result != null){
                    if (result.getResultCode() == RESULT_CANCELED){
                        Toast.makeText(MainActivity.this, "FALHA AO ATUALIZAR BIBLIOTECA", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "SUCESSO", Toast.LENGTH_SHORT).show();
                    }
                }
                armazenarEmVetor();
            }
        });

    }
    private void armazenarEmVetor(){
        DataBase dataBase = new DataBase(getApplicationContext());
        Cursor cursor = dataBase.recuperarDados();
        if (cursor.getCount() == 0){
            Toast.makeText(MainActivity.this, "NO DATA", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                listaId.add(cursor.getInt(0));
                listaData.add(cursor.getString(1));
                listaPara01.add(cursor.getString(2));
                listaPara02.add(cursor.getString(3));
                listaPara03.add(cursor.getString(4));
                listaPara04.add(cursor.getString(5));
            }
            Toast.makeText(MainActivity.this, "FIM", Toast.LENGTH_SHORT).show();

        }
    }
}