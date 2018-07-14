package com.iflytek.IELTS.page1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.iflytek.assist.IATHandler;
import com.iflytek.voicedemo.R;

import java.util.ArrayList;

public class MyFirst extends AppCompatActivity {

    RecyclerView recyclerView;
    com.iflytek.assist.ChatAdapter chatAdapter;
    ImageView imageView;


    private com.iflytek.assist.ChatAdapter.OnItemClickListener onItemClickListener = new com.iflytek.assist.ChatAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(int position) {
            Toast.makeText(MyFirst.this,"YAY",Toast.LENGTH_SHORT).show();
        }
    };



    com.iflytek.assist.IATHandler.IATDelegate delegate = new IATHandler.IATDelegate(){
        @Override
        public void onResult(String text, Boolean isLast) {
            System.out.println("888888888888888888");
        }

        @Override
        public void onError(String text) {
            System.out.println("888888888888888888");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_first);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        imageView = (ImageView) findViewById(R.id.image_view);

        /*chatAdapter = new com.iflytek.assist.ChatAdapter(this,onItemClickListener);
        chatAdapter.arrayList = new ArrayList<String>();
        chatAdapter.arrayList.add("123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132");
        chatAdapter.arrayList.add("123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132");
        chatAdapter.arrayList.add("123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132");
        chatAdapter.arrayList.add("123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132123123132");
*/

        recyclerView.setAdapter(chatAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        chatAdapter.notifyDataSetChanged();






        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, com.iflytek.voicedemo.MainActivity.class);
//                startActivity(intent);
                view.setBackgroundResource(R.drawable.user);

                IATHandler handler = new IATHandler(MyFirst.this);
                handler.delegate = MyFirst.this.delegate;
                handler.start();


            }
        });


    }


}
