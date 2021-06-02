package vn.udn.vku.tntan.appnhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.udn.vku.tntan.appnhac.Activity.DanhsachbaihatActivity;
import vn.udn.vku.tntan.appnhac.Model.Playlist;
import vn.udn.vku.tntan.appnhac.R;

public class DanhsachcacplaylistAdapter extends RecyclerView.Adapter<DanhsachcacplaylistAdapter.ViewHolder> {

    Context context;
    ArrayList<Playlist> mangcacplaylist;

    public DanhsachcacplaylistAdapter(Context context, ArrayList<Playlist> mangcacplaylist) {
        this.context = context;
        this.mangcacplaylist = mangcacplaylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danhsachplaylist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhsachcacplaylistAdapter.ViewHolder holder, int position) {
        Playlist playlist = mangcacplaylist.get(position);
        Picasso.with(context).load(playlist.getIcon()).into(holder.imghinhnen);
        holder.txttenplaylist.setText(playlist.getTen());
    }

    @Override
    public int getItemCount() {
        return mangcacplaylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imghinhnen;
        TextView txttenplaylist;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imghinhnen =itemView.findViewById(R.id.imvdsplaylist);
            txttenplaylist =itemView.findViewById(R.id.txtTenPlaylist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("itemplaylist",mangcacplaylist.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
