package com.example.mingi.sewoon.Shop;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.mingi.sewoon.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Fragment_1F extends Fragment {

    public Fragment_1F() {
            // Required empty public constructor
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_fragment_1, container, false);
    }

    private ListView shopListView;
    private ShopListAdapter adapter;
    private List<Shop> shopList;

    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);
        shopListView = (ListView) getView().findViewById(R.id.shopListView);
        shopList = new ArrayList<Shop>();
        adapter = new ShopListAdapter(getContext().getApplicationContext(), shopList);
        shopListView.setAdapter(adapter);



        shopListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            String name, location, item, category, phone,location2,photo;
                            name = jsonResponse.getString("name");
                            location = jsonResponse.getString("location");
                            item = jsonResponse.getString("item");
                            category = jsonResponse.getString("category");
                            phone = jsonResponse.getString("phone");
                            location2 = jsonResponse.getString("location2");
                            photo = jsonResponse.getString("photo");
                            if (success) {

                                    Intent intent = new Intent(getActivity(), ShopDetailActivity.class);
                                    intent.putExtra("name", name);
                                    intent.putExtra("location", location);
                                    intent.putExtra("item", item);
                                    intent.putExtra("category", category);
                                    intent.putExtra("phone", phone);
                                    intent.putExtra("location2", location2);
                                    intent.putExtra("photo", photo);
                                    getActivity().startActivity(intent);

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                };

                ShopDetailRequest bcDetailRequest = new ShopDetailRequest(shopList.get(i).getName(), responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
                queue.add(bcDetailRequest);


            }
        });



        new BackgroundTask().execute();
    }


    class BackgroundTask extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {

            target = "http://scvalsrl.cafe24.com/ShopList.php?location=1F";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while ((temp = bufferedReader.readLine()) != null) {

                    stringBuilder.append(temp + "\n");

                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            } catch (Exception e) {

                e.printStackTrace();

            }

            return null;

        }

        @Override
        public void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        public void onPostExecute(String result) {

            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count = 0;
                String name,item,location,category,phone,location2,photo;

                while (count < jsonArray.length()) {

                    JSONObject object = jsonArray.getJSONObject(count);
                    name = object.getString("name");
                    item = object.getString("item");
                    location = object.getString("location");
                    category = object.getString("category");
                    phone = object.getString("phone");
                    location2 = object.getString("location2");
                    photo = object.getString("photo");

                    shopList.add(new Shop(name,  location,  item,  category,phone,location2,photo));
                    count++;

                }
                adapter.notifyDataSetChanged();
            } catch (Exception e) {

                e.printStackTrace();

            }




        }

    }

}