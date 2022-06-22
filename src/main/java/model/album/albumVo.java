package model.album;

public class albumVo {
    private int idAlbum;
    private String nombreAlbum;
    private int anioPublicacion;
    private boolean estadoAlbum;

    public albumVo(){

    }
    
    public albumVo(int idAlbum, String nombreAlbum, int anioPublicacion, boolean estadoAlbum) {
        this.idAlbum = idAlbum;
        this.nombreAlbum = nombreAlbum;
        this.anioPublicacion = anioPublicacion;
        this.estadoAlbum = estadoAlbum;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isEstadoAlbum() {
        return estadoAlbum;
    }

    public void setEstadoAlbum(boolean estadoAlbum) {
        this.estadoAlbum = estadoAlbum;
    }

}
