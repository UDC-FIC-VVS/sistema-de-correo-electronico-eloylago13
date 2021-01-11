package gal.udc.fic.vvs.email.archivo;

import org.junit.Assert;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;


import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class AudioTestPBT {

    @Property
    public void obtenerMimeTypeAudio(String nombre, String contenido) {
        Audio audio = new Audio(nombre, contenido);
        assertEquals("audio/ogg", audio.obtenerMimeType());
    }

    @Property
    public void obtenerNombreAudio(String aleatorio) {
        Audio audio = new Audio(aleatorio, "contenido");
        Assert.assertEquals(aleatorio , audio.obtenerNombre());
    }

    @Property
    public void obtenerContenidoAudio(String aleatorio) {
        Audio audio = new Audio("nombre", aleatorio);
        Assert.assertEquals(aleatorio , audio.obtenerContenido());
    }

    @Property
    public void obtnerTamañoAudio(String aleatorio1, String aleatorio2) {
        Audio audio = new Audio(aleatorio1, aleatorio2);
        Assert.assertEquals(aleatorio2.length() , audio.obtenerTamaño());
    }

    @Property
    public void obtenerPreVisualizacion(String aleatorio1, String aleatorio2) {
        Audio audio = new Audio(aleatorio1, aleatorio2);
        String previ = aleatorio1 + "(" + aleatorio2.length() + " bytes, " + "audio/ogg" + ")";
        Assert.assertEquals(previ, audio.obtenerPreVisualizacion());
    }



}
