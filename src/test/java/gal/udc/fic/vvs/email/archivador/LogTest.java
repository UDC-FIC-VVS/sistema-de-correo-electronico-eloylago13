package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class LogTest extends TestCase {

    private String nombre = "NombreArchivador";
    private int espacio= 100;

    Archivador decorado = new ArchivadorSimple(nombre, espacio);

    Correo correo = new Mensaje(new Texto("nombre", "contenido"));

    @Test
    public void testObtenerNombre() {
        Log log = new Log(decorado);

        Assert.assertEquals(decorado.obtenerNombre(), log.obtenerNombre());
    }

    @Test
    public void testAlmacenarCorreo() {
        Log log = new Log(decorado);

        assertTrue(log.almacenarCorreo(correo));
    }

    @Test
    public void testObtenerEspacioTotal() {
        Log log = new Log(decorado);

        Assert.assertEquals(100, log.obtenerEspacioTotal());

    }

    @Test
    public void testObtenerEspacioDisponible() {
        Log log = new Log(decorado);

        log.almacenarCorreo(correo);

        Assert.assertEquals(100- correo.obtenerTamaño(), log.obtenerEspacioDisponible());
    }




}