package com.kabilova.inscorpclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.user.Insured;

public class AfterLoginActivity extends AppCompatActivity {
    final String URL_PATH = "http://10.0.2.2:4000/inscorp/loadActivePolicies";
    EditText etClient;
    ListView activePolicies;
    List<String> list;
    List<GO> policiesGO = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        Insured insured = getIntent().getParcelableExtra("insured");
        System.out.println(insured.getId());

        etClient = (EditText) findViewById(R.id.etClient);
        activePolicies = (ListView) findViewById(R.id.lvActivePolicies);
        etClient.setText(insured.getFirstName() + " " + insured.getSecondName() + " " + insured.getLastName());

        RequestParams requestParams = new RequestParams();
        requestParams.put("insured", insured.getId());
        invokeWS(requestParams);

        activePolicies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AfterLoginActivity.this, PolicyActivity.class);
                //TODO get intent with select policy
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
                        go.setPolicaID(jsonObject.getInt("policaID"));
//                        go.setDateFrom(Calendar.getInstance().setTimeInMillis( jsonObject.getLong("dateFrom")));
                        policiesGO.add(go);
//                        list.add(String.valueOf(jsonObject.getString("policytype")) + " " + jsonObject.getString("dateTo"));

                        try {
                            JSONObject vObj = new JSONObject(jsonObject.getString("vehicle"));
                            System.out.println(vObj.getString("regNum"));
                                list.add(jsonObject.getInt("policaID"), String.valueOf(jsonObject.getString("policytype")) + " " + vObj.getString("regNum"));
                        } catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                }catch(UnsupportedEncodingException e){
                    e.printStackTrace();
                } catch(JSONException e){
                    e.printStackTrace();
                }

                    activePolicies.setAdapter(adapter);
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

}
