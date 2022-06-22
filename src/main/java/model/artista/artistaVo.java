package model.artista;

public class artistaVo {
    
    private int idArtista;
    private String noDocumento;
    private String tipoDocumento;
    private String nombreArtista;
    private String apellidoArtista;
    private String nombreArtistico;
    private int feNacimArtista;
    private String emailArtista;
    private boolean estadoArtista;

    public artistaVo(){

    }
    
    public artistaVo(int idArtista, String noDocumento, String tipoDocumento, String nombreArtista,
            String apellidoArtista, String nombreArtistico, int feNacimArtista, String emailArtista,
            boolean estadoArtista) {
        this.idArtista = idArtista;
        this.noDocumento = noDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombreArtista = nombreArtista;
        this.apellidoArtista = apellidoArtista;
        this.nombreArtistico = nombreArtistico;
        this.feNacimArtista = feNacimArtista;
        this.emailArtista = emailArtista;
        this.estadoArtista = estadoArtista;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public String getNoDocumento() {
        return noDocumento;
    }

    public void setNoDocumento(String noDocumento) {
        this.noDocumento = noDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getApellidoArtista() {
        return apellidoArtista;
    }

    public void setApellidoArtista(String apellidoArtista) {
        this.apellidoArtista = apellidoArtista;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public int getFeNacimArtista() {
        return feNacimArtista;
    }

    public void setFeNacimArtista(int feNacimArtista) {
        this.feNacimArtista = feNacimArtista;
    }

    public String getEmailArtista() {
        return emailArtista;
    }

    public void setEmailArtista(String emailArtista) {
        this.emailArtista = emailArtista;
    }

    public boolean isEstadoArtista() {
        return estadoArtista;
    }

    public void setEstadoArtista(boolean estadoArtista) {
        this.estadoArtista = estadoArtista;
    }

}
