package model;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.*;

public class vUser {
    private String username;
    private String password;

    private static final File FILE = new File("/Automation/task/src/test/resources/Credentials.json");

    //@JsonProperty("url")
   // private String url;

    //public void readCredsFromJson() throws IOException {
      //  JsonReader jsonReader = new JsonReader(new StringReader("/Automation/task/src/test/resources/Credentials.json"));
       // while (jsonReader.hasNext()) {
           // String name = jsonReader.nextName();
           // if (name.equals("username")) {
           //    setUsername(jsonReader.nextString());
          //  }
          //  if (name.equals("password")) {
          //      setPassword(jsonReader.nextString());
         //   }
       // }
   // }

    BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE));
    JsonObject json = new Gson().fromJson(bufferedReader, JsonObject.class);

    public vUser() throws FileNotFoundException {
    }

    public String getUsername() {
        username = json.get("username").getAsString();
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        password = json.get("password").getAsString();
        System.out.println();
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return new StringBuffer("username:").append(this.username).append("password")
                .append(this.password).toString();
    }
}
