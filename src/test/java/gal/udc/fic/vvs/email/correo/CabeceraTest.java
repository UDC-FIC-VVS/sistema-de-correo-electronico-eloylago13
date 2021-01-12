package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Texto;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Vector;

public class CabeceraTest extends TestCase {

    private String nombreCabecera = "Cabecera";
    private String valorCabecera = "valor";

    String nombreTexto = "Texto";
    String contenidoTexto = "contenido";
    Texto texto = new Texto(nombreTexto, contenidoTexto);
    MensajeAbstracto mensaje = new Mensaje(texto);

    /**
     * Comprobación de que establece como leido y no obtiene ningún no leído
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testEstablecerLeidoYObtenerNoLeidos() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        cabecera.establecerLeido(true);
        Assert.assertEquals(0,cabecera.obtenerNoLeidos());
    }


    /**
     * Comprobación de que devuleve el tamaño correcto
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerTamaño() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        Assert.assertEquals((nombreCabecera+valorCabecera+contenidoTexto).length(), cabecera.obtenerTamaño());

    }

    /**
     * Comprobación de que devuleve el icono correcto
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerIcono() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        Assert.assertEquals(Correo.ICONO_NUEVO_MENSAJE, cabecera.obtenerIcono());

    }

    /**
     * Comprobación de que obtiene la previsualización esperada
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativa
     *      No debería de devolver los "..." para una cadena de esta longitud que
     *      no necesita truncar
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerPreVisualizacion() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        Assert.assertEquals(contenidoTexto , cabecera.obtenerPreVisualizacion());

    }

    /**
     * Comprobación de que obtiene la previsualización esperada
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerVisualizacion() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        Assert.assertEquals(nombreCabecera + ": " + valorCabecera + "\n" + mensaje.obtenerVisualizacion(), cabecera.obtenerVisualizacion());

    }

    /**
     * Comprobación de que obtiene la ruta esperada
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativa
     *      No debería de devolver los "..." para una cadena de esta longitud que
     *      no necesita truncar
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerRuta() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        Assert.assertEquals(contenidoTexto, cabecera.obtenerRuta());

    }

    /**
     * Comprobación de que obtienemos una excepción como se indica en el método
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test (expected = OperacionInvalida.class)
    public void testExplorar() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        Vector v = new Vector();
        try {
            Assert.assertEquals(v, cabecera.explorar());
        } catch (OperacionInvalida operacionInvalida) {
        }
    }

    /**
     * Comprobación de que obtiene el vector con la cabecera a partir del contenido del texto
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testBuscar() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        Vector v = new Vector();
        v.add(cabecera);

        Assert.assertEquals(v, cabecera.buscar(contenidoTexto));
    }

    /**
     * Comprobación de que obtienemos una excepción como se indica en el método
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test (expected =  OperacionInvalida.class)
    public void testAñadir() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        String nombreTextoMensaje = "Textoprueba";
        String contenidoTextoMensaje = "contenidoprueba";
        Texto textoMensaje = new Texto(nombreTextoMensaje, contenidoTextoMensaje);
        Mensaje mensajeAdd = new Mensaje(textoMensaje);

        try {
            cabecera.añadir(mensajeAdd);
        } catch (OperacionInvalida operacionInvalida) {
        }
    }

    /**
     * Comprobación de que obtienemos una excepción como se indica en el método
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test (expected =  OperacionInvalida.class)
    public void testEliminar() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        String nombreTextoMensaje = "Textoprueba";
        String contenidoTextoMensaje = "contenidoprueba";
        Texto textoMensaje = new Texto(nombreTextoMensaje, contenidoTextoMensaje);
        Mensaje mensajeAdd = new Mensaje(textoMensaje);

        try {
            cabecera.eliminar(mensajeAdd);
        } catch (OperacionInvalida operacionInvalida) {
        }
    }

    /**
     * Comprobación de que obtienemos el hijo esperado a partir del padre
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerHijoYEstablecerPadre() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        Cabecera cabecera2 = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        cabecera.establecerPadre(cabecera2);

        try {
            Assert.assertEquals(cabecera, cabecera2.obtenerHijo(1));
        } catch (OperacionInvalida operacionInvalida) {
        }

    }

    /**
     * Comprobación de que obtienemos el padre esperado a partir del hijo
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerPadre() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        Cabecera cabecera2 = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        cabecera.establecerPadre(cabecera2);

        Assert.assertEquals(cabecera2, cabecera.obtenerPadre());

    }


}
