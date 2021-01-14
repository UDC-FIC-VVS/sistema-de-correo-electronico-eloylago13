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
     * Comprobación de que obtener tamaño devuelve correctamente el resultado.
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void testObtenerTamañoAdjunto(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);

        Assert.assertEquals(mensajeAleatorio.obtenerTamaño() + mensajeAleatorioReenvio.obtenerTamaño(), reenvio.obtenerTamaño());

    }


    /**
     * Comprobación de que establece como leido y no obtiene ningún no leído
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void testEstablecerLeidoYObtenerNoLeidos(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);

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
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void testObtenerIcono(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);

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
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void testObtenerPreVisualizacion(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);

        Assert.assertEquals(mensajeAleatorio.obtenerPreVisualizacion() , reenvio.obtenerPreVisualizacion());


    }

    /**
     * Comprobación de que obtiene la visualización esperada
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void testObtenerVisualizacion(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);

        Assert.assertEquals(mensajeAleatorio.obtenerVisualizacion()+"\n\n---- Correo reenviado ----\n\n"+ mensajeAleatorioReenvio.obtenerVisualizacion() + "\n---- Fin correo reenviado ----", reenvio.obtenerVisualizacion());

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
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void testObtenerRuta(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);

        Assert.assertEquals(mensajeAleatorio.obtenerPreVisualizacion(), reenvio.obtenerRuta());

    }

    /**
     * Comprobación de que obtienemos una excepción como se indica en el método
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: generados aleatoriamente
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
     * Comprobación de que obtiene el vector con el adjunto a partir del contenido del texto
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void testBuscar(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);
        Vector v = new Vector();
        v.add(reenvio);

        Assert.assertEquals(v, reenvio.buscar(mensajeAleatorio.obtenerVisualizacion()));

    }




    /**
     * Comprobación de que obtienemos el hijo esperado a partir del padre
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: generados aleatoriamente
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
     * Comprobación de que obtienemos el padre esperado a partir del hijo
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void testObtenerPadre(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, @From(GeneradorMensajePBT.class) Mensaje mensajeAleatorioReenvio) {
        Reenvio reenvio = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);
        Reenvio reenvio2 = new Reenvio(mensajeAleatorio, mensajeAleatorioReenvio);

        reenvio.establecerPadre(reenvio2);


        Assert.assertEquals(reenvio2, reenvio.obtenerPadre());

    }
}
