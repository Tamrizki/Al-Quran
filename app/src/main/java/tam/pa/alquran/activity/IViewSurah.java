package tam.pa.alquran.activity;

import java.util.List;

import tam.pa.alquran.model.DataSurahItem;

public interface IViewSurah {
    void getDetailSurah(List<DataSurahItem> data);
    void onErrorMsg(String msg);
}
