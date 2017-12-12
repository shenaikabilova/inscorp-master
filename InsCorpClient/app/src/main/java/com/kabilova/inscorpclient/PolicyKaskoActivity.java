package com.kabilova.inscorpclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.policy.Kasko;

public class PolicyKaskoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_kasko);

        Kasko kasko = getIntent().getParcelableExtra("kasko");

        System.out.println(kasko.getVehicle().getRegNum());

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
//        etZone = (
        etDateFrom.setText(kasko.getDateFrom().getTime().toString());
        etDateTo.setText(kasko.getDateTo().getTime().toString());
//        etValue =
    }
}
