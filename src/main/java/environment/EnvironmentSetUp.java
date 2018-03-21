package environment;
import com.google.gson.stream.JsonReader;
import model.vUser;

import java.io.*;


public class EnvironmentSetUp {

    vUser vUser = new vUser();
    private static final File FILE = new File("/Automation/task/src/test/resources/Credentials.json");

    public EnvironmentSetUp() throws FileNotFoundException {
    }

    public void readCredsFromJson() throws IOException {
        JsonReader jsonReader = new JsonReader(new StringReader("/Automation/task/src/test/resources/Credentials.json"));
        while (jsonReader.hasNext()){
            String name = jsonReader.nextName();
            if (name.equals("username")){
                vUser.setUsername(jsonReader.nextString());
            }
            if (name.equals("password")){
                vUser.setPassword(jsonReader.nextString());
            }
        }
        //InputStream inputStream = new FileInputStream(FILE);
        //vUser.setUsername(inputStream.read());


        {

            }
        };
    }

