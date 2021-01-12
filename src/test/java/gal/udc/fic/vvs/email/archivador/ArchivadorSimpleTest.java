package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertTrue;

public class ArchivadorSimpleTest{

    private String nombre = "NombreArchivador";
    private int espacio= 100;

    Correo correo = new Mensaje(new Texto("nombre", "contenido"));


    /**
     * Comprobación de que crear con nulo
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativo
     *      No deberíamos de poder crear con nombre nulo
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test (expected = OperacionInvalida.class)
    public void archivadorConNombreNull(){
        ArchivadorSimple arch = new ArchivadorSimple(null, espacio);

    }

    /**
     * Comprobación de crear con espacio inválido
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativo
     *      No deberíamos de poder crear con números negativos
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test (expected = OperacionInvalida.class)
    public void archivadorConEspacioInvalido(){
        ArchivadorSimple arch = new ArchivadorSimple(nombre, -10);

    }

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
    @Test
    public void testObtenerNombre() {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        Assert.assertEquals(nombre, arch.obtenerNombre());
    }

    /**
     * Comprobación de obtener nombre vacio
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerNombreVacio() {
        ArchivadorSimple arch = new ArchivadorSimple("", espacio);

        Assert.assertEquals("", arch.obtenerNombre());
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
    @Test
    public void testAlmacenarCorreo() {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        assertTrue(arch.almacenarCorreo(correo));
    }

    /**
     * Comprobación de almacenar correo invalido
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativa
     *      Debería de lanzar Operación inválida
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test (expected = OperacionInvalida.class)
    public void testAlmacenarCorreoNul() {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        assertTrue(arch.almacenarCorreo(null));
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
    @Test
    public void testObtenerEspacioTotal() {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        Assert.assertEquals(100, arch.obtenerEspacioTotal());

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
    @Test
    public void testObtenerEspacioDisponible() {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        arch.almacenarCorreo(correo);

        Assert.assertEquals(100- correo.obtenerTamaño(), arch.obtenerEspacioDisponible());
    }


    /**
     * Comprobación de obtener delegado devuelva null
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerDelegado() {
        ArchivadorSimple arch = new ArchivadorSimple(nombre, espacio);

        Assert.assertEquals(null, arch.obtenerDelegado());

    }
}