package hello.jbtbe.global.file;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class Path {

    public static String join(String... paths) {
        AtomicReference<String> result = new AtomicReference<>("");

        Arrays.stream(paths).toList().forEach(it -> {
                    if (it.endsWith("/")) {
                        it = it.substring(0, it.length() - 1);
                    }
                    if (it.startsWith("/")) {
                        it = it.substring(1);
                    }
                    result.set(result.get() + "/" + it);
                }
        );

        if (result.get().startsWith("/")) {
            result.set(result.get().substring(1));
        }

        return result.get();
    }
}
