package vn.udn.vku.tntan.appnhac.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import vn.udn.vku.tntan.appnhac.Model.Playlist;
import vn.udn.vku.tntan.appnhac.R;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {
    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {
        super(context, resource, objects);
    }
    class ViewHolder{
        TextView txttenplaylist;
        ImageView imgbackground, imgplaylist;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;  // cap phat gia tri truoc
        if (convertView == null)       //neu nhu random lan dau tien ma cvv chua co view nao o ben trong
        {
            //gan layout vao va anh xa lai
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dong_playlist,null);
            viewHolder = new ViewHolder();
            viewHolder.txttenplaylist = convertView.findViewById(R.id.txttenplaylist);
            viewHolder.imgplaylist = convertView.findViewById(R.id.imvplaylist);
            viewHolder.imgbackground = convertView.findViewById(R.id.imvbackgroundplaylist);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Playlist playlist = getItem(position);
        Picasso.with(getContext()).load(playlist.getHinhPlayList()).into(viewHolder.imgbackground);
        Picasso.with(getContext()).load(playlist.getIcon()).into(viewHolder.imgplaylist);
        viewHolder.txttenplaylist.setText(playlist.getTen());

        return convertView;
    }
}
