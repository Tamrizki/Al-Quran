package tam.pa.alquran.helper;

import android.app.ProgressDialog;
import android.content.Context;

import tam.pa.alquran.R;

public class LoadingHelper {
    ProgressDialog progDialog;
    Context context;

    public LoadingHelper(Context context) {
        this.context = context;
    }
    public void startLoading(){
        // Show Progress Dialog
        progDialog = new ProgressDialog(context);
        progDialog.setMessage(context.getString(R.string.msg_wait));
        progDialog.setIndeterminate(true);
        progDialog.setCancelable(false);
        progDialog.show();
    }

    public void stopLoading(){
        progDialog.dismiss();
    }
}
