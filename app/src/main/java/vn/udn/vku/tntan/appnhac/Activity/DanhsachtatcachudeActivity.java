package vn.udn.vku.tntan.appnhac.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.udn.vku.tntan.appnhac.Adapter.DanhsachtatcachudeAdapter;
import vn.udn.vku.tntan.appnhac.Model.ChuDe;
import vn.udn.vku.tntan.appnhac.R;
import vn.udn.vku.tntan.appnhac.Service.APIService;
import vn.udn.vku.tntan.appnhac.Service.Dataservice;

public class DanhsachtatcachudeActivity extends AppCompatActivity {

    RecyclerView recyclerViewtatcachude;
    Toolbar toolbartatcachude;
    DanhsachtatcachudeAdapter danhsachtatcachudeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatcachude);
        init();
        GetData();
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<ChuDe>> callback = dataservice.GetAllchude();
        callback.enqueue(new Callback<List<ChuDe>>() {
            @Override
            public void onResponse(Call<List<ChuDe>> call, Response<List<ChuDe>> response) {
                ArrayList<ChuDe> mangchude = (ArrayList<ChuDe>) response.body();
                danhsachtatcachudeAdapter = new DanhsachtatcachudeAdapter(DanhsachtatcachudeActivity.this,mangchude);
                recyclerViewtatcachude.setLayoutManager(new GridLayoutManager(DanhsachtatcachudeActivity.this,1));
                recyclerViewtatcachude.setAdapter(danhsachtatcachudeAdapter);
            }

            @Override
            public void onFailure(Call<List<ChuDe>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerViewtatcachude = findViewById(R.id.recylertatcachude);
        toolbartatcachude = findViewById(R.id.toolbartatcachude);
        setSupportActionBar(toolbartatcachude);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất Cả Chủ Đề");
        toolbartatcachude.setTitleTextColor(getResources().getColor(R.color.mautim));
        toolbartatcachude.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}