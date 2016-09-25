package Util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Amit on 9/25/2016.
 */
public class JSONParser {

    public static JSONObject getObject(String tagName, JSONObject jsonObject)
            throws JSONException {

        JSONObject jObj = jsonObject.getJSONObject(tagName);
        return jObj;
    }

    public static String getString(String tagName, JSONObject jsonObject)
            throws JSONException {

        return jsonObject.getString(tagName);
    }

    public static int getInt(String tagName, JSONObject jsonObject)
            throws JSONException {

        return jsonObject.getInt(tagName);
    }

}
