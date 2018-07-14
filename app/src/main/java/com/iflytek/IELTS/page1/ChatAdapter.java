package com.iflytek.assist;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iflytek.voicedemo.R;

import java.util.ArrayList;

/**
 * Created by qxb-810 on 2018/7/11.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {


    private Context context;
    private OnItemClickListener mItemClickListener;

    public chatDelegate delegate;


    public interface chatDelegate {

        void onResult(String text,Boolean isLast);
        void onError(String text);

    }

    @Override
    public void onResult

            www[
                    ]


    public ArrayList<String> arrayList;

    public ChatAdapter(Context context,OnItemClickListener mItemClickListener){
        this.context = context;
        this.mItemClickListener = mItemClickListener;

    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    /*@Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_chat,parent,false);
        return new MyViewHolder(view);
    }*/

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 1) {
            View view = parent.findViewById(R.id.bubble1);
            return new MyViewHolder(view);
        } else{ //if (viewType == 2)
            View view = parent.findViewById(R.id.bubble2);
            return new MyViewHolder(view);
        }

    }

    @Override
    public int getItemViewType(int position) {

        if (position%2 == 0){
            return 1;
        }else if (position%2 == 1){
            return 2;
        }

        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textView.setText(arrayList.get(position));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        private LinearLayout linearLayout;

        private ImageView bubble1;

        private ImageView bubble2;

        public MyViewHolder(View itemView) {
            super(itemView);
            //textView = (TextView) itemView.findViewById(R.id.tv_question);
            //linearLayout = (LinearLayout) itemView.findViewById(R.id.ll_chat);
            bubble1 = (ImageView) itemView.findViewById(R.id.bubble1);
            bubble2 = (ImageView) itemView.findViewById(R.id.bubble2);



        }
    }


}
