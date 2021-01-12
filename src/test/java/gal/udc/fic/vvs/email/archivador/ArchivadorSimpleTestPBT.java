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
public class ArchivadorSimpleTestPBT {

    @Property
    public void testObtenerNombre(String nombre, @InRange(min="1") int espacio) {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        Assert.assertEquals(nombre, arch.obtenerNombre());
    }

    @Property
    public void testAlmacenarCorreo(String nombre, @InRange(min="1") int espacio, String nombreTexto, String contenidoTexto) {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        Mensaje correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));

        assertTrue(arch.almacenarCorreo(correo));

    }

    @Property
    public void testObtenerEspacioTotal(String nombre, @InRange(min="1") int espacio) {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        Assert.assertEquals(espacio, arch.obtenerEspacioTotal());

    }

    @Property
    public void testObtenerEspacioDisponible(String nombre, @InRange(min="1") int espacio, String nombreTexto, String contenidoTexto) {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        Mensaje correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));

        arch.almacenarCorreo(correo);

        Assert.assertEquals(espacio- correo.obtenerTamaño(), arch.obtenerEspacioDisponible());
    }



}
