package vn.udn.vku.tntan.appnhac.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.udn.vku.tntan.appnhac.Adapter.SearchAdapter;
import vn.udn.vku.tntan.appnhac.Model.Baihat;
import vn.udn.vku.tntan.appnhac.R;
import vn.udn.vku.tntan.appnhac.Service.APIService;
import vn.udn.vku.tntan.appnhac.Service.Dataservice;

public class Fragment_Tim_Kiem extends Fragment {

    View view;
    Toolbar toolbar;
    RecyclerView recyclerViewseach;
    TextView txttrongdulieu;
    SearchAdapter searchAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tim_kiem,container,false);
        toolbar =view.findViewById(R.id.toolbarsearch);
        recyclerViewseach = view.findViewById(R.id.recyclerSearch);
        txttrongdulieu = view.findViewById(R.id.txttrong);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("");
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull  Menu menu,  MenuInflater inflater) {
        inflater.inflate(R.menu.seach_view, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        SearchView seach_view = (SearchView) menuItem.getActionView();
        seach_view.setMaxWidth(Integer.MAX_VALUE);
        seach_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                SearchTukhoa(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
    private void SearchTukhoa(String  query){
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetSearch(query);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                ArrayList<Baihat> mangbaihat = (ArrayList<Baihat>) response.body();
                if (mangbaihat.size() > 0){
                    searchAdapter = new SearchAdapter(getActivity(), mangbaihat);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerViewseach.setLayoutManager(linearLayoutManager);
                    recyclerViewseach.setAdapter(searchAdapter);
                    txttrongdulieu.setVisibility(View.GONE);
                    recyclerViewseach.setVisibility(View.VISIBLE);
                }else{
                    recyclerViewseach.setVisibility(View.GONE);
                    txttrongdulieu.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }
}
