package com.kuy.application.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v4.content.ContextCompat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kuy.application.models.Station;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gilang on 5/1/17.
 */

public class StationUtil {

    private List<Station> stations;
    private Map<String, Station> map;

    private StationUtil() {
        stations = new ArrayList<>();
        map = new HashMap<>();
    }

    private static class Singleton {
        public static final StationUtil instance = new StationUtil();
    }

    public static StationUtil getInstance() {
        return Singleton.instance;
    }


    public void loadStationsFromData(Context context) {
        try {
            String json = readFromAssets(context, "station.json");
            Gson gson = new Gson();
            stations = gson.fromJson(json, new TypeToken<ArrayList<Station>>() {
            }.getType());
            for (Station s : stations) {
                map.put(s.getId(), s);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Station> getStations() {
        return stations;
    }

    public static String readFromAssets(Context context, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(filename)));

        // do reading, usually loop until end of file reading
        StringBuilder sb = new StringBuilder();
        String mLine = reader.readLine();
        while (mLine != null) {
            sb.append(mLine); // process line
            mLine = reader.readLine();
        }
        reader.close();
        return sb.toString();
    }

}
