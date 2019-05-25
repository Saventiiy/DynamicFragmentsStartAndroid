package com.bignerdranch.android.dynamicfragmentsstartandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.widget.CheckBox;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentA fragmentA;
    FragmentB fragmentB;
    FragmentTransaction fragmentTransaction;
    CheckBox backStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        backStack = findViewById(R.id.back_stack_checkBox);

    }

    public void onClick(View v){
        fragmentTransaction = getFragmentManager().beginTransaction();
        switch(v.getId()){
            case R.id.add_button:
                fragmentTransaction.add(R.id.FLayout, fragmentA);
                break;

            case R.id.remove_button:
                fragmentTransaction.remove(fragmentA);
                break;

            case R.id.replace_button:
                fragmentTransaction.replace(R.id.FLayout, fragmentB);
                break;

            default:
                break;
        }

        if(backStack.isChecked()){
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();

    }
}
