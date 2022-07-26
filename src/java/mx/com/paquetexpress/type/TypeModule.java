package mx.com.paquetexpress.type;

/**
 *
 * @author evillegas
 */
import java.io.Serializable;

/**
 *
 * @author jasanchez
 */
public enum TypeModule  implements Serializable{

    MODULE("EADRestFul");
    private final String type;

    TypeModule(String clasificacion) {
        this.type = clasificacion;
    }

    public String getType() {
        return type;
    }

    public static TypeModule getEnum(String clasificador) {
        if (MODULE.getType().equalsIgnoreCase(clasificador)) {
            return MODULE;
        }
        return null;
    }
}

