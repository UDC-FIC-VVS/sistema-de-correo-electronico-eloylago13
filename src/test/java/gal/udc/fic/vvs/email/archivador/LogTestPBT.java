package gal.udc.fic.vvs.email.archivador;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class)
public class LogTestPBT {

    @Property
    public void testObtenerNombre(String nombre, @InRange(min="1") int espacio) {

        Archivador decorado = new ArchivadorSimple(nombre, espacio);
        Log log = new Log(decorado);

        Assert.assertEquals(decorado.obtenerNombre(), log.obtenerNombre());
    }

    @Property
    public void testAlmacenarCorreo(String nombre, @InRange(min="1") int espacio, String nombreTexto, String contenidoTexto) {
        Archivador decorado = new ArchivadorSimple(nombre, espacio);
        Log log = new Log(decorado);
        Mensaje correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));

        assertTrue(log.almacenarCorreo(correo));
    }

    @Property
    public void testObtenerEspacioTotal(String nombre, @InRange(min="1") int espacio) {
        Archivador decorado = new ArchivadorSimple(nombre, espacio);
        Log log = new Log(decorado);

        Assert.assertEquals(espacio, log.obtenerEspacioTotal());

    }

    @Property
    public void testObtenerEspacioDisponible(String nombre, @InRange(min="1") int espacio, String nombreTexto, String contenidoTexto) {
        Archivador decorado = new ArchivadorSimple(nombre, espacio);
        Log log = new Log(decorado);
        Mensaje correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));
        log.almacenarCorreo(correo);

        Assert.assertEquals(espacio- correo.obtenerTamaño(), log.obtenerEspacioDisponible());
    }


}
