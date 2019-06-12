package com.example.reza.form;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import com.example.reza.form.model.ResponseDb;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.detailID)
    TextView detailID;
    @BindView(R.id.detailTanggal)
    TextView detailTanggal;
    @BindView(R.id.detailRegion)
    TextView detailRegion;
    @BindView(R.id.detailKabupaten)
    TextView detailKabupaten;
    @BindView(R.id.detailKecamatan)
    TextView detailKecamatan;
    @BindView(R.id.detailKompleks)
    TextView detailKompleks;
    @BindView(R.id.detailDeveloper)
    TextView detailDeveloper;
    @BindView(R.id.detailJenisProperti)
    TextView detailJenisProperti;
    @BindView(R.id.detailKlarifikasiTipeRumah)
    TextView detailKlarifikasiTipeRumah;
    @BindView(R.id.detailMayoritasKendaraan)
    TextView detailMayoritasKendaraan;
    @BindView(R.id.detailMetodePembangunan)
    TextView detailMetodePembangunan;
    @BindView(R.id.detailAksesPenjualan)
    TextView detailAksesPenjualan;
    @BindView(R.id.detailKompetitor)
    TextView detailKompetitor;
    @BindView(R.id.detailMayoritasProvider)
    TextView detailMayoritasProvider;
    @BindView(R.id.detailRata2Biaya)
    TextView detailRata2Biaya;
    @BindView(R.id.detailRollout)
    TextView detailRollout;
    @BindView(R.id.detailSurveyor)
    TextView detailSurveyor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        detailID.setText(intent.getStringExtra("id_report"));
        detailTanggal.setText(intent.getStringExtra("tanggal_survey"));
        detailRegion.setText(intent.getStringExtra("region"));
        detailKabupaten.setText(intent.getStringExtra("kab_kota"));
        detailKecamatan.setText(intent.getStringExtra("kecamatan"));
        detailKompleks.setText(intent.getStringExtra("kompleks"));
        detailDeveloper.setText(intent.getStringExtra("developer"));
        detailJenisProperti.setText(intent.getStringExtra("jenis_properti_area"));
        detailKlarifikasiTipeRumah.setText(intent.getStringExtra("klasifikasi_tipe_rumah"));
        detailMayoritasKendaraan.setText(intent.getStringExtra("mayoritas_kendaraan"));
        detailMetodePembangunan.setText(intent.getStringExtra("metode_pembangunan"));
        detailAksesPenjualan.setText(intent.getStringExtra("akses_penjualan"));
        detailKompetitor.setText(intent.getStringExtra("kompetitor"));
        detailMayoritasProvider.setText(intent.getStringExtra("mayoritas_provider"));
        detailRata2Biaya.setText(intent.getStringExtra("rata2_biaya"));
        detailSurveyor.setText(intent.getStringExtra("surveyor"));
        detailRollout.setText(intent.getStringExtra("roll_out"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
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
