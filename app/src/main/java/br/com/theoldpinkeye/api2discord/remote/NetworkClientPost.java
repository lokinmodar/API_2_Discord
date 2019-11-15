package br.com.theoldpinkeye.api2discord.remote;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class NetworkClientPost {
    private static Retrofit retrofit;
    /*
    This public static method will return Retrofit client
    anywhere in the application
    */
    public static Retrofit getRetrofitClient(String baseUrl) {
        //If condition to ensure we don't create multiple retrofit instances in a single application

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .build();

        if (retrofit == null) {
            //Defining the Retrofit using Builder
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl) //This is the only mandatory call on Builder object.
                    .addConverterFactory(GsonConverterFactory.create()) // Convertor library used to convert response into POJO
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}