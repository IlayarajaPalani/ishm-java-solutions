package com.ishm.codingchallenge.collections;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ServiceCallForMovieTitle {
    /*
     * Complete the function below.
     */

    static int getNumberOfMovies(String substr) {
        int count = 0;
        String response;
        int currPage = 1;
        int totalPage = Integer.MAX_VALUE;
        List<String> titleList = new ArrayList<>();
        while(currPage <= totalPage){
            try{
                URL reqUrl = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr + "&page=" + currPage);
                HttpURLConnection conn = (HttpURLConnection) reqUrl.openConnection();
                conn.setRequestMethod("GET");
                BufferedReader inputStream = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while((response = inputStream.readLine())!= null){
                    JsonObject outObject = new Gson().fromJson(response, JsonObject.class);
                    System.out.println(outObject.toString());
                    totalPage = outObject.get("total_pages").getAsInt();
                    JsonArray finalData = outObject.getAsJsonArray("data");
                    for(int i=0; i<finalData.size(); i++){
                        String title = finalData.get(i).getAsJsonObject().get("Title").getAsString();
                        titleList.add(title);
                    }

                }
                inputStream.close();
                currPage++;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return titleList.size();

    }
    /*
     * Endpoint: "https://jsonmock.hackerrank.com/api/movies/search/?Title=substr"
     */


    public static void main(String[] args) throws IOException{
        String _substr = "Spide";
        int res = getNumberOfMovies(_substr);
        System.out.println(res);
    }
}
