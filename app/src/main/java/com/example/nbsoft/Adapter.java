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

    private final RecyclerViewInterfejs recyclerViewInterfejs;

    private String link = "https://www.mantralabsglobal.com/wp-content/uploads/2017/05/Android_thumb800.jpg";

    private ArrayList<Proizvod> listaProizvoda;
    public Adapter(ArrayList<Proizvod> listaProizvoda, RecyclerViewInterfejs recyclerViewInterfejs) {
        this.listaProizvoda = listaProizvoda;
        this.recyclerViewInterfejs = recyclerViewInterfejs;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView brand;
        private TextView name;
        private TextView price;
        private ImageView image;

        public ViewHolder(View view, final RecyclerViewInterfejs recyclerViewInterfejs) {

            super(view);
            brand = (TextView) view.findViewById(R.id.brend);
            name = (TextView) view.findViewById(R.id.ime);
            price = (TextView) view.findViewById(R.id.cena);
            image = (ImageView) view.findViewById(R.id.slika);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterfejs != null){
                        int poz = getAdapterPosition();

                        if(poz != RecyclerView.NO_POSITION){
                            recyclerViewInterfejs.onClickProizvod(poz);
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

        return new ViewHolder(view, recyclerViewInterfejs);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, int position) {

        viewHolder.getBrand().setText(listaProizvoda.get(position).getBrand());
        viewHolder.getName().setText(listaProizvoda.get(position).getName());
        viewHolder.getPrice().setText(listaProizvoda.get(position).getPrice()+" $");
        Glide.with(viewHolder.itemView).load(listaProizvoda.get(position).getImage_link()).into(viewHolder.getImage());
    }


    @Override
    public int getItemCount() {
        return listaProizvoda.size();
    }
}
