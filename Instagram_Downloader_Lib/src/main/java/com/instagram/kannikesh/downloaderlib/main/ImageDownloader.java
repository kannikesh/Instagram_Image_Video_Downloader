package com.instagram.kannikesh.downloaderlib.main;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.err;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.instagram.kannikesh.downloaderlib.utils.UtilsMain;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;

public class ImageDownloader {

    public static void downloadImage(Context context, String imageUri){

        String image;
        String[] finalImageUri = new String[1];

        finalImageUri[0] = null;
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(context);

        if (TextUtils.isEmpty(imageUri)){
            Toast.makeText(context, "Please Enter post Url.", Toast.LENGTH_SHORT).show();
            Log.d("Instagram-Lib_image","Provided String Is Empty");
        } else {
            if (imageUri.contains("?utm_source=ig_web_copy_link")) {
                String partToRemove = "?utm_source=ig_web_copy_link";
                image = imageUri.replace(partToRemove, "");
            } else if (imageUri.contains("?utm_source=ig_web_button_share_sheet")) {
                String partToRemove = "?utm_source=ig_web_button_share_sheet";
                image = imageUri.replace(partToRemove, "");
            } else if (imageUri.contains("?utm_medium=share_sheet")) {
                String partToRemove = "?utm_medium=share_sheet";
                image = imageUri.replace(partToRemove, "");
            } else if (imageUri.contains("?utm_medium=copy_link")) {
                String partToRemove = "?utm_medium=copy_link";
                image = imageUri.replace(partToRemove, "");
            }
            else {
                image = imageUri;
            }

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                    image + "?_a=1", null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    JSONObject o = null;
                    try {
                        o = response.getJSONObject("graphql");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    JSONObject o1 = null;
                    try {
                        o1 = response.getJSONObject("shortcode_media");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    finalImageUri[0] = null;
                    try {
                        finalImageUri[0] = o1.getString("display_url");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Log.d("Instagram-Lib_image", finalImageUri[0]);
                    UtilsMain.downloadImage(finalImageUri[0], UtilsMain.RootDirectoryInstagram, context, "InstaImage" + System.currentTimeMillis() + ",jpg");
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(context, "Something Went Wrong"+error, Toast.LENGTH_SHORT).show();
                }
            });
            requestQueue.add(jsonObjectRequest);
        }
    }

}
