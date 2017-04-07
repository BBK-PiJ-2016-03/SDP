package singleton;

import jdk.internal.org.objectweb.asm.commons.InstructionAdapter;

import java.util.stream.IntStream;

/**
 * Created by aworton on 27/02/17.
 */
public class Main {

    public static void main(String... args) {

        IntStream.range(0,200).forEach(threadNum -> {
            Thread t = new Thread(() -> IntStream.range(0, 10).forEach(iteration -> System.out.println(NonLazySingleton.INSTANCE.getNextId())));

            t.start();
        });
    }
}
