package gal.udc.fic.vvs.email.archivo;

import gal.udc.fic.vvs.email.correo.OperacionInvalida;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ImagenTest{

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
     * Comprobación de crear una imagen sin contenido
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativa
     *      No deberíamos de poder crear sin contenido
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test (expected = OperacionInvalida.class)
    public void imagenSinContenido() {
        Imagen imagen = new Imagen(nombreImagen, null);

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
    public void imagenSinNombre() {
        Imagen imagen = new Imagen(null, contenido);
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
        Imagen imagen = new Imagen(nombreImagen, "");

        Assert.assertEquals("", imagen.obtenerContenido());
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
    public void testObtenerTamañoVacio() {
        Imagen imagen = new Imagen(nombreImagen, "");


        Assert.assertEquals(0, imagen.obtenerTamaño());
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