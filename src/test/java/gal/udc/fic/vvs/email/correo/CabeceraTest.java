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
     *
     */
    @Test
    public void testEstablecerLeidoYObtenerNoLeidos() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        cabecera.establecerLeido(true);
        Assert.assertEquals(0,cabecera.obtenerNoLeidos());


    }


    /**
     *
     */
    @Test
    public void testObtenerTamaño() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        Assert.assertEquals((nombreCabecera+valorCabecera+contenidoTexto).length(), cabecera.obtenerTamaño());

    }

    /**
     *
     */
    @Test
    public void testObtenerIcono() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        Assert.assertEquals(Correo.ICONO_NUEVO_MENSAJE, cabecera.obtenerIcono());

    }

    /**
     * Mismo problema. "..."
     */
    @Test
    public void testObtenerPreVisualizacion() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        Assert.assertEquals(contenidoTexto , cabecera.obtenerPreVisualizacion());

    }

    /**
     *
     */
    @Test
    public void testObtenerVisualizacion() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        Assert.assertEquals(nombreCabecera + ": " + valorCabecera + "\n" + mensaje.obtenerVisualizacion(), cabecera.obtenerVisualizacion());

    }

    /**
     * Mismo razonamiento seguido. No debería de aplicar "..."
     */
    @Test
    public void testObtenerRuta() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        Assert.assertEquals(contenidoTexto, cabecera.obtenerRuta());

    }

    /**
     *
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
     *
     */
    @Test
    public void testBuscar() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        Vector v = new Vector();
        v.add(cabecera);

        Assert.assertEquals(v, cabecera.buscar(contenidoTexto));
    }

    /**
     *
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
     *
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
     *
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
     *
     */
    @Test
    public void testObtenerPadre() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        Cabecera cabecera2 = new Cabecera(mensaje, nombreCabecera, valorCabecera);

        cabecera.establecerPadre(cabecera2);

        Assert.assertEquals(cabecera2, cabecera.obtenerPadre());

    }

    /**
     * Mismo fallo previsualización. "..."
     */
    @Test
    public void testTestObtenerRuta() {
        Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
        Assert.assertEquals(contenidoTexto,cabecera.obtenerRuta());



    }



}
