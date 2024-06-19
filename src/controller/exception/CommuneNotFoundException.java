package exception;

/**
 * Cette exception est lancée lorsqu'une commune n'est pas trouvée.
 */
public class CommuneNotFoundException extends Exception {

    /**
     * Crée une nouvelle exception avec un message spécifié.
     * @param m le message détaillant la cause de l'exception
     */
    public CommuneNotFoundException(String m) {
        super(m);
    }

}
