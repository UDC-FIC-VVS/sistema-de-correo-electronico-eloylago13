package gal.udc.fic.vvs.email.archivo;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ImagenTest extends TestCase {

    private String nombreImagen = "Imagen";
    private String contenido = "Imagen número uno";

    /**
     * Obtener mimeType de imagen.
     */
    @Test
    public void testObtenerMimeImagenType() {
        Imagen imagen = new Imagen(nombreImagen, contenido);
        String mimeType = imagen.obtenerMimeType();

        Assert.assertEquals("image/png", mimeType);
    }

    /**
     * Obtener nombre del archivo imagen.
     */
    @Test
    public void testObtenerNombre() {
        Imagen imagen = new Imagen(nombreImagen, contenido);

        Assert.assertEquals(nombreImagen,imagen.obtenerNombre());
    }

    /**
     *Obtener contenido del archivo imagen.
     */
    @Test
    public void testObtenerContenido() {
        Imagen imagen = new Imagen(nombreImagen, contenido);

        Assert.assertEquals(contenido, imagen.obtenerContenido());
    }

    /**
     *Obtener tamaño del archivo imagen.
     */
    @Test
    public void testObtenerTamaño() {
        Imagen imagen = new Imagen(nombreImagen, contenido);


        Assert.assertEquals(contenido.length(), imagen.obtenerTamaño());
    }

    /**
     *Obtener previsualización del archivo imagen.
     */
    @Test
    public void testObtenerPreVisualizacion() {
        Imagen imagen = new Imagen(nombreImagen, contenido);


        String previ = nombreImagen + "(" + contenido.length() + " bytes, " + "image/png" + ")";

        Assert.assertEquals(previ, imagen.obtenerPreVisualizacion());
    }


}