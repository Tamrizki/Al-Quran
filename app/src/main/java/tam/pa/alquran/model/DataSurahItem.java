package tam.pa.alquran.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataSurahItem {
    @SerializedName("arti")
    @Expose
    private String arti;
    @SerializedName("asma")
    @Expose
    private String asma;
    @SerializedName("ayat")
    @Expose
    private Integer ayat;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("urut")
    @Expose
    private String urut;
    @SerializedName("audio")
    @Expose
    private String audio;
    @SerializedName("nomor")
    @Expose
    private String nomor;
    @SerializedName("rukuk")
    @Expose
    private String rukuk;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;

    public String getArti() {
        return arti;
    }

    public String getAsma() {
        return asma;
    }

    public Integer getAyat() {
        return ayat;
    }

    public String getNama() {
        return nama;
    }

    public String getType() {
        return type;
    }

    public String getUrut() {
        return urut;
    }

    public String getAudio() {
        return audio;
    }

    public String getNomor() {
        return nomor;
    }

    public String getRukuk() {
        return rukuk;
    }

    public String getKeterangan() {
        return keterangan;
    }
}
