package gal.udc.fic.vvs.email.correo;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import generadorPBT.GeneradorCarpetaPBT;
import generadorPBT.GeneradorMensajePBT;
import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class CarpetaLimitadaTestPBT {


    /**
     * Comprobación de que obtiene el tamaño correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: generado aleatoriamente
     */
    @Property
    public void testObtenerTamaño(String nombre, String nombreTxt, String contenidoTxt, String contenidoTxt2,@InRange(min="1") int espacio, @From(GeneradorCarpetaPBT.class) Carpeta carpetaAleatoria) {
        CarpetaLimitada carpeta = new CarpetaLimitada(carpetaAleatoria, espacio);

        Texto nuevoTexto = new Texto(nombreTxt, contenidoTxt);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre, contenidoTxt2);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpeta.añadir(mensaje);
            carpeta.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }
        Assert.assertEquals((contenidoTxt + contenidoTxt2).length(), carpeta.obtenerTamaño());
    }

    /**
     * Comprobación de que obtiene hijo correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void testObtenerHijoCarpeta(String nombre, String nombreTxt, String contenidoTxt, @InRange(min="1") int espacio, @From(GeneradorCarpetaPBT.class) Carpeta carpetaAleatoria) {
        CarpetaLimitada carpeta = new CarpetaLimitada(carpetaAleatoria, espacio);

        Texto txt = new Texto(nombreTxt, contenidoTxt);
        Mensaje mensaje = new Mensaje(txt);



        try {
            carpeta.añadir(mensaje);

        } catch (OperacionInvalida operacionInvalida) {

        }

        try {
            Assert.assertEquals(mensaje,carpeta.obtenerHijo(0));

        } catch (OperacionInvalida operacionInvalida) {
            operacionInvalida.printStackTrace();
        }
    }


    /**
     * Comprobación de que obtiene icono correctamente
     *
     * Nivel da proba: UNIDAD
     *
     * Categorías ás que pertence: funcional dinámica caja negra positiva
     *
     * Mecanismo de selección dos datos: generados aleatoriamente
     */
    @Property
    public void testObtenerIcono( String contenidoTxt, @InRange(min="1") int espacio, @From(GeneradorCarpetaPBT.class) Carpeta carpetaAleatoria) {

        CarpetaLimitada carpeta = new CarpetaLimitada(carpetaAleatoria, espacio);

        Assert.assertEquals(Correo.ICONO_CARPETA,carpeta.obtenerIcono());

    }

}
