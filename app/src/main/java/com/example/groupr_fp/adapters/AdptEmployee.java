package com.example.groupr_fp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.groupr_fp.R;
import com.example.groupr_fp.models.Employee;

import java.util.ArrayList;


public class AdptEmployee extends BaseAdapter {

    private Context context;
    private ArrayList<Employee> list;

    public AdptEmployee(Context context, ArrayList<Employee> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View cv, ViewGroup parent) {
        Employee emp = list.get(position);

        if (cv == null){
            cv = LayoutInflater.from(context).inflate(R.layout.item_emp, null);
        }

        ImageView imgV = cv.findViewById(R.id.imgEmp);
        TextView txtEmpName = cv.findViewById(R.id.txtEmpName);
        TextView txtEmpID = cv.findViewById(R.id.txtEmpID);

        if (emp.getGender() == 'M'){
            imgV.setImageDrawable(context.getDrawable(R.drawable.ic_user_man));
        }else{
            imgV.setImageDrawable(context.getDrawable(R.drawable.ic_user_woman));
        }

        txtEmpName.setText(emp.getName());
        txtEmpID.setText(String.valueOf(position+1));
        return cv;
    }

    public ArrayList<Employee> getList() {
        return list;
    }
}
