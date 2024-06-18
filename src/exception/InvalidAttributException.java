package exception;

/**
 * Cette exception est lancée lorsqu'un attribut est invalide invalide.
 */
public class InvalidAttributException extends Exception {

    /**
     * Crée une nouvelle exception avec un message spécifié.
     * @param m le message détaillant la cause de l'exception
     */
    public InvalidAttributException(String m) {
        super(m);
    }

}
