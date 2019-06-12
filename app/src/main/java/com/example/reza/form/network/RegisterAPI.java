package com.example.reza.form.network;

import com.example.reza.form.model.GhetResponse;
import com.example.reza.form.model.ResponseInsertData;
import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RegisterAPI {

    @FormUrlEncoded
    @POST("insertData.php")
    Call<ResponseInsertData> insertData(
                                    @Field("tanggal") String tanggal,
                                    @Field("region") String region,
                                    @Field("kab_kota") String kabkota,
                                    @Field("kecamatan") String kecamatan,
                                    @Field("kelurahan") String kelurahan,
                                    @Field("kompleks") String kompleks,
                                    @Field("developer") String developer,
                                    @Field("jenis_properti_area") String jenispropertiarea,
                                    @Field("mayoritas_kendaraan") String mayoritaskendaraan,
                                    @Field("klarifikasi_tipe_rumah") String klasifikasitiperumah,
                                    @Field("metode_pembangunan") String metodepembangunan,
                                    @Field("akses_penjualan") String aksespenjualan,
                                    @Field("kompetitor") String kompetitor,
                                    @Field("mayoritas_provider") String mayoritasprovider,
                                    @Field("rata2_biaya") String rata2biaya,
                                    @Field("surveyor") String surveyor,
                                    @Field("roll_out") String rollout
    );

    @GET("readData.php")
    Call<JsonArray> readDb(
            @Query("surveyor") String surveyor,
            @Query("kab_kota") String kab_kota,
            @Query("kompleks") String kompleks,
            @Query("tanggal_survey") String tanggal_survey,
            @Query("kelurahan") String kelurahan,
            @Query("akses_penjualan") String akses_penjualan,
            @Query("roll_out") String roll_out,
            @Query("mayoritas_kendaraan") String mayoritas_kendaraan,
            @Query("rata2_biaya") String rata2_biaya,
            @Query("klasifikasi_tipe_rumah") String klasifikasi_tipe_rumah,
            @Query("mayoritas_provider") String mayoritas_provider,
            @Query("jenis_properti_area") String jenis_properti_area,
            @Query("kecamatan") String kecamatan,
            @Query("developer") String developer,
            @Query("id_report") String id_report,
            @Query("kompetitor") String kompetitor,
            @Query("metode_pembangunan") String metode_pembangunan,
            @Query("region") String region);

}
