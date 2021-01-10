package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Texto;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Vector;

public class MensajeTest extends TestCase {

    private String nombre = "Contenido";
    private String contenido = "Texto de contenido";


    /** Comprobación de marcar como leído un mensaje.
     *  Creamos un texto y se lo añadimos a un mensaje.
     *  Ese mensaje inicialmente está como no leído. Lo comprobamos y luego lo marcamos como leído.
     *  Por último comprobamo que no queda ningún mensaje como leído.
     */
    @Test
    public void testEstablecerLeidoMensaje() {

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
    @Test
    public void testEstablecerNoLeidoMensaje() {

        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Assert.assertEquals(1, mensaje.obtenerNoLeidos());

        mensaje.establecerLeido(true);

        mensaje.establecerLeido(false);

        Assert.assertEquals(1, mensaje.obtenerNoLeidos());
    }

    /**
     * CON TEXTO NULO NO PASA TEST. DEBERÍA DE DEVOLVER CADENA VACÍA.
     */
    @Test
    public void mensajeTextoNulo() {

        String textoVacio = null;
        String textoCortoEsperado = "";
        Texto nuevoTextoVacio = new Texto("ContenidoVacio", textoVacio);
        Mensaje mensajeVacio = new Mensaje(nuevoTextoVacio);

        Assert.assertEquals(textoCortoEsperado, mensajeVacio.obtenerVisualizacion());
        Assert.assertEquals(0, mensajeVacio.obtenerTamaño());

    }

    /**
     * Comprobamos que devuelve 0.
     */
    @Test
    public void mensajeSinTexto() {
        String textoVacio = "";
        String textoEsperado = "";
        Texto nuevoTextoVacio = new Texto("ContenidoVacio", textoVacio);
        Mensaje mensajeVacio = new Mensaje(nuevoTextoVacio);

        Assert.assertEquals(textoEsperado, mensajeVacio.obtenerVisualizacion());
        Assert.assertEquals(0, mensajeVacio.obtenerTamaño());
    }

   

    /** Comprobación de icono según el estado de leído de un mensaje.
     *  Primero creamos un mensaje que por defecto no estará leído, y comprobamos que el icono es el que le corresponde.
     *  Después lo marcamos como leído y luego vemos que el icono es el de leído.
     */
    @Test
    public void testObtenerIconoTest() {
        Texto nuevoTexto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Assert.assertEquals(Correo.ICONO_NUEVO_MENSAJE, mensaje.obtenerIcono());

        mensaje.establecerLeido(true);

        Assert.assertEquals(Correo.ICONO_MENSAJE, mensaje.obtenerIcono());
    }

    /** Test que comprueba que trunca los mensajes mayores a una constante y no trunca los que son menores.
     * Creamos dos mensajes, uno largo y otro pequeño y comprobamos como devuelve la previsualización de ambos.
     * El mensaje corto debería de aparecer sin "..." ya que muestra el mensaje completo.
     */
    @Test
    public void testObtenerPreVisualizacion() {
        String textoCorto = "Texto pequeño";
        //Aquí deberíamos de retocar el código para que si no lo trunca no ponga los ... Dará fallo porque no debe de aparecer eso.
        String textoCortoEsperado = textoCorto;
        String textoLargo = "Texto mucho más largo para probar que trunca con los tres puntos el texto en la previsualización";
        String textoLargoEsperado = textoLargo.substring(0,32)+"...";
        Texto nuevoTextoCorto = new Texto("Contenido1", textoCorto);
        Mensaje mensajeCorto = new Mensaje(nuevoTextoCorto);

        Texto nuevoTextoLargo = new Texto("Contenido2", textoLargo);
        Mensaje mensajeLargo = new Mensaje(nuevoTextoLargo);

        Assert.assertEquals(textoCortoEsperado, mensajeCorto.obtenerPreVisualizacion());
        Assert.assertEquals(textoLargoEsperado, mensajeLargo.obtenerPreVisualizacion());
    }

    /**
     *
     */
    @Test
    public void testObtenerVisualizacion() {
        String textoCorto = "Texto pequeño";
        String textoCortoEsperado = textoCorto;
        String textoLargo = "Texto mucho más largo para probar que trunca con los tres puntos el texto en la previsualización";
        String textoLargoEsperado = textoLargo;
        Texto nuevoTextoCorto = new Texto("Contenido1", textoCorto);
        Mensaje mensajeCorto = new Mensaje(nuevoTextoCorto);

        Texto nuevoTextoLargo = new Texto("Contenido2", textoLargo);
        Mensaje mensajeLargo = new Mensaje(nuevoTextoLargo);

        Assert.assertEquals(textoCortoEsperado, mensajeCorto.obtenerVisualizacion());
        Assert.assertEquals(textoLargoEsperado, mensajeLargo.obtenerVisualizacion());
    }

    /**
     * Habría que corregir el código. Debería de dar un vector vacio. El código acepta una búsqueda con cadena vacía.
     */
    @Test
    public void testBuscar() {
        Vector<Mensaje> coleccion = new Vector<Mensaje>();

        String contenido = "Texto de contenido";
        String cadenaBusquedaComienzaCon = contenido.substring(0,4);
        String cadenaBusquedaAcabaCon = contenido.substring(10, contenido.length());
        String cadenaBusquedaContiene = contenido.substring(4, 10);

        String cadenaBusqueda2 = "No tiene nada que ver";
        String cadenaBusqueda3 = "";
        String cadenaBusqueda4 = null;
        Texto nuevoTexto = new Texto("Contenido",contenido);
        Mensaje mensaje = new Mensaje(nuevoTexto);
        coleccion.add(mensaje);

        Assert.assertEquals(coleccion.get(0), ((Vector)mensaje.buscar(cadenaBusquedaComienzaCon)).get(0));
        Assert.assertEquals(coleccion.get(0), ((Vector)mensaje.buscar(cadenaBusquedaAcabaCon)).get(0));
        Assert.assertEquals(coleccion.get(0), ((Vector)mensaje.buscar(cadenaBusquedaContiene)).get(0));
        Assert.assertEquals(0,((Vector)mensaje.buscar(cadenaBusqueda2)).size());

        Assert.assertEquals(0,((Vector)mensaje.buscar(cadenaBusqueda3)).size());
    }




}