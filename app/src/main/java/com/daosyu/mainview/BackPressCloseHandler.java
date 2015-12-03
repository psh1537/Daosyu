package com.daosyu.mainview;

import android.app.Activity;
import android.widget.Toast;

/*
 * 뒤로가기 버튼을 2번 누르면 액티비티가 종료되는 클래스를 구현한다.
 */
public class BackPressCloseHandler {
    private long backKeyPressedTime = 0;

    private Activity activity;
    private Toast toast;

    public BackPressCloseHandler(Activity context){
        this.activity = context;
    }

    public void onBackPressed(){
        //뒤로 버튼 2초 보다 늦게 누를경우 Toast 메시지를 띄운다.
        if(System.currentTimeMillis() > backKeyPressedTime + 2000){
            backKeyPressedTime = System.currentTimeMillis();
            showGuide();

        } else if(System.currentTimeMillis() <= backKeyPressedTime + 2000){
            //뒤로 버튼 2초 안에 누를경우 메시지를 종료하고 액티비티를 종료한다.
            activity.finish();
            toast.cancel();
        }
    }

    public void showGuide(){
        toast = Toast.makeText(activity, "\'뒤로\' 버튼을 한번 더 누르면 종료됩니다", Toast.LENGTH_SHORT);
        toast.show();
    }
}
