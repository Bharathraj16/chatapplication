package com.example.zegocloud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.zegocloud.zimkit.services.ZIMKit;

import im.zego.zim.enums.ZIMErrorCode;

public class LoginMockActivity extends AppCompatActivity {
    EditText userIdInput;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mock);
        userIdInput=findViewById(R.id.userid_input);
        loginBtn=findViewById(R.id.Loginpage);

        loginBtn.setOnClickListener(view -> {
            String userId=userIdInput.getText().toString();
            connectUser(userId,userId,"");
        });
    }
    public void connectUser(String userId, String userName,String userAvatar) {
        ZIMKit.connectUser(userId,userName,userAvatar, errorInfo -> {
            if (errorInfo.code == ZIMErrorCode.SUCCESS) {
                toConversationActivity();
            }
        });
    }

    private void toConversationActivity() {
        Intent intent = new Intent(this,ConversationActivity.class);
        startActivity(intent);
    }
}