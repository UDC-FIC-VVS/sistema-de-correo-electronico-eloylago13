package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class DelegadoTest extends TestCase {

    private String nombre = "NombreArchivador";
    private int espacio= 100;

    Archivador decorado = new ArchivadorSimple(nombre, espacio);

    Correo correo = new Mensaje(new Texto("nombre", "contenido"));


    @Test
    public void testObtenerNombre() {
        Delegado delegado = new Delegado(decorado);

        Assert.assertEquals(nombre, delegado.obtenerNombre());

    }

    @Test
    public void testAlmacenarCorreo() {
        Delegado delegado = new Delegado(decorado);

        assertTrue(delegado.almacenarCorreo(correo));
    }

    @Test
    public void testObtenerEspacioTotal() {
        Delegado delegado = new Delegado(decorado);

        Assert.assertEquals(espacio, delegado.obtenerEspacioTotal());

    }

    @Test
    public void testObtenerEspacioDisponible() {
        Delegado delegado = new Delegado(decorado);


        Assert.assertEquals(espacio, delegado.obtenerEspacioDisponible());


    }

    @Test
    public void testEstablecerYObtenerDelegado() {
        Delegado delegado = new Delegado(decorado);
        Archivador archvDel = new ArchivadorSimple("nombre", 100);
        delegado.establecerDelegado(archvDel);

        Assert.assertEquals(archvDel, delegado.obtenerDelegado() );

    }



}