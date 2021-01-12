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
     * Comprobación de que obtener tamaño devuelve correctamente el resultado.
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void testObtenerTamañoCabecera(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);

        Assert.assertEquals(mensajeAleatorio.obtenerTamaño() + nombre.length() + valor.length(), cabecera.obtenerTamaño());

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
    public void testEstablecerLeidoYObtenerNoLeidos(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);

        cabecera.establecerLeido(true);
        Assert.assertEquals(0,cabecera.obtenerNoLeidos());

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
    public void testObtenerIcono(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);

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
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void testObtenerPreVisualizacion(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);

        Assert.assertEquals(mensajeAleatorio.obtenerPreVisualizacion() , cabecera.obtenerPreVisualizacion());


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
    public void testObtenerVisualizacion(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);

        Assert.assertEquals(nombre + ": " + valor + "\n" + mensajeAleatorio.obtenerVisualizacion(), cabecera.obtenerVisualizacion());

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
    public void testObtenerRuta(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio,String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);

        Assert.assertEquals(mensajeAleatorio.obtenerPreVisualizacion(), cabecera.obtenerRuta());

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
    public void testExplorar(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio,String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);


        Vector v = new Vector();
        try {
            Assert.assertEquals(v, cabecera.explorar());
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
    public void testBuscar(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio,String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);
        Vector v = new Vector();
        v.add(cabecera);

        Assert.assertEquals(v, cabecera.buscar(mensajeAleatorio.obtenerVisualizacion()));

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
     * Comprobación de que obtienemos el padre esperado a partir del hijo
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void testObtenerPadre(@From(GeneradorMensajePBT.class) Mensaje mensajeAleatorio, String nombre, String valor) {
        Cabecera cabecera = new Cabecera(mensajeAleatorio, nombre, valor);
        Cabecera cabecera2 = new Cabecera(mensajeAleatorio, nombre, valor);

        cabecera.establecerPadre(cabecera2);


        Assert.assertEquals(cabecera2, cabecera.obtenerPadre());

    }


}
