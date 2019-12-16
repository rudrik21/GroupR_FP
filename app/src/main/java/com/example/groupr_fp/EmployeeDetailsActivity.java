package com.example.groupr_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.groupr_fp.models.Employee;
import com.example.groupr_fp.models.Programmer;

public class EmployeeDetailsActivity extends AppCompatActivity {

    private TextView txtEmpDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        txtEmpDetails = (TextView) findViewById(R.id.txtEmpDetails);

        int pos = (getIntent().getIntExtra("POSITION", -1));
        if (pos != -1){
            txtEmpDetails.setText(Employee.listEmployees.get(pos-1).toString());
        }


    }
}
