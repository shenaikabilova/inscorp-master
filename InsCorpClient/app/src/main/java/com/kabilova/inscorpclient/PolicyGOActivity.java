package com.kabilova.inscorpclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import kabilova.tu.inscorp.model.policy.GO;

public class PolicyGOActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_go);

        GO go = getIntent().getParcelableExtra("go");

        EditText etClient = (EditText) findViewById(R.id.etClient);
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
        EditText etZone = (EditText) findViewById(R.id.etZone);
        EditText etDateFrom = (EditText) findViewById(R.id.etDateFrom);
        EditText etDateTo = (EditText) findViewById(R.id.etDateTo);
        EditText etValue = (EditText) findViewById(R.id.etValue);

        etClient.setText(go.getInsured().getFirstName() + " " + go.getInsured().getSecondName() + " " + go.getInsured().getLastName());
        etEGN.setText(go.getInsured().getEgn());
        etAddress.setText(go.getInsured().getAddress());
        etPhone.setText(go.getInsured().getPhoneNumber());
        etRegNum.setText(go.getVehicle().getRegNum());
        etCountry.setText(go.getInsured().getCountry());
        etType.setText(go.getVehicle().getVehicleSubtype().getVehicleType().getVehicleType());
        etSubtype.setText(go.getVehicle().getVehicleSubtype().getSubtype());
        etBrand.setText(go.getVehicle().getBrand());
        etModel.setText(go.getVehicle().getModel());
        etRAMA.setText(go.getVehicle().getRAMA());
        etEngine.setText(String.valueOf(go.getVehicle().getEngine()));
//        etZone = (
        etDateFrom.setText(go.getDateFrom().getTime().toString());
        etDateTo.setText(go.getDateTo().getTime().toString());
//        etValue =
    }
}
