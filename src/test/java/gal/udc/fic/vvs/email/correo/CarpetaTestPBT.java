package gal.udc.fic.vvs.email.correo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Vector;

@RunWith(JUnitQuickcheck.class)
public class CarpetaTestPBT {



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
    public void testObtenerTamaño(String nombre, String nombreTxt, String contenidoTxt, String contenidoTxt2) {
        Carpeta carpeta = new Carpeta(nombre);

        Texto nuevoTexto = new Texto(nombreTxt, contenidoTxt);
        Mensaje mensaje = new Mensaje(nuevoTexto);

        Texto nuevoTexto2 = new Texto(nombre, contenidoTxt2);
        Mensaje mensaje2 = new Mensaje(nuevoTexto2);

        try {
            carpeta.añadir(mensaje);
            carpeta.añadir(mensaje2);

        } catch (OperacionInvalida operacionInvalida) {

        }
        Assert.assertEquals((contenidoTxt+contenidoTxt2).length(),carpeta.obtenerTamaño());
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
    public void testObtenerHijoCarpeta(String nombre, String nombreTxt, String contenidoTxt) {
        Carpeta carpeta = new Carpeta(nombre);

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
    public void testObtenerIcono(String nombre) {

        Carpeta carpeta = new Carpeta(nombre);

        Assert.assertEquals(Correo.ICONO_CARPETA,carpeta.obtenerIcono());

    }




}
