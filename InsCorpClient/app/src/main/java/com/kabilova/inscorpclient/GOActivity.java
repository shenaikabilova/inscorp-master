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
import com.kabilova.model.ParcelablePolicyGO;
import com.kabilova.model.ParcelableTariffGO;
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
import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.tariff.TariffGO;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.vehicle.Vehicle;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;

public class GOActivity extends AppCompatActivity {
    final String URL_PATH = "http://10.0.2.2:4000/inscorp/loadPoliciesGO";
    ListView policies;
    List<String> list;
    List<GO> policiesGO = new ArrayList<>();
    private Insured insured;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go);
        insured = getIntent().getParcelableExtra("insured");
        policies = (ListView) findViewById(R.id.lvGO);

        RequestParams requestParams = new RequestParams();
        requestParams.put("insured", insured.getId());
        invokeWS(requestParams);

        policies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GOActivity.this, PolicyGOActivity.class);

                ParcelablePolicyGO parcelablePolicyGO = new ParcelablePolicyGO();
                parcelablePolicyGO.setPolicaID(policiesGO.get(position).getPolicaID());
                parcelablePolicyGO.setDateFrom(policiesGO.get(position).getDateFrom());
                parcelablePolicyGO.setDateTo(policiesGO.get(position).getDateTo());

                ParcelableVehicle parcelableVehicle = new ParcelableVehicle();
                ParcelableVehicleSubtype parcelableVehicleSubtype = new ParcelableVehicleSubtype();
                ParcelableVehicleType parcelableVehicleType = new ParcelableVehicleType();

                parcelableVehicleType.setVehicleType(policiesGO.get(position).getVehicle().getVehicleSubtype().getVehicleType().getVehicleType());

                parcelableVehicleSubtype.setId(policiesGO.get(position).getVehicle().getVehicleSubtype().getId());
                parcelableVehicleSubtype.setVehicleType(parcelableVehicleType);
                parcelableVehicleSubtype.setSubtype(policiesGO.get(position).getVehicle().getVehicleSubtype().getSubtype());

                parcelableVehicle.setVehicleID(policiesGO.get(position).getVehicle().getVehicleID());
//                parcelableVehicle.setInsured(((Insured) in.readParcelable(Insurer.class.getClassLoader())));
//                parcelableVehicle.setVehicleType((VehicleType) in.readParcelable(VehicleType.class.getClassLoader()));
                parcelableVehicle.setVehicleSubtype(parcelableVehicleSubtype);
                parcelableVehicle.setRegNum(policiesGO.get(position).getVehicle().getRegNum());
                parcelableVehicle.setRAMA(policiesGO.get(position).getVehicle().getRAMA());
                parcelableVehicle.setBrand(policiesGO.get(position).getVehicle().getBrand());
                parcelableVehicle.setModel(policiesGO.get(position).getVehicle().getModel());
//                parcelableVehicle.setFirstReg((Calendar) in.readValue(getClass().getClassLoader()));
                parcelableVehicle.setYears(policiesGO.get(position).getVehicle().getYears());
                parcelableVehicle.setEngine(policiesGO.get(position).getVehicle().getEngine());
                parcelableVehicle.setColor(policiesGO.get(position).getVehicle().getColor());
                parcelableVehicle.setPlaceNumber(policiesGO.get(position).getVehicle().getPlaceNumber());

                parcelablePolicyGO.setVehicle(parcelableVehicle);
                parcelablePolicyGO.setInsured(insured);

                ParcelableTariffGO parcelableTariffGO = new ParcelableTariffGO();
                parcelableTariffGO.setZone(policiesGO.get(position).getTariffGO().getZone());
                parcelableTariffGO.setValue(policiesGO.get(position).getTariffGO().getValue());

                parcelablePolicyGO.setTariffGO(parcelableTariffGO);
                System.out.println("vehicle: " + policiesGO.get(position).getVehicle() );
                intent.putExtra("insured", getParcelableInsured());
                intent.putExtra("go", parcelablePolicyGO);
                startActivity(intent);
            }
        });

    }

    private void invokeWS (final RequestParams requestParams) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(URL_PATH, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                list = new ArrayList<>();
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, list);

                try {
                    String str = new String(responseBody, "UTF-8");
                    JSONArray jsonArray = new JSONArray(str);

                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        System.out.println(jsonObject);

                        GO go = new GO();
                        go.setPolicaID(jsonObject.getString("policaID"));
                        Calendar dateFrom = Calendar.getInstance();
                        Calendar dateTo = Calendar.getInstance();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        dateFrom.setTime(simpleDateFormat.parse(jsonObject.getString("dateFrom")));
                        go.setDateFrom(dateFrom);
                        dateTo.setTime(simpleDateFormat.parse(jsonObject.getString("dateTo")));
                        go.setDateTo(dateTo);
//                        list.add(String.valueOf(jsonObject.getString("policytype")) + " " + jsonObject.getString("dateTo"));

                        try {
                            JSONObject insObj = new JSONObject(jsonObject.getString("insured"));
                            Insured insured = new Insured();
                            insured.setId(insObj.getInt("id"));


                            JSONObject vObj = new JSONObject(jsonObject.getString("vehicle"));
                            Vehicle vehicle = new Vehicle();
                            vehicle.setVehicleID(vObj.getInt("vehicleID"));

                            JSONObject vSubtype = new JSONObject(vObj.getString("vehicleSubtype"));
                            JSONObject vType = new JSONObject(vObj.getString("vehicleType"));
                            VehicleSubtype vehicleSubtype = new VehicleSubtype(vSubtype.getInt("id"),
                                    new VehicleType(vType.getInt("id"), vType.getString("vehicleType")),
                                    vSubtype.getString("subtype"));

                            vehicle.setVehicleSubtype(vehicleSubtype);
                            vehicle.setRegNum(vObj.getString("regNum"));
                            vehicle.setRAMA(vObj.getString("rama"));
                            vehicle.setBrand(vObj.getString("brand"));
                            vehicle.setModel(vObj.getString("model"));

                            Calendar firstReg = Calendar.getInstance();
                            firstReg.setTime(simpleDateFormat.parse(vObj.getString("firstReg")));
                            vehicle.setFirstReg(firstReg);
                            vehicle.setYears(vObj.getInt("years"));
                            vehicle.setEngine(vObj.getDouble("engine"));
                            vehicle.setColor(vObj.getString("color"));
                            vehicle.setPlaceNumber(vObj.getInt("placeNumber"));

                            go.setVehicle(vehicle);

//                            Tariff tariff = new Tariff();
//                            tariff.setValue(new JSONObject(jsonObject.getString("tariff")).getDouble("value"));
//                            go.setTariff(tariff);

                            JSONObject vTariffGO = new JSONObject(jsonObject.getString("tariffGO"));
                            TariffGO tariffGO = new TariffGO();
                            tariffGO.setTariffID(vTariffGO.getInt("tariffID"));
                            tariffGO.setValue(vTariffGO.getDouble("value"));
                            tariffGO.setZone(vTariffGO.getInt("zone"));
                            go.setTariffGO(tariffGO);

                            policiesGO.add(go);
                            list.add(String.valueOf(jsonObject.getString("policytype")) + " " + vObj.getString("regNum"));
                        } catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                }catch(UnsupportedEncodingException e){
                    e.printStackTrace();
                } catch(JSONException e){
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                policies.setAdapter(adapter);
                adapter.notifyDataSetChanged();

//                    new Handler().postDelayed(new Runnable() {
//                        public void run() {
//                            invokeWS(requestParams);
//                        }
//                    }, 10000);

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
                intent = new Intent(GOActivity.this, AfterLoginActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
            case R.id.action_vehicles:
                intent = new Intent(GOActivity.this, LoadVehiclesActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
                break;
            case R.id.action_ins:
                intent = new Intent(GOActivity.this, LoadPoliciesActivity.class);
                intent.putExtra("insured", getParcelableInsured());
                startActivity(intent);
                break;
            case R.id.action_settings:
                intent = new Intent(GOActivity.this, SettingsActivity.class);
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

