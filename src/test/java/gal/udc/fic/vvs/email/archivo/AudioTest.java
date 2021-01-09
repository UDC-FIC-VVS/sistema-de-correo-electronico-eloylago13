package gal.udc.fic.vvs.email.archivo;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class AudioTest extends TestCase {

    private String nombreAudio = "Canción";
    private String contenido = "Canción número uno";

    /**
     * Obtener mimeType de audio.
     */
    @Test
    public void testObtenerMimeType() {
        Audio audio = new Audio(nombreAudio, contenido);
        String mimeType = audio.obtenerMimeType();

        Assert.assertEquals("audio/ogg", mimeType);
    }


    /**
     * Obtener nombre del archivo audio.
     */
    @Test
    public void obtenerNombreAudioTest(){
        Audio audio = new Audio(nombreAudio, contenido);

        Assert.assertEquals(nombreAudio,audio.obtenerNombre());
    }

    /**
     *Obtener contenido del archivo audio.
     */
    @Test
    public void obtenerContenidoArchivoTest(){
        Audio audio = new Audio(nombreAudio, contenido);

        Assert.assertEquals(contenido, audio.obtenerContenido());
    }

    /**
     *Obtener tamaño del archivo audio.
     */
    @Test
    public void obtenerTamañoArchivoTest(){
        Audio audio = new Audio(nombreAudio, contenido);


        Assert.assertEquals((nombreAudio+contenido).length(), audio.obtenerTamaño());

    }

    /**
     *Obtener previsualización del archivo audio.
     */
    @Test
    public void obtenerPrevisualizacionArchivoTest(){
        Audio audio = new Audio(nombreAudio, contenido);


        String previ = nombreAudio + "(" + contenido.length() + " bytes, " + "text/plain" + ")";

        Assert.assertEquals(previ, audio.obtenerPreVisualizacion());

    }





}