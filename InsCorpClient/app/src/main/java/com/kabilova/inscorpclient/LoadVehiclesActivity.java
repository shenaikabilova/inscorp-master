package com.kabilova.inscorpclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.kabilova.model.ParcelableInsured;
import com.kabilova.model.ParcelableVehicle;
import com.kabilova.model.ParcelableVehicleSubtype;
import com.kabilova.model.ParcelableVehicleType;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

public class LoadVehiclesActivity extends AppCompatActivity {
    final String URL_PATH = "http://10.0.2.2:4000/inscorp/loadVehicles";
    private Insured insured;
    ListView listViewVehicles;
    List<String> list;
    List<Vehicle> vehicles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_vehicles);

        insured = getIntent().getParcelableExtra("insured");
        listViewVehicles = (ListView) findViewById(R.id.lvLoadVehicles);

        RequestParams requestParams = new RequestParams();
        requestParams.put("insured", insured.getId());
        invokeWS(requestParams);

        listViewVehicles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LoadVehiclesActivity.this, VehicleActivity.class);
                ParcelableVehicle parcelableVehicle = new ParcelableVehicle();
                ParcelableVehicleSubtype parcelableVehicleSubtype = new ParcelableVehicleSubtype();
                ParcelableVehicleType parcelableVehicleType = new ParcelableVehicleType();

                parcelableVehicle.setVehicleID(vehicles.get(position).getVehicleID());

                parcelableVehicleType.setVehicleType(vehicles.get(position).getVehicleSubtype().getVehicleType().getVehicleType());

                parcelableVehicleSubtype.setId(vehicles.get(position).getVehicleSubtype().getId());
                parcelableVehicleSubtype.setVehicleType(parcelableVehicleType);
                parcelableVehicleSubtype.setSubtype(vehicles.get(position).getVehicleSubtype().getSubtype());

                parcelableVehicle.setVehicleSubtype(parcelableVehicleSubtype);
                parcelableVehicle.setRegNum(vehicles.get(position).getRegNum());
                parcelableVehicle.setRAMA(vehicles.get(position).getRAMA());
                parcelableVehicle.setBrand(vehicles.get(position).getBrand());
                parcelableVehicle.setModel(vehicles.get(position).getModel());
                parcelableVehicle.setFirstReg(vehicles.get(position).getFirstReg());
                parcelableVehicle.setYears(vehicles.get(position).getYears());
                parcelableVehicle.setEngine(vehicles.get(position).getEngine());
                parcelableVehicle.setColor(vehicles.get(position).getColor());
                parcelableVehicle.setPlaceNumber(vehicles.get(position).getPlaceNumber());

                intent.putExtra("insured", getParcelableInsured());
                intent.putExtra("vehicle", parcelableVehicle);
                startActivity(intent);
            }
        });
    }

    private void invokeWS(final RequestParams requestParams){
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(URL_PATH, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                list = new ArrayList<>();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, list);

                try{
                    String str = new String(responseBody, "UTF-8");
                    JSONArray jsonArray = new JSONArray(str);

                    for(int i=0; i<jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        System.out.println(jsonObject);

                        Vehicle vehicle = new Vehicle();
                        vehicle.setVehicleID(jsonObject.getInt("vehicleID"));

                        JSONObject vType = new JSONObject(jsonObject.getString("vehicleType"));
                        JSONObject vSubtype = new JSONObject(jsonObject.getString("vehicleSubtype"));
                        VehicleSubtype vehicleSubtype = new VehicleSubtype(vSubtype.getInt("id"),
                                                                           new VehicleType(vType.getInt("id"), vType.getString("vehicleType")),
                                                                           vSubtype.getString("subtype"));

                        vehicle.setVehicleSubtype(vehicleSubtype);
                        vehicle.setRegNum(jsonObject.getString("regNum"));
                        vehicle.setRAMA(jsonObject.getString("rama"));
                        vehicle.setBrand(jsonObject.getString("brand"));
                        vehicle.setModel(jsonObject.getString("model"));

                        Calendar firstReg = Calendar.getInstance();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        firstReg.setTime(simpleDateFormat.parse(jsonObject.getString("firstReg")));
                        vehicle.setFirstReg(firstReg);
                        vehicle.setYears(jsonObject.getInt("years"));
                        vehicle.setEngine(jsonObject.getDouble("engine"));
                        vehicle.setColor(jsonObject.getString("color"));
                        vehicle.setPlaceNumber(jsonObject.getInt("placeNumber"));

                        vehicles.add(vehicle);
                        list.add(String.valueOf(jsonObject.getString("regNum")));
                    }
                } catch(UnsupportedEncodingException e){
                    e.printStackTrace();
                } catch(JSONException e){
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                listViewVehicles.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println(error.getMessage());
                if(statusCode == 404) {
                    Toast.makeText(getApplicationContext(), "Requested resource not found!", Toast.LENGTH_LONG).show();
                }
                else if(statusCode == 500) {
                    Toast.makeText(getApplicationContext(), "Cannot connect to server!", Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
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
                intent = new Intent(LoadVehiclesActivity.this, AfterLoginActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
            case R.id.action_ins:
                intent = new Intent(LoadVehiclesActivity.this, LoadPoliciesActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
                break;
            case R.id.action_settings:
                intent = new Intent(LoadVehiclesActivity.this, SettingsActivity.class);
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
