package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.btssio.ppe.autocool.R;

import java.util.List;

import metier.Voiture;

public class AdapterVoiture extends ArrayAdapter<Voiture> {

    public AdapterVoiture(Context context, int textViewResourceId){
        super(context, textViewResourceId);
    }

    public AdapterVoiture(Context context, int resource, List<Voiture> items){
        super(context, resource, items);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        View cView = convertView;

        if (cView == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            cView = vi.inflate(R.layout.sous_liste_voitures, null);
        }

        Voiture voiture = getItem(position);

        if (voiture != null) {
            TextView tv_type = (TextView) cView.findViewById(R.id.tv_typeVoiture);
            TextView tv_place = (TextView) cView.findViewById(R.id.tv_nbPlacesVoiture);
            TextView tv_boite = (TextView) cView.findViewById(R.id.tv_typeBoitier);

            if (tv_type != null) {
                tv_type.setText(voiture.getTypeVoiture());
            }
            if (tv_place != null) {
                tv_place.setText(voiture.getNbPlacesVoiture());
            }
            if (tv_boite != null) {
                if(voiture.getAuto().equals("N")) {
                    tv_boite.setText("Manuel");
                }else{
                    tv_boite.setText("Automatique");
                }
            }
        }


        return cView;
    }
}
