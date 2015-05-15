package metier;

import java.util.List;

public class Station {
    private String numero;
    private String ville;
    private String lieu;
    private String type;
    private String libelleType;
    private String niveau;
    private List<Voiture> sesVoitures;

    public Station (){
        super();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLibelleType() {
        return libelleType;
    }

    public void setLibelleType(String libelleType) {
        this.libelleType = libelleType;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public List<Voiture> getSesVoitures() { return sesVoitures; }

    public void setSesVoitures(List<Voiture> sesVoitures) { this.sesVoitures = sesVoitures; }

}
