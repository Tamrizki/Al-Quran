package tam.pa.alquran.network;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tam.pa.alquran.model.DataAyatItem;
import tam.pa.alquran.model.DataSurahItem;

public interface ApiService {
    @GET("data")
    Observable<List<DataSurahItem>> getListSurah();

    @GET("surat/{nomor}")
    Observable<List<DataAyatItem>> getDetailAyat(@Path("nomor")String nomor);

}
