package com.ksnu.dailylifesaver;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.CustomViewHolder> {

    private ArrayList<DailyData> arrayList;

    //constructor
    public DailyAdapter(ArrayList<DailyData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public DailyAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    //실제 추가 될 때의 생명주기
    @Override
    public void onBindViewHolder(@NonNull DailyAdapter.CustomViewHolder holder, int position) {
//        holder.recycler_title.setText(arrayList.get(position).getRecycler_title());
//        holder.recycler_title.setText(arrayList.get(position).getRecycler_time_start());
//        holder.recycler_title.setText(arrayList.get(position).getRecycler_time_end());

        holder.itemView.setTag(position);
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
            //꾹 눌렀을 때 동작 설정

        });
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView recycler_title;
        protected TextView recycler_time_start;
        protected TextView recycler_time_end;
        protected TextView recycler_mon;
        protected TextView recycler_tue;
        protected TextView recycler_wed;
        protected TextView recycler_thu;
        protected TextView recycler_fri;
        protected TextView recycler_sat;
        protected TextView recycler_sun;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.recycler_title = (TextView) itemView.findViewById(R.id.recycler_title);
            this.recycler_time_start = (TextView) itemView.findViewById(R.id.recycler_time_start);
            this.recycler_time_end = (TextView) itemView.findViewById(R.id.recycler_time_end);
            this.recycler_mon = (TextView) itemView.findViewById(R.id.recycler_mon);
            this.recycler_tue = (TextView) itemView.findViewById(R.id.recycler_tue);
            this.recycler_wed = (TextView) itemView.findViewById(R.id.recycler_wed);
            this.recycler_thu = (TextView) itemView.findViewById(R.id.recycler_thu);
            this.recycler_fri = (TextView) itemView.findViewById(R.id.recycler_fri);
            this.recycler_sat = (TextView) itemView.findViewById(R.id.recycler_sat);
            this.recycler_sun = (TextView) itemView.findViewById(R.id.recycler_sun);
        }
    }
}
