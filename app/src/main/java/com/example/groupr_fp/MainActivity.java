package com.example.groupr_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

import com.example.groupr_fp.adapters.AdptEmployee;
import com.example.groupr_fp.models.Employee;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, TextWatcher {

    private static String TAG = "MainActivity: ";
    private EditText edtSearch;
    private GridView gridEmployees;
    private FloatingActionButton btnAddEmployee;

    private AdptEmployee adptEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){

        edtSearch = (EditText) findViewById(R.id.edtSearch);
        gridEmployees = (GridView) findViewById(R.id.gridEmployees);
        btnAddEmployee = (FloatingActionButton) findViewById(R.id.btnAddEmployee);
        btnAddEmployee.setOnClickListener(this);

        edtSearch.addTextChangedListener(this);
        adptEmployee = new AdptEmployee(this, Employee.listEmployees);
        gridEmployees.setAdapter(adptEmployee);

        gridEmployees.setOnItemClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAddEmployee){
            Intent i = new Intent(this, AddEmployeeActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(i);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        gridEmployees.setAdapter(null);
        adptEmployee = new AdptEmployee(this, Employee.listEmployees);
        gridEmployees.setAdapter(adptEmployee);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, EmployeeDetailsActivity.class);
        i.putExtra("POSITION", adptEmployee.getList().get(position).getId());
        startActivity(i);
    }

    //  On search employee
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        edtSearch.removeTextChangedListener(this);

        adptEmployee = new AdptEmployee(this, Employee.getFilteredEmployees(s.toString()));
        gridEmployees.setAdapter(adptEmployee);

        edtSearch.addTextChangedListener(this);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
