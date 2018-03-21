package model;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.stream.JsonReader;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.*;

public class test {

    public static void main(String[] args) throws FileNotFoundException {
       // InputStream inputStream = new FileInputStream("/Automation/task/src/test/resources/Credentials.json");
       // InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
       // JsonReader jsonReader = new JsonReader(inputStreamReader);
        //vUser vkUser = new vUser();
        String path = "/Automation/task/src/test/resources/Credentials.json";
       // final String FILE_NAME = "/Automation/task/src/test/resources/Credentials.xlsx";

       BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

      //Gson gson = new Gson();
       JsonObject json = new Gson().fromJson(bufferedReader, JsonObject.class);

        System.out.println(json.get("username").getAsString());
        System.out.println(json.get("password").getAsString());

       // System.out.println(json.getClass());
       // System.out.println(json.toString());

       // System.out.println(vkUser.getUsername());

        //JSONObject myObject = new JSONObject();
      //  String username = myObject.getJSONObject("username").toString();
       // System.out.println(username);




    }
    }

