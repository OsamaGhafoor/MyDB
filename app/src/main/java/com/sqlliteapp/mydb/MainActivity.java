package com.sqlliteapp.mydb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.txtView);


        MYDB mydb = new MYDB(this);


      /* mydb.addContacts("Muhammad Awais","03104415439");
         mydb.addContacts("Zaffira","91234499047");
         mydb.addContacts("Warda","03219845674");
         mydb.addContacts("Hanaya","03247829843");
        mydb.addContacts("aqib","1234567");*/

       /* ContentModel model = new ContentModel();
        model.id=1;
        model.phone_no="03474155080";

        mydb.updateContact(model);*/

        //mydb.deleteContact(5);


        ArrayList<ContentModel> arrcontect = mydb.fetchcontects();

        for (int i = 0;i<arrcontect.size();i++) {

           txtView.append ("ID:"+arrcontect.get(i).id+"\n NAME:"+arrcontect.get(i).name+"\n PHONE NO:"+arrcontect.get(i).phone_no+"\n\n\n\n");

        }





    }
}