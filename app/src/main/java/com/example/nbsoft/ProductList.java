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


public class ProductList extends AppCompatActivity implements RecyclerViewInterface {
    private RecyclerView proizvodi;
    LinearLayoutManager lm;
    private ArrayList<Product> test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        proizvodi = findViewById(R.id.products);
        lm = new LinearLayoutManager(this);
        proizvodi.setLayoutManager(lm);

        ProizvodAPI pApi = new ProizvodAPI();
        pApi.execute();
    }

   @Override
    public void onClickProizvod(int position) {
      Intent intent = new Intent(ProductList.this, ProductDetails.class);

       intent.putExtra("Name",test.get(position).getName());
       intent.putExtra("Brand",test.get(position).getBrand());
       intent.putExtra("Price", test.get(position).getPrice());
       intent.putExtra("Image",test.get(position).getImage_link());
       startActivity(intent);
    }

    public class ProizvodAPI extends AsyncTask<Object, Integer, ArrayList<Product>> {

        @Override
        protected ArrayList<Product> doInBackground(Object... obj) {


            Gson gson = new Gson();
            try {
                URL url = new URL("https://makeup-api.herokuapp.com/api/v1/products.json?brand=maybelline");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    String response = bufferedReader.readLine();
                    System.out.println(response);

                    Product[] proizvodi = gson.fromJson(response, Product[].class);

                    ArrayList<Product> arrayListaProizvodi = new ArrayList<Product>();
                    for (Product product : proizvodi) {
                        if (product.getBrand() == null || product.getPrice() == null ||
                            product.getName() == null || product.getImage_link() == null) {
                            continue;
                        }
                        System.out.println("Dodajem proizvod" + product);
                        arrayListaProizvodi.add(product);
                    }
                    return arrayListaProizvodi;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Product> lista_proizvoda) {
            test = lista_proizvoda;
            proizvodi.setAdapter(new Adapter(lista_proizvoda, ProductList.this));

        }
    }

}
