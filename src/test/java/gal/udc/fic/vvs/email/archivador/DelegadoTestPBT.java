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
public class DelegadoTestPBT {


    /**
     * Comprobación de obtener nombre
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Property
    public void testObtenerNombre(String nombre, @InRange(min="1") int espacio) {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        Delegado del = new Delegado(arch);

        Assert.assertEquals(nombre, del.obtenerNombre());
    }

    /**
     * Comprobación de almacenar correo válido
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Property
    public void testAlmacenarCorreo(String nombre, @InRange(min="1") int espacio, String nombreTexto, String contenidoTexto) {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        Delegado del = new Delegado(arch);


        Mensaje correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));

        assertTrue(del.almacenarCorreo(correo));

    }

    /**
     * Comprobación de espacio total válido
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Property
    public void testObtenerEspacioTotal(String nombre, @InRange(min="1") int espacio) {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        Delegado del = new Delegado(arch);


        Assert.assertEquals(espacio, del.obtenerEspacioTotal());

    }

    /**
     * Comprobación de espacio disponible válido
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Property
    public void testObtenerEspacioDisponible(String nombre, @InRange(min="1") int espacio, String nombreTexto, String contenidoTexto) {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        Delegado del = new Delegado(arch);


        Mensaje correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));

        del.almacenarCorreo(correo);

        Assert.assertEquals(espacio- correo.obtenerTamaño(), del.obtenerEspacioDisponible());
    }

}
