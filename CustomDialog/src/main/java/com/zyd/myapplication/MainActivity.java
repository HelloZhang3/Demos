package com.zyd.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyDialog();
            }
        });

    }

    /**
     * 自定义弹窗
     */
    private void showMyDialog() {
        LayoutInflater mLayoutInflater = LayoutInflater.from(MainActivity.this);
        LinearLayout mDialog = (LinearLayout) mLayoutInflater.inflate(R.layout.dialog_layout, null);

        final Dialog dialog = new AlertDialog.Builder(MainActivity.this).create();
        dialog.show();

        dialog.getWindow().setContentView(mDialog);

        mDialog.findViewById(R.id.yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        mDialog.findViewById(R.id.cannel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }
}
