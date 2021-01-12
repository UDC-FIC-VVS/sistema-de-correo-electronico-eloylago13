package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class LogTest extends TestCase {

    private String nombre = "NombreArchivador";
    private int espacio= 100;

    Archivador decorado = new ArchivadorSimple(nombre, espacio);

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
    public void logSobreNull() {
        Log log = new Log(null);
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
        Log log = new Log(decorado);

        Assert.assertEquals(decorado.obtenerNombre(), log.obtenerNombre());
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
        Log log = new Log(decorado);

        assertTrue(log.almacenarCorreo(correo));
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
    public void testAlmacenarCorreoInvalido() {
        Log log = new Log(decorado);

        assertTrue(log.almacenarCorreo(null));
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
        Log log = new Log(decorado);

        Assert.assertEquals(100, log.obtenerEspacioTotal());

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
        Log log = new Log(decorado);

        log.almacenarCorreo(correo);

        Assert.assertEquals(100- correo.obtenerTamaño(), log.obtenerEspacioDisponible());
    }




}