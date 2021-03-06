package com.jixianxueyuan.app;

import android.content.Context;
import android.content.SharedPreferences;

import com.jixianxueyuan.dto.UserDTO;

/**
 * Created by pengchao on 7/19/15.
 */
public class Mine {

    private static Mine instance = new Mine();
    public static Mine getInstance(){
        return instance;
    }

    private final String SAVE_NAME = "mine";

    String qqOpenId = "";
    UserDTO userInfo = new UserDTO();

    private Mine(){

    }

    public String getQqOpenId() {
        return qqOpenId;
    }

    public void setQqOpenId(String qqOpenId) {
        this.qqOpenId = qqOpenId;
    }

    public UserDTO getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserDTO userInfo) {
        this.userInfo = userInfo;
    }

    public void loginOut(Context context){
        qqOpenId = "";
        userInfo = null;
        SharedPreferences.Editor editor = context.getSharedPreferences(SAVE_NAME, Context.MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();
    }


    public boolean SerializationFromLocal(Context context){

        SharedPreferences shared = context.getSharedPreferences(SAVE_NAME, Context.MODE_PRIVATE);

        if(shared.contains("loginName")){
            userInfo.setLoginName(shared.getString("loginName", ""));
        }
        if(shared.contains("qqOpenId")){
            qqOpenId = shared.getString("qqOpenId", "");
        }
        if(shared.contains("id")){
            userInfo.setId(shared.getLong("id", -1));
        }
        if(shared.contains("name")){
            userInfo.setName(shared.getString("name", ""));
        }
        if(shared.contains("gender")){
            userInfo.setGender(shared.getString("gender", "未知"));
        }
        if(shared.contains("avatar")){
            userInfo.setAvatar(shared.getString("avatar", ""));
        }
        if(shared.contains("birth")){
            userInfo.setBirth(shared.getString("birth", ""));
        }
        if(shared.contains("description")){
            userInfo.setDescription(shared.getString("description", ""));
        }
        if(shared.contains("signature")){
            userInfo.setSignature(shared.getString("signature", ""));
        }
        if(shared.contains("bg")){
            userInfo.setBg(shared.getString("bg", ""));
        }
        if(shared.contains("token")){
            userInfo.setToken(shared.getString("token", ""));
        }


        return true;
    }


    public void WriteSerializationToLocal(Context context){

        SharedPreferences.Editor editor = context.getSharedPreferences(SAVE_NAME, Context.MODE_PRIVATE).edit();
        editor.clear();

        editor.putString("qqOpenId", qqOpenId);
        editor.putLong("id", userInfo.getId());
        editor.putString("loginName", userInfo.getLoginName());
        editor.putString("name", userInfo.getName());
        editor.putString("gender", userInfo.getGender());
        editor.putString("avatar", userInfo.getAvatar());
        editor.putString("birth", userInfo.getBirth());
        editor.putString("description", userInfo.getDescription());
        editor.putString("signature", userInfo.getSignature());
        editor.putString("bg", userInfo.getBg());
        editor.putString("token", userInfo.getToken());

        editor.commit();
    }

}


