package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Texto;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Vector;

public class ReenvioTest extends TestCase {



    String nombreTexto = "Texto";
    String contenidoTexto = "contenido";
    Texto texto = new Texto(nombreTexto, contenidoTexto);
    Correo correo = new Mensaje(texto);

    String nombreReenvio= "TextoReenvio";
    String contenidoRenvio = "contenidoReenvio";
    Texto reenvioTexto = new Texto(nombreReenvio, contenidoRenvio);
    Mensaje reenvioMensaje = new Mensaje(reenvioTexto);

    String nombreTexto2 = "Texto2";
    String contenidoTexto2 = "contenido2";
    Texto texto2 = new Texto(nombreTexto2, contenidoTexto2);
    Correo correo2 = new Mensaje(texto2);

    String nombreReenvio2= "TextoReenvio2";
    String contenidoRenvio2 = "contenidoReenvio2";
    Texto reenvioTexto2 = new Texto(nombreReenvio2, contenidoRenvio2);
    Mensaje reenvioMensaje2 = new Mensaje(reenvioTexto2);

    /**
     * Comprobación de que devuleve el tamaño correcto
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos:
     */
    @Test
    public void testTestObtenerTamaño() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);

        Assert.assertEquals((contenidoRenvio+contenidoTexto).length(), reenvio.obtenerTamaño());
    }

    /**
     * Comprobación de que obtiene la previsualización esperada
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos:
     */
    @Test
    public void testTestObtenerVisualizacion() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);

        Assert.assertEquals("contenido"+"\n\n---- Correo reenviado ----\n\n" + "contenido" + "\n---- Fin correo reenviado ----", reenvio.obtenerVisualizacion());
    }

    /**
     * Comprobación de que establece como leido y no obtiene ningún no leído
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos:
     */
    @Test
    public void testEstablecerLeidoYObtenerNoLeidos() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);

        reenvio.establecerLeido(true);

        Assert.assertEquals(0,reenvio.obtenerNoLeidos());
    }


    /**
     * Comprobación de que devuleve el icono correcto
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos:
     */
    @Test
    public void testObtenerIcono() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);

        Assert.assertEquals(Correo.ICONO_NUEVO_MENSAJE, reenvio.obtenerIcono());
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
     * Mecanismo de selección dos datos:
     */
    @Test
    public void testObtenerPreVisualizacion() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);

        Assert.assertEquals(contenidoRenvio, reenvio.obtenerPreVisualizacion());
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
     * Mecanismo de selección dos datos:
     */
    @Test
    public void testObtenerRuta() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);

        Assert.assertEquals(contenidoRenvio, reenvio.obtenerRuta());

    }

    /**
     * Comprobación de que obtienemos una excepción como se indica en el método
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos:
     */
    @Test (expected = OperacionInvalida.class)
    public void testExplorar() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);

        Vector v = new Vector();
        try {
            Assert.assertEquals(v, reenvio.explorar());
        } catch (OperacionInvalida operacionInvalida) {
        }
    }

    /**
     * Comprobación de que obtiene el vector con el reenvío a partir del contenido del texto
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos:
     */
    @Test
    public void testBuscar() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);
        Vector v = new Vector();
        v.add(reenvio);

        Assert.assertEquals(v, reenvio.buscar(contenidoTexto));

    }

    /**
     * Comprobación de que obtienemos una excepción como se indica en el método
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos:
     */
    @Test (expected =  OperacionInvalida.class)
    public void testAñadir() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);
        String nombreTextoMensaje = "Textoprueba";
        String contenidoTextoMensaje = "contenidoprueba";
        Texto textoMensaje = new Texto(nombreTextoMensaje, contenidoTextoMensaje);
        Mensaje mensajeAdd = new Mensaje(textoMensaje);

        try {
            reenvio.añadir(mensajeAdd);
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
     * Mecanismo de selección dos datos:
     */
    @Test (expected =  OperacionInvalida.class)
    public void testEliminar() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);
        String nombreTextoMensaje = "Textoprueba";
        String contenidoTextoMensaje = "contenidoprueba";
        Texto textoMensaje = new Texto(nombreTextoMensaje, contenidoTextoMensaje);
        Mensaje mensajeAdd = new Mensaje(textoMensaje);

        try {
            reenvio.eliminar(mensajeAdd);
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
     * Mecanismo de selección dos datos:
     */
    @Test
    public void testObtenerHijoYEstablecerPadre() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);
        Reenvio reenvio2 = new Reenvio(reenvioMensaje2, correo2);

        reenvio.establecerPadre(reenvio2);

        try {
            Assert.assertEquals(reenvio, reenvio2.obtenerHijo(1));
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
     * Mecanismo de selección dos datos:
     */
    @Test
    public void testObtenerPadre() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);
        Reenvio reenvio2 = new Reenvio(reenvioMensaje2, correo2);

        reenvio.establecerPadre(reenvio2);

        Assert.assertEquals(reenvio2, reenvio.obtenerPadre());

    }


}