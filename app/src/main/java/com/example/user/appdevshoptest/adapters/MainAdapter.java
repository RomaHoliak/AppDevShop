package com.example.user.appdevshoptest.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.appdevshoptest.R;
import com.example.user.appdevshoptest.model.Entity;
import com.example.user.appdevshoptest.model.Item;
import com.example.user.appdevshoptest.model.SubItem;

import java.util.ArrayList;

/**
 * Created by user on 15.01.18.
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int CHILD = 0;
    private final int PARENT = 1;

    private ArrayList<Entity> arrayList;
    private Context context;

    public MainAdapter(ArrayList<Entity> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        if (viewType == CHILD){
            // Inflate the custom layout
            View itemView = inflater.inflate(R.layout.child_item, parent, false);

            // Return a new holder instance
            return new ChildViewHolder(itemView);
        }
        else{
            // Inflate the custom layout
            View itemView = inflater.inflate(R.layout.main_item, parent, false);


            // Return a new holder instance
            return new MainViewHolder(itemView);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder.getItemViewType() == CHILD){
            initChildRV(((ChildViewHolder)holder).recyclerView, (ArrayList<Item>) arrayList.get(position).getSubItem().getListItems());
        }else {
            ((MainViewHolder)holder).tvItem.setText(arrayList.get(position).getItem().getName());
            if (arrayList.get(position).getItem().isEmpty())
                ((MainViewHolder) holder).ivArrow.setVisibility(View.INVISIBLE);
            else
                ((MainViewHolder) holder).ivArrow.setVisibility(View.VISIBLE);

            if (arrayList.get(position).isCheck())
                ((MainViewHolder) holder).ivArrow.setBackgroundResource(R.drawable.ic_arrow_drop_up_black_48px);
            else
                ((MainViewHolder) holder).ivArrow.setBackgroundResource(R.drawable.ic_arrow_drop_down_black_48px);



        }
    }


    @Override
    public int getItemViewType(int position) {

        if (arrayList.get(position).getSubItem() != null){
            return CHILD;
        }
        else{
            return PARENT;
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }







    public class MainViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout rlMain;
        TextView tvItem;
        ImageView ivArrow;




        public MainViewHolder(View itemView) {
            super(itemView);


            rlMain = (RelativeLayout) itemView.findViewById(R.id.relative_main);
            tvItem = (TextView) itemView.findViewById(R.id.tv_item);
            ivArrow = (ImageView) itemView.findViewById(R.id.iv_arrow);



            rlMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int currentpos = getAdapterPosition();
                    if (arrayList.get(currentpos).getItem().getListItems() == null &&
                            arrayList.get(currentpos).getItem().getListItems().isEmpty())
                    return;

                   if (!arrayList.get(currentpos).isCheck()){
                        arrayList.add(currentpos+1,
                                Entity.newBuilder().setSubItem(new SubItem(arrayList.get(currentpos).getItem().getListItems())).build());
                        notifyItemInserted(currentpos+1);
                       arrayList.get(currentpos).setCheck(true);
                       rotate(ivArrow);
                       ivArrow.setBackgroundResource(R.drawable.ic_arrow_drop_up_black_48px);
                    }else {
                       arrayList.remove(currentpos + 1);
                       notifyItemRemoved(currentpos + 1);
                       arrayList.get(currentpos).setCheck(false);
                       rotate(ivArrow);

                       ivArrow.setBackgroundResource(R.drawable.ic_arrow_drop_down_black_48px);
                   }


                }
            });
        }


    }

    public class ChildViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;

        public ChildViewHolder(View itemView) {
            super(itemView);

            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView_child);
        }
    }

    private void initChildRV(RecyclerView rv,ArrayList<Item> arrayList){
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setHasFixedSize(true);
        rv.setAdapter(new ChildAdapter(arrayList));
    }

    private void rotate(final ImageView imageView){

        RotateAnimation rotate = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF,
                    0.5f,  Animation.RELATIVE_TO_SELF, 0.5f);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                notifyDataSetChanged();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        rotate.setFillAfter(true);
        rotate.setDuration(300);

        imageView.startAnimation(rotate);

    }

}
