package br.com.theoldpinkeye.api2discord.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiFetch{
    @GET("/MyHL/webapi/board")
    Call<ApiData> getDrops(@Query("from") String time, @Query("what") String drops);
}
