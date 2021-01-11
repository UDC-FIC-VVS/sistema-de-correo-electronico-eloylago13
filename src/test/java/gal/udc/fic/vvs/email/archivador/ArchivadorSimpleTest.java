package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Vector;

public class ArchivadorSimpleTest extends TestCase {

    private String nombre = "NombreArchivador";
    private int espacio= 100;

    Correo correo = new Mensaje(new Texto("nombre", "contenido"));

    @Test
    public void testObtenerNombre() {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        Assert.assertEquals(nombre, arch.obtenerNombre());
    }

    @Test
    public void testAlmacenarCorreo() {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        assertTrue(arch.almacenarCorreo(correo));

    }

    @Test
    public void testObtenerEspacioTotal() {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        Assert.assertEquals(100, arch.obtenerEspacioTotal());

    }

    @Test
    public void testObtenerEspacioDisponible() {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        arch.almacenarCorreo(correo);

        Assert.assertEquals(100- correo.obtenerTamaño(), arch.obtenerEspacioDisponible());
    }

    /**
     * COMO SE PRUEBA ESTO SIN OBTENER DELEGADO?
     */
    @Test
    public void testEstablecerDelegado() {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);
    }

    @Test
    public void testObtenerDelegado() {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        Assert.assertEquals(null, arch.obtenerDelegado());

    }
}