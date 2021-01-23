package com.code.form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button buttonUpload, btnRegister;
    private EditText etName, etEmail, etPassword, etPassword2;
    private TextView tvLicence, tvGender, tvCountry;
    private TextView tvWarningName, tvWarningEmail, tvWarningPassword, tvWarningPassword2;
    private RadioGroup rgGender;
    private Spinner spinner;
    private CheckBox agreementCheck;
    private ConstraintLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews(){
        Log.d(TAG, "initViews");

        buttonUpload = (Button)findViewById(R.id.buttonUpload);
        btnRegister = (Button)findViewById(R.id.btnRegister);
        etName = (EditText)findViewById(R.id.etName);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPassword = (EditText)findViewById(R.id.etPassword);
        etPassword2 = (EditText)findViewById(R.id.etPassword2);
        tvLicence = (TextView)findViewById(R.id.tvLicence);
        tvGender = (TextView)findViewById(R.id.tvGender);
        tvCountry = (TextView)findViewById(R.id.tvCountry);
        rgGender = (RadioGroup)findViewById(R.id.rgGender);
        spinner = (Spinner)findViewById(R.id.spinner);
        agreementCheck = (CheckBox)findViewById(R.id.agreementCheck);
        parent = (ConstraintLayout)findViewById(R.id.parent);
        tvWarningName = (TextView)findViewById(R.id.tvWarningName);
        tvWarningEmail = (TextView)findViewById(R.id.tvWarningEmail);
        tvWarningPassword = (TextView)findViewById(R.id.tvWarningPassword);
        tvWarningPassword2 = (TextView)findViewById(R.id.tvWarningPassword2);
    }

    public void onUpload(View view){
        Toast.makeText(MainActivity.this, "Upload Picture", Toast.LENGTH_LONG).show();
    }

    public void onRegister(View view){
        initRegister();
    }

    private void initRegister(){
        Log.d(TAG, "initReg");

        if(validateData()){
            if(agreementCheck.isChecked()){
                showSnackBAr();
            }
            else {
                Toast.makeText(this, "You need to check agreement", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void showSnackBAr(){
        Log.d(TAG, "SnackBar");

        tvWarningName.setVisibility(View.GONE);
        tvWarningEmail.setVisibility(View.GONE);
        tvWarningPassword.setVisibility(View.GONE);
        tvWarningPassword2.setVisibility(View.GONE);

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String country = spinner.getSelectedItem().toString();
        String gender = "";

        switch (rgGender.getCheckedRadioButtonId()){
            case R.id.rbMale:
                gender = "Male";
                break;
            case R.id.rbFemale:
                gender = "Female";
                break;
            case R.id.rbOther:
                gender = "Other";
                break;
            default:
                gender = "Unknown";
                break;
        }

        String snackText = "Name : " + name + "\n" + "Email : " + email + "\n" + "Country : " + country + "\n" + "Gender : " + gender;

        Log.d(TAG, "SnackText : " + snackText);

        Snackbar.make(parent, snackText, Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        etName.setText("");
                        etEmail.setText("");
                        etPassword.setText("");
                        etPassword2.setText("");
                    }
                }).show();
    }

    private boolean validateData(){
        Log.d(TAG, "validateData");

        if(etName.getText().toString().equals("")){
            tvWarningName.setVisibility(View.VISIBLE);
            tvWarningName.setText("Enter your Name");
            return false;
        }

        if(etEmail.getText().toString().equals("")){
            tvWarningEmail.setVisibility(View.VISIBLE);
            tvWarningEmail.setText("Enter your Email");
            return false;
        }

        if(etPassword.getText().toString().equals("")){
            tvWarningPassword.setVisibility(View.VISIBLE);
            tvWarningPassword.setText("Enter your Password");
            return false;
        }

        if(etPassword2.getText().toString().equals("")){
            tvWarningPassword2.setVisibility(View.VISIBLE);
            tvWarningPassword2.setText("Re Enter your Password");
            return false;
        }

        if(!etPassword.getText().toString().equals(etPassword2.getText().toString())){
            tvWarningPassword2.setVisibility(View.VISIBLE);
            tvWarningPassword2.setText("Password doesn't match");
            return false;
        }

        return true;
    }
}