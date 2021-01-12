package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Texto;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Vector;

public class AdjuntoTest extends TestCase {

    private String nombreAudio = "Canción";
    private String contenidoAudio = "Canción número uno";

    Audio audio = new Audio(nombreAudio, contenidoAudio);

    String nombreTexto = "Texto";
    String contenidoTexto = "contenido";
    Texto texto = new Texto(nombreTexto, contenidoTexto);
    MensajeAbstracto mensaje = new Mensaje(texto);



    /**
     * Comprobación de que obtener test devuelve correctamente el resultado.
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerTamaño() {
        Adjunto adjunto = new Adjunto(mensaje, audio);

        Assert.assertEquals((contenidoAudio+contenidoTexto).length(), adjunto.obtenerTamaño());

    }

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
        Adjunto adjunto = new Adjunto(mensaje, audio);

        adjunto.establecerLeido(true);
        Assert.assertEquals(0,adjunto.obtenerNoLeidos());

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
        Adjunto adjunto = new Adjunto(mensaje, audio);

        Assert.assertEquals(Correo.ICONO_NUEVO_MENSAJE, adjunto.obtenerIcono());


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
        Adjunto adjunto = new Adjunto(mensaje, audio);

        Assert.assertEquals(contenidoTexto , adjunto.obtenerPreVisualizacion());


    }



    /**
     * Comprobación de que obtiene la visualización esperada
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerVisualizacion() {
        Adjunto adjunto = new Adjunto(mensaje, audio);

        Assert.assertEquals(contenidoTexto + "\n\nAdxunto: " + audio.obtenerPreVisualizacion(), adjunto.obtenerVisualizacion());

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
        Adjunto adjunto = new Adjunto(mensaje, audio);

        Assert.assertEquals(contenidoTexto, adjunto.obtenerRuta());

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
        Adjunto adjunto = new Adjunto(mensaje, audio);


        Vector v = new Vector();
        try {
            Assert.assertEquals(v, adjunto.explorar());
        } catch (OperacionInvalida operacionInvalida) {
        }
    }

    /**
     * Comprobación de que obtiene el vector con el adjunto a partir del contenido del texto
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testBuscar() {
        Adjunto adjunto = new Adjunto(mensaje, audio);
        Vector v = new Vector();
        v.add(adjunto);

        Assert.assertEquals(v, adjunto.buscar(contenidoTexto));

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
        Adjunto adjunto = new Adjunto(mensaje, audio);

        String nombreTextoMensaje = "Textoprueba";
        String contenidoTextoMensaje = "contenidoprueba";
        Texto textoMensaje = new Texto(nombreTextoMensaje, contenidoTextoMensaje);
        Mensaje mensajeAdd = new Mensaje(textoMensaje);

        try {
            adjunto.añadir(mensajeAdd);
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
        Adjunto adjunto = new Adjunto(mensaje, audio);

        String nombreTextoMensaje = "Textoprueba";
        String contenidoTextoMensaje = "contenidoprueba";
        Texto textoMensaje = new Texto(nombreTextoMensaje, contenidoTextoMensaje);
        Mensaje mensajeAdd = new Mensaje(textoMensaje);

        try {
            adjunto.eliminar(mensajeAdd);
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
        Adjunto adjunto = new Adjunto(mensaje, audio);

        Adjunto adjunto2 = new Adjunto(mensaje, audio);

        adjunto.establecerPadre(adjunto2);

        try {
            Assert.assertEquals(adjunto, adjunto2.obtenerHijo(1));
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
        Adjunto adjunto = new Adjunto(mensaje, audio);
        Adjunto adjunto2 = new Adjunto(mensaje, audio);

        adjunto.establecerPadre(adjunto2);


        Assert.assertEquals(adjunto2, adjunto.obtenerPadre());



    }



}