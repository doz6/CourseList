package com.doz6.courselist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    public void setCourse(View view){
        btn=(Button)view;
        AlertDialog.Builder courseBuilder=new AlertDialog.Builder(this);//创建对话框
        courseBuilder.setTitle("请输入课程名");
        final EditText editText=new EditText(this);
        editText.setText(btn.getText().toString());
        courseBuilder.setView(editText);
        courseBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                btn.setText(editText.getText().toString());
            }
        });
        courseBuilder.create().show();//创建并显示对话框
    }
}
