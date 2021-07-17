package utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class ReadJsonFile {
    /***
     * @return Username and Password from json file
     * @throws IOException while reading  json file
     * @throws ParseException Converting json data into object
     */

    @DataProvider(name = "Login")
    public Object[] ReadJsonFile() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\Administrator\\IdeaProjects\\FlipkartDataDriven\\src\\main\\java\\utility\\Credentials.json");

        Object obj = jsonParser.parse(reader);

        JSONObject userloginsJsonobj = (JSONObject) obj;
        JSONArray userloginsArray = (JSONArray) userloginsJsonobj.get("userlogins");
        //store data in array
        String arr[] = new String[userloginsArray.size()];
        //read data from array
        for (int i =0; i< userloginsArray.size();i++){
            JSONObject users = (JSONObject) userloginsArray.get(i);
            String Username = (String) users.get("Username");
            String Password = (String) users.get("Password");

            arr[i] = Username+","+Password;
        }
        return arr;

    }
}
