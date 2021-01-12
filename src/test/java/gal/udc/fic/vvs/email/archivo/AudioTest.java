package gal.udc.fic.vvs.email.archivo;

import com.sun.org.apache.bcel.internal.ExceptionConstants;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class AudioTest  {

    private String nombreAudio = "Canción";
    private String contenido = "Canción número uno";


    /**
     * Comprobación de crear un audio sin contenido
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativa
     *      No deberíamos de poder crear un audio sin contenido
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test (expected = OperacionInvalida.class)
    public void audioSinContenido() {
        Audio audio = new Audio(nombreAudio, null);

    }

    /**
     * Comprobación de obtener nombre nulo
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra negativa
     *      No deberíamos de poder crear un audio sin nombre
     *
     * Mecanismo de selección dos datos: mi criterio
     */
    @Test (expected = OperacionInvalida.class)
    public void audioSinNombre() {
        Audio audio = new Audio(null, contenido);
    }

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
    public void testObtenerMimeType() {
        Audio audio = new Audio(nombreAudio, contenido);
        String mimeType = audio.obtenerMimeType();

        Assert.assertEquals("audio/ogg", mimeType);
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
        Audio audio = new Audio(nombreAudio, contenido);

        Assert.assertEquals(nombreAudio, audio.obtenerNombre());
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
        Audio audio = new Audio("", contenido);

        Assert.assertEquals("", audio.obtenerNombre());
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
    public void testObtenerVacio() {
        Audio audio = new Audio(nombreAudio, contenido);

        Assert.assertEquals(contenido, audio.obtenerContenido());
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
    public void testObtenerContenidoSinContenido() {
        Audio audio = new Audio(nombreAudio, "");

        Assert.assertEquals("", audio.obtenerContenido());
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
    public void testObtenerTamaño() {
        Audio audio = new Audio(nombreAudio, contenido);
        Assert.assertEquals((contenido).length(), audio.obtenerTamaño());
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
        Audio audio = new Audio(nombreAudio, contenido);


        String previ = nombreAudio + "(" + contenido.length() + " bytes, " + "audio/ogg" + ")";

        Assert.assertEquals(previ, audio.obtenerPreVisualizacion());
    }


}