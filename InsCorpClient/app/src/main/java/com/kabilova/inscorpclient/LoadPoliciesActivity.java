package com.kabilova.inscorpclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.kabilova.model.ParcelableInsured;

import kabilova.tu.inscorp.model.user.Insured;

public class LoadPoliciesActivity extends AppCompatActivity {
    private Insured insured;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_policies);

        insured = getIntent().getParcelableExtra("insured");

        Button bAllGO = (Button) findViewById(R.id.bAllGO);
        Button bAllKasko = (Button) findViewById(R.id.bAllKasko);

        bAllGO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoadPoliciesActivity.this, GOActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
            }
        });

        bAllKasko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoadPoliciesActivity.this, KaskoActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
            }
        });
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
                intent = new Intent(LoadPoliciesActivity.this, AfterLoginActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
            case R.id.action_vehicles:
                intent = new Intent(LoadPoliciesActivity.this, LoadVehiclesActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
                break;
            case R.id.action_settings:
                intent = new Intent(LoadPoliciesActivity.this, SettingsActivity.class);
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
