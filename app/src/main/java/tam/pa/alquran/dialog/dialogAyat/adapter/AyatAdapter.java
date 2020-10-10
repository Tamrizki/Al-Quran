package tam.pa.alquran.dialog.dialogAyat.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.alquran.R;
import tam.pa.alquran.model.DataAyatItem;

public class AyatAdapter extends RecyclerView.Adapter<AyatAdapter.viewHolder> {
    private Context mContext;
    private List<DataAyatItem>listAyat;

    public AyatAdapter(Context mContext, List<DataAyatItem> listAyat) {
        this.mContext = mContext;
        this.listAyat = listAyat;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list_ayat, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.Bind(listAyat.get(position));
    }

    @Override
    public int getItemCount() {
        return listAyat.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvAyatArab)
        TextView tvAyatArab;
        @BindView(R.id.tvAyatIndo)
        TextView tvAyatIndo;
        @BindView(R.id.tvArti)
        TextView tvArti;
        @BindView(R.id.tvNumberAyat)
        TextView tvNumberAyat;
        @BindView(R.id.llBackground)
        LinearLayout llBackground;
        @BindView(R.id.line)
        View line;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void Bind(DataAyatItem data) {
            tvAyatArab.setText(data.getAr());
            tvAyatIndo.setText(Html.fromHtml(data.getTr()));
            tvArti.setText(data.getId());
            tvNumberAyat.setText(data.getNomor());
            if (Integer.valueOf(data.getNomor()) % 2 == 0){
                llBackground.setBackground(mContext.getDrawable(R.drawable.custom_bg_radius10_white));
                line.setBackground(mContext.getDrawable(R.drawable.custom_bg_radius10_green));
            }
        }
    }
}
