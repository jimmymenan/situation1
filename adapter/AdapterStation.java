package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.btssio.ppe.autocool.R;

import java.util.List;

import metier.Station;

public class AdapterStation extends ArrayAdapter<Station> {

    public AdapterStation(Context context, int textViewResourceId){
        super(context, textViewResourceId);
    }

    public AdapterStation(Context context, int resource, List<Station> items){
        super(context, resource, items);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        View cView = convertView;

        if (cView == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            cView = vi.inflate(R.layout.liste_stations, null);
        }

        Station station = getItem(position);

        if (station != null) {
            TextView tv_lieu = (TextView) cView.findViewById(R.id.tv_lieu);
            TextView tv_ville = (TextView) cView.findViewById(R.id.tv_ville);
            TextView tv_libelle = (TextView) cView.findViewById(R.id.tv_libelle);
            TextView tv_type = (TextView) cView.findViewById(R.id.tv_type);
            TextView tv_niveau = (TextView) cView.findViewById(R.id.tv_niveau);


            if (tv_lieu != null) {
                tv_lieu.setText(station.getLieu());
            }
            if (tv_ville != null) {
                tv_ville.setText(station.getVille());
            }
            if (tv_libelle != null) {
                tv_libelle.setText(station.getLibelleType());
            }
            if (tv_type != null) {
                if (station.getType().equals("p")) {
                    tv_type.setText("Parking ");
                }else{
                    tv_type.setText("Voirie");
                }
            }
            if (tv_niveau != null) {
                tv_niveau.setText("niveau  "+station.getNiveau());
            }else{
                tv_niveau.setText("");
            }

        }


        return cView;
    }
}
