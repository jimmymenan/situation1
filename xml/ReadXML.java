package xml;


import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.btssio.ppe.autocool.R;

import java.io.InputStream;
import java.util.List;

import metier.Station;

public class ReadXML {
    private List<Station> lesStations;

    public ReadXML(Context context) {
        try{
            SAXHandler handler = new SAXHandler();
            Resources resources = context.getResources();
            InputStream is = resources.openRawResource(R.raw.stations);
            handler.parse(is);
            lesStations = handler.getLesStations();

        } catch (Exception e) {
            Log.i("ReadXML", "Erreur ReadXML");
        }
    }

    public List<Station> getLesStations(){
        return lesStations;
    }
}
