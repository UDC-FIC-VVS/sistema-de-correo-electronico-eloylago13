package gal.udc.fic.vvs.email;

import static org.junit.Assert.assertTrue;

import gal.udc.fic.vvs.email.archivador.Archivador;
import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.correo.CorreoAbstracto;
import org.junit.Assert;
import org.junit.Test;

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

    @Test
    public void obtenerNombreArchivoTest()
    {

    }

    @Test
    public void obtenerContenidoTest()
    {

    }

    @Test
    public void obtenerPreVisualizacionTest()
    {

    }

    @Test
    public void obtenerMimeTypeTest()
    {

    }

    @Test
    public void obtenerMimeTypeAudioTest()
    {

    }

    @Test
    public void obtenerMimeTypeImagenTest()
    {

    }

    @Test
    public void obtenerMimeTypeTextoTest()
    {

    }






    /***************************************************************/

    /** TESTS PARA CLIENTE**/






    /***************************************************************/


    /** TESTS PARA CORREO**/










    /***************************************************************/









}
