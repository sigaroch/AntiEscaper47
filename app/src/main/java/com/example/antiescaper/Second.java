package com.example.antiescaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Second extends AppCompatActivity {
    private final static String FILE_mail = "mail.txt";
    private final static String FILE_pass = "pass.txt";
    String pass_user;
    EditText mail;
    EditText pass;
    Entrance enter = new Entrance();
    //String d="9";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mail = findViewById(R.id.edit_mail);
        pass = findViewById(R.id.edit_pass);
        FileInputStream fin = null;
        FileInputStream fin_ = null;
        FileOutputStream fos = null;
        try {
            fin = openFileInput(FILE_mail);
            fin_ = openFileInput(FILE_pass);
            byte[] bytes = new byte[fin.available()];
            byte[] bytes_ = new byte[fin_.available()];
            fin.read(bytes);
            fin_.read(bytes_);
            String text = new String (bytes);
            String text_ = new String(bytes_);
            mail.setText(text);
            pass.setText(text_);
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
    }

    public void SAVE_EXCHANGE (View view) throws IOException {
        FileOutputStream fos = null;
        FileOutputStream fos_ = null;
        try {
            EditText text_mail = findViewById(R.id.edit_mail);
            EditText text_pass = findViewById(R.id.edit_pass);
            String text = text_mail.getText().toString();
            String text_ = text_pass.getText().toString();
            fos = openFileOutput(FILE_mail, MODE_PRIVATE);
            fos.write(text.getBytes());
            fos_ = openFileOutput(FILE_pass, MODE_PRIVATE);
            fos_.write(text_.getBytes());
            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}


