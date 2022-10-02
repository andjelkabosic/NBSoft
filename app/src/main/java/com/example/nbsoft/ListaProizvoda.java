package com.example.nbsoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class ListaProizvoda extends AppCompatActivity implements RecyclerViewInterfejs{
    private RecyclerView proizvodi;
    LinearLayoutManager lm;
    private ArrayList<Proizvod> test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_proizvoda);

        proizvodi = findViewById(R.id.proizvodi);
        lm = new LinearLayoutManager(this);
        proizvodi.setLayoutManager(lm);

        ProizvodAPI pApi = new ProizvodAPI();
        pApi.execute();
    }

   @Override
    public void onClickProizvod(int position) {
      Intent intent = new Intent(ListaProizvoda.this, DetaljiProizvoda.class);

       intent.putExtra("Name",test.get(position).getName());
       intent.putExtra("Brand",test.get(position).getBrand());
       intent.putExtra("Price", test.get(position).getPrice());
       intent.putExtra("Image",test.get(position).getImage_link());
       startActivity(intent);
    }

    public class ProizvodAPI extends AsyncTask<Object, Integer, ArrayList<Proizvod>> {

        @Override
        protected ArrayList<Proizvod> doInBackground(Object... obj) {


            Gson gson = new Gson();
            try {
                URL url = new URL("https://makeup-api.herokuapp.com/api/v1/products.json?brand=maybelline");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    String response = bufferedReader.readLine();
                    System.out.println(response);

                    Proizvod[] proizvodi = gson.fromJson(response, Proizvod[].class);

                    ArrayList<Proizvod> arrayListaProizvodi = new ArrayList<Proizvod>();
                    for (Proizvod proizvod: proizvodi) {
                        if (proizvod.getBrand() == null || proizvod.getPrice() == null ||
                            proizvod.getName() == null || proizvod.getImage_link() == null) {
                            continue;
                        }
                        System.out.println("Dodajem proizvod" + proizvod);
                        arrayListaProizvodi.add(proizvod);
                    }
                    return arrayListaProizvodi;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Proizvod> lista_proizvoda) {
            test = lista_proizvoda;
            proizvodi.setAdapter(new Adapter(lista_proizvoda,ListaProizvoda.this));

        }
    }

}
