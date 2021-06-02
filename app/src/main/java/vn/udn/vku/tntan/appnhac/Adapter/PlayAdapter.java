package vn.udn.vku.tntan.appnhac.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.udn.vku.tntan.appnhac.Model.Baihat;
import vn.udn.vku.tntan.appnhac.R;

public class  PlayAdapter extends RecyclerView.Adapter<PlayAdapter.ViewHolder> {

    Context context;
    ArrayList<Baihat> mangbaihat;

    public PlayAdapter(Context context, ArrayList<Baihat> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_playbaihat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayAdapter.ViewHolder holder, int position) {
        Baihat baihat = mangbaihat.get(position);
        holder.txtcasi.setText(baihat.getCasi());
        holder.txtindex.setText(position + 1 + "");
        holder.txttenbaihat.setText(baihat.getTenbaihat());
        Picasso.with(context).load(baihat.getHinhbaihat()).into(holder.imghinhbaihat);
        Picasso.with(context).load(baihat.getLuotthich()).into(holder.imglike);
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtindex, txttenbaihat, txtcasi;
        ImageView imghinhbaihat, imglike;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtcasi = itemView.findViewById(R.id.txtplaytencasi);
            txttenbaihat = itemView.findViewById(R.id.txtplaynhactenbaihat);
            txtindex = itemView.findViewById(R.id.txtplayindex);
            imghinhbaihat = itemView.findViewById(R.id.imghinhbaihat);
            imglike = itemView.findViewById(R.id.imgyeuthich);
        }
    }
}
