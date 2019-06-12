package com.example.reza.form;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reza.form.loginactivity.MainActivity;
import com.example.reza.form.model.ResponseInsertData;
import com.example.reza.form.network.ApiClient;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.reza.form.loginactivity.Constants.AKSESPENJUALAN;
import static com.example.reza.form.loginactivity.Constants.DEVELOPER;
import static com.example.reza.form.loginactivity.Constants.JENISPROPERTI;
import static com.example.reza.form.loginactivity.Constants.KABKOTA;
import static com.example.reza.form.loginactivity.Constants.KECEMATAN;
import static com.example.reza.form.loginactivity.Constants.KELURAHAN;
import static com.example.reza.form.loginactivity.Constants.KLASIFIKASITIPERUMAH;
import static com.example.reza.form.loginactivity.Constants.KOMPETITOR;
import static com.example.reza.form.loginactivity.Constants.KOMPLEKS;
import static com.example.reza.form.loginactivity.Constants.MAYORITASKENDARAAN;
import static com.example.reza.form.loginactivity.Constants.MAYORITASPROVIDER;
import static com.example.reza.form.loginactivity.Constants.METODEPEMBANGUNAN;
import static com.example.reza.form.loginactivity.Constants.RATA2BIAYA;
import static com.example.reza.form.loginactivity.Constants.REGION;
import static com.example.reza.form.loginactivity.Constants.ROLLOUT;
import static com.example.reza.form.loginactivity.Constants.SURVEYOR;
import static com.example.reza.form.loginactivity.Constants.TANGGAL;

public class Identita_Surveyor extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private final int REQUEST_IMAGE_CAPTURE = 1, REQUEST_IMAGE_GALLERY = 2;
    @BindView(R.id.rbYa)
    RadioButton rbYa;
    @BindView(R.id.rbTidak)
    RadioButton rbTidak;
    @BindView(R.id.btnFinish)
    Button btnFinish;
    RadioGroup Radiogroup2;
    @BindView(R.id.spinnerSuryeyor)
    Spinner spinnerSuryeyor;
    private String surveyor;
    private ImageView image;
    private String strRollout;
    private Bundle bundle;
    private Bitmap bitmap;
    String text3;

    private static final int IMG_REQUEST = 777;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identita__surveyor);
        ButterKnife.bind(this);

        if (rbYa.isChecked()) {
            strRollout = "Ya";

        } else {
            strRollout = "Tidak";

        }

//        surveyor = edSurveyor.getText().toString();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.str_surveyor, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSuryeyor.setAdapter(adapter);
        spinnerSuryeyor.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        surveyor = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), surveyor, Toast.LENGTH_SHORT).show();
        View selectedView = spinnerSuryeyor.getSelectedView();
        if (selectedView != null && selectedView instanceof TextView) {
            spinnerSuryeyor.requestFocus();
//            bundle.putString(SURVEYOR, surveyor);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_OK) {
            Uri uri = data.getData();

        } else if (requestCode == REQUEST_IMAGE_GALLERY) {
            Uri uri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                image.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @SuppressLint("ResourceType")
    @OnClick({R.id.btnFinish, R.id.rbYa, R.id.rbTidak})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.rbYa:
                strRollout = "Ya";

                break;
            case R.id.rbTidak:
                strRollout = "Tidak";

                break;
            case R.id.btnFinish:
//                surveyor = edSurveyor.getText().toString();

                bundle = new Bundle();
                bundle.putString(ROLLOUT, strRollout);
                bundle.putString(SURVEYOR, surveyor);
                Bundle bundle = getIntent().getExtras();
                String tanggal = bundle.getString(TANGGAL);
                String region = bundle.getString(REGION);
                String kabkota = bundle.getString(KABKOTA);
                String kecamatan = bundle.getString(KECEMATAN);
                String kelurahan = bundle.getString(KELURAHAN);
                String developer = bundle.getString(DEVELOPER);
                String kompleks = bundle.getString(KOMPLEKS);
                String jenis_properti_area = bundle.getString(JENISPROPERTI);
                String mayoritas_kendaraan = bundle.getString(MAYORITASKENDARAAN);
                String klarifikasi_tipe_rumah = bundle.getString(KLASIFIKASITIPERUMAH);
                String metode_pembangunan = bundle.getString(METODEPEMBANGUNAN);
                String akses_penjualan = bundle.getString(AKSESPENJUALAN);
                String kompetitor = bundle.getString(KOMPETITOR);
                String mayoritas_provider = bundle.getString(MAYORITASPROVIDER);
                String rata2_biaya = bundle.getString(RATA2BIAYA);

                ApiClient.getClient().insertData(tanggal, region, kabkota, kecamatan, kelurahan, kompleks, developer, jenis_properti_area, mayoritas_kendaraan,
                        klarifikasi_tipe_rumah, metode_pembangunan, akses_penjualan, kompetitor, mayoritas_provider, rata2_biaya, surveyor, strRollout)
                        .enqueue(new Callback<ResponseInsertData>() {

                            @Override
                            public void onResponse(Call<ResponseInsertData> call, Response<ResponseInsertData> response) {
                                String result = response.body().getResult();
                                String msg = response.body().getMsg();
                                if (result.equals("1")) {
                                    Toast.makeText(Identita_Surveyor.this, msg, Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Identita_Surveyor.this, msg, Toast.LENGTH_SHORT).show();

                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseInsertData> call, Throwable t) {
                                Toast.makeText(Identita_Surveyor.this, "gagal" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }

                        });

                Intent intentAkhir = new Intent(this, MainActivity.class);
                startActivity(intentAkhir);
                break;

        }

    }

}
