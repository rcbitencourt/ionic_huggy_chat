package io.ionic.starter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import io.huggy.chatsdk.HuggyAttachments;
import io.huggy.chatsdk.HuggyChat;

public class HuggyChatActiviy extends AppCompatActivity {
    private static final String SDK_ID = "40b1c6b7-c591-4e1a-a3c3-0560f41b1a51";

    private WebView webView;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        HuggyAttachments.handleAttachment(requestCode, resultCode, intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huggy_chat);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        webView = findViewById(R.id.web_view);
        HuggyChat.getInstance(this.SDK_ID).setUpWebView(webView, HuggyChatActiviy.this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
