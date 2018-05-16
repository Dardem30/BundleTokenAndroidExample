package com.example.roman.myretrofitexample.data.network;


import com.example.roman.myretrofitexample.data.network.interceptors.HeaderInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ServiceGenerator {
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static <S> S createService(Class<S> serviceClass){

             httpClient.addInterceptor(new HeaderInterceptor());
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit.Builder sBuilder =
                new Retrofit.Builder()
                        .baseUrl("https://socialnetwork2.herokuapp.com")
                        .addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit = sBuilder
                .client(httpClient.build())
                .build();
        return retrofit.create(serviceClass);
    }
}
