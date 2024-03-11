package com.example.quadraticequationsolver;

import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.quadraticequationsolver.databinding.ActivityMainBinding;

public class MyEquation extends BaseObservable {

    String a,b,c;

    ActivityMainBinding Binding;

    public MyEquation(ActivityMainBinding binding) {
        Binding = binding;
    }
    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
    @Bindable
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void solveEquation(View v)
    {
        int a=0,b=0,c=0;

        double d=0.0,x1=0.0,x2=0.0,x=0.0;

        try
        {
            a=Integer.parseInt(getA());
            b=Integer.parseInt(getB());
            c=Integer.parseInt(getC());

            d=(b*b)-(4*a*c);

            if(d>0)
            {
                x1=(-b+ Math.sqrt(d))/(2*a);
                x2=(-b- Math.sqrt(d))/(2*a);

                Binding.result.setText("x1="+x1+"\nx2="+x2);
            }
            else if (d<0)
            {
                Binding.result.setText("No real roots complex roots(Complex roots)");
            }
            else
            {   x=-b/(2*a);
                Binding.result.setText("x="+x);
            }
        }
        catch (NumberFormatException e)
        {
            Toast.makeText(v.getContext(), "Please enter integer values for a,b & c", Toast.LENGTH_SHORT).show();
        }

    }

    public void reset(View v)
    {
        Binding.editText1.getText().clear();
        Binding.editText2.getText().clear();
        Binding.editText3.getText().clear();
        Binding.result.setText("Result");
    }
}
