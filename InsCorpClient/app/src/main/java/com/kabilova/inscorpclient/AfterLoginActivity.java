package com.kabilova.inscorpclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.kabilova.model.ParcelableInsured;
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
import java.util.Date;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.user.Insured;

public class AfterLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        final Insured insured = getIntent().getParcelableExtra("insured");
        System.out.println(insured.getId());

        EditText etClient = (EditText) findViewById(R.id.etClient);
        etClient.setText(insured.getFirstName() + " " + insured.getSecondName() + " " + insured.getLastName());

        Button bGO = (Button) findViewById(R.id.bGO);
        Button bKasko = (Button) findViewById(R.id.bKasko);

        bGO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AfterLoginActivity.this, ActiveGOActivity.class);
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
                intent.putExtra("insured", parcelableInsured);
                startActivity(intent);
            }
        });

        bKasko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AfterLoginActivity.this, ActiveKaskoActivity.class);
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
                intent.putExtra("insured", parcelableInsured);
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
        switch (item.getItemId()) {
//            case R.id.action_vehicles:
//                startActivity(new Intent(AfterLoginActivity.this, AdminPanelAddSubject.class));
//                break;
//            case R.id.action_ins:
//                startActivity(new Intent(AfterLoginActivity.this, AdminPanelSearchStudent.class));
//                break;
            case R.id.action_settings:
                startActivity(new Intent(AfterLoginActivity.this, SettingsActivity.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }
}
