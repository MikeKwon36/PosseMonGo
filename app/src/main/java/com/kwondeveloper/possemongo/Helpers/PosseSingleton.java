package com.kwondeveloper.possemongo.Helpers;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.kwondeveloper.possemongo.Data.JsonObject;
import com.kwondeveloper.possemongo.Data.Locations;
import com.kwondeveloper.possemongo.Data.Posse;
import com.kwondeveloper.possemongo.Data.Programmers;
import com.kwondeveloper.possemongo.Data.Response;
import com.kwondeveloper.possemongo.Data.Services;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 9/3/2016.
 */
public class PosseSingleton {

    public static final String POSSE_JSON_FILE = "android_model_challenge.json";

    //Made sense to leave this global variable here since the Singleton instance persists across
    // state changes and activity/fragment life cycles
    public static boolean mTwoPane;

    private static PosseSingleton mInstance;
    private static ArrayList<Posse> mArray;
    private static Context mContext;

    //Singleton ArrayList constructor is private to ensure only a single instance is created
    private PosseSingleton(){
        mArray = new ArrayList<Posse>();
    }

    //getInstance() method call instantiates and/or returns an instance of the PosseSingleton class
    //Context is passed in getInstance() to enable access to assets resource folder
    public static PosseSingleton getInstance(Context context){
        Log.d("***PosseSingleton", "Singleton getInstance method called");
        if(mInstance==null){
            mInstance = new PosseSingleton();
            mContext = context;
            resetRoster();
            Log.d("***PosseSingleton", "Singleton roster instantiated");
        }
        return mInstance;
    }

    public static void addProgrammer(Posse programmer){
        mArray.add(programmer);
    }
    public static Posse removeProgrammer(int index){
        return mArray.remove(index);
    }
    public static Posse getProgrammer(int index){
        return mArray.get(index);
    }
    public static ArrayList<Posse> getRoster(){
            return mArray;
    }

    //This version of addProgrammer() is needed when dragging & dropping list items in specific positions
    public static void addProgrammer(Posse programmer, int position){
        mArray.add(position,programmer);
    }

    //Populates the roster during launch, and resets the roster if floating action button is clicked
    public static void resetRoster(){
        Log.d("***PosseSingleton", "resetRoster() called");
        String json;
        if(!mArray.isEmpty()){mArray.clear();}
        json = loadJSONFromAsset(POSSE_JSON_FILE);
        loadProgrammers(json);
    }

    //Method to make the phone number appear a little nicer
    public static String formatPhoneNumber (String s) {
        return String.format("(%s) %s-%s",s.substring(0, 3),s.substring(3, 6),s.substring(6, 10));
    }

    //JSON document stored in App's assets folder for access (normally this process would be
    // preceded/replaced by an HTTP API call to build a JSON object from the web
    @Nullable
    public static String loadJSONFromAsset(String fileName) {
        String json;
        try {
            InputStream is = mContext.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        Log.d("***PosseSingleton", "Is JSON populated?" + !json.isEmpty());
        return json;
    }

    //Leverage GSON to build 'Posse' objects to store programmer information in a Singleton reference
    public static void loadProgrammers(String json) {
        Log.d("***PosseSingleton", "loadProgrammers method called");
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json,JsonObject.class);
        for (Locations location:jsonObject.getResponse().getLocations()) {
            for(Services service:location.getServices()){
                for(Programmers programmer:service.getProgrammers()){
                    Posse newProgrammer = new Posse();
                    newProgrammer.setAge(programmer.getAge());
                    newProgrammer.setArtist(programmer.getArtist());
                    newProgrammer.setFavoriteColor(programmer.getFavoriteColor());
                    newProgrammer.setName(programmer.getName());
                    newProgrammer.setPhone(formatPhoneNumber(programmer.getPhone()));
                    newProgrammer.setWeight(programmer.getWeight());
                    newProgrammer.setPlatform(service.getPlatform());
                    newProgrammer.setPostalCode(location.getPostalCode());
                    newProgrammer.setRegion(location.getRegion());
                    newProgrammer.setLocality(location.getLocality());
                    newProgrammer.setCountry(location.getCountry());
                    Log.d("***PosseSingleton", newProgrammer.getName() + " added to Singleton");
                    PosseSingleton.addProgrammer(newProgrammer);
                }
            }
        }
    }
}