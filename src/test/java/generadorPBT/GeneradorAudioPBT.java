package generadorPBT;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import gal.udc.fic.vvs.email.archivo.Audio;

public class GeneradorAudioPBT extends Generator<Audio> {
    public GeneradorAudioPBT() {
        super(Audio.class);
    }

    @Override
    public Audio generate(SourceOfRandomness aleatorio, GenerationStatus status) {
        return  new Audio(aleatorio.toString(), aleatorio.toString());
    }

}