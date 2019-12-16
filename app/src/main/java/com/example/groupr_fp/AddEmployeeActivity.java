package com.example.groupr_fp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groupr_fp.models.Car;
import com.example.groupr_fp.models.Employee;
import com.example.groupr_fp.models.Manager;
import com.example.groupr_fp.models.Motorcycle;
import com.example.groupr_fp.models.Programmer;
import com.example.groupr_fp.models.Tester;
import com.example.groupr_fp.models.Vehicle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class AddEmployeeActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {


    private static String TAG = "AddEmployeeActivity: ";

    private LinearLayout viewForm;
    private ImageView imgAvatar;
    private TextInputEditText edtFname;
    private TextInputEditText edtLname;
    private RadioGroup rgpGender;
    private RadioButton rbtMale;
    private RadioButton rbtFemale;
    private TextInputEditText edtByear;
    private TextInputEditText edtMsalary;
    private TextInputEditText edtOrate;
    private TextInputEditText edtEmpID;
    private AppCompatSpinner spinnerEmpType;
    private TextInputLayout viewEmpTypeVal, viewEmpTravelDays;
    private TextInputEditText edtEmpTypeVal, edtEmpTravelDays;
    private RadioGroup rgpVehicle;
    private RadioButton rbtCar;
    private RadioButton rbtMotorbike;
    private TextInputLayout viewCar;
    private TextInputEditText edtCarType;
    private RelativeLayout viewBike;
    private Switch switchSidecar;
    private TextInputEditText edtVmodel;
    private TextInputEditText edtPlateNumber;
    private AppCompatSpinner spinnerVcolor;
    private FloatingActionButton btnAddEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        init();
    }

    private void init() {
        viewForm = (LinearLayout) findViewById(R.id.viewForm);
        imgAvatar = (ImageView) findViewById(R.id.imgAvatar);
        edtFname = (TextInputEditText) findViewById(R.id.edtFname);
        edtLname = (TextInputEditText) findViewById(R.id.edtLname);
        rgpGender = (RadioGroup) findViewById(R.id.rgpGender);
        rbtMale = (RadioButton) findViewById(R.id.rbtMale);
        rbtFemale = (RadioButton) findViewById(R.id.rbtFemale);
        edtByear = (TextInputEditText) findViewById(R.id.edtByear);
        edtMsalary = (TextInputEditText) findViewById(R.id.edtMsalary);
        edtOrate = (TextInputEditText) findViewById(R.id.edtOrate);
        edtEmpID = (TextInputEditText) findViewById(R.id.edtEmpID);
        spinnerEmpType = (AppCompatSpinner) findViewById(R.id.spinnerEmpType);
        viewEmpTypeVal = (TextInputLayout) findViewById(R.id.viewEmpTypeVal);
        edtEmpTypeVal = (TextInputEditText) findViewById(R.id.edtEmpTypeVal);
        viewEmpTravelDays = (TextInputLayout) findViewById(R.id.viewEmpTravelDays);
        edtEmpTravelDays = (TextInputEditText) findViewById(R.id.edtEmpTravelDays);
        rgpVehicle = (RadioGroup) findViewById(R.id.rgpVehicle);
        rbtCar = (RadioButton) findViewById(R.id.rbtCar);
        rbtMotorbike = (RadioButton) findViewById(R.id.rbtMotorbike);
        viewCar = (TextInputLayout) findViewById(R.id.viewCar);
        edtCarType = (TextInputEditText) findViewById(R.id.edtCarType);
        viewBike = (RelativeLayout) findViewById(R.id.viewBike);
        switchSidecar = (Switch) findViewById(R.id.switchSidecar);
        edtVmodel = (TextInputEditText) findViewById(R.id.edtVmodel);
        edtPlateNumber = (TextInputEditText) findViewById(R.id.edtPlateNumber);
        spinnerVcolor = (AppCompatSpinner) findViewById(R.id.spinnerVcolor);
        btnAddEmployee = (FloatingActionButton) findViewById(R.id.btnAddEmployee);

        edtEmpID.setText(String.valueOf(Employee.listEmployees.size() + 1));

        spinnerEmpType.setOnItemSelectedListener(this);
        spinnerVcolor.setOnItemSelectedListener(this);

        rgpGender.setOnCheckedChangeListener(this);
        rgpVehicle.setOnCheckedChangeListener(this);
        btnAddEmployee.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinnerEmpType:
                if (position == 0) {
                    viewEmpTypeVal.setVisibility(View.GONE);
                    viewEmpTravelDays.setVisibility(View.GONE);
                } else {
                    viewEmpTypeVal.setVisibility(View.VISIBLE);

                    switch (parent.getSelectedItemPosition()) {
                        case 1:
                            viewEmpTypeVal.setHint("#Projects");
                            break;
                        case 2:
                            viewEmpTypeVal.setHint("#Clients");
                            viewEmpTravelDays.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            viewEmpTypeVal.setHint("#Bugs");
                            break;
                    }
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        switch (group.getCheckedRadioButtonId()) {

            case R.id.rbtMale:
                imgAvatar.setImageDrawable(getDrawable(R.drawable.ic_user_man));
                break;

            case R.id.rbtFemale:
                imgAvatar.setImageDrawable(getDrawable(R.drawable.ic_user_woman));
                break;

            case R.id.rbtCar:
                viewCar.setVisibility(View.VISIBLE);
                viewBike.setVisibility(View.GONE);
                break;

            case R.id.rbtMotorbike:
                viewCar.setVisibility(View.GONE);
                viewBike.setVisibility(View.VISIBLE);
                break;

        }
    }
}
