package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import metier.Station;
import metier.Voiture;

public class SAXHandler extends DefaultHandler{
    private Station station;
    private List<Station> lesStations = new ArrayList<Station>();
    private Voiture voiture;
    private List<Voiture> lesVoitures;
    private String value;

    public void parse(InputStream is) throws ParserConfigurationException, SAXException, IOException{
        SAXParserFactory SAXPFactory = SAXParserFactory.newInstance();
        SAXParser parser = SAXPFactory.newSAXParser();
        parser.parse(is, this);
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        if(localName.equals("Station")) {
            station = new Station();
            station.setNumero(attributes.getValue(0));
        }else if(localName.equalsIgnoreCase("Voitures")) {
            lesVoitures = new ArrayList<Voiture>();
        }else if(localName.equals("Voiture")) {
            voiture = new Voiture();
            voiture.setIdVoiture(attributes.getValue(0));
            voiture.setTypeVoiture(attributes.getValue(1));
            voiture.setNbPlacesVoiture(attributes.getValue(2));
            voiture.setAuto(attributes.getValue(3));
        }

    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        value = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(localName.equalsIgnoreCase("Station")) {
            lesStations.add(station);
        }else if(localName.equalsIgnoreCase("Ville")){
            station.setVille(value);
        }else if(localName.equalsIgnoreCase("Lieu")){
            station.setLieu(value);
        }else if(localName.equalsIgnoreCase("Type")){
            station.setType(value);
        }else if(localName.equalsIgnoreCase("LibelleType")) {
            station.setLibelleType(value);
        }else if(localName.equalsIgnoreCase("Niveau")){
            station.setNiveau(value);
        }else if(localName.equalsIgnoreCase("Voiture")){
            lesVoitures.add(voiture);
        }else if(localName.equalsIgnoreCase("Voitures")){
            station.setSesVoitures(lesVoitures);
        }
    }

    public List<Station> getLesStations() {
        return lesStations;
    }
}
