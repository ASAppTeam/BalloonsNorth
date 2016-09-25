package Util;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asteam.balloonsnorth.R;

import java.util.List;

import Data.Sale;

/**
 * Created by Amit on 9/20/2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cardViewSale);
            personName = (TextView) itemView.findViewById(R.id.saleName);
            personAge = (TextView) itemView.findViewById(R.id.saleDescription);
            personPhoto = (ImageView) itemView.findViewById(R.id.salePhoto);
        }
    }

    List<Sale> Sales;

    public RVAdapter(List<Sale> Sales) {
        this.Sales = Sales;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sale_card_view, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(Sales.get(i).getName());
        personViewHolder.personAge.setText(Sales.get(i).getSaledescription());
        personViewHolder.personPhoto.setImageResource(Sales.get(i).getPhotoId());
    }

    @Override
    public int getItemCount() {
        return Sales.size();
    }
}
