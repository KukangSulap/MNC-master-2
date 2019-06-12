package com.example.reza.form;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.reza.form.model.ResponseDb;
import com.example.reza.form.network.ApiClient;
import com.example.reza.form.network.RegisterAPI;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AdminActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener  {

    private List<ResponseDb> responseDb;
    @BindView(R.id.rv_admin)
    RecyclerView rvAdmin;
    @BindView(R.id.refreshlayout)
    SwipeRefreshLayout refreshlayout;
    RegisterAPI mApiService;
    String surveyor,kab_kota,kompleks,tanggal_survey,kelurahan,akses_penjualan,roll_out,mayoritas_kendaraan,rata2_biaya,klasifikasi_tipe_rumah,mayoritas_provider,jenis_properti_area,kecamatan,developer,id_report,metode_pembangunan,region,kompetitor;

    List<ResponseDb> dataItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ButterKnife.bind(this);
        kab_kota = getIntent().getStringExtra("kab_kota");
        kompleks = getIntent().getStringExtra("kompleks");
        tanggal_survey = getIntent().getStringExtra("tanggal_survey");
        kelurahan = getIntent().getStringExtra("kelurahan");
        akses_penjualan = getIntent().getStringExtra("akses_penjualan");
        roll_out = getIntent().getStringExtra("roll_out");
        mayoritas_kendaraan = getIntent().getStringExtra("mayoritas_kendaraan");
        rata2_biaya = getIntent().getStringExtra("rata2_biaya");
        klasifikasi_tipe_rumah = getIntent().getStringExtra("klasifikasi_tipe_rumah");
        mayoritas_provider = getIntent().getStringExtra("mayoritas_provider");
        jenis_properti_area = getIntent().getStringExtra("jenis_properti_area");
        kecamatan = getIntent().getStringExtra("kecamatan");
        developer = getIntent().getStringExtra("developer");
        id_report = getIntent().getStringExtra("id_report");
        kompetitor = getIntent().getStringExtra("kompetitor");
        metode_pembangunan = getIntent().getStringExtra("metode_pembangunan");
        region = getIntent().getStringExtra("region");
        surveyor = getIntent().getStringExtra("surveyor");
        loadData();
        refreshlayout.setOnRefreshListener(this);

    }

    public void loadData() {
        final Call<JsonArray> recipeCall = (Call<JsonArray>) ApiClient.getClient().readDb(surveyor,kab_kota,kompleks,tanggal_survey,kelurahan,akses_penjualan,roll_out,mayoritas_kendaraan,rata2_biaya,klasifikasi_tipe_rumah,mayoritas_provider,jenis_properti_area,kecamatan,developer,id_report,kompetitor,metode_pembangunan,region);
        recipeCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

                String hasilString = response.body().toString();
                Type listType = new TypeToken<List<ResponseDb>>(){}.getType();
                dataItems = getTeamListFromJson(hasilString, listType);
                Log.d("Retrofit Get", "Jumlah Data = " + String.valueOf(dataItems.size()));
                Collections.sort(dataItems, ResponseDb.BY_ID);
                if (dataItems.size() == 0){
                    LinearLayout linearLayout = findViewById(R.id.constlayout);
                } else {
                    rvAdmin.setLayoutManager(new LinearLayoutManager(AdminActivity.this));
                    rvAdmin.setAdapter(new CustomAdapter(dataItems, AdminActivity.this));
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.d("Retrofit Get", t.getMessage());
            }
        });

    }

    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

        List<ResponseDb> responseDb;
        Context context;

        public CustomAdapter(List<ResponseDb> responseDb, AdminActivity adminActivity) {
            this.responseDb = responseDb;
            this.context = adminActivity;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(context).inflate(R.layout.listitem, null);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
            holder.preview_Tanggal.setText(responseDb.get(position).getTanggalSurvey());
            holder.preview1.setText("Report ID :  " + responseDb.get(position).getIdReport());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, DetailActivity.class)

                            .putExtra("kab_kota",(responseDb.get(position).getKabKota()))
                            .putExtra("surveyor",(responseDb.get(position).getSurveyor()))
                            .putExtra("kompleks",(responseDb.get(position).getKompleks()))
                            .putExtra("tanggal_survey",(responseDb.get(position).getTanggalSurvey()))
                            .putExtra("akses_penjualan",(responseDb.get(position).getAksesPenjualan()))
                            .putExtra("roll_out",(responseDb.get(position).getRollOut()))
                            .putExtra("mayoritas_kendaraan",(responseDb.get(position).getMayoritasKendaraan()))
                            .putExtra("rata2_biaya", (responseDb.get(position).getRata2Biaya()))
                            .putExtra("klasifikasi_tipe_rumah",(responseDb.get(position).getKlasifikasiTipeRumah()))
                            .putExtra("mayoritas_provider",(responseDb.get(position).getMayoritasProvider()))
                            .putExtra("jenis_properti_area",(responseDb.get(position).getJenisPropertiArea()))
                            .putExtra("kecamatan",(responseDb.get(position).getKecamatan()))
                            .putExtra("developer",(responseDb.get(position).getDeveloper()))
                            .putExtra("id_report",(responseDb.get(position).getIdReport()))
                            .putExtra("kompetitor",(responseDb.get(position).getKompetitor()))
                            .putExtra("metode_pembangunan",(responseDb.get(position).getMetodePembangunan()))
                            .putExtra("region",(responseDb.get(position).getRegion()))

                    );
                }
            });

            }

        @Override
        public int getItemCount() {
            return responseDb.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView preview_Tanggal, preview1;

            public MyViewHolder(View itemView) {
                super(itemView);
                preview_Tanggal = itemView.findViewById(R.id.previewTanggal);
                preview1 = itemView.findViewById(R.id.preview);
            }
        }

    }

    @Override
    public void onRefresh() {
        loadData();
        refreshlayout.setRefreshing(false);
    }

    public static List<ResponseDb> getTeamListFromJson(String jsonString, Type type) {
        if (!isValid(jsonString)) {
            return null;
        }
        return new Gson().fromJson(jsonString, type);
    }

    public static boolean isValid(String json) {
        try {
            new JsonParser().parse(json);
            return true;
        } catch (JsonSyntaxException jse) {
            return false;
        }
    }
}
