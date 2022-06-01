package com.example.antiescaper;

import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;

public class Entrance extends MainActivity {
    private final static String FILE_NAME = "content.txt";
    String s1 = pass_1;

   public boolean check_str(String s, String pass)
    {
        boolean fl=true;
        char[] s_ = s.toCharArray();
        char[] pass_ = pass.toCharArray();
        for(int i=0; i<Math.min(s.length(),pass.length());i++)
        {
            if(s_[i]!=pass_[i]) fl=false;
        }
        return fl&&(s.length()==pass.length());
    }
    /*public void openText(View view){

        FileInputStream fin = null;
        TextView textView = findViewById(R.id.text);
        try {
            fin = openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String (bytes);
            textView.setText(text);
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
    }*/

}
