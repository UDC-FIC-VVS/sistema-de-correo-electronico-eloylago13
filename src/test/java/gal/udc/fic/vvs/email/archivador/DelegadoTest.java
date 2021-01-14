package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DelegadoTest {

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
    public void delegadoSobreNull() {
        Delegado delegado = new Delegado(null);

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
        Delegado delegado = new Delegado(decorado);

        Assert.assertEquals(nombre, delegado.obtenerNombre());

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
        Delegado delegado = new Delegado(decorado);

        assertTrue(delegado.almacenarCorreo(correo));
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
        Delegado delegado = new Delegado(decorado);

        assertTrue(delegado.almacenarCorreo(null));
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
        Delegado delegado = new Delegado(decorado);

        Assert.assertEquals(espacio, delegado.obtenerEspacioTotal());

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
        Delegado delegado = new Delegado(decorado);


        Assert.assertEquals(espacio, delegado.obtenerEspacioDisponible());


    }

    /**
     * Comprobación de establecer delegado y obtenerlo correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testEstablecerYObtenerDelegado() {
        Delegado delegado = new Delegado(decorado);
        Archivador archvDel = new ArchivadorSimple("nombre", 100);
        delegado.establecerDelegado(archvDel);

        Assert.assertEquals(archvDel, delegado.obtenerDelegado() );

    }



}