package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Texto;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Vector;

public class CarpetaTest {

    private String nombre = "Contenido";
    private String contenido = "Texto de contenido";


    private String _nombre = "carpeta";


    /**
     * Comprobación de que no puede añadir una carpeta con nombre nulo
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativa
     *      No podemos realizar esta operación
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test (expected = OperacionInvalida.class)
    public void carpetaNombreNull() {
        Carpeta carpeta = new Carpeta(null);

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
        Carpeta carpeta = new Carpeta(_nombre);

        try {
            carpeta.añadir(null);

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
        Carpeta carpeta = new Carpeta(_nombre);

        try {
            carpeta.eliminar(null);

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
        Carpeta carpeta = new Carpeta(_nombre);


        try {
            Assert.assertEquals(null,carpeta.obtenerHijo(1));

        } catch (OperacionInvalida operacionInvalida) {
        }
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
        Carpeta carpeta = new Carpeta(_nombre);

        carpeta.establecerPadre(null);
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
     * Comprobación de que obtiene el tamaño correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerTamañoVacio() {
        Carpeta carpeta = new Carpeta(_nombre);


        Assert.assertEquals(0,carpeta.obtenerTamaño());
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
    public void testBuscarSinNada() {

        Carpeta carpeta = new Carpeta(_nombre);

        Vector v = new Vector();

        Assert.assertEquals(v, carpeta.buscar(nombre));
    }
}