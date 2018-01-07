package com.kabilova.inscorpclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.kabilova.model.ParcelableInsured;

import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.vehicle.Vehicle;

public class VehicleActivity extends AppCompatActivity {
    private Insured insured;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        insured = getIntent().getParcelableExtra("insured");
        Vehicle vehicle = getIntent().getParcelableExtra("vehicle");

        EditText etVehicleOwner = (EditText) findViewById(R.id.etVehicleOwnerName);
        EditText etVehicleRegNum = (EditText) findViewById(R.id.etVehicleRegNum);
        EditText etVehicleType = (EditText) findViewById(R.id.etVehicleType);
        EditText etVehicleSubtype = (EditText) findViewById(R.id.etVehicleSubtype);
        EditText etVehicleBrand = (EditText) findViewById(R.id.etVehicleBrand);
        EditText etVehicleModel = (EditText) findViewById(R.id.etVehicleModel);
        EditText etVehicleRAMA = (EditText) findViewById(R.id.etVehicleRAMA);
        EditText etVehicleEngine = (EditText) findViewById(R.id.etVehicleEngine);
        EditText etVehicleFirstReg = (EditText) findViewById(R.id.etVehicleFirstReg);
        EditText etVehicleYears = (EditText) findViewById(R.id.etVehicleYears);
        EditText etVehicleColor = (EditText) findViewById(R.id.etVehicleColor);
        EditText etVehiclePlaceNumber = (EditText) findViewById(R.id.etVehiclePlaceNumber);

        etVehicleOwner.setText(insured.getFirstName() + " " + insured.getSecondName() + " " + insured.getLastName());
        etVehicleRegNum.setText(vehicle.getRegNum());
        etVehicleType.setText(vehicle.getVehicleSubtype().getVehicleType().getVehicleType());
        etVehicleSubtype.setText(vehicle.getVehicleSubtype().getSubtype());
        etVehicleBrand.setText(vehicle.getBrand());
        etVehicleModel.setText(vehicle.getModel());
        etVehicleRAMA.setText(vehicle.getRAMA());
        etVehicleEngine.setText(String.valueOf(vehicle.getEngine()));
        etVehicleFirstReg.setText(String.valueOf(vehicle.getFirstReg()));
        etVehicleYears.setText(Integer.toString(vehicle.getYears()));
        etVehicleColor.setText(vehicle.getColor());
        etVehiclePlaceNumber.setText(Integer.toString(vehicle.getPlaceNumber()));
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
                intent = new Intent(VehicleActivity.this, AfterLoginActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
            case R.id.action_vehicles:
                intent = new Intent(VehicleActivity.this, LoadVehiclesActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
                break;
            case R.id.action_ins:
                intent = new Intent(VehicleActivity.this, LoadPoliciesActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
                break;
            case R.id.action_settings:
                intent = new Intent(VehicleActivity.this, SettingsActivity.class);
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
