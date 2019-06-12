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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reza.form.loginactivity.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.reza.form.loginactivity.Constants.KABKOTA;
import static com.example.reza.form.loginactivity.Constants.KECEMATAN;
import static com.example.reza.form.loginactivity.Constants.RATA2BIAYA;
import static com.example.reza.form.loginactivity.Constants.REGION;
import static com.example.reza.form.loginactivity.Constants.SURVEYOR;
import static com.example.reza.form.loginactivity.Constants.TANGGAL;

public class TanggalSurveyArea extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @BindView(R.id.spinerRegion)
    Spinner spinerRegion;
    @BindView(R.id.btnNextTanggal)
    Button btnNextTanggal;
    String text1;
    @BindView(R.id.edTanggal)
    EditText edTanggal;
    private Bundle bundle;
    //    String hasilSpinerRegion;
    String tanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanggal_survey_area);
        ButterKnife.bind(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.str_region, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinerRegion.setAdapter(adapter);
        spinerRegion.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        text1 = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text1, Toast.LENGTH_SHORT).show();
        View selectedView = spinerRegion.getSelectedView();
        if (selectedView != null && selectedView instanceof TextView) {
            spinerRegion.requestFocus();
            bundle = new Bundle();
            bundle.putString(Constants.REGION, text1);
            Log.d("datanya", text1);
            tanggal = edTanggal.getText().toString();
            bundle.putString(TANGGAL, tanggal);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @OnClick({R.id.btnNextTanggal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnNextTanggal:
                if (TextUtils.isEmpty(edTanggal.getText())) {
                    edTanggal.setError("Harus Diisi");
                }else {
//                    String surveyor = getIntent().getExtras().getString(SURVEYOR);
//                    bundle.putString(SURVEYOR, surveyor);
                    Intent intent3 = new Intent(this, InfoKabKota.class);
                    intent3.putExtras(bundle);
                    startActivity(intent3);
                    break;
                }
        }
    }

}
