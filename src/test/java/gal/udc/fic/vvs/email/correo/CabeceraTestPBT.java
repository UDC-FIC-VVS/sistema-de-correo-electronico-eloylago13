package gal.udc.fic.vvs.email.correo;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Audio;
import generadorPBT.GeneradorAudioPBT;
import generadorPBT.GeneradorMensajePBT;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.Vector;

@RunWith(JUnitQuickcheck.class)
public class CabeceraTestPBT {
    /**
     *
     */
    @Property
    public void testObtenerTamañoCabecera(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);

        Assert.assertEquals(mensajeAleatorio.obtenerTamaño() + nombre.length() + valor.length(), cabecera.obtenerTamaño());

    }


    /**
     *
     */
    @Property
    public void testEstablecerLeidoYObtenerNoLeidos(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);

        cabecera.establecerLeido(true);
        Assert.assertEquals(0,cabecera.obtenerNoLeidos());

    }



    /**
     *
     */
    @Property
    public void testObtenerIcono(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);

        Assert.assertEquals(Correo.ICONO_NUEVO_MENSAJE, cabecera.obtenerIcono());


    }

    /**
     * Mismo problema. "..."
     */
    @Property
    public void testObtenerPreVisualizacion(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);

        Assert.assertEquals(mensajeAleatorio.obtenerPreVisualizacion() , cabecera.obtenerPreVisualizacion());


    }

    /**
     *
     */
    @Property
    public void testObtenerVisualizacion(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);

        Assert.assertEquals(nombre + ": " + valor + "\n" + mensajeAleatorio.obtenerVisualizacion(), cabecera.obtenerVisualizacion());

    }

    /**
     * Mismo razonamiento seguido. No debería de aplicar "..."
     */
    @Property
    public void testObtenerRuta(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio,String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);

        Assert.assertEquals(mensajeAleatorio.obtenerPreVisualizacion(), cabecera.obtenerRuta());

    }

    /**
     *
     */
    @Property
    public void testExplorar(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio,String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);


        Vector v = new Vector();
        try {
            Assert.assertEquals(v, cabecera.explorar());
        } catch (OperacionInvalida operacionInvalida) {
        }
    }

    /**
     *
     */
    @Property
    public void testBuscar(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio,String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);
        Vector v = new Vector();
        v.add(cabecera);

        Assert.assertEquals(v, cabecera.buscar(mensajeAleatorio.obtenerVisualizacion()));

    }




    /**
     *
     */
    @Property
    public void testObtenerHijoYEstablecerPadre(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);

        Cabecera cabecera2 = new Cabecera(mensajeAleatorio, nombre, valor);

        cabecera.establecerPadre(cabecera2);

        try {
            Assert.assertEquals(cabecera, cabecera2.obtenerHijo(1));
        } catch (OperacionInvalida operacionInvalida) {
        }


    }

    /**
     *
     */
    @Property
    public void testObtenerPadre(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);
        Cabecera cabecera2 = new Cabecera(mensajeAleatorio, nombre, valor);

        cabecera.establecerPadre(cabecera2);


        Assert.assertEquals(cabecera2, cabecera.obtenerPadre());

    }


}
