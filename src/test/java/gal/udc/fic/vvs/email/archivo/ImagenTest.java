package gal.udc.fic.vvs.email.archivo;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ImagenTest extends TestCase {

    private String nombreImagen = "Imagen";
    private String contenido = "Imagen número uno";

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
        Imagen imagen = new Imagen(nombreImagen, contenido);
        String mimeType = imagen.obtenerMimeType();

        Assert.assertEquals("image/png", mimeType);
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
        Imagen imagen = new Imagen(nombreImagen, contenido);

        Assert.assertEquals(nombreImagen,imagen.obtenerNombre());
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
        Imagen imagen = new Imagen(nombreImagen, contenido);

        Assert.assertEquals(contenido, imagen.obtenerContenido());
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
        Imagen imagen = new Imagen(nombreImagen, contenido);


        Assert.assertEquals(contenido.length(), imagen.obtenerTamaño());
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
        Imagen imagen = new Imagen(nombreImagen, contenido);


        String previ = nombreImagen + "(" + contenido.length() + " bytes, " + "image/png" + ")";

        Assert.assertEquals(previ, imagen.obtenerPreVisualizacion());
    }


}