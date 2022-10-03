package com.example.nbsoft;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;

    private String link = "https://www.mantralabsglobal.com/wp-content/uploads/2017/05/Android_thumb800.jpg";

    private ArrayList<Product> productList;
    public Adapter(ArrayList<Product> productList, RecyclerViewInterface recyclerViewInterface) {
        this.productList = productList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView brand;
        private TextView name;
        private TextView price;
        private ImageView image;

        public ViewHolder(View view, final RecyclerViewInterface recyclerViewInterface) {

            super(view);
            brand = (TextView) view.findViewById(R.id.brand);
            name = (TextView) view.findViewById(R.id.name);
            price = (TextView) view.findViewById(R.id.price);
            image = (ImageView) view.findViewById(R.id.image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int poz = getAdapterPosition();

                        if(poz != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onClickProizvod(poz);
                        }
                    }
                }
            });
        }

        public TextView getName() {
            return name;
        }

        public TextView getPrice() {
            return price;
        }

        public ImageView getImage() {
            return image;
        }

        public TextView getBrand() {
            return brand;
        }
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);

        return new ViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, int position) {

        viewHolder.getBrand().setText(productList.get(position).getBrand());
        viewHolder.getName().setText(productList.get(position).getName());
        viewHolder.getPrice().setText(productList.get(position).getPrice()+" $");
        Glide.with(viewHolder.itemView).load(productList.get(position).getImage_link()).into(viewHolder.getImage());
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }
}
