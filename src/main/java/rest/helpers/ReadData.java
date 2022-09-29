package rest.helpers;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class ReadData {
    Util util = new Util();
    private JSONObject jsonObject;
    JSONParser parser = new JSONParser();

    public void readTestData() {

        try {
            Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + util.getProperty("JSON-PATH")));
            jsonObject = new JSONObject(obj.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject getTestData(String filter) {

        if (jsonObject == null)
            readTestData();

        return (JSONObject) jsonObject.get(filter);
    }
}