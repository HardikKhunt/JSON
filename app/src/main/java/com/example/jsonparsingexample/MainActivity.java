package com.example.jsonparsingexample;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    String JSON_STRING = "{\"results\":[{\"gender\":\"female\",\"name\":{\"title\":\"Ms\",\"first\":\"Thea\",\"last\":\"Thomsen\"},\"location\":{\"street\":{\"number\":5729,\"name\":\"Højager\"},\"city\":\"Haslev\",\"state\":\"Syddanmark\",\"country\":\"Denmark\",\"postcode\":13936,\"coordinates\":{\"latitude\":\"-35.9076\",\"longitude\":\"122.4637\"},\"timezone\":{\"offset\":\"-3:30\",\"description\":\"Newfoundland\"}},\"email\":\"thea.thomsen@example.com\",\"login\":{\"uuid\":\"ffc5954f-08e5-4a12-af61-a3df1f0a3792\",\"username\":\"bigmouse295\",\"password\":\"harley1\",\"salt\":\"F6wOgjP7\",\"md5\":\"eb9312bc6c2b8a53bf0339cf0813c999\",\"sha1\":\"0ea8ce0f5da109987cbc87514d83f3059e03914d\",\"sha256\":\"6cefd47773a290fb77413f0c8934e76e149478fa6ffaa2b3080e98201087fbb1\"},\"dob\":{\"date\":\"1990-08-02T12:49:16.451Z\",\"age\":30},\"registered\":{\"date\":\"2018-08-24T08:04:53.193Z\",\"age\":2},\"phone\":\"90624510\",\"cell\":\"96921021\",\"id\":{\"name\":\"CPR\",\"value\":\"020890-1704\"},\"picture\":{\"large\":\"https://randomuser.me/api/portraits/women/11.jpg\",\"medium\":\"https://randomuser.me/api/portraits/med/women/11.jpg\",\"thumbnail\":\"https://randomuser.me/api/portraits/thumb/women/11.jpg\"},\"nat\":\"DK\"}],\"info\":{\"seed\":\"2e54e582e379c5c4\",\"results\":1,\"page\":1,\"version\":\"1.3\"}}";
    String name, salary;
    TextView employeeName, employeeSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the reference of TextView's
        employeeName = (TextView) findViewById(R.id.name);
        employeeSalary = (TextView) findViewById(R.id.salary);

        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(JSON_STRING);
            // fetch JSONObject named employee
            JSONObject employee = obj.getJSONObject("name");
            // get employee name and salary
            name = employee.getString("title");
            salary = employee.getString("first");
            // set employee name and salary in TextView's
            employeeName.setText("Name: "+name);
            employeeSalary.setText("Salary: "+salary);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}