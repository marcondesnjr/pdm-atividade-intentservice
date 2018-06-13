package marcondesnjr.github.io.atividadeintentservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import marcondesnjr.github.io.atividadeintentservice.entities.Repository;
import marcondesnjr.github.io.atividadeintentservice.services.RepoService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final List<Repository> list = new ArrayList<>();

        ReposAdapter rAdapter = new ReposAdapter(new ArrayList<Repository>(),this);
        recyclerView.setAdapter(rAdapter);

        BroadcastReceiver bReceiver = new BroadcastReceiver(){

            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle b = intent.getBundleExtra("repos");
                ArrayList<Repository> repoList = new ArrayList<>();
                for(int i = 1; i< b.size(); i++){
                    repoList.add((Repository) b.getSerializable(i+""));
                }
                updateList(list);
            }
        };
        LocalBroadcastManager.getInstance(this).registerReceiver(bReceiver, new IntentFilter("REP_LOADED"));

        findViewById(R.id.buttonEnviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = ((EditText) findViewById(R.id.editTextNome)).getText().toString();
                startService(nome);
            }
        });

    }



    private void startService(String nome){
        Intent intent = new Intent(this, RepoService.class);
        intent.putExtra("usr", nome );
        startService(intent);
    }

    private void updateList(List<Repository> list){
        RecyclerView recyclerView = findViewById(R.id.recView);
        ((ReposAdapter) recyclerView.getAdapter()).add(list);
    }
}
