package gal.udc.fic.vvs.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class TestArchivoArchUnit {

    @Test
    public void archUnitArchivoAccesibilidad(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivo");

        ArchRule rule = classes().should().notBePrivate();
    }

    @Test
    public void archUnitArchivoObtenerNombreDevuelveString(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivo");

        ArchRule rule = methods().that().haveFullName("obtenerNombre").should().haveRawReturnType(String.class);
    }

    @Test
    public void archUnitArchivoObtenerContenidoDevolverString(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivador");

        ArchRule rule = methods().that().haveFullName("obtenerContenido").should().haveRawReturnType(String.class);
    }

    @Test
    public void archUnitArchivoObtenerTamañoDevolverInt(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivador");

        ArchRule rule = methods().that().haveFullName("obtenerTamaño").should().haveRawReturnType(Integer.class);
    }

    @Test
    public void archUnitArchivoObtenerPrevisualizacionDevolverInt(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivador");

        ArchRule rule = methods().that().haveFullName("obtenerPreVisualizacion").should().haveRawReturnType(String.class);
    }

    @Test
    public void archUnitArchivoObtenerMimeTypeDevolveString(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivador");

        ArchRule rule = methods().that().haveFullName("obtenerMimeType").should().haveRawReturnType(String.class);
    }

}
