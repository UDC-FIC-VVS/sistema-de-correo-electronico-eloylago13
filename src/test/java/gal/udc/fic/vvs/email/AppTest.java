package gal.udc.fic.vvs.email;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import gal.udc.fic.vvs.email.archivador.Archivador;
import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Imagen;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Vector;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    /*****************************************************************/

    /** TESTS PARA ARVHIVADOR**/

    @Test
    public void obtenerNombreArchivadorTest()
    {
        //Creamos un archivador
        ArchivadorSimple arch = new ArchivadorSimple("Nombre", 200);

        //Obtenemos su nombre con el método correspondiente
        String nombre = arch.obtenerNombre();

        //Comparamos que el nombre corresponde al deseado
        Assert.assertEquals("Nombre", nombre );
    }

    @Test
    public void obtenerNombreArchivadorNuloTest()
    {
        //Creamos un archivador
        ArchivadorSimple arch = new ArchivadorSimple(null, 200);

        //Obtenemos su nombre con el método correspondiente
        String nombre = arch.obtenerNombre();

        //Comparamos que el nombre corresponde al deseado
        Assert.assertEquals(null, nombre );
    }

/*
    @Test
    public void almacenarCorreoTest()
    {
        //Creamos un archivador
        ArchivadorSimple arch = new ArchivadorSimple(null, 200);

        CorreoAbstracto correo = new CorreoAbstracto();

    }*/

    @Test
    public void obtenerEspacioTotalTest()
    {
        //Creamos un archivador
        ArchivadorSimple arch = new ArchivadorSimple(null, 200);

        //Obtenemos su nombre con el método correspondiente
        int espacioTotal = arch.obtenerEspacioTotal();

        //Comparamos que el nombre corresponde al deseado
        Assert.assertEquals(200, espacioTotal);

    }
    @Test
    public void obtenerEspacioDisponibleTest()
    {
        //Creamos un archivador
        ArchivadorSimple arch = new ArchivadorSimple(null, 200);

        //Obtenemos su nombre con el método correspondiente
        int espacioDisponible = arch.obtenerEspacioDisponible();

        //Comparamos que el nombre corresponde al deseado
        Assert.assertEquals(200, espacioDisponible);
    }

    @Test
    public void obtenerDelegadoTest()
    {
        //Creamos un archivador
        ArchivadorSimple arch = new ArchivadorSimple(null, 200);

        //Obtenemos el delegado que debería de ser inicialmente null
        Archivador delegado = arch.obtenerDelegado();

        //Comprobamos que lo es
        Assert.assertEquals(null, delegado);
    }

    @Test
    public void establecerDelegadoTest()
    {

    }

    @Test
    public void Test()
    {

    }





    /*****************************************************************/

    /** TESTS PARA ARCHIVO**/

    /**
     *
     */
    @Test
    public void obtenerNombreArchivoTest(){
        String contenido = "contenido";
        String nombre = "nombre";

        Texto arch = new Texto(nombre, contenido);

        Assert.assertEquals(nombre, arch.obtenerNombre());

    }

    /**
     *
     */
    @Test
    public void obtenerContenidoArchivoTest(){
        String contenido = "contenido";
        String nombre = "nombre";

        Texto arch = new Texto(nombre, contenido);

        Assert.assertEquals(contenido, arch.obtenerContenido());

    }

    /**
     *
     */
    @Test
    public void obtenerTamañoArchivoTest(){
        String contenido = "contenido";
        int length = contenido.length();
        String nombre = "nombre";

        Texto arch = new Texto(nombre, contenido);

        Assert.assertEquals(length, arch.obtenerTamaño());

    }

    /**
     *
     */
    @Test
    public void obtenerPrevisualizacionArchivoTest(){
        String contenido = "contenido";
        String nombre = "nombre";
        Texto arch = new Texto(nombre, contenido);

        String previ = nombre + "(" + contenido.length() + " bytes, " + "text/plain" + ")";

        Assert.assertEquals(previ, arch.obtenerPreVisualizacion());

    }


    /***************************************************************/

    /** TESTS PARA CLIENTE**/






    /***************************************************************/


    /** TESTS PARA CORREO**/

    /** Comprobación de marcar como leído un mensaje.
     *  Creamos un texto y se lo añadimos a un mensaje.
     *  Ese mensaje inicialmente está como no leído. Lo comprobamos y luego lo marcamos como leído.
     *  Por último comprobamo que no queda ningún mensaje como leído.
     */
    @Test
    public void establecerLeidoMensajeTest()
    {
        Texto nuevoTexto = new Texto("Contenido", "Texto de contenido");
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Assert.assertEquals(1, mensaje.obtenerNoLeidos());

        mensaje.establecerLeido(true);
        //System.out.println(null == mensaje.obtenerIcono()? "No tiene":"Tiene");

        Assert.assertEquals(0, mensaje.obtenerNoLeidos());
    }

    /** Comprobación de icono según el estado de leído de un mensaje.
     *  Primero creamos un mensaje que por defecto no estará leído, y comprobamos que el icono es el que le corresponde.
     *  Después lo marcamos como leído y luego vemos que el icono es el de leído.
     */
    @Test
    public void obtenerIconoEsperadoTest()
    {
        Texto nuevoTexto = new Texto("Contenido", "Texto de contenido");
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
    public void obtenerPreVisualizacionMensajeTest()
    {
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
    public void obtenerVisualizacionMensajeTest()
    {
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
     *
     */
    @Test
    public void buscarMensajeTest()
    {
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
        //Habría que corregir el código. Debería de dar un vector vacio. El código acepta una búsqueda con cadena vacía.
        Assert.assertEquals(0,((Vector)mensaje.buscar(cadenaBusqueda3)).size());

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
     *
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

    /**
     * FUNCIONAMIENTO INCORRECTO. NO SE DEBERÍA DE PODER HACER UN RENVÍO DE UN NULO.
     */
    @Test (expected = OperacionInvalida.class)
    public void mensajeReenvioSobreNull(){

        String textoPrimero = "Hola";
        Texto nuevoTextoPrimero = new Texto("ContenidoPrimero", textoPrimero);
        Mensaje mensajePrimero = new Mensaje(nuevoTextoPrimero);


        String textoSegundo = "Adiós";
        Texto nuevoTextoSegundo = new Texto("ContenidoSegundo", textoSegundo);
        Mensaje mensajeSegundo = new Mensaje(nuevoTextoSegundo);

        Reenvio reenvio = new Reenvio(mensajePrimero, null);

    }

    /**
     * FUNCIONAMIENTO INCORRECTO. NO SE DEBERÍA DE PODER HACER UN ADJUNTO SOBRE UN MENSAJE NULO.
     */
    @Test (expected = Exception.class)
    public void decoradorSobreNulo(){

        String textoPrimero = "Hola";
        Texto nuevoTextoPrimero = new Texto("ContenidoPrimero", textoPrimero);
        Mensaje mensajePrimero = new Mensaje(nuevoTextoPrimero);

        Imagen imagen = new Imagen("Paisaje", "muchosBytes");

        Adjunto adjunto = new Adjunto(null, imagen);

    }

    /**
     * FUNCIONAMIENTO CORRECTO.
     */
    @Test
    public void decoradorMensajeLongitud(){

        String textoPrimero = "Hola";
        Texto nuevoTextoPrimero = new Texto("ContenidoPrimero", textoPrimero);
        Mensaje mensajePrimero = new Mensaje(nuevoTextoPrimero);

        Imagen imagen = new Imagen("Paisaje", "muchosBytes");

        Adjunto adjunto = new Adjunto(mensajePrimero, imagen);

        Assert.assertEquals("muchosBytes".length() + mensajePrimero.obtenerTamaño(), adjunto.obtenerTamaño());

    }

    /**
     * FUNCIONAMIENTO CORRECTO.
     */
    @Test
    public void decoradorMensajeExplorar()  {

        String textoPrimero = "Hola";
        Texto nuevoTextoPrimero = new Texto("ContenidoPrimero", textoPrimero);
        Mensaje mensajePrimero = new Mensaje(nuevoTextoPrimero);

        Imagen imagen = new Imagen("Paisaje", "muchosBytes");

        Adjunto adjunto = new Adjunto(mensajePrimero, imagen);

        try {
            adjunto.explorar();
            fail();
        } catch (OperacionInvalida operacionInvalida) {
            operacionInvalida.printStackTrace();
        }
    }

    //probar con cabecera nula. Una cabecera no podria contener








    /***************************************************************/









}
