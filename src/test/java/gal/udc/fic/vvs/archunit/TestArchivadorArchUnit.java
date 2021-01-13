package gal.udc.fic.vvs.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import gal.udc.fic.vvs.email.archivador.Archivador;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class TestArchivadorArchUnit {

    //Algunos ejemplos... Compruebo que cada método devuelve siempre lo que debería

    @Test
    public void archUnitArchivadorAccesibilidad(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivador");

        ArchRule rule = classes().should().notBePrivate();
    }

    @Test
    public void archUnitArchivadorObtenerNombreDevolverString(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivador");

        ArchRule rule = methods().that().haveFullName("obtenerNombre").should().haveRawReturnType(String.class);
    }

    @Test
    public void archUnitArchivadorEspacioTotalYdisponibleDevolverInt(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivador");

        ArchRule rule = methods().that().haveFullName("obtenerEspacioTotal").and().haveFullName("obtenerEspacioDisponible").should().haveRawReturnType(Integer.class);
    }


    @Test
    public void archUnitArchivadorAlmacecnarDevolverBool(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivador");

        ArchRule rule = methods().that().haveFullName("almacenarCorreo").should().haveRawReturnType(Boolean.class);
    }

    @Test
    public void archUnitArchivadorObtenerDelegadoDevolverArchivador(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivador");

        ArchRule rule = methods().that().haveFullName("obtenerDelegado").should().haveRawReturnType(Archivador.class);
    }

    @Test
    public void archUnitArchivadorEstablecerDelegadoDevolverVoid(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivador");

        ArchRule rule = methods().that().haveFullName("obtenerDelegado").should().haveRawReturnType(Void.class);
    }
}
