package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    public static Object [][] getJsonData(String JsonPath, String JsonData, int attribute) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(JsonPath));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray jsonArray = (JSONArray) jsonObject.get(JsonData);

        Object [][] objectArray = new String [jsonArray.size()][attribute];
        for(int i = 0; i < jsonArray.size(); i ++){
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
            objectArray[i][0] = String.valueOf(jsonObject1.get("TaskTitle"));
            System.out.println("The first element: " +objectArray[i][0] );
            objectArray[i][1] = String.valueOf(jsonObject1.get("TaskNote"));
            System.out.println("The second element: " +objectArray[i][1] );
        }
        return objectArray;
    }
}
