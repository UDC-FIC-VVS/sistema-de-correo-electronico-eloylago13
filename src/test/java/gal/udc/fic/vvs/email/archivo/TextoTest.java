package gal.udc.fic.vvs.email.archivo;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class TextoTest extends TestCase {

    private String nombreTexto = "Texto";
    private String contenido = "Texto número uno";

    /**
     * Comprobación de obtener mimeType
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerMimeImagenType() {
        Texto texto = new Texto(nombreTexto, contenido);
        String mimeType = texto.obtenerMimeType();

        Assert.assertEquals("text/plain", mimeType);
    }

    /**
     * Comprobación de obtener nombre
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerNombre() {
        Texto texto = new Texto(nombreTexto, contenido);

        Assert.assertEquals(nombreTexto, texto.obtenerNombre());
    }

    /**
     * Comprobación de obtener contenido
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerContenido() {
        Texto texto = new Texto(nombreTexto, contenido);

        Assert.assertEquals(contenido, texto.obtenerContenido());
    }

    /**
     * Comprobación de obtener tamaño
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerTamaño() {
        Texto texto = new Texto(nombreTexto, contenido);


        Assert.assertEquals(contenido.length(), texto.obtenerTamaño());
    }

    /**
     * Comprobación de obtener previsualización
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerPreVisualizacion() {
        Texto texto = new Texto(nombreTexto, contenido);


        String previ = nombreTexto + "(" + contenido.length() + " bytes, " + "text/plain" + ")";

        Assert.assertEquals(previ, texto.obtenerPreVisualizacion());
    }

}