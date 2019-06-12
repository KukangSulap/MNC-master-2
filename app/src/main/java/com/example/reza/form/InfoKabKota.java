package com.example.reza.form;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.example.reza.form.loginactivity.Constants.DEVELOPER;
import static com.example.reza.form.loginactivity.Constants.KABKOTA;
import static com.example.reza.form.loginactivity.Constants.KECEMATAN;
import static com.example.reza.form.loginactivity.Constants.KELURAHAN;
import static com.example.reza.form.loginactivity.Constants.KOMPLEKS;
import static com.example.reza.form.loginactivity.Constants.REGION;
import static com.example.reza.form.loginactivity.Constants.SURVEYOR;
import static com.example.reza.form.loginactivity.Constants.TANGGAL;

public class InfoKabKota  extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.spinnerKabKota)
    Spinner spinnerKabKota;
    @BindView(R.id.etKecamatan)
    TextView etKecamatan;
    @BindView(R.id.edKecamtan)
    EditText edKecamtan;
    @BindView(R.id.edKelurahan)
    EditText edKelurahan;
    @BindView(R.id.edKompleks)
    EditText edKompleks;
    @BindView(R.id.edDeveloper)
    EditText edDeveloper;
    @BindView(R.id.btnNextKab)
    Button btnNextKab;
    @BindView(R.id.scrollKab)
    ScrollView scrollKab;

    String kecamatan;
    String kelurahan;
    String kompleks;
    String developer;
    String text2;
    private Bundle bundle;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_kab_kota);
        ButterKnife.bind(this);

        bundle = new Bundle();
        String databaru =getIntent().getExtras().getString(REGION);

        bundle.putString(REGION, databaru);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.str_kab, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKabKota.setAdapter(adapter);
        spinnerKabKota.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        text2 = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text2, Toast.LENGTH_SHORT).show();
        View selectedView = spinnerKabKota.getSelectedView();
        if (selectedView != null && selectedView instanceof TextView) {
            spinnerKabKota.requestFocus();
            bundle.putString(KABKOTA, text2);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @OnClick({R.id.btnNextKab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnNextKab:

                if (TextUtils.isEmpty(edKecamtan.getText())) {
                    edKecamtan.setError("Harus Diisi");

                }if (TextUtils.isEmpty(edKelurahan.getText())) {
                    edKelurahan.setError("Harus Diisi");

                }if (TextUtils.isEmpty(edDeveloper.getText())) {
                    edDeveloper.setError("Harus Diisi");

                }else {
                String tanggal = getIntent().getExtras().getString(TANGGAL);
                bundle.putString(TANGGAL, tanggal);
                kecamatan = edKecamtan.getText().toString();
                kelurahan = edKelurahan.getText().toString();
                kompleks = edKompleks.getText().toString();
                developer = edDeveloper.getText().toString();
                bundle.putString(KECEMATAN, kecamatan);
                bundle.putString(KELURAHAN, kelurahan);
                bundle.putString(KOMPLEKS, kompleks);
                bundle.putString(DEVELOPER, developer);
                Log.d("cekdatanya",kecamatan+","+kelurahan+","+developer);
                Intent intent4 = new Intent(this, InformasiDetailSurveyArea.class);
                    intent4.putExtras(bundle);
                    startActivity(intent4);

            };
                break;


        }
    }

}
