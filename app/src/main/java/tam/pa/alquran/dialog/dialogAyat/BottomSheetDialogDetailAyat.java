package tam.pa.alquran.dialog.dialogAyat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.alquran.R;
import tam.pa.alquran.dialog.dialogAyat.adapter.AyatAdapter;
import tam.pa.alquran.model.DataAyatItem;
import tam.pa.alquran.model.DataSurahItem;

public class BottomSheetDialogDetailAyat extends BottomSheetDialog implements IViewAyat {
    private Context context;
    private AyatAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private DataSurahItem dataSurah;
    private IViewAyat iView;
    private AyatPresenter presenter;
    @BindView(R.id.tvNameSurahArab) TextView tvNameSurahArab;
    @BindView(R.id.tvNameSurah) TextView tvNameSurah;
    @BindView(R.id.tvKota) TextView tvKota;
    @BindView(R.id.tvNomorAyat) TextView tvNomorAyat;
    @BindView(R.id.rvListAyat) RecyclerView rvListAyat;
    public BottomSheetDialogDetailAyat(@NonNull Context context, DataSurahItem dataSurahItem) {
        super(context, R.style.BottomSheetDialogTheme);
        this.context = context;
        this.iView = this;
        this.dataSurah = dataSurahItem;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.bottom_sheet_dialog);
        ButterKnife.bind(this);
        SetContent();
        presenter = new AyatPresenter(iView, (Activity) context);
        presenter.onGetDetailAyat(dataSurah.getNomor());
    }

    private void SetContent() {
        tvNameSurahArab.setText(dataSurah.getAsma());
        tvNameSurah.setText(dataSurah.getNama());
        tvKota.setText(dataSurah.getType());
        tvNomorAyat.setText(String.valueOf(dataSurah.getAyat()));
    }

    @Override
    public void onGetDataAyat(List<DataAyatItem> data) {
        SetListAyat(data);
    }

    @Override
    public void onErrorMsg(String msg) {
        Toast.makeText(context, ""+msg, Toast.LENGTH_SHORT).show();
    }

    private void SetListAyat(List<DataAyatItem> data) {
        layoutManager = new LinearLayoutManager(context);
        adapter = new AyatAdapter(context, data);
        rvListAyat.setHasFixedSize(true);
        rvListAyat.setLayoutManager(layoutManager);
        rvListAyat.setAdapter(adapter);
    }
}
