package com.kabilova.inscorpclient;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kabilova.model.ParcelableInsured;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;

public class LoginActivity extends AppCompatActivity {
    final String URL_PATH = "http://10.0.2.2:4000/inscorp/loginUser";
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.etUsername);
        password = (EditText) findViewById(R.id.etPassword);

        Button buttonLogin = (Button) findViewById(R.id.bLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams requestParams = new RequestParams();
                requestParams.put("username", username.getText().toString());
                requestParams.put("password", password.getText().toString());
                invokeWS(requestParams);
            }
        });
    }

    private void invokeWS (RequestParams requestParams) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL_PATH, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String str = new String(responseBody, "UTF-8");
                    System.out.println("str: " + str);
                    JSONObject myObject = new JSONObject(str);
                    Intent intent;

                    if(myObject.getString("type").equals("insured")){
                        ParcelableInsured parcelableInsured = new ParcelableInsured();
                        parcelableInsured.setId(myObject.getInt("id"));
                        parcelableInsured.setFirstName(myObject.getString("firstName"));
                        parcelableInsured.setSecondName(myObject.getString("secondName"));
                        parcelableInsured.setLastName(myObject.getString("lastName"));
                        parcelableInsured.setUsername(myObject.getString("username"));
                        parcelableInsured.setPassword(myObject.getString("password"));
                        parcelableInsured.setPhoneNumber(myObject.getString("phoneNumber"));
                        parcelableInsured.setEmail(myObject.getString("email"));
                        parcelableInsured.setEgn(myObject.getString("egn"));
                        parcelableInsured.setPostCode(myObject.getInt("postCode"));
                        parcelableInsured.setCountry(myObject.getString("country"));
                        parcelableInsured.setCity(myObject.getString("city"));
                        parcelableInsured.setAddress(myObject.getString("address"));

                        intent = new Intent(LoginActivity.this, AfterLoginActivity.class);
                        intent.putExtra("insured", parcelableInsured);
                        startActivity(intent);
                    }
                } catch (UnsupportedEncodingException e){
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
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
