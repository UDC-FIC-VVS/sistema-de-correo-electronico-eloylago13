package generadorPBT;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class GeneradorMensajePBT extends Generator<Mensaje> {
    public GeneradorMensajePBT() {
        super(Mensaje.class);
    }

    @Override
    public Mensaje generate(SourceOfRandomness aleatorio, GenerationStatus status) {
        return new Mensaje(new Texto(aleatorio.toString(), aleatorio.toString()));
    }
}