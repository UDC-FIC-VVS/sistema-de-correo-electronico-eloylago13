package gal.udc.fic.vvs.email.archivo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Assert;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class TextoTestPBT {

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
    public void obtenerMimeTypeTexto(String aleatorio1, String aleatorio2) {
        Texto txt = new Texto(aleatorio1, aleatorio2);
        Assert.assertEquals("text/plain", txt.obtenerMimeType());
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
    public void obtenerNombreTexto(String aleatorio) {
        Texto txt = new Texto(aleatorio, "contenido");
        Assert.assertEquals(aleatorio , txt.obtenerNombre());
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
    public void obtenerContenidoTexto(String aleatorio) {
        Texto txt = new Texto("nombre", aleatorio);
        Assert.assertEquals(aleatorio , txt.obtenerContenido());
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
    public void obtnerTamañoTexto(String aleatorio1, String aleatorio2) {
        Texto txt = new Texto(aleatorio1, aleatorio2);
        Assert.assertEquals(aleatorio2.length() , txt.obtenerTamaño());
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
        Texto txt = new Texto(aleatorio1, aleatorio2);
        String previ = aleatorio1 + "(" + aleatorio2.length() + " bytes, " + "text/plain" + ")";
        Assert.assertEquals(previ, txt.obtenerPreVisualizacion());
    }
}
