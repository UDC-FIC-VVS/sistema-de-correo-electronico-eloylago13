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
     *
     */
    @Test
    public void testObtenerTamaño() {
        Adjunto adjunto = new Adjunto(mensaje, audio);

        Assert.assertEquals((contenidoAudio+contenidoTexto).length(), adjunto.obtenerTamaño());

    }

    /**
     *
     */
    @Test
    public void testEstablecerLeidoYObtenerNoLeidos() {
        Adjunto adjunto = new Adjunto(mensaje, audio);

        adjunto.establecerLeido(true);
        Assert.assertEquals(0,adjunto.obtenerNoLeidos());

    }



    /**
     *
     */
    @Test
    public void testObtenerIcono() {
        Adjunto adjunto = new Adjunto(mensaje, audio);

        Assert.assertEquals(Correo.ICONO_NUEVO_MENSAJE, adjunto.obtenerIcono());


    }

    /**
     * Mismo problema. "..."
     */
    @Test
    public void testObtenerPreVisualizacion() {
        Adjunto adjunto = new Adjunto(mensaje, audio);

        Assert.assertEquals(contenidoTexto , adjunto.obtenerPreVisualizacion());


    }

    /**
     *
     */
    @Test
    public void testObtenerVisualizacion() {
        Adjunto adjunto = new Adjunto(mensaje, audio);

        Assert.assertEquals(contenidoTexto + "\n\nAdxunto: " + audio.obtenerPreVisualizacion(), adjunto.obtenerVisualizacion());

    }

    /**
     * Mismo razonamiento seguido. No debería de aplicar "..."
     */
    @Test
    public void testObtenerRuta() {
        Adjunto adjunto = new Adjunto(mensaje, audio);

        Assert.assertEquals(contenidoTexto, adjunto.obtenerRuta());

    }

    /**
     *
     */
    @Test
    public void testExplorar() {
        Adjunto adjunto = new Adjunto(mensaje, audio);


        Vector v = new Vector();
        try {
            Assert.assertEquals(v, adjunto.explorar());
        } catch (OperacionInvalida operacionInvalida) {
        }
    }

    /**
     *
     */
    @Test
    public void testBuscar() {
        Adjunto adjunto = new Adjunto(mensaje, audio);
        Vector v = new Vector();
        v.add(adjunto);

        Assert.assertEquals(v, adjunto.buscar(contenidoTexto));

    }

    /**
     *
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
     *
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
     *
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
     *
     */
    @Test
    public void testObtenerPadre() {
        Adjunto adjunto = new Adjunto(mensaje, audio);
        Adjunto adjunto2 = new Adjunto(mensaje, audio);

        adjunto.establecerPadre(adjunto2);


        Assert.assertEquals(adjunto2, adjunto.obtenerPadre());



    }


    /**
     * Mismo fallo previsualización. "..."
     */
    @Test
    public void testTestObtenerRuta() {
        Adjunto adjunto = new Adjunto(mensaje, audio);

        Assert.assertEquals(contenidoTexto,adjunto.obtenerRuta());


    }


}