package desktop.minhnhut.model;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by minhnhut on 3/15/2018.
 */

public class ACDatabase {

    private Context context;
    private int resourceId;

    public ACDatabase() {

    }

    public ACDatabase(Context context, int resourceId) {
        this.context = context;
        this.resourceId = resourceId;
    }

    public Context getContext() {
        return context;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }


    public ArrayList<String> getListKeyDatabase() throws IOException, JSONException {
        JSONObject jsonObjectRoot = getJsonObjectRoot();
        return getListKeyJsonObject(jsonObjectRoot);
    }

    public ArrayList<String> getListKeyBrandModel() throws IOException, JSONException {
        JSONObject jsonObjectBrandModel = getJsonObjectWithKeyBrandModel();
        ArrayList<String> keyBrand = getListKeyJsonObject(jsonObjectBrandModel);
        return sortBrands(keyBrand);
    }

    public ArrayList<String> getListKeyRemoteConfig() throws IOException, JSONException {
        JSONObject jsonObjectRemoteConfig = getJsonObjectWithKeyRemoteConfig();
        ArrayList<String> keyRemoteConfig = getListKeyJsonObject(jsonObjectRemoteConfig);
        return sortRemoteConfigs(keyRemoteConfig);
    }

    public HashMap<String, ArrayList<String>> getHashMapBrandModel() throws IOException, JSONException {
        JSONObject jsonObjectWithKeyBrandModel = getJsonObjectWithKeyBrandModel();

        HashMap<String, ArrayList<String>> hashMapBrandModel = new HashMap<>();

        ArrayList<String> keyBrand = getListKeyBrandModel();
        for (String brand : keyBrand) {
            JSONObject jsonObjectBrand = jsonObjectWithKeyBrandModel.getJSONObject(brand);
            ArrayList<String> listKeyModelOfBrand = getListKeyJsonObject(jsonObjectBrand);
            hashMapBrandModel.put(brand, listKeyModelOfBrand);
        }

        return hashMapBrandModel;
    }

    public HashMap<String, HashMap<String, ACModel>> getDatabase() throws IOException, JSONException {
        HashMap<String, HashMap<String, ACModel>> acdatabase = new HashMap<>();

        HashMap<String, ArrayList<String>> hashMapBrandModel = getHashMapBrandModel();

        JSONObject jsonObjectBrandModel = getJsonObjectWithKeyBrandModel();

        for (String brand : hashMapBrandModel.keySet()) {
            HashMap<String, ACModel> hashMapModel = new HashMap<>();

            JSONObject jsonObjectBrand = jsonObjectBrandModel.getJSONObject(brand);
            for (String model : hashMapBrandModel.get(brand)) {
                ACModel acModel = getModel(jsonObjectBrand.getJSONObject(model));
                hashMapModel.put(model, acModel);
            }

            acdatabase.put(brand, hashMapModel);
        }

        return acdatabase;
    }

    public int getRemoteConfigFromBrandModel(HashMap<String, HashMap<String, ACModel>> database, ACConfig acConfig) {
        return database.get(acConfig.getBrand()).get(acConfig.getModel()).getRemoteConfig();
    }

    public RemoteConfig getRemoteConfig(int remoteConfig) throws IOException, JSONException {
        JSONObject jsonObjectRemoteConfig = getJsonObjectWithKeyRemoteConfig();
        return getRemoteConfig(jsonObjectRemoteConfig.getJSONObject(remoteConfig + ""));
    }

    private ACModel getModel(JSONObject jsonObjectModel) throws IOException, JSONException {
        ACModel acModel = new ACModel();
        acModel.setRemoteConfig(jsonObjectModel.getInt(Define.Key_RemoteConfig));
        acModel.setInverter(jsonObjectModel.getInt(Define.Key_Inverter));
        acModel.setHeatingPower(jsonObjectModel.getInt(Define.Key_HeatingPower));
        acModel.setCoolingPower(jsonObjectModel.getInt(Define.Key_CoolingPower));
        acModel.setCoolingPower(jsonObjectModel.getInt(Define.Key_InputPower));
        acModel.setIndoorOutdoorLink(jsonObjectModel.getInt(Define.Key_IndoorOutdoorLink));
        acModel.setMainPowerTo(jsonObjectModel.getString(Define.Key_MainPowerTo));

        return acModel;
    }

    private RemoteConfig getRemoteConfig(JSONObject jsonObjectRemoteConfig) throws IOException, JSONException {
        RemoteConfig remoteConfig = new RemoteConfig();

        remoteConfig.setRemoteID(jsonObjectRemoteConfig.getInt(Define.Key_RemoteID));
        remoteConfig.setMaxTemp(jsonObjectRemoteConfig.getInt(Define.Key_MaxTemp));
        remoteConfig.setMinTemp(jsonObjectRemoteConfig.getInt(Define.Key_MinTemp));
        remoteConfig.setMaxFan(jsonObjectRemoteConfig.getInt(Define.Key_MaxFan));
        remoteConfig.setHeatMode(jsonObjectRemoteConfig.getInt(Define.Key_HeatMode));
        remoteConfig.setAutoMode(jsonObjectRemoteConfig.getInt(Define.Key_AutoMode));
        remoteConfig.setFile(jsonObjectRemoteConfig.getString(Define.Key_File));
        remoteConfig.setImage(jsonObjectRemoteConfig.getString(Define.Key_Image));

        return remoteConfig;
    }

    private String getTextFromJsonACDatabase() throws IOException {
        InputStream is = this.context.getResources().openRawResource(this.resourceId);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String s;
        while((s = br.readLine()) != null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }

    private JSONObject getJsonObjectRoot() throws IOException, JSONException {
        String jsonText = getTextFromJsonACDatabase();
        return new JSONObject(jsonText);
    }

    private JSONObject getJsonObjectWithKeyBrandModel() throws IOException, JSONException {
        JSONObject jsonObjectRoot = getJsonObjectRoot();
        return jsonObjectRoot.getJSONObject(Define.KEY_BRANDMODEL);
    }

    private JSONObject getJsonObjectWithKeyRemoteConfig() throws IOException, JSONException {
        JSONObject jsonObjectRoot = getJsonObjectRoot();
        return jsonObjectRoot.getJSONObject(Define.KEY_REMOTE_CONFIG);
    }

    private ArrayList<String> getListKeyJsonObject(JSONObject jsonObject)  {
        ArrayList<String> keyRoot = new ArrayList<>();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            keyRoot.add(key);
        }
        return keyRoot;
    }



    private ArrayList<String> sortBrands(ArrayList<String> arrayList) {
        Collections.sort(arrayList);
        return arrayList;
    }

    private ArrayList<String> sortRemoteConfigs(ArrayList<String> arrayList) {
        ArrayList<Integer> arrayListInt = getArrayListInteger(arrayList);
        Collections.sort(arrayListInt);
        return getArrayListString(arrayListInt);
    }

    private ArrayList<Integer> getArrayListInteger(ArrayList<String> arrayList) {
        ArrayList<Integer> result = new ArrayList<>();

        for (String strValue : arrayList) {
            result.add(Integer.parseInt(strValue));
        }

        return result;
    }

    private ArrayList<String> getArrayListString(ArrayList<Integer> arrayList) {
        ArrayList<String> result = new ArrayList<>();

        for (int intValue : arrayList) {
            result.add(intValue + "");
        }

        return result;
    }

}
