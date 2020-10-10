package tam.pa.alquran.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.alquran.R;
import tam.pa.alquran.activity.adapter.SurahAdapter;
import tam.pa.alquran.model.DataSurahItem;

public class MainActivity extends AppCompatActivity implements IViewSurah{
    private SurahPresenter presenter;
    private IViewSurah iViewSurah;
    private SurahAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @BindView(R.id.rvListSurah) RecyclerView rvListSurah;
    @BindView(R.id.collapsingToolbar) CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        iViewSurah = this;
        SetCollapsing();
        presenter = new SurahPresenter(iViewSurah, this);
        presenter.onGetDetailSurah();
    }

    private void SetCollapsing() {
        collapsingToolbar.setTitle(getString(R.string.app_name));
        collapsingToolbar.setCollapsedTitleTextColor(this.getResources().getColor(R.color.colorGreen));
        collapsingToolbar.setExpandedTitleColor(this.getResources().getColor(R.color.transparant));
    }

    private void SetListSurah(List<DataSurahItem> listSurah) {
        layoutManager = new LinearLayoutManager(this);
        adapter = new SurahAdapter(listSurah, this);
        rvListSurah.setHasFixedSize(true);
        rvListSurah.setLayoutManager(layoutManager);
        rvListSurah.setAdapter(adapter);
    }

    @Override
    public void getDetailSurah(List<DataSurahItem> data) {
        SetListSurah(data);
    }

    @Override
    public void onErrorMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
