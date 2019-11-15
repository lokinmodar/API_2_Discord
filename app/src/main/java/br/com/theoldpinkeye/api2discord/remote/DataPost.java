package br.com.theoldpinkeye.api2discord.remote;

import br.com.theoldpinkeye.api2discord.data.DropJson;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DataPost {



    // Over here we are sending a POST request with two fields as POST request body params
    //@Headers("Content-Type:application/json")
    @POST("api/webhooks/[channel.id]/[webhook.id]")
    Call<ResponseBody> postDropInfo(@Body DropJson dropJson);
}
