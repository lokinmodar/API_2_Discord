package br.com.theoldpinkeye.api2discord;

import android.icu.util.Calendar;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.theoldpinkeye.api2discord.data.ApiData;
import br.com.theoldpinkeye.api2discord.data.ApiFetch;
import br.com.theoldpinkeye.api2discord.data.Datum;
import br.com.theoldpinkeye.api2discord.data.DropInfo;
import br.com.theoldpinkeye.api2discord.data.NetworkClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public List<Datum> dados = new ArrayList<>();
    public List<DropInfo> treatedData = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        fetchApiData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    private DropInfo dataParse(Datum drop){


        String date = drop.getDate();

        int usernameStart = drop.getDropTxt().indexOf(":")+2;
        String minusUsername = drop.getDropTxt().substring(usernameStart);//Tira a palavra "Username: "
        //Log.e("Passo 1", minusUsername);

        int usernameEnd = minusUsername.indexOf(")")+1;
        String username = minusUsername.substring(0, usernameEnd); //Salva Username
        String minusUsernameText = minusUsername.substring(usernameEnd+2);//Após extração do nome de Usuário
        //Log.e("Passo 2", minusUsernameText);


        int guildcardNumberStart = minusUsernameText.indexOf(":")+2;
        String minusGuildcardFieldName = minusUsernameText.substring(guildcardNumberStart);//Tira a palavra "Guildcard Number: "
        //Log.e("Passo 3", minusGuildcardFieldName);

        int guildcardNumberEnd = minusGuildcardFieldName.indexOf(" ")-1;
        String guildcard = minusGuildcardFieldName.substring(0, guildcardNumberEnd);//Salva numero do Guilcard
        String minusUserGuild = minusGuildcardFieldName.substring(guildcardNumberEnd+2);//Após extração do nome de usuário e guildcard
        //Log.e("Passo 4", minusUserGuild);

        int hexNumberStart = minusUserGuild.indexOf(":")+2;
        String minusHexFieldName = minusUserGuild.substring(hexNumberStart);//Tira a palavra "Hex: "
        //Log.e("Passo 5", minusHexFieldName);

        int hexNumberEnd = minusHexFieldName.indexOf(" ")-1;
        String hex = minusHexFieldName.substring(0, hexNumberEnd);//Salva numero Hex
        String minusUserGuildHex = minusHexFieldName.substring(hexNumberEnd+2);//Após extração do nome de usuário e guildcard e hex
        //Log.e("Passo 6", minusUserGuildHex);

        String item = minusUserGuildHex.substring(minusUserGuildHex.indexOf("d")+2);//Salva item obtido
        //Log.e("Passo 7", item);


        return new DropInfo(date, username, guildcard, hex, item);
    }


    private void fetchApiData() {
        //Obtain an instance of Retrofit by calling the static method.
        Retrofit retrofit = NetworkClient.getRetrofitClient();
        /*
        The main purpose of Retrofit is to create HTTP calls from the Java interface based on the annotation associated with each method. This is achieved by just passing the interface class as parameter to the create method
        */
        ApiFetch dataFetchAPIs = retrofit.create(ApiFetch.class);
        /*
        Invoke the method corresponding to the HTTP request which will return a Call object. This Call object will used to send the actual network request with the specified parameters
        */
        Date dataAtual = new Date();
        Log.d("Hoje: ", dateFormat.format(dataAtual));

        Calendar c = Calendar.getInstance();
        c.setTime(dataAtual);
        c.add(Calendar.DATE, -1);

        Date hojeMenosUm = c.getTime();

        Log.d("Hoje menos um", hojeMenosUm.toString());


        Call call = dataFetchAPIs.getDrops(dateFormat.format(hojeMenosUm), "drop");
        /*
        This is the line which actually sends a network request. Calling enqueue() executes a call asynchronously. It has two callback listeners which will invoked on the main thread
        */
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                /*This is the success callback. Though the response type is JSON, with Retrofit we get the response in the form of WResponse POJO class
                 */
                if (response.body() != null) {
                    ApiData apiResponse = (ApiData) response.body();

                    //Log.i("dado", apiResponse.toString());

                    dados.addAll(apiResponse.getData());
                    for (Datum d : dados){
                        //Log.i("Dado:", d.toString());
                        treatedData.add(dataParse(d));

                    }
                    for (DropInfo i : treatedData){
                        Log.e("Dado tratado:", i.toString());
                    }

                }


            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("Erro! ", t.toString());
                /*
                Error callback
                */
            }
        });


    }
}
