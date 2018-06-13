package marcondesnjr.github.io.atividadeintentservice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import marcondesnjr.github.io.atividadeintentservice.entities.Repository;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.RepoViewHolder> {

    private List<Repository> repositories;
    private Context context;

    public ReposAdapter(List<Repository> repositories, Context context) {
        this.repositories = repositories;
        this.context = context;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RepoViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class RepoViewHolder extends RecyclerView.ViewHolder{
        public RepoViewHolder(View itemView) {
            super(itemView);
        }
    }

}
