package model.genero;

public class generoVo{

    private int idGenero;
    private String nombreGenero;
    private boolean estadoGenero;

    public generoVo(){

    }

    public generoVo(int idGenero, String nombreGenero, boolean estadoGenero) {
        this.idGenero = idGenero;
        this.nombreGenero = nombreGenero;
        this.estadoGenero = estadoGenero;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    public boolean isEstadoGenero() {
        return estadoGenero;
    }

    public void setEstadoGenero(boolean estadoGenero) {
        this.estadoGenero = estadoGenero;
    }
}
