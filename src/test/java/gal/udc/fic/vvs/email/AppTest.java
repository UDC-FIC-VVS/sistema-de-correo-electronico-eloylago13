package gal.udc.fic.vvs.email;

import static org.junit.Assert.assertTrue;

import gal.udc.fic.vvs.email.archivador.Archivador;
import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.CorreoAbstracto;
import gal.udc.fic.vvs.email.correo.Mensaje;
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



    /***************************************************************/









}
