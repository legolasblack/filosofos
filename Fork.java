package filosofos;

public class Fork {
    private boolean estado;
    
    public Fork() {
        this.estado=true;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public boolean getEstado() {
        return this.estado;
        
    }

}