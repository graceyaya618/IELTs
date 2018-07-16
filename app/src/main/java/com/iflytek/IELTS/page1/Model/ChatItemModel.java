package com.iflytek.IELTS.page1.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by qxb-810 on 2018/7/14.
 */

public class ChatItemModel implements Parcelable {

    private String voicePath;
    private String voiceText;
    private Boolean isQuestion;

    private String questionText;
    private String answerText;

    public ChatItemModel(){

    }

    protected ChatItemModel(Parcel in) {
        voicePath = in.readString();
        voiceText = in.readString();
        byte tmpIsQuestion = in.readByte();
        isQuestion = tmpIsQuestion == 0 ? null : tmpIsQuestion == 1;
        questionText = in.readString();
        answerText = in.readString();
    }

    public static final Creator<ChatItemModel> CREATOR = new Creator<ChatItemModel>() {
        @Override
        public ChatItemModel createFromParcel(Parcel in) {
            return new ChatItemModel(in);
        }

        @Override
        public ChatItemModel[] newArray(int size) {
            return new ChatItemModel[size];
        }
    };

    public Boolean getQuestion() {
        return isQuestion;
    }

    public void setQuestion(Boolean question) {
        isQuestion = question;
    }

    public String getVoicePath() {
        return voicePath;
    }

    public void setVoicePath(String voicePath) {
        this.voicePath = voicePath;
    }

    public String getVoiceText() {
        return voiceText;
    }

    public void setVoiceText(String voiceText) {
        this.voiceText = voiceText;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(voicePath);
        parcel.writeString(voiceText);
        parcel.writeByte((byte) (isQuestion == null ? 0 : isQuestion ? 1 : 2));
        parcel.writeString(questionText);
        parcel.writeString(answerText);
    }
}
