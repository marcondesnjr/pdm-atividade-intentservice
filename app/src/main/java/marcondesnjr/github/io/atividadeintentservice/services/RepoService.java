package marcondesnjr.github.io.atividadeintentservice.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import marcondesnjr.github.io.atividadeintentservice.entities.Repository;

public class RepoService extends IntentService {

    public RepoService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable final Intent intent) {
        String usr = intent.getStringExtra("usr");
        String url = "https://api.github.com/users/"+usr+"/repos";
        Ion.with(getApplicationContext()).load(url).asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
                try {
                    JSONArray json = new JSONArray(result);
                    Bundle b = new Bundle();
                    for(int i = 0; i<json.length(); i++){
                        JSONObject obj = json.getJSONObject(i);
                        String nome = obj.getString("name");
                        String autor = obj.getJSONObject("owner").getString("login");
                        String autorImg = obj.getJSONObject("owner").getString("avatar_url");
                        String desc = obj.getString("description");
                        Repository repo = new Repository(autorImg,nome,autor,desc);
                        b.putSerializable("repos", repo);
                    }
                }catch (JSONException ex){
                    Log.e("app", "Could not parse malformed JSON: \"" + ex + "\"");
                }
            }
        });
    }



}
