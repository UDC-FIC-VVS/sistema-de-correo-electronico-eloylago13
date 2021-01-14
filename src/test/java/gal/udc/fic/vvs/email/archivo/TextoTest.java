package gal.udc.fic.vvs.email.archivo;

import gal.udc.fic.vvs.email.correo.OperacionInvalida;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class TextoTest {

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
     * Comprobación de crear una texto null
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativa
     *      No deberíamos de poder crear sin contenido
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test (expected = OperacionInvalida.class)
    public void TextoSinContenido() {
        Texto texto = new Texto(nombreTexto, null);

    }

    /**
     * Comprobación de obtener nombre nulo
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativa
     *      No deberíamos de poder crear  sin nombre
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test (expected = OperacionInvalida.class)
    public void textoSinNombre() {
        Texto texto = new Texto(null, contenido);
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
     * Comprobación de obtener nombre vacio
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerNombreVacio() {
        Texto texto = new Texto("", contenido);

        Assert.assertEquals("", texto.obtenerNombre());
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
     * Comprobación de obtener contenido vacio
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerContenidoVacio() {
        Texto texto = new Texto(nombreTexto, "");

        Assert.assertEquals("", texto.obtenerContenido());
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
     * Comprobación de obtener tamaño vacio
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test
    public void testObtenerTamañoVacio() {
        Texto texto = new Texto(nombreTexto, "");


        Assert.assertEquals(0, texto.obtenerTamaño());
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