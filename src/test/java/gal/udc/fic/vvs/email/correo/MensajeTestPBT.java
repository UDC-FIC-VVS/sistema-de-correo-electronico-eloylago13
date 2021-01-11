package gal.udc.fic.vvs.email.correo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Vector;

@RunWith(JUnitQuickcheck.class)
public class MensajeTestPBT {

    /** Comprobación de marcar como leído un mensaje.
     *  Creamos un texto y se lo añadimos a un mensaje.
     *  Ese mensaje inicialmente está como no leído. Lo comprobamos y luego lo marcamos como leído.
     *  Por último comprobamo que no queda ningún mensaje como leído.
     */
    @Property
    public void testEstablecerLeidoMensaje(String nombre, String contenido) {
        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Assert.assertEquals(1, mensaje.obtenerNoLeidos());

        mensaje.establecerLeido(true);
        //System.out.println(null == mensaje.obtenerIcono()? "No tiene":"Tiene");

        Assert.assertEquals(0, mensaje.obtenerNoLeidos());


    }

    /** Comprobación de marcar como no leído un mensaje.
     *  Creamos un texto y se lo añadimos a un mensaje.
     *  Ese mensaje inicialmente está como no leído. Lo comprobamos y luego lo marcamos como leído. A continuación, volvemos a desmarcarlo
     *  Por último comprobamo que queda un mensaje como no leído.
     */
    @Property
    public void testEstablecerYObtenerNoLeidoMensaje(String nombre, String contenido) {

        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Assert.assertEquals(1, mensaje.obtenerNoLeidos());

        mensaje.establecerLeido(true);

        mensaje.establecerLeido(false);

        Assert.assertEquals(1, mensaje.obtenerNoLeidos());
    }



    /** Comprobación de icono según el estado de leído de un mensaje.
     *  Primero creamos un mensaje que por defecto no estará leído, y comprobamos que el icono es el que le corresponde.
     *  Después lo marcamos como leído y luego vemos que el icono es el de leído.
     */
    @Property
    public void testObtenerIconoMensaje(String nombre, String contenido) {
        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Assert.assertEquals(Correo.ICONO_NUEVO_MENSAJE, mensaje.obtenerIcono());

        mensaje.establecerLeido(true);

        Assert.assertEquals(Correo.ICONO_MENSAJE, mensaje.obtenerIcono());
    }


    /** Test que comprueba que trunca los mensajes mayores a una constante y no trunca los que son menores.
     * Creamos dos mensajes, uno largo y otro pequeño y comprobamos como devuelve la previsualización de ambos.
     * El mensaje corto debería de aparecer sin "..." ya que muestra el mensaje completo.
     * (No se cómo comprobar usando valores aleatorios que si la longitud es menor a la indicada no debería de devolver ...
     */
    @Property
    public void testTestObtenerPreVisualizacionMensaje(String nombre, String contenido) {


        Texto texto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(texto);

    }

    /**
     *
     */
    @Property
    public void testTestObtenerVisualizacionMensaje(String nombre, String contenido) {

        Texto texto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(texto);

        Assert.assertEquals(contenido, mensaje.obtenerVisualizacion());
    }




    /**
     * Funciona correctamente aunque debería de prescindir de los "...". Corregir previsualización
     */
    @Property
    public void testObtenerRutaMensaje(String nombre, String contenido) {
        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Mensaje mensaje2 = new Mensaje(nuevoTexto);
        mensaje.establecerPadre(mensaje2);

        //Como no tiene padre, debería de devolver la previsualización del contenido.
        Assert.assertEquals(mensaje.obtenerPreVisualizacion()+" > "+mensaje2.obtenerPreVisualizacion(),mensaje.obtenerRuta());
    }



    /**
     *
     */
    @Property
    public void testObtenerHijoMensaje(String nombre, String contenido) {
        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre+2, contenido+2);
        Mensaje mensaje2 = new Mensaje(nuevoTexto);

        mensaje2.establecerPadre(mensaje);

        try {
            Assert.assertEquals(mensaje2,mensaje.obtenerHijo(1));
        } catch (OperacionInvalida operacionInvalida) {

        }
    }

    /**
     *
     */
    @Property
    public void testEstablecerYObtenerPadreMensaje(String nombre, String contenido) {
        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre+2, contenido+2);
        Mensaje mensaje2 = new Mensaje(nuevoTexto);

        mensaje2.establecerPadre(mensaje);


        Assert.assertEquals(mensaje, mensaje2.obtenerPadre());

    }
}
