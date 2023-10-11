package buinz.caka.gamexephinh.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import buinz.caka.gamexephinh.R;
import buinz.caka.gamexephinh.model.HistoryModel;


public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private Context context;
    private ArrayList<HistoryModel> historyList;

    public HistoryAdapter(Context context, ArrayList<HistoryModel> historyList) {
        this.context = context;
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_rcv, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HistoryModel currentHistory = historyList.get(position);
        if (position%2==0){
            holder.timeTv.setTextColor(Color.parseColor("#FF0000"));
            holder.itemRel.setBackgroundColor(Color.parseColor("#33FFFFFF"));
        }else{
            holder.timeTv.setTextColor(Color.parseColor("#00FF38"));
            holder.itemRel.setBackgroundColor(Color.parseColor("#33000000"));
        }
        holder.moveTv.setText(currentHistory.getMoves());
        holder.timeTv.setText(currentHistory.getTime());
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView moveTv, timeTv;
        RelativeLayout itemRel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            moveTv = itemView.findViewById(R.id.moveTv);
            timeTv = itemView.findViewById(R.id.timeTv);
            itemRel = itemView.findViewById(R.id.itemRel);
        }
    }
}
