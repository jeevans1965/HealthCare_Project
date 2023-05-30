package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
   private String[][]doctor_details1= {
           {"Doctor Name:Ajit", "Hospital Address: Bengalure","Exo:5yrs", "Mobile No:9874663210","680"},
           {"Doctor Name:Prasad", "Hospital Address: Mangalure","Exo:4yrs", "Mobile No:9874663210","900"},
           {"Doctor Name:Deepak", "Hospital Address: Bengalure","Exo:5yrs", "Mobile No:9874663210","680"},
           {"Doctor Name:Tarun", "Hospital Address: Mysuru","Exo:6yrs", "Mobile No:9874663210","580"},
           {"Doctor Name:Ashok", "Hospital Address: Mumbai","Exo:3yrs", "Mobile No:9874663210","800"},
    };

    private String[][]doctor_details2= {
            {"Doctor Name:Ajit", "Hospital Address: Bengalure","Exo:5yrs", "Mobile No:9874663210","680"},
            {"Doctor Name:Prasad", "Hospital Address: Mangalure","Exo:4yrs", "Mobile No:9874663210","900"},
            {"Doctor Name:Deepak", "Hospital Address: Bengalure","Exo:5yrs", "Mobile No:9874663210","680"},
            {"Doctor Name:Tarun", "Hospital Address: Mysuru","Exo:6yrs", "Mobile No:9874663210","580"},
            {"Doctor Name:Ashok", "Hospital Address: Mumbai","Exo:3yrs", "Mobile No:9874663210","800"},
    };

    private String[][]doctor_details3= {
            {"Doctor Name:Ajit", "Hospital Address: Bengalure","Exo:5yrs", "Mobile No:9874663210","680"},
            {"Doctor Name:Prasad", "Hospital Address: Mangalure","Exo:4yrs", "Mobile No:9874663210","900"},
            {"Doctor Name:Deepak", "Hospital Address: Bengalure","Exo:5yrs", "Mobile No:9874663210","680"},
            {"Doctor Name:Tarun", "Hospital Address: Mysuru","Exo:6yrs", "Mobile No:9874663210","580"},
            {"Doctor Name:Ashok", "Hospital Address: Mumbai","Exo:3yrs", "Mobile No:9874663210","800"},
    };

    private String[][]doctor_details4= {
            {"Doctor Name:Ajit", "Hospital Address: Bengalure","Exo:5yrs", "Mobile No:9874663210","680"},
            {"Doctor Name:Prasad", "Hospital Address: Mangalure","Exo:4yrs", "Mobile No:9874663210","900"},
            {"Doctor Name:Deepak", "Hospital Address: Bengalure","Exo:5yrs", "Mobile No:9874663210","680"},
            {"Doctor Name:Tarun", "Hospital Address: Mysuru","Exo:6yrs", "Mobile No:9874663210","580"},
            {"Doctor Name:Ashok", "Hospital Address: Mumbai","Exo:3yrs", "Mobile No:9874663210","800"},
    };

    private String[][]doctor_details5= {
            {"Doctor Name:Ajit", "Hospital Address: Bengalure","Exo:5yrs", "Mobile No:9874663210","680"},
            {"Doctor Name:Prasad", "Hospital Address: Mangalure","Exo:4yrs", "Mobile No:9874663210","900"},
            {"Doctor Name:Deepak", "Hospital Address: Bengalure","Exo:5yrs", "Mobile No:9874663210","680"},
            {"Doctor Name:Tarun", "Hospital Address: Mysuru","Exo:6yrs", "Mobile No:9874663210","580"},
            {"Doctor Name:Ashok", "Hospital Address: Mumbai","Exo:3yrs", "Mobile No:9874663210","800"},
    };

    TextView tv;
    Button btn;
    String[][] Doctor_details={};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textView_logo6);
        btn = findViewById(R.id.buttonCartCheckout);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0)
            Doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            Doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            Doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            Doctor_details = doctor_details4;
        else
            Doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for( int i=0; i<Doctor_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",doctor_details1[i][0]);
            item.put("line2",doctor_details1[i][1]);
            item.put("line3",doctor_details1[i][2]);
            item.put("line4",doctor_details1[i][3]);
            item.put("line5","cons Fees:"+Doctor_details[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst=findViewById(R.id.listViewCart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",Doctor_details[i][0]);
                it.putExtra("text3",Doctor_details[i][1]);
                it.putExtra("text4",Doctor_details[i][3]);
                it.putExtra("text5",Doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}