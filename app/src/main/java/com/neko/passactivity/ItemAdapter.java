package com.neko.passactivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.bumptech.glide.Glide;
import com.neko.passactivity.databinding.ItemLanguageBinding;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private ArrayList<Item> mItems ;
    private Context context;

    public ItemAdapter(ArrayList<Item> mItems, Context context) {
        this.mItems = mItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View viewLanguage = inflater.inflate(R.layout.item_language, parent, false);
//        ViewHolder viewHolder = new ViewHolder(viewLanguage);
//        return viewHolder;

        ItemLanguageBinding itemLanguageBinding = DataBindingUtil.inflate(LayoutInflater
                .from(parent.getContext()), R.layout.item_language, parent, false);
        return new ViewHolder(itemLanguageBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = mItems.get(position);

        Glide.with(context).load(item.getmImage()).into(holder.itemLanguageBinding.imIcon);
        holder.itemLanguageBinding.tvTitle.setText(item.getmName());
        holder.itemLanguageBinding.tvRam.setText(item.getmDetail());

        holder.itemView.setOnClickListener(v -> {


        });

    }

    private ClickListener clickListener;

    public interface ClickListener {
        void onItemClick(String style);
    }

    /*Set data cho RV*/
    public void setData(ArrayList<Item> lst) {
        mItems.clear();
        mItems.addAll(lst);
        notifyDataSetChanged();
    }

    /**
     * example
     */

    public void updateItem(int position, String detail) {
        mItems.get(position).setmDetail(detail);
        /*co 2 cach update rv
        * 1: update ca list
        * 2: update 1 item*/

        notifyDataSetChanged();

//        notifyItemChanged(position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemLanguageBinding itemLanguageBinding;

        public ViewHolder(@NonNull ItemLanguageBinding itemView) {
            super(itemView.getRoot());

            itemLanguageBinding = itemView;
        }


//        public void bindData(Item item){
//            item.setmName("CPU");
//
//        }
    }
}