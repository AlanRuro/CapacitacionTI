/*
 * To change this license header, choose License Headers in Project Propertiesadasdasdasdasd.
 * To change this template file, choose Toolsdasdasds | Templates
 * and open the template in thasdasdasdasde editor.
 */
package mx.com.paquetexpress.type;

/**
 *
 * @author ealvarez
 */
public enum PushEventsType {

    PUSH_EVENTS_BITACORA("BITACORA"),
    PUSH_EVENTS_RAD("RAD"),
    PUSH_EVENTS_EAD("EAD");

    private String value;

    PushEventsType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}