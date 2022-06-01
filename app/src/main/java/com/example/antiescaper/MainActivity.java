package com.example.antiescaper;
//
//
//
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText chislo;
    EditText osn1;
    EditText osn2;
    TextView res;
    String pass_1;
    String pass_2="";
    private final static String FILE_pass = "pass.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chislo = findViewById(R.id.c1);
        osn1 = findViewById(R.id.c2);
        osn2 = findViewById(R.id.c3);
        res = findViewById(R.id.c4);
        pass_1 = getResources().getString(R.string.password_developer);
        FileInputStream fin = null;
        try {
            fin = openFileInput(FILE_pass);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String (bytes);
            pass_2=text;
        }
        catch(IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }   
        Toast first = Toast.makeText
                (this,
                        "Привет, введи адрес своей почты и поставь пароль для дайнейшего использования доп. функций",
                        Toast.LENGTH_LONG);

        if(pass_2.isEmpty())
        {
            Intent intent = new Intent(this, Second.class);
            startActivity(intent);
            first.show();
        }

        startService(new Intent(this, MyService.class));

    }
    /*@Override
    protected void onResume ()
    {

    }*/

    public void solve (View view){
        Toast toast = Toast.makeText(this,"Error", Toast.LENGTH_SHORT);
        Entrance enter = new Entrance();
        int osn_1 = Integer.parseInt(osn1.getText().toString());
        int osn_2 = Integer.parseInt(osn2.getText().toString());
        String stroka = chislo.getText().toString();
        Solve task = new Solve(stroka,osn_1,osn_2);
        if (!task.provekaosn(osn_1)||!task.provekaosn(osn_2)||!task.proverkastr(stroka,osn_1)) {
            if(enter.check_str(stroka,pass_1)||enter.check_str(stroka,pass_2))
            {
                Intent intent = new Intent(this, Second.class);
                startActivity(intent);
            }
            else
                toast.show();
        }
        else
        {
            stroka = task.InBtoDec(stroka,osn_1);
            stroka = task.InDecToB(stroka,osn_2);
            res.setText(stroka);
        }
    }

}
