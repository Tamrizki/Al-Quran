package tam.pa.alquran.activity;

import android.app.Activity;
import android.util.Log;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import tam.pa.alquran.helper.LoadingHelper;
import tam.pa.alquran.model.DataSurahItem;
import tam.pa.alquran.network.ApiClient;
import tam.pa.alquran.network.ApiService;

public class SurahPresenter {
    private IViewSurah iViewSurah;
    private Activity activity;
    public LoadingHelper loadingHelper;
    private ApiService apiService;

    public SurahPresenter(IViewSurah iViewSurah, Activity activity) {
        this.iViewSurah = iViewSurah;
        this.activity = activity;
        loadingHelper = new LoadingHelper(activity);
    }
    public void onGetDetailSurah(){
        loadingHelper.startLoading();
        apiService = ApiClient.getRetrofit().create(ApiService.class);
        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(
                apiService
                        .getListSurah()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<List<DataSurahItem>>() {
                            @Override
                            public void onNext(List<DataSurahItem> dataSurahItems) {
                                iViewSurah.getDetailSurah(dataSurahItems);
                            }

                            @Override
                            public void onError(Throwable e) {
                                iViewSurah.onErrorMsg("Gagal mengunduh data!");
                                loadingHelper.stopLoading();
                            }

                            @Override
                            public void onComplete() {
                                loadingHelper.stopLoading();
                            }
                        }
        ));
    }
}
