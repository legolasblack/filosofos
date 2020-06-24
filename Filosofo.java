package filosofos;

import java.util.Random;
import java.lang.Thread;

public class Filosofo extends Thread {
    private String nombre;
    private int estado;
    private Fork derecho;
    private Fork izquierdo;

    public Filosofo() {
        this.estado = 1;
    }

    public Filosofo(Fork dere, Fork izq, String nom) {
        this.estado = 1;
        this.derecho = dere;
        this.izquierdo = izq;
        this.nombre = nom;
    }

    public int solicitud_estado() {
        Random numaleatorio = new Random();
        return 1 + numaleatorio.nextInt(2);

    }

    public int solicitud_tiempo() {
        Random numaleatorio = new Random();
        return 1000 + numaleatorio.nextInt(15000);

    }

    public void run() {
        while (10 < 20) {
            if (this.estado == 0) {
                this.estado = this.solicitud_estado();
            } else if (this.estado == 1) {
                long tiempo_de_pensar = this.solicitud_tiempo();
                System.out.println("el filosofo " + this.nombre + " pensara por " + tiempo_de_pensar + " milisegundos");
                this.estado=0;
                try {
                    Thread.sleep(tiempo_de_pensar);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } // fin else if
            else if (this.estado == 2) {
                if (this.derecho.getEstado() || this.izquierdo.getEstado()) {
                    int tiempo_comer = this.solicitud_tiempo();
                    System.out.println("el filosofo " + this.nombre + " comera por " + tiempo_comer + " milisegundos");
                    this.derecho.setEstado(false);
                    this.izquierdo.setEstado(false);
                    try {
                        Thread.sleep(tiempo_comer);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    this.estado = 0;
                    this.derecho.setEstado(true);
                    this.izquierdo.setEstado(true);
                } else {
                    int tiempo_espera = this.solicitud_tiempo();
                    System.out.println("El recurso se encuentra ocupado para el filosofo " + this.nombre);
                    System.out.println(
                            "El filosofo " + this.nombre + " entrara en espera por " + tiempo_espera + "milisegundos");
                    if (this.derecho.getEstado()) {
                        this.derecho.setEstado(false);
                    } else {
                        this.izquierdo.setEstado(false);
                    }
                    try {
                        Thread.sleep(tiempo_espera);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    this.estado=2;

                }
            }
         }//cierre del while
         
         }//cierre del metodo run
         
     



}