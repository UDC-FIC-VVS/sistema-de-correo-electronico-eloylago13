package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Texto;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Vector;

public class ReenvioTest extends TestCase {


    Audio audio = new Audio("Cancion", "contenido");

    String nombreTexto = "Texto";
    String contenidoTexto = "contenido";
    Texto texto = new Texto(nombreTexto, contenidoTexto);
    Correo correo = new Mensaje(texto);

    String nombreReenvio= "Texto";
    String contenidoRenvio = "contenido";
    Texto reenvioTexto = new Texto(nombreReenvio, contenidoRenvio);
    Mensaje reenvioMensaje = new Mensaje(reenvioTexto);

    /**
     *
     */
    @Test
    public void testTestObtenerTamaño() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);

        Assert.assertEquals((contenidoRenvio+contenidoTexto).length(), reenvio.obtenerTamaño());
    }

    /**
     *
     */
    @Test
    public void testTestObtenerVisualizacion() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);

        Assert.assertEquals("contenido"+"\n\n---- Correo reenviado ----\n\n" + "contenido" + "\n---- Fin correo reenviado ----", reenvio.obtenerVisualizacion());
    }

    /**
     *
     */
    @Test
    public void testEstablecerLeidoYObtenerNoLeidos() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);

        reenvio.establecerLeido(true);

        Assert.assertEquals(0,reenvio.obtenerNoLeidos());
    }


    /**
     *
     */
    @Test
    public void testObtenerIcono() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);

        Assert.assertEquals(Correo.ICONO_NUEVO_MENSAJE, reenvio.obtenerIcono());
    }

    /**
     * Mismo razonamiento seguido. No debería de aplicar "..."
     */
    @Test
    public void testObtenerPreVisualizacion() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);

        Assert.assertEquals(contenidoRenvio, reenvio.obtenerPreVisualizacion());
    }

    /**
     * Mismo razonamiento seguido. No debería de aplicar "..."
     */
    @Test
    public void testObtenerRuta() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);

        Assert.assertEquals(contenidoRenvio, reenvio.obtenerRuta());

    }

    /**
     * Al hacer un explorar de un correo, que su explorar devuelve excepción, es correcto.
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
     *
     */
    @Test
    public void testBuscar() {
        Reenvio reenvio = new Reenvio(reenvioMensaje, correo);
        Vector v = new Vector();
        v.add(reenvio);

        Assert.assertEquals(v, reenvio.buscar(contenidoTexto));

    }

    /**
     *
     */
    @Test
    public void testAñadir() {

    }

    public void testEliminar() {
    }

    public void testObtenerHijo() {
    }

    public void testObtenerPadre() {
    }

    public void testEstablecerPadre() {
    }

    public void testTestObtenerRuta() {
    }

    public void testTestExplorar() {
    }

    public void testTestAñadir() {
    }

    public void testTestEliminar() {
    }

    public void testTestObtenerHijo() {
    }

    public void testTestObtenerPadre() {
    }

    public void testTestEstablecerPadre() {
    }


}