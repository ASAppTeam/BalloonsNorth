package Util;

import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.asteam.balloonsnorth.R;

import java.util.List;

import Data.Sale;

/**
 * Created by Amit on 9/20/2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    public static final String FONTS_NAME = "fonts/roboto_regular.ttf";


    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView saleName;
        TextView saleDescription;
        ImageView salePhoto;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cardViewSale);
            saleName = (TextView) itemView.findViewById(R.id.saleName);
            saleDescription = (TextView) itemView.findViewById(R.id.saleDescription);
            salePhoto = (ImageView) itemView.findViewById(R.id.salePhoto);

            // Sets font type and size //
            Typeface tf = Typeface.createFromAsset(itemView.getContext().getAssets(), FONTS_NAME);
            this.saleName.setTypeface(tf);
            this.saleDescription.setTypeface(tf);
            saleName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            saleDescription.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);

            // Sets the sale description LayoutParams //
            RelativeLayout.LayoutParams saleDescriptionParams = (RelativeLayout.LayoutParams) saleDescription.getLayoutParams();
            saleDescriptionParams.setMargins(0, 20, 0, 0); //substitute parameters for left, top, right, bottom
            saleDescription.setLayoutParams(saleDescriptionParams);

            RelativeLayout.LayoutParams saleNameParams = (RelativeLayout.LayoutParams) saleName.getLayoutParams();
            saleNameParams.setMargins(0, 5, 0, 10); //substitute parameters for left, top, right, bottom
            saleName.setLayoutParams(saleNameParams);

            RelativeLayout.LayoutParams salePhotoParams = (RelativeLayout.LayoutParams) salePhoto.getLayoutParams();
            salePhotoParams.setMargins(0, 5, 0, 5); //substitute parameters for left, top, right, bottom
            salePhoto.setLayoutParams(salePhotoParams);
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
        personViewHolder.saleName.setText(Sales.get(i).getName());
        personViewHolder.saleDescription.setText(Sales.get(i).getSaledescription());
        personViewHolder.salePhoto.setImageResource(Sales.get(i).getPhotoId());
    }

    @Override
    public int getItemCount() {
        return Sales.size();
    }
}
