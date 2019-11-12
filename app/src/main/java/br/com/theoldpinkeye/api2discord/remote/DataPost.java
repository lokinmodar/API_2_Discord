package br.com.theoldpinkeye.api2discord.remote;

import br.com.theoldpinkeye.api2discord.data.DropJson;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DataPost {

    /* Over here we are sending a POST request with two fields as POST request body params */
    @Headers("Content-Type: application/json")
    @POST("/638118271501074437/lkvR_AyIgfrq1upc_4soCiHJO0aoFMmKE3xjS8GoeoVNeeR_9XpMOEFVHOjUBhKFMR3v")
    Call<DropJson> postDropInfo(@Body DropJson dropJson);
}
