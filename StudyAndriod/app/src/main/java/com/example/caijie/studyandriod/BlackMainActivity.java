package com.example.caijie.studyandriod;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 *
 */
public class BlackMainActivity extends AppCompatActivity {

    /**
     * @param savedInstanceState
     */

    private IntentFilter intentFilter = new IntentFilter();

    private NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver();

    private String[] data = {
            "Apple", "Banana", "Orange", "Watermelon"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return 10;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position+200;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout line = new LinearLayout(BlackMainActivity.this);
                line.setOrientation(LinearLayout.VERTICAL);
                ImageView image = new ImageView(BlackMainActivity.this);
                image.setImageResource(R.mipmap.ic_launcher);

                TextView textView = new TextView(BlackMainActivity.this);
                textView.setText("第"+(position+1)+"个列表项");
                textView.setTextSize(20);

                line.addView(image);
                line.addView(textView);

                return line;
            }
        };


        ListView list1 = (ListView) findViewById(R.id.list1);
        String[] arr1 = {"孙悟空", "猪八戒", "唐生"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, data);
        list1.setAdapter(adapter);

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position < data.length) {

                    Log.e("TAG", data[position] + "======");
                    Toast.makeText(BlackMainActivity.this, "data[position] + ======", Toast.LENGTH_SHORT).show();
                }

            }
        });


        ListView list2 = (ListView) findViewById(R.id.list2);
        String[] arr2 = {"JAVA", "C++", "HTML", "CSS"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.arrayitem_layout, arr2);
        list2.setAdapter(adapter2);


        // requestWindowFeature(Window.FEATURE_NO_TITLE);
//        LinearLayout  mainLayout = (LinearLayout)findViewById(R.id.root);
//
//        final MoveView moveView = new MoveView(this);
//        moveView.setCurrentX(100);
//        moveView.setCurrentY(200);
//        moveView.setMinimumHeight(300);
//        moveView.setMinimumWidth(500);
//        mainLayout.addView(moveView);

//        intentFilter.addAction("android.net.com.CONNECTIVITY_CHANGE");
//
//        registerReceiver(networkChangeReceiver,intentFilter);

//        Button button = (Button)findViewById(R.id.button_1);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent("om.example.broadcasttest.MY_BROADCAST");
//                sendBroadcast(intent);
//               // sendOrderedBroadcast();
//            }
//        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.add_item: {
                Toast.makeText(BlackMainActivity.this, "You are click add", Toast.LENGTH_SHORT).show();
                break;

            }
            case R.id.remove_item: {
                Toast.makeText(BlackMainActivity.this, "You are click remove", Toast.LENGTH_SHORT).show();
                break;
            }


        }
        return true;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {

            case RESULT_OK: {

                if (resultCode == RESULT_OK) {

                    // Log.d(TAG, "onActivityResult " + returnData);
                } else {
                    Log.d("Error", "Error");
                }
            }
        }
    }

    class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            ConnectivityManager connectionManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();

            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "Network is available", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Network is not available", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
