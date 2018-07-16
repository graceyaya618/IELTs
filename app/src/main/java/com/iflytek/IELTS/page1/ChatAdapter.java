package com.iflytek.IELTS.page1;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.iflytek.IELTS.page1.Model.ChatItemModel;
import com.iflytek.voicedemo.R;


import java.util.ArrayList;

/**
 * Created by qxb-810 on 2018/7/11.
 */

public class ChatAdapter extends RecyclerView.Adapter {


    private Context context;
    private OnItemClickListener mItemClickListener;

    public chatDelegate delegate;


    public interface chatDelegate {

        void onResult(String text, Boolean isLast);

        void onError(String text);

    }


    //泛型  数组内的数据要和指定的泛型一致
    public ArrayList<ChatItemModel> arrayList = new ArrayList<>();

    public ChatAdapter(Context context, OnItemClickListener mItemClickListener) {
        this.context = context;
        this.mItemClickListener = mItemClickListener;

    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == 1) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_list, parent, false);

            return new questionHolder(view);
        } else if (viewType == 2) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_list_reverse, parent, false);

            return new answerHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {

        if (position % 2 == 0) {
            return 1;
        } else if (position % 2 == 1) {
            return 2;
        }

        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ChatItemModel chatItemModel = arrayList.get(position);

        if (position % 2 == 0) {
            questionHolder qh = (questionHolder) holder;
            qh.questionBubble.getLayoutParams().width = chatItemModel.getVoiceText().length() * 10;

        } else if (position % 2 == 1) {


        }


//        holder.questionBubble.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mItemClickListener.onItemClick(position);
//            }
//        });

        //先注释掉 等下再看这个问题
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    //TODO
    public ArrayList<ChatItemModel> getArrayList() {
        return arrayList;
    }


    private class questionHolder extends RecyclerView.ViewHolder {

        /*private TextView textView;

        private LinearLayout linearLayout;*/

        private ImageView questionBubble;


        public questionHolder(View itemView) {
            super(itemView);
            //textView = (TextView) itemView.findViewById(R.id.tv_question);
            //linearLayout = (LinearLayout) itemView.findViewById(R.id.ll_chat);
            questionBubble = (ImageView) itemView.findViewById(R.id.bubble1);

        }


    }

    private class answerHolder extends RecyclerView.ViewHolder {

        /* private TextView textView;

         private LinearLayout linearLayout;
 */
        private ImageView answerBubble;

        public answerHolder(View itemView) {
            super(itemView);
            //textView = (TextView) itemView.findViewById(R.id.tv_question);
            //linearLayout = (LinearLayout) itemView.findViewById(R.id.ll_chat);

            answerBubble = (ImageView) itemView.findViewById(R.id.bubble2);
        }
    }
}
