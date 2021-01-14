package gal.udc.fic.vvs.email.archivo;

import org.junit.Assert;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;


import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class AudioTestPBT {

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
    public void obtenerMimeTypeAudio(String nombre, String contenido) {
        Audio audio = new Audio(nombre, contenido);
        assertEquals("audio/ogg", audio.obtenerMimeType());
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
    public void obtenerNombreAudio(String aleatorio) {
        Audio audio = new Audio(aleatorio, "contenido");
        Assert.assertEquals(aleatorio , audio.obtenerNombre());
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
        Audio audio = new Audio("nombre", aleatorio);
        Assert.assertEquals(aleatorio , audio.obtenerContenido());
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
        Audio audio = new Audio(aleatorio1, aleatorio2);
        Assert.assertEquals(aleatorio2.length() , audio.obtenerTamaño());
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
        Audio audio = new Audio(aleatorio1, aleatorio2);
        String previ = aleatorio1 + "(" + aleatorio2.length() + " bytes, " + "audio/ogg" + ")";
        Assert.assertEquals(previ, audio.obtenerPreVisualizacion());
    }



}
