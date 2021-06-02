package vn.udn.vku.tntan.appnhac.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.udn.vku.tntan.appnhac.Activity.DanhsachbaihatActivity;
import vn.udn.vku.tntan.appnhac.Activity.DanhsachtatcachudeActivity;
import vn.udn.vku.tntan.appnhac.Activity.DanhsachtheloaitheochudeActivity;
import vn.udn.vku.tntan.appnhac.Model.ChuDe;
import vn.udn.vku.tntan.appnhac.Model.TheLoai;
import vn.udn.vku.tntan.appnhac.Model.TheloaiChude;
import vn.udn.vku.tntan.appnhac.R;
import vn.udn.vku.tntan.appnhac.Service.APIService;
import vn.udn.vku.tntan.appnhac.Service.Dataservice;

public class Fragment_Chude_Theloai extends Fragment {

    View view;
    HorizontalScrollView horizontalScrollView;
    TextView txtxemthem;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chude,container,false);
        horizontalScrollView = view.findViewById(R.id.horizontalscrollview);
        txtxemthem = view.findViewById(R.id.txtxemthem);
        txtxemthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DanhsachtatcachudeActivity.class);
                startActivity(intent);
            }
        });

        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<TheloaiChude> callback = dataservice.GetChudeVaTheloaiCurrentDay();
        callback.enqueue(new Callback<TheloaiChude>(){

            @Override
            public void onResponse(Call<TheloaiChude> call, Response<TheloaiChude> response) {
                TheloaiChude theloaiChude = response.body();

                final ArrayList<ChuDe> chudeArrayList = new ArrayList<>();
                chudeArrayList.addAll(theloaiChude.getChuDe());

                final ArrayList<TheLoai> theloaiArrayList = new ArrayList<>();
                theloaiArrayList.addAll(theloaiChude.getTheLoai());

                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(580,250);
                layout.setMargins(10,20,10,30);

                for (int i=0 ; i<(chudeArrayList.size());i++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (chudeArrayList.get(i).getHinhChuDe() != null){
                        Picasso.with(getActivity()).load(chudeArrayList.get(i).getHinhChuDe()).into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                    int finalI = i;
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity(), DanhsachtheloaitheochudeActivity.class);
                            intent.putExtra("chude",chudeArrayList.get(finalI));
                            startActivity(intent);
                        }
                    });

                }

                for (int j=0 ; j<(chudeArrayList.size());j++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (theloaiArrayList.get(j).getHinhTheLoai() != null){
                       Picasso.with(getActivity()).load(theloaiArrayList.get(j).getHinhTheLoai()).into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                    int finalJ = j;
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity(), DanhsachbaihatActivity.class);
                            intent.putExtra("idtheloai",theloaiArrayList.get(finalJ));
                            startActivity(intent);
                        }
                    });


                 }
                horizontalScrollView.addView(linearLayout);

            }

            @Override
            public void onFailure(Call<TheloaiChude> call, Throwable t) {

            }
        });
    }
}
