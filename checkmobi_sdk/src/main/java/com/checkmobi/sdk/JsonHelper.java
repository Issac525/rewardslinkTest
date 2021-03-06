package com.checkmobi.sdk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class JsonHelper
{

    public static Map<String, Object> toMap(JSONObject object) throws JSONException
    {
        HashMap<String, Object> map = new HashMap<>();
        Iterator keys = object.keys();

        while (keys.hasNext())
        {
            String key = (String) keys.next();
            map.put(key, fromJson(object.get(key)));
        }

        return map;
    }

    private static List toList(JSONArray array) throws JSONException
    {
        List list = new ArrayList();

        for (int i = 0; i < array.length(); i++)
            list.add(fromJson(array.get(i)));

        return list;
    }

    private static Object fromJson(Object json) throws JSONException
    {
        if (json == JSONObject.NULL)
            return null;
        else if (json instanceof JSONObject)
            return toMap((JSONObject) json);
        else if (json instanceof JSONArray)
            return toList((JSONArray) json);
        else
            return json;
    }
}