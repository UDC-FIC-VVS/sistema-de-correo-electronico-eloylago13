package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Texto;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Vector;

public class CarpetaLimitadaTest {

    private String nombre = "Contenido";
    private String contenido = "Texto de contenido";


    private String _nombre = "carpeta";

    Carpeta carpeta = new Carpeta(_nombre);

    /**
     * Comprobación de que no podemos realizar una carpeta limitada sobre null
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativa
     *      No podemos hacer una carpeta limitada sobre null
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test (expected = OperacionInvalida.class)
    public void carpetaLimitadaSobreNull() {
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(null, 10);
    }


    /**
     * Comprobación de que no podemos realizar una carpeta limitada sobre null
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativa
     *      No podemos hacer una carpeta limitada sobre null
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test (expected = OperacionInvalida.class)
    public void carpetaLimitadaTamañoInvalido() {
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, -10);
    }



    /**
     * Comprobación de que la ruta es la esperada
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerRuta() {
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta,10);

        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre+2, contenido+2);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpetaLimitada.añadir(mensaje);
            carpetaLimitada.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }


        Vector expected = new Vector();
        expected.add(mensaje);
        expected.add(mensaje2);



            Assert.assertEquals("carpeta (2)", carpetaLimitada.obtenerRuta());


    }


    /**
     * Comprobación de que devuleve el añade y devuelve lo esperado a partir de lo añadido
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testExplorarYAñadir() {
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta,10);

        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre+2, contenido+2);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpetaLimitada.añadir(mensaje);
            carpetaLimitada.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }


        Vector expected = new Vector();
        expected.add(mensaje);
        expected.add(mensaje2);


        try {
            Assert.assertEquals(expected, carpetaLimitada.explorar());
        } catch (OperacionInvalida operacionInvalida) {
        }

    }


    /**
     * Comprobación de que devuleve el añade y devuelve lo esperado a partir de lo añadido
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativa
     *          Debería de devolver operación inválida y no nullpointer
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test (expected = OperacionInvalida.class)
    public void testAñadirNull() {
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta,10);

        try {
            carpetaLimitada.añadir(null);

        } catch (OperacionInvalida operacionInvalida) {

        }


    }


    /**
     * Comprobación de que elimina correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testEliminar() {
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta,10);

        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre+2, contenido+2);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpetaLimitada.añadir(mensaje);
            carpetaLimitada.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }

        try {
            carpetaLimitada.eliminar(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }
        Vector expected = new Vector();
        expected.add(mensaje);

        try {
            Assert.assertEquals(expected, carpetaLimitada.explorar());
        } catch (OperacionInvalida operacionInvalida) {
        }
    }

    /**
     * Comprobación de que devuleve el elimina y devuelve lo esperado a partir de lo añadido
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativa
     *          Debería de devolver operación inválida
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test (expected = OperacionInvalida.class)
    public void testEliminarNull() {
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta,10);

        try {
            carpetaLimitada.eliminar(null);

        } catch (OperacionInvalida operacionInvalida) {

        }


    }

    /**
     * Comprobación de que obtiene hijos correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerHijo() {
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta,10);

        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre+2, contenido+2);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpetaLimitada.añadir(mensaje);
            carpetaLimitada.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }

        try {
            Assert.assertEquals(mensaje,carpetaLimitada.obtenerHijo(0));
            Assert.assertEquals(mensaje2,carpetaLimitada.obtenerHijo(1));

        } catch (OperacionInvalida operacionInvalida) {
        }
    }


    /**
     * Comprobación de que obtiene null cuando no hay hijos
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativa
     *      No devuleve el null
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerHijoSinHijo() {
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta,10);


        try {
            Assert.assertEquals(null,carpetaLimitada.obtenerHijo(1));

        } catch (OperacionInvalida operacionInvalida) {
        }
    }


    /**
     * Comprobación de que obtenemos el padre correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testEstablecerYObtenerPadre() {
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta,10);


        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        carpetaLimitada.establecerPadre(mensaje);

        Assert.assertEquals(mensaje, carpetaLimitada.obtenerPadre());

    }


    /**
     * Comprobación de que obtenemos una operacion invalida al añadir padre null
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativa
     *      Debería de devolver Operación inválida
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test (expected = OperacionInvalida.class)
    public void testEstablecerPadreNull() {
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta,10);



        carpetaLimitada.establecerPadre(null);

    }


    /**
     * Comprobación de que establece leidos y obtiene no leidos correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testEstablecerLeidoYObtenerNoLeidos() {
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta,10);

        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre+2, contenido+2);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpetaLimitada.añadir(mensaje);
            carpetaLimitada.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }

        carpetaLimitada.establecerLeido(true);

        Assert.assertEquals(0, carpetaLimitada.obtenerNoLeidos());
    }




    /**
     * Comprobación de que obtiene tamaño correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerTamaño() {
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta,10);

        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre, contenido);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpetaLimitada.añadir(mensaje);
            carpetaLimitada.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }
        Assert.assertEquals((contenido+contenido).length(),carpetaLimitada.obtenerTamaño());

    }


    /**
     * Comprobación de que obtiene icono correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerIcono() {
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta,10);

        Assert.assertEquals(Correo.ICONO_CARPETA, carpetaLimitada.obtenerIcono());


    }


    /**
     * Comprobación de que obtiene previsualización correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerPreVisualizacion() {
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta,10);
        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre, contenido);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpetaLimitada.añadir(mensaje);
            carpetaLimitada.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }

        Assert.assertEquals("carpeta (2)", carpetaLimitada.obtenerPreVisualizacion());

    }


    /**
     * Comprobación de que obtiene visualización correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerVisualizacion() {
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta,10);
        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre, contenido);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpetaLimitada.añadir(mensaje);
            carpetaLimitada.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }

        Assert.assertEquals("carpeta (2)", carpetaLimitada.obtenerVisualizacion());

    }






    /**
     * Comprobación de que obtiene previsualización correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativa
     *  Poniendo 9 de tamaño realmente serían 10
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testBuscar() {
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta,10);
        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre, contenido);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);
        Texto nuevoTexto3 = new Texto(nombre, contenido);
        Mensaje mensaje3 = new Mensaje(nuevoTexto3);

        Texto nuevoTexto4 = new Texto(nombre, contenido);
        Mensaje mensaje4 = new Mensaje(nuevoTexto4);
        Texto nuevoTexto5 = new Texto(nombre, contenido);
        Mensaje mensaje5 = new Mensaje(nuevoTexto5);

        Texto nuevoTexto6 = new Texto(nombre, contenido);
        Mensaje mensaje6 = new Mensaje(nuevoTexto6);
        Texto nuevoTexto7 = new Texto(nombre, contenido);
        Mensaje mensaje7 = new Mensaje(nuevoTexto7);

        Texto nuevoTexto8 = new Texto(nombre, contenido);
        Mensaje mensaje8 = new Mensaje(nuevoTexto8);
        Texto nuevoTexto9 = new Texto(nombre, contenido);
        Mensaje mensaje9 = new Mensaje(nuevoTexto9);

        Texto nuevoTexto10 = new Texto(nombre, contenido);
        Mensaje mensaje10 = new Mensaje(nuevoTexto10);
        Texto nuevoTexto11 = new Texto(nombre, contenido);
        Mensaje mensaje11 = new Mensaje(nuevoTexto11);

        Vector v = new Vector();
        v.add(mensaje);
        v.add(mensaje2);
        v.add(mensaje3);
        v.add(mensaje4);
        v.add(mensaje5);
        v.add(mensaje6);
        v.add(mensaje7);
        v.add(mensaje8);
        v.add(mensaje9);
        v.add(mensaje10);



        try {
            carpetaLimitada.añadir(mensaje);
            carpetaLimitada.añadir(mensaje2);
            carpetaLimitada.añadir(mensaje3);
            carpetaLimitada.añadir(mensaje4);
            carpetaLimitada.añadir(mensaje5);
            carpetaLimitada.añadir(mensaje6);
            carpetaLimitada.añadir(mensaje7);
            carpetaLimitada.añadir(mensaje8);
            carpetaLimitada.añadir(mensaje9);
            carpetaLimitada.añadir(mensaje10);
            carpetaLimitada.añadir(mensaje11);

        } catch (OperacionInvalida operacionInvalida) {
        }

        Assert.assertEquals(v, carpetaLimitada.buscar(contenido));

    }


}
