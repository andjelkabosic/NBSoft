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

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView brend;
        private TextView naziv;
        private TextView cena;
        private ImageView slika;

        public ViewHolder(View view, final RecyclerViewInterfejs recyclerViewInterfejs) {
            super(view);
            // Define click listener for the ViewHolder's View

            brend = (TextView) view.findViewById(R.id.brend);
            naziv = (TextView) view.findViewById(R.id.ime);
            cena = (TextView) view.findViewById(R.id.cena);
            slika = (ImageView) view.findViewById(R.id.slika);
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

        public TextView getNaziv() {
            return naziv;
        }

        public TextView getCena() {
            return cena;
        }

        public ImageView getSlika() {
            return slika;
        }

        public TextView getBrend() {
            return brend;
        }
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);

        return new ViewHolder(view, recyclerViewInterfejs);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getBrend().setText(listaProizvoda.get(position).getBrand());
        viewHolder.getNaziv().setText(listaProizvoda.get(position).getName());
        viewHolder.getCena().setText(listaProizvoda.get(position).getPrice());
        //viewHolder.getSlika().setText(listaProizvoda.get(position));
        Glide.with(viewHolder.itemView).load(listaProizvoda.get(position).getImage_link()).into(viewHolder.getSlika());
    }


    @Override
    public int getItemCount() {
        return listaProizvoda.size();
    }
}
