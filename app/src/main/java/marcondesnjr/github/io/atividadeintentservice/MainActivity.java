package marcondesnjr.github.io.atividadeintentservice;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import marcondesnjr.github.io.atividadeintentservice.entities.Repository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Repository> list = new ArrayList<>();

        ReposAdapter rAdapter = new ReposAdapter(null,this);
        recyclerView.setAdapter(rAdapter);
    }


}
