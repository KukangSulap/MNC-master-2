package com.example.reza.form.model;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

public class ResponseDb{

	@SerializedName("kompetitor")
	private String kompetitor;

	@SerializedName("kab_kota")
	private String kabKota;

	@SerializedName("kompleks")
	private String kompleks;

	@SerializedName("tanggal_survey")
	private String tanggalSurvey;

	@SerializedName("surveyor")
	private String surveyor;

	@SerializedName("kelurahan")
	private String kelurahan;

	@SerializedName("akses_penjualan")
	private String aksesPenjualan;

	@SerializedName("roll_out")
	private String rollOut;

	@SerializedName("mayoritas_kendaraan")
	private String mayoritasKendaraan;

	@SerializedName("rata2_biaya")
	private String rata2Biaya;

	@SerializedName("klasifikasi_tipe_rumah")
	private String klasifikasiTipeRumah;

	@SerializedName("mayoritas_provider")
	private String mayoritasProvider;

	@SerializedName("jenis_properti_area")
	private String jenisPropertiArea;

	@SerializedName("kecamatan")
	private String kecamatan;

	@SerializedName("developer")
	private String developer;

	@SerializedName("id_report")
	private String idReport;

	@SerializedName("metode_pembangunan")
	private String metodePembangunan;

	@SerializedName("region")
	private String region;

	@SerializedName("timestamp")
	private String timestamp;

	public void setKompetitor(String kompetitor){
		this.kompetitor = kompetitor;
	}

	public static final Comparator<ResponseDb> BY_ID = new Comparator<ResponseDb>() {
		@Override
		public int compare(ResponseDb o1, ResponseDb o2) {

			return o2.getTimestamp().compareTo(o1.getTimestamp());
		}
	};

	public String getKompetitor(){
		return kompetitor;
	}

	public void setKabKota(String kabKota){
		this.kabKota = kabKota;
	}

	public String getKabKota(){
		return kabKota;
	}

	public void setKompleks(String kompleks){
		this.kompleks = kompleks;
	}

	public String getKompleks(){
		return kompleks;
	}

	public void setTanggalSurvey(String tanggalSurvey){
		this.tanggalSurvey = tanggalSurvey;
	}

	public String getTanggalSurvey(){
		return tanggalSurvey;
	}

	public void setSurveyor(String surveyor){
		this.surveyor = surveyor;
	}

	public String getSurveyor(){
		return surveyor;
	}

	public void setKelurahan(String kelurahan){
		this.kelurahan = kelurahan;
	}

	public String getKelurahan(){
		return kelurahan;
	}

	public void setAksesPenjualan(String aksesPenjualan){
		this.aksesPenjualan = aksesPenjualan;
	}

	public String getAksesPenjualan(){
		return aksesPenjualan;
	}

	public void setRollOut(String rollOut){
		this.rollOut = rollOut;
	}

	public String getRollOut(){
		return rollOut;
	}

	public void setMayoritasKendaraan(String mayoritasKendaraan){
		this.mayoritasKendaraan = mayoritasKendaraan;
	}

	public String getMayoritasKendaraan(){
		return mayoritasKendaraan;
	}

	public void setRata2Biaya(String rata2Biaya){
		this.rata2Biaya = rata2Biaya;
	}

	public String getRata2Biaya(){
		return rata2Biaya;
	}

	public void setKlasifikasiTipeRumah(String klasifikasiTipeRumah){
		this.klasifikasiTipeRumah = klasifikasiTipeRumah;
	}

	public String getKlasifikasiTipeRumah(){
		return klasifikasiTipeRumah;
	}

	public void setMayoritasProvider(String mayoritasProvider){
		this.mayoritasProvider = mayoritasProvider;
	}

	public String getMayoritasProvider(){
		return mayoritasProvider;
	}

	public void setJenisPropertiArea(String jenisPropertiArea){
		this.jenisPropertiArea = jenisPropertiArea;
	}

	public String getJenisPropertiArea(){
		return jenisPropertiArea;
	}

	public void setKecamatan(String kecamatan){
		this.kecamatan = kecamatan;
	}

	public String getKecamatan(){
		return kecamatan;
	}

	public void setDeveloper(String developer){
		this.developer = developer;
	}

	public String getDeveloper(){
		return developer;
	}

	public void setIdReport(String idReport){
		this.idReport = idReport;
	}

	public String getIdReport(){
		return idReport;
	}

	public void setMetodePembangunan(String metodePembangunan){
		this.metodePembangunan = metodePembangunan;
	}

	public String getMetodePembangunan(){
		return metodePembangunan;
	}

	public void setRegion(String region){
		this.region = region;
	}

	public String getRegion(){
		return region;
	}

	public void setTimestamp(String timestamp){
		this.timestamp = timestamp;
	}

	public String getTimestamp(){
		return timestamp;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDb{" + 
			"kompetitor = '" + kompetitor + '\'' + 
			",kab_kota = '" + kabKota + '\'' + 
			",kompleks = '" + kompleks + '\'' + 
			",tanggal_survey = '" + tanggalSurvey + '\'' + 
			",surveyor = '" + surveyor + '\'' + 
			",kelurahan = '" + kelurahan + '\'' + 
			",akses_penjualan = '" + aksesPenjualan + '\'' + 
			",roll_out = '" + rollOut + '\'' + 
			",mayoritas_kendaraan = '" + mayoritasKendaraan + '\'' + 
			",rata2_biaya = '" + rata2Biaya + '\'' + 
			",klasifikasi_tipe_rumah = '" + klasifikasiTipeRumah + '\'' + 
			",mayoritas_provider = '" + mayoritasProvider + '\'' + 
			",jenis_properti_area = '" + jenisPropertiArea + '\'' + 
			",kecamatan = '" + kecamatan + '\'' + 
			",developer = '" + developer + '\'' + 
			",id_report = '" + idReport + '\'' + 
			",metode_pembangunan = '" + metodePembangunan + '\'' + 
			",region = '" + region + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			"}";
		}
}