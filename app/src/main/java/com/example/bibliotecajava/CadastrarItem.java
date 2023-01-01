package com.example.bibliotecajava;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class CadastrarItem extends AppCompatActivity {

    TextView tv01, tv02, tv03, tv04;
    EditText ed01, ed02, ed03, ed04;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_item);
        //-------------
        tv01 = findViewById(R.id.tv01);
        tv02 = findViewById(R.id.tv02);
        tv03 = findViewById(R.id.tv03);
        tv04 = findViewById(R.id.tv04);
        //------------
        ed01 = findViewById(R.id.ed01);
        ed02 = findViewById(R.id.ed02);
        ed03 = findViewById(R.id.ed03);
        ed04 = findViewById(R.id.ed04);
        //--------
        //Toast.makeText(CadastrarItem.this, "vc clicou no " + i + " item", Toast.LENGTH_SHORT).show();
        spinner = findViewById(R.id.spinnerRegisterItem);




    }
}