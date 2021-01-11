package gal.udc.fic.vvs.email.correo;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import generadorPBT.GeneradorMensajePBT;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.Vector;

@RunWith(JUnitQuickcheck.class)
public class ReenvioTestPBT {
    /**
     *
     */
    @Property
    public void testObtenerTamañoAdjunto(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);

        Assert.assertEquals(mensajeAleatorio.obtenerTamaño() + mensajeAleatorioReenvio.obtenerTamaño(), reenvio.obtenerTamaño());

    }


    /**
     *
     */
    @Property
    public void testEstablecerLeidoYObtenerNoLeidos(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);

        reenvio.establecerLeido(true);
        Assert.assertEquals(0,reenvio.obtenerNoLeidos());

    }



    /**
     *
     */
    @Property
    public void testObtenerIcono(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);

        Assert.assertEquals(Correo.ICONO_NUEVO_MENSAJE, reenvio.obtenerIcono());


    }

    /**
     * Mismo problema. "..."
     */
    @Property
    public void testObtenerPreVisualizacion(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);

        Assert.assertEquals(mensajeAleatorio.obtenerPreVisualizacion() , reenvio.obtenerPreVisualizacion());


    }

    /**
     *
     */
    @Property
    public void testObtenerVisualizacion(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);

        Assert.assertEquals(mensajeAleatorio.obtenerVisualizacion()+"\n\n---- Correo reenviado ----\n\n"+ mensajeAleatorioReenvio.obtenerVisualizacion() + "\n---- Fin correo reenviado ----", reenvio.obtenerVisualizacion());

    }

    /**
     * Mismo razonamiento seguido. No debería de aplicar "..."
     */
    @Property
    public void testObtenerRuta(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);

        Assert.assertEquals(mensajeAleatorio.obtenerPreVisualizacion(), reenvio.obtenerRuta());

    }

    /**
     *
     */
    @Property
    public void testExplorar(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);


        Vector v = new Vector();
        try {
            Assert.assertEquals(v, reenvio.explorar());
        } catch (OperacionInvalida operacionInvalida) {
        }
    }

    /**
     *
     */
    @Property
    public void testBuscar(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);
        Vector v = new Vector();
        v.add(reenvio);

        Assert.assertEquals(v, reenvio.buscar(mensajeAleatorio.obtenerVisualizacion()));

    }




    /**
     *
     */
    @Property
    public void testObtenerHijoYEstablecerPadre(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);

        Reenvio reenvio2 = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);

        reenvio.establecerPadre(reenvio2);

        try {
            Assert.assertEquals(reenvio, reenvio2.obtenerHijo(1));
        } catch (OperacionInvalida operacionInvalida) {
        }


    }

    /**
     *
     */
    @Property
    public void testObtenerPadre(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);
        Reenvio reenvio2 = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);

        reenvio.establecerPadre(reenvio2);


        Assert.assertEquals(reenvio2, reenvio.obtenerPadre());

    }
}
