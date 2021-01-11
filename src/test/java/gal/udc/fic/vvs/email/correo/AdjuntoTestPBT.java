package gal.udc.fic.vvs.email.correo;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Texto;
import generadorPBT.*;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.Vector;

@RunWith(JUnitQuickcheck.class)
public class AdjuntoTestPBT {
    /**
     *
     */
    @Property
    public void testObtenerTamañoAdjunto(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorAudioPBT.class) Audio audioAleatorio) {
        Adjunto adjunto = new Adjunto(mensajeAleatorio, audioAleatorio);

        Assert.assertEquals((mensajeAleatorio.obtenerTamaño()+audioAleatorio.obtenerTamaño()), adjunto.obtenerTamaño());

    }


    /**
     *
     */
    @Property
    public void testEstablecerLeidoYObtenerNoLeidos(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorAudioPBT.class) Audio audioAleatorio) {
        Adjunto adjunto = new Adjunto(mensajeAleatorio, audioAleatorio);

        adjunto.establecerLeido(true);
        Assert.assertEquals(0,adjunto.obtenerNoLeidos());

    }



    /**
     *
     */
    @Property
    public void testObtenerIcono(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorAudioPBT.class) Audio audioAleatorio) {
        Adjunto adjunto = new Adjunto(mensajeAleatorio, audioAleatorio);

        Assert.assertEquals(Correo.ICONO_NUEVO_MENSAJE, adjunto.obtenerIcono());


    }

    /**
     * Mismo problema. "..."
     */
    @Property
    public void testObtenerPreVisualizacion(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorAudioPBT.class) Audio audioAleatorio) {
        Adjunto adjunto = new Adjunto(mensajeAleatorio, audioAleatorio);

        Assert.assertEquals(mensajeAleatorio.obtenerPreVisualizacion() , adjunto.obtenerPreVisualizacion());


    }

    /**
     *
     */
    @Property
    public void testObtenerVisualizacion(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorAudioPBT.class) Audio audioAleatorio) {
        Adjunto adjunto = new Adjunto(mensajeAleatorio, audioAleatorio);

        Assert.assertEquals(mensajeAleatorio.obtenerVisualizacion() + "\n\nAdxunto: " + audioAleatorio.obtenerPreVisualizacion(), adjunto.obtenerVisualizacion());

    }

    /**
     * Mismo razonamiento seguido. No debería de aplicar "..."
     */
    @Property
    public void testObtenerRuta(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorAudioPBT.class) Audio audioAleatorio) {
        Adjunto adjunto = new Adjunto(mensajeAleatorio, audioAleatorio);

        Assert.assertEquals(mensajeAleatorio.obtenerPreVisualizacion(), adjunto.obtenerRuta());

    }

    /**
     *
     */
    @Property
    public void testExplorar(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorAudioPBT.class) Audio audioAleatorio) {
        Adjunto adjunto = new Adjunto(mensajeAleatorio, audioAleatorio);


        Vector v = new Vector();
        try {
            Assert.assertEquals(v, adjunto.explorar());
        } catch (OperacionInvalida operacionInvalida) {
        }
    }

    /**
     *
     */
    @Property
    public void testBuscar(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorAudioPBT.class) Audio audioAleatorio) {
        Adjunto adjunto = new Adjunto(mensajeAleatorio, audioAleatorio);
        Vector v = new Vector();
        v.add(adjunto);

        Assert.assertEquals(v, adjunto.buscar(mensajeAleatorio.obtenerVisualizacion()));

    }




    /**
     *
     */
    @Property
    public void testObtenerHijoYEstablecerPadre(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorAudioPBT.class) Audio audioAleatorio) {
        Adjunto adjunto = new Adjunto(mensajeAleatorio, audioAleatorio);

        Adjunto adjunto2 = new Adjunto(mensajeAleatorio, audioAleatorio);

        adjunto.establecerPadre(adjunto2);

        try {
            Assert.assertEquals(adjunto, adjunto2.obtenerHijo(1));
        } catch (OperacionInvalida operacionInvalida) {
        }


    }

    /**
     *
     */
    @Property
    public void testObtenerPadre(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorAudioPBT.class) Audio audioAleatorio) {
        Adjunto adjunto = new Adjunto(mensajeAleatorio, audioAleatorio);
        Adjunto adjunto2 = new Adjunto(mensajeAleatorio, audioAleatorio);

        adjunto.establecerPadre(adjunto2);


        Assert.assertEquals(adjunto2, adjunto.obtenerPadre());

    }



}
