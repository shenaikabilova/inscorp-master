package com.kabilova.inscorpclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.kabilova.model.ParcelableInsured;

import kabilova.tu.inscorp.model.user.Insured;

public class SettingsActivity extends AppCompatActivity {
    private Insured insured;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        insured = getIntent().getParcelableExtra("insured");

        EditText etName = (EditText) findViewById(R.id.etName);
        EditText etEGN = (EditText) findViewById(R.id.etEGN);
        EditText etCounty = (EditText) findViewById(R.id.etUserCounty);
        EditText etCity = (EditText) findViewById(R.id.etCity);
        EditText etPK = (EditText) findViewById(R.id.etPK);
        EditText etPhone = (EditText) findViewById(R.id.etPhone);
        EditText etEmail = (EditText) findViewById(R.id.etEmail);

        etName.setText(insured.getFirstName() + " " + insured.getSecondName() + " " + insured.getLastName());
        etEGN.setText(insured.getEgn());
        etCounty.setText(insured.getCountry());
        etCity.setText(insured.getCity());
        etPK.setText(Integer.toString(insured.getPostCode()));
        etPhone.setText(insured.getPhoneNumber());
        etEmail.setText(insured.getEmail());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_home:
                intent = new Intent(SettingsActivity.this, AfterLoginActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
            case R.id.action_vehicles:
                intent = new Intent(SettingsActivity.this, LoadVehiclesActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
                break;
            case R.id.action_ins:
                intent = new Intent(SettingsActivity.this, LoadPoliciesActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }

    private ParcelableInsured getParcelableInsured() {
        ParcelableInsured parcelableInsured = new ParcelableInsured();
        parcelableInsured.setId(insured.getId());
        parcelableInsured.setFirstName(insured.getFirstName());
        parcelableInsured.setSecondName(insured.getSecondName());
        parcelableInsured.setLastName(insured.getLastName());
        parcelableInsured.setUsername(insured.getUsername());
        parcelableInsured.setPassword(insured.getPassword());
        parcelableInsured.setPhoneNumber(insured.getPhoneNumber());
        parcelableInsured.setEmail(insured.getEmail());
        parcelableInsured.setEgn(insured.getEgn());
        parcelableInsured.setPostCode(insured.getPostCode());
        parcelableInsured.setCountry(insured.getCountry());
        parcelableInsured.setCity(insured.getCity());
        parcelableInsured.setAddress(insured.getAddress());
        return parcelableInsured;
    }
}
