package br.com.theoldpinkeye.api2discord.remote;

import br.com.theoldpinkeye.api2discord.data.ApiData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiFetch{
    @GET("/MyHL/webapi/board")
    Call<ApiData> getDrops(@Query("from") String time, @Query("what") String drops);
}
