package com.example.livedataapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
EditText editText;
Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        editText=findViewById(R.id.add_et);
        btn=findViewById(R.id.add_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                if (TextUtils.isEmpty(editText.getText())){
                    setResult(RESULT_CANCELED,intent);
                    Log.d("wxq", "add失败");
                }else{
                    intent.putExtra("name",editText.getText().toString());
                    setResult(RESULT_OK,intent);
                    Log.d("wxq", "获取成功: "+editText.getText().toString());
                }
                finish();
            }
        });
    }
}