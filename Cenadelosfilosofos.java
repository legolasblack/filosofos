package filosofos;

public class Cenadelosfilosofos {
    public static void main(String[] args) {
        Fork uno =new Fork();
        Fork dos =new Fork();
        Fork tres =new Fork();
        Fork cuatro =new Fork();
        Fork cinco =new Fork();


        Filosofo Socrates=new Filosofo(uno,dos,"Socrates");
        Filosofo Platon=new Filosofo(dos,tres,"Platon");
        Filosofo Aristoteles=new Filosofo(tres,cuatro,"Aristoteles");
        Filosofo Pitagoras=new Filosofo(cuatro,cinco,"Pitagoras");
        Filosofo Heraclito=new Filosofo(cinco,uno,"Heraclito");

        Socrates.start();
        Platon.start();
        Aristoteles.start();
        Pitagoras.start();
        Heraclito.start();

    }

}