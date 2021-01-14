package gal.udc.fic.vvs.email.archivo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Assert;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class ImagenTestPBT {

    /**
     * Comprobación de obtener mimeType
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void obtenerMimeTypeImagen(String aleatorio1, String aleatorio2) {
        Imagen img = new Imagen(aleatorio1, aleatorio2);
        assertEquals("image/png", img.obtenerMimeType());
    }

    /**
     * Comprobación de obtener nombre
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void obtenerNombreImagen(String aleatorio) {
        Imagen img = new Imagen(aleatorio, "contenido");
        Assert.assertEquals(aleatorio , img.obtenerNombre());
    }

    /**
     * Comprobación de obtener contenido
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void obtenerContenidoAudio(String aleatorio) {
        Imagen img = new Imagen("nombre", aleatorio);
        Assert.assertEquals(aleatorio , img.obtenerContenido());
    }

    /**
     * Comprobación de obtener tamaño
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void obtnerTamañoAudio(String aleatorio1, String aleatorio2) {
        Imagen img = new Imagen(aleatorio1, aleatorio2);
        Assert.assertEquals(aleatorio2.length() , img.obtenerTamaño());
    }

    /**
     * Comprobación de obtener previsualización
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void obtenerPreVisualizacion(String aleatorio1, String aleatorio2) {
        Imagen img = new Imagen(aleatorio1, aleatorio2);
        String previ = aleatorio1 + "(" + aleatorio2.length() + " bytes, " + "image/png" + ")";
        Assert.assertEquals(previ, img.obtenerPreVisualizacion());
    }
}
