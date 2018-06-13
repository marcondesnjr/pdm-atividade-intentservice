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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import marcondesnjr.github.io.atividadeintentservice.entities.Repository;

public class RepoService extends IntentService {

    public RepoService(String name) {
        super(name);
    }

    public RepoService() {
        super("DFT");
    }

    @Override
    protected void onHandleIntent(@Nullable final Intent intent) {
        String usr = intent.getStringExtra("usr");
        String urlStr = "https://api.github.com/users/"+usr+"/repos";
        URL url = null;
        String result = "";
        try {
            url = new URL(urlStr);

        BufferedReader reader = null;

            reader = new BufferedReader(new InputStreamReader(url.openStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            result += line;
        }
        reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("APP", result);


    }



}
