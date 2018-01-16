package com.example.user.appdevshoptest.adapters;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.appdevshoptest.R;
import com.example.user.appdevshoptest.model.Item;
import com.example.user.appdevshoptest.model.SubItem;

import java.util.ArrayList;

/**
 * Created by user on 15.01.18.
 */

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.SubViewHolder> {

    private ArrayList<Item> arrayList;

    public ChildAdapter(ArrayList<Item> arrayList){
        this.arrayList = arrayList;
    }
    @Override
    public SubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sub_item, parent, false);

        return new SubViewHolder(v);

    }

    @Override
    public void onBindViewHolder(SubViewHolder holder, int position) {
        holder.tvTitle.setText(arrayList.get(position).getName());

        if (arrayList.get(position).isCheck()) {
            holder.ivCheck.setVisibility(View.VISIBLE);
        }else {
            holder.ivCheck.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class SubViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout rlSub;
        TextView tvTitle;
        ImageView ivCheck;

        public SubViewHolder(View itemView) {
            super(itemView);

            rlSub = (RelativeLayout) itemView.findViewById(R.id.relative_sub);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            ivCheck = (ImageView) itemView.findViewById(R.id.iv_check);

            rlSub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int currentPos = getAdapterPosition();
                    if (!arrayList.get(currentPos).isCheck()) {
                        resetCheck();
                        ivCheck.setVisibility(View.VISIBLE);
                        arrayList.get(currentPos).setCheck(true);
                    }else {
                        ivCheck.setVisibility(View.INVISIBLE);
                        arrayList.get(currentPos).setCheck(false);

                    }
                    notifyDataSetChanged();
                }
            });
        }
    }


    private void resetCheck(){
        for (Item item: arrayList)
            item.setCheck(false);
    }
}
