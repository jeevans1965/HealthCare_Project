package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    private String[][]packages=
            {
                    {"Packages 1: Full Body CheckUp","", "", "","999"},
                    {"Packages 2: Blood Glucose Fasting","", "", "","299"},
                    {"Packages 3: Covid-19 antibody - IgG","", "", "","899"},
                    {"Packages 4: Thyroid Check","", "", "","599"},
                    {"Packages 5: Immunity check","", "", "","799"}
            };

    private String[] package_details={
            "Blood Glucose Fasting\n"+
                    "complete hemogram\n"+
                    "HbA1c\n" +
                    "Iron studies\n"+
                    "kidney function test\n" +
                    "LDH Lactate dehydrogenase, serum\n"+
                    "lipid profile\n"+
                    "liver test function",
            "blood glucose fasting ",
            "covid-19",
            "Thyroid profile",
            "complete hemogram\n"+
                    "CRP quantities, Serum\n"+
                    "iron studies\n"+
                    "kidney function test\n"+
                    "liver function test\n"+
                    "lipid profile"
    };
    HashMap<String, String>Item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart=findViewById(R.id.buttonCartCheckout);
        btnBack = findViewById(R.id.buttonLDGoBack);
        listView = findViewById(R.id.listViewCart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });

        list =new ArrayList();

        for(int i=0;i<packages.length;i++){
            Item = new HashMap<String,String>();
            Item.put("line1",packages[i][0]);
            Item.put("line2",packages[i][1]);
            Item.put("line3",packages[i][2]);
            Item.put("line4",packages[i][3]);
            Item.put("line5","Total Cost"+packages[i][4]);
            list.add(Item);
        }

        sa =new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listView.setAdapter(sa);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);

                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this, CartLabActivity.class));
            }
        });
    }
}