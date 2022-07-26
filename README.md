# EJBExampleRestful

Nombre: EjbExampleRestful
Descripcion: Ejemplo de persistencia y transaccion con Weblogic12c

Fecha de creación: 18-sep-2021
Usuario de creación: Ricardo Lopez Gastelum.


TEST JSON
POST
localhost:7001/EJBExampleRestful/api/test/ejb
{
    "header": {
        "security": {
            "user": "20935",
            "password": null,
            "type": 0,
            "token": "Z2VuZXJpY0FUVFVzZXI6Z2VuZXJpY0FUVFBhc3N3b3Jk"
        },
        "device": null,
        "target": {
            "module": "Test EjbExampleRestful",
            "version": null,
            "service": null,
            "uri": "http://localhost:7001/EJBExampleRestful/api/test/ejb",
            "event": "test()"
        },
        "output": null
    },
    "body": {
        "request": {
            "data": {
                "paramA": null
            },
            "objectDTO": "TestDTO"
        },
        "response": null
    }
}