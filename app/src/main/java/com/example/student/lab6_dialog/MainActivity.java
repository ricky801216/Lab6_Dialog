package com.example.student.lab6_dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.CancellationSignal;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int drink = 0;
   boolean chk[] = new boolean[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void click1(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("對話框");
        builder.setMessage("確定要離開?");
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Log.d("CLICK", "按了確定");
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("CLICK", "按了取消");
                dialog.dismiss();
            }
        });

        builder.setNeutralButton("略過", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("CLICK", "按了略過");
        dialog.dismiss();
            }
        });
        builder.create().show();
    }
    public void click2(View v)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        final EditText et = new EditText(MainActivity.this);
        builder.setTitle("輸入型對話框");
        builder.setMessage("輸入開發工具名稱:");
        builder.setView(et);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("CLICK", "按了確定" + et.getText().toString());
                Toast.makeText(MainActivity.this, "你輸入了", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("CLICK", "按了取消");
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
    public void click3(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("測試輸入");
        final String[] str = {"可樂", "紅茶", "汽水"};
        builder.setSingleChoiceItems(str, drink, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("CLICK", "選了:" + which + "," + str[which]);
                drink = which;
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("CLICK", "按了取消");
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
    public void click4(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("測試輸入");
        final String[] str = {"可樂", "紅茶", "汽水"};
        builder.setItems(str,  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("CLICK", "選了:" + which + "," + str[which]);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("CLICK", "按了取消");
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
    public  void click5(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("測試輸入");
        final String[] str = {"可樂", "紅茶", "汽水"};
        final boolean[] disp = chk.clone();
        builder.setMultiChoiceItems(str, chk , new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                chk = disp.clone();
            }

        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Log.d("CLICK", "按了確定");
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("CLICK", "按了取消");
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
    public void click6(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("測試輸入");
        builder.setMessage("請輸入內容");
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.layout, null);
        final EditText ed1 = (EditText)layout.findViewById(R.id.editText);
        final EditText ed2 = (EditText)layout.findViewById(R.id.editText);
        builder.setView(layout);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Log.d("CLICK", "按了確定:"+ ed1.getText().toString() + "," + ed2.getText().toString());
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("CLICK", "按了取消");
            }
        });
        builder.create().show();
    }

    public void click7(View v) {
        final ProgressDialog pd = new ProgressDialog(MainActivity.this);
        pd.setTitle("加載中");
        pd.setMessage("請稍候...");
        pd.show();
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                pd.dismiss();
            }}.start();
    }
}
