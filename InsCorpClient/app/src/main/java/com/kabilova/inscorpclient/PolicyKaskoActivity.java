package com.kabilova.inscorpclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.kabilova.model.ParcelableInsured;

import kabilova.tu.inscorp.model.policy.Kasko;
import kabilova.tu.inscorp.model.user.Insured;

public class PolicyKaskoActivity extends AppCompatActivity {
    private Insured insured;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_kasko);

        insured = getIntent().getParcelableExtra("insured");
        Kasko kasko = getIntent().getParcelableExtra("kasko");

        EditText etClient = (EditText) findViewById(R.id.etVehicleOwnerName);
        EditText etEGN = (EditText) findViewById(R.id.etEGN);
        EditText etAddress = (EditText) findViewById(R.id.etAddress);
        EditText etPhone = (EditText) findViewById(R.id.etPhoneNumber);
        EditText etRegNum = (EditText) findViewById(R.id.etRegNum);
        EditText etCountry = (EditText) findViewById(R.id.etCountry);
        EditText etType = (EditText) findViewById(R.id.etType);
        EditText etSubtype = (EditText) findViewById(R.id.etSubtype);
        EditText etBrand = (EditText) findViewById(R.id.etBrand);
        EditText etModel = (EditText) findViewById(R.id.etModel);
        EditText etRAMA = (EditText) findViewById(R.id.etRAMA);
        EditText etEngine = (EditText) findViewById(R.id.etEngine);
        EditText etDateFrom = (EditText) findViewById(R.id.etDateFrom);
        EditText etDateTo = (EditText) findViewById(R.id.etDateTo);
        EditText etValue = (EditText) findViewById(R.id.etValue);
        EditText etPercent = (EditText) findViewById(R.id.etPercent);
        EditText etKaskoType = (EditText) findViewById(R.id.etKaskoType);
        EditText etVehicleValue = (EditText) findViewById(R.id.etVehValue);

        etClient.setText(kasko.getInsured().getFirstName() + " " + kasko.getInsured().getSecondName() + " " + kasko.getInsured().getLastName());
        etEGN.setText(kasko.getInsured().getEgn());
        etAddress.setText(kasko.getInsured().getAddress());
        etPhone.setText(kasko.getInsured().getPhoneNumber());
        etRegNum.setText(kasko.getVehicle().getRegNum());
        etCountry.setText(kasko.getInsured().getCountry());
        etType.setText(kasko.getVehicle().getVehicleSubtype().getVehicleType().getVehicleType());
        etSubtype.setText(kasko.getVehicle().getVehicleSubtype().getSubtype());
        etBrand.setText(kasko.getVehicle().getBrand());
        etModel.setText(kasko.getVehicle().getModel());
        etRAMA.setText(kasko.getVehicle().getRAMA());
        etEngine.setText(String.valueOf(kasko.getVehicle().getEngine()));
        etDateFrom.setText(kasko.getDateFrom().getTime().toString());
        etDateTo.setText(kasko.getDateTo().getTime().toString());
        etValue.setText(Double.toString(kasko.getValue()));
        etPercent.setText(Integer.toString(kasko.getTariffKasko().getKaskoPercent()));
        etKaskoType.setText(kasko.getKaskoType());
        etVehicleValue.setText(Double.toString(kasko.getVehicleValue()));
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
                intent = new Intent(PolicyKaskoActivity.this, AfterLoginActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
            case R.id.action_vehicles:
                intent = new Intent(PolicyKaskoActivity.this, LoadVehiclesActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
                break;
            case R.id.action_ins:
                intent = new Intent(PolicyKaskoActivity.this, LoadPoliciesActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
                break;
            case R.id.action_settings:
                intent = new Intent(PolicyKaskoActivity.this, SettingsActivity.class);
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
