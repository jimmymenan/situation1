package metier;

public class Voiture {
    private String idVoiture;
    private String typeVoiture;
    private String nbPlacesVoiture;
    private String auto;

    public Voiture(){
        super();
    }

    public String getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(String idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getTypeVoiture() {
        return typeVoiture;
    }

    public void setTypeVoiture(String typeVoiture) {
        this.typeVoiture = typeVoiture;
    }

    public String getNbPlacesVoiture() {
        return nbPlacesVoiture;
    }

    public void setNbPlacesVoiture(String nbPlacesVoiture) { this.nbPlacesVoiture = nbPlacesVoiture; }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }
}
