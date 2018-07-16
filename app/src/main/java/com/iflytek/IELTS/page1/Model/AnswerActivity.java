package com.iflytek.IELTS.page1.Model;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iflytek.voicedemo.R;

import java.io.IOException;
import java.util.ArrayList;

public class AnswerActivity extends AppCompatActivity {

    static char[] numArray = { '零', '一', '二', '三', '四', '五', '六', '七', '八', '九' };


    private ImageView leftimgBtn;
    private ImageView rightimgBtn;

    private TextView textView;
    private EditText editText;

    private ImageView voiceimagBtn;

    private ChatItemModel currentModel;

    ArrayList<ChatItemModel> modelArrayList;

    public static MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        leftimgBtn = (ImageView) findViewById(R.id.leftimg);
        rightimgBtn = (ImageView) findViewById(R.id.rightimg);
        textView = (TextView) findViewById(R.id.title);
        editText = (EditText) findViewById(R.id.editview);
        voiceimagBtn = (ImageView) findViewById(R.id.voice_img_btn);

        //获取上个页面的传值
        modelArrayList = getIntent().getParcelableArrayListExtra("values");


        currentModel = modelArrayList.get(0);
        resetUIwithModel();

        leftimgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                切换到上一个model QA
                if (modelArrayList.indexOf(currentModel) == 0) {
                    Toast.makeText(AnswerActivity.this,"It's already the first", Toast.LENGTH_SHORT).show();
                } else  {
                    currentModel = modelArrayList.get(modelArrayList.indexOf(currentModel) - 1);
                    resetUIwithModel();
                }

            }
        });

        rightimgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                切换到下一个model QA
                if (modelArrayList.indexOf(currentModel) == modelArrayList.size() - 1) {
                    Toast.makeText(AnswerActivity.this,"This is the last one", Toast.LENGTH_SHORT).show();
                } else  {
                    currentModel = modelArrayList.get(modelArrayList.indexOf(currentModel) + 1);
                    resetUIwithModel();
                }

            }
        });


        voiceimagBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //播放本地存储的语音文件
                if (currentModel != null) {
                    mediaPlayer.reset();
                    try {
                        mediaPlayer.setDataSource(currentModel.getVoicePath());
                        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                mp.start();
                            }
                        });
                        // Prepare to async playing
                        mediaPlayer.prepareAsync();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

            }
        });


        //监听文本框内容的改变
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               currentModel.setAnswerText(charSequence.toString());
               System.out.println(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

//根据当前的model重置UI
    public void resetUIwithModel() {

        editText.setText(currentModel.getAnswerText());
        textView.setText("问题" + numToChinaese(modelArrayList.indexOf(currentModel) + 1));
    }

    public String numToChinaese(int num) {
        if (num > numArray.length - 1) return "";
        return String.valueOf(numArray[num]);
    }


}
