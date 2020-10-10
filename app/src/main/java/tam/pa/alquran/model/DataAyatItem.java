package tam.pa.alquran.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataAyatItem {
    @SerializedName("ar")
    @Expose
    private String ar;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("tr")
    @Expose
    private String tr;
    @SerializedName("nomor")
    @Expose
    private String nomor;

    public String getAr() {
        return ar;
    }

    public String getId() {
        return id;
    }

    public String getTr() {
        return tr;
    }

    public String getNomor() {
        return nomor;
    }
}
