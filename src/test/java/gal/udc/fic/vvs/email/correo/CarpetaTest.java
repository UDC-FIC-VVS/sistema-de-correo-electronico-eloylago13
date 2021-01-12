package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Texto;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Vector;

public class CarpetaTest extends TestCase {

    private String nombre = "Contenido";
    private String contenido = "Texto de contenido";


    private String _nombre = "carpeta";

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
    public void testExplorarYAñadirCarpeta() {
        Carpeta carpeta = new Carpeta(_nombre);

        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre+2, contenido+2);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpeta.añadir(mensaje);
            carpeta.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }


        Vector expected = new Vector();
        expected.add(mensaje);
        expected.add(mensaje2);


        try {
            Assert.assertEquals(expected, carpeta.explorar());
        } catch (OperacionInvalida operacionInvalida) {
        }

    }


    /**
     * Comprobación de que elimina corerctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testEliminar() {
        Carpeta carpeta = new Carpeta(_nombre);

        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre+2, contenido+2);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpeta.añadir(mensaje);
            carpeta.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }

        try {
            carpeta.eliminar(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }
        Vector expected = new Vector();
        expected.add(mensaje);

        try {
            Assert.assertEquals(expected, carpeta.explorar());
        } catch (OperacionInvalida operacionInvalida) {
        }
    }

    /**
     * Comprobación de que obtiene hijo correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerHijoCarpeta() {
        Carpeta carpeta = new Carpeta(_nombre);

        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre+2, contenido+2);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpeta.añadir(mensaje);
            carpeta.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }

        try {
            Assert.assertEquals(mensaje,carpeta.obtenerHijo(0));
            Assert.assertEquals(mensaje2,carpeta.obtenerHijo(1));

        } catch (OperacionInvalida operacionInvalida) {
            operacionInvalida.printStackTrace();
        }
    }
    /**
     * Comprobación de que establece como leido correctamente y devuelve los no leidos
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testEstablecerLeidoYObtenerNoLeidos() {
        Carpeta carpeta = new Carpeta(_nombre);

        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre+2, contenido+2);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpeta.añadir(mensaje);
            carpeta.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }

        carpeta.establecerLeido(true);

        Assert.assertEquals(0, carpeta.obtenerNoLeidos());


    }


    /**
     * Comprobación de que obtiene el tamaño correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerTamaño() {
        Carpeta carpeta = new Carpeta(_nombre);

        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre, contenido);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpeta.añadir(mensaje);
            carpeta.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }
        Assert.assertEquals((contenido+contenido).length(),carpeta.obtenerTamaño());
    }

    /**
     * Comprobación de que obtiene el icono correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerIcono() {
        Carpeta carpeta = new Carpeta(_nombre);

        Assert.assertEquals(Correo.ICONO_CARPETA, carpeta.obtenerIcono());
    }

    /**
     * Comprobación de que obtiene la previsualización correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerPreVisualizacion() {
        Carpeta carpeta = new Carpeta(_nombre);

        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre, contenido);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpeta.añadir(mensaje);
            carpeta.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }

        Assert.assertEquals("carpeta (2)", carpeta.obtenerPreVisualizacion());
    }

    /**
     * Comprobación de que obtiene la visualización correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerVisualizacion() {
        Carpeta carpeta = new Carpeta(_nombre);

        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre, contenido);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpeta.añadir(mensaje);
            carpeta.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }

        Assert.assertEquals("carpeta (2)", carpeta.obtenerVisualizacion());
    }

    /**
     * Comprobación de que busca correctamente con algo añadido
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testBuscar() {

        Carpeta carpeta = new Carpeta(_nombre);

        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre, contenido);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpeta.añadir(mensaje);
            carpeta.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }
        Vector v = new Vector();
        v.add(mensaje);
        v.add(mensaje2);
        Assert.assertEquals(v, carpeta.buscar(nombre));
    }
}