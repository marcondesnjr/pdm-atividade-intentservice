package marcondesnjr.github.io.atividadeintentservice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        Repository rep = repositories.get(position);
        holder.textViewNome.setText(rep.getNome());
        holder.textViewAutor.setText(rep.getAutor());
        holder.textViewDesc.setText(rep.getDesc());
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public void add(List<Repository> list){
        this.repositories.addAll(list);
        this.notifyDataSetChanged();
    }

    class RepoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textViewNome;
        private TextView textViewAutor;
        private TextView textViewDesc;

        public RepoViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.textViewNome = itemView.findViewById(R.id.textViewName);
            this.textViewAutor = itemView.findViewById(R.id.textViewAutor);
            this.textViewDesc = itemView.findViewById(R.id.textViewDesc);
        }
    }

}
