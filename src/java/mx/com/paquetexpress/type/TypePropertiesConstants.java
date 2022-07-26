package mx.com.paquetexpress.type;

import java.io.Serializable;

public enum TypePropertiesConstants implements Serializable {

    TEST(1);
    private final int type;

    TypePropertiesConstants(int clasificacion) {
        this.type = clasificacion;
    }

    public int getType() {
        return type;
    }

    public static TypePropertiesConstants getEnum(int clasificador) {
        if (TEST.getType() == clasificador){
            return TEST;
        }
        throw new IllegalArgumentException("No Enum specified for this string");
    }
}
