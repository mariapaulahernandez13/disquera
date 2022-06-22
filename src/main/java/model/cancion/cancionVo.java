package model.cancion;

public class cancionVo {
    private int idCancion;
    private String nombreCancion;
    private int fechaGrabacion;
    private String duracionCancion;
    private boolean estadoCancion;

    public cancionVo(){
        
    }
    
    public cancionVo(int idCancion, String nombreCancion, int fechaGrabacion, String duracionCancion,
            boolean estadoCancion) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.fechaGrabacion = fechaGrabacion;
        this.duracionCancion = duracionCancion;
        this.estadoCancion = estadoCancion;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public int getFechaGrabacion() {
        return fechaGrabacion;
    }

    public void setFechaGrabacion(int fechaGrabacion) {
        this.fechaGrabacion = fechaGrabacion;
    }

    public String getDuracionCancion() {
        return duracionCancion;
    }

    public void setDuracionCancion(String duracionCancion) {
        this.duracionCancion = duracionCancion;
    }

    public boolean isEstadoCancion() {
        return estadoCancion;
    }

    public void setEstadoCancion(boolean estadoCancion) {
        this.estadoCancion = estadoCancion;
    }

    
}
