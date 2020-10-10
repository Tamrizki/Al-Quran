package tam.pa.alquran.dialog.dialogAyat;

import java.util.List;

import tam.pa.alquran.model.DataAyatItem;

public interface IViewAyat {
    void onGetDataAyat(List<DataAyatItem> data);
    void onErrorMsg(String msg);
}
