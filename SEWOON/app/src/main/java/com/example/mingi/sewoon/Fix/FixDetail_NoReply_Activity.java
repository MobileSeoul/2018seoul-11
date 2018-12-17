package com.example.mingi.sewoon.Fix;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.mingi.sewoon.MainActivity;
import com.example.mingi.sewoon.R;
import com.example.mingi.sewoon.Shop.ShopMenuActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FixDetail_NoReply_Activity extends AppCompatActivity {


    String image, title, content, category, day,userID;
    String reply;
    TextView fix_title, fix_content, fix_category, fix_day;
    Button reply_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_detail_noreply);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fix_title = (TextView) findViewById(R.id.fix_title);
        fix_content = (TextView) findViewById(R.id.fix_content);
        fix_category = (TextView) findViewById(R.id.fix_category);
        fix_day = (TextView) findViewById(R.id.fix_day);
        reply_btn = (Button) findViewById(R.id.fix_reply_btn);
        Intent intent = getIntent();

        image = intent.getStringExtra("image");
        title = intent.getStringExtra("title");
        content = intent.getStringExtra("content");
        category = intent.getStringExtra("category");
        day = intent.getStringExtra("day");
        reply = intent.getStringExtra("reply");
        userID = intent.getStringExtra("userID");

        fix_title.setText(title);
        fix_content.setText(content);
        fix_day.setText(day);
        fix_category.setText("수리문의 > "+category);

        new FixDetail_Reply_Activity.DownloadImageTask((ImageView) findViewById(R.id.fix_image))
                .execute("http://scvalsrl.cafe24.com/uploads/" + image);


    }

    static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        if( id == android.R.id.home){

            finish();
            return true;

        }

        return super.onOptionsItemSelected(item);


    }


}
