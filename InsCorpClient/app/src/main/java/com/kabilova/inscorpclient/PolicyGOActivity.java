package com.kabilova.inscorpclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.kabilova.model.ParcelableInsured;

import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.user.Insured;

public class PolicyGOActivity extends AppCompatActivity {
    private Insured insured;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_go);

        insured = getIntent().getParcelableExtra("insured");
        GO go = getIntent().getParcelableExtra("go");

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
        etZone.setText(Integer.toString(go.getTariffGO().getZone()));
        etDateFrom.setText(go.getDateFrom().getTime().toString());
        etDateTo.setText(go.getDateTo().getTime().toString());
        etValue.setText(Double.toString(go.getTariffGO().getValue()));
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
                intent = new Intent(PolicyGOActivity.this, AfterLoginActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
            case R.id.action_vehicles:
                intent = new Intent(PolicyGOActivity.this, LoadVehiclesActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
                break;
            case R.id.action_ins:
                intent = new Intent(PolicyGOActivity.this, LoadPoliciesActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
                break;
            case R.id.action_settings:
                intent = new Intent(PolicyGOActivity.this, SettingsActivity.class);
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
