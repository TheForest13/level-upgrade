import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Mono.empty();
        Flux.empty();
        Mono<Integer> mono = Mono.just(1);
        Flux<Integer> flux = Flux.just(1, 2, 3);

        Flux<Integer> fluxFromMono = mono.flux();
        Mono<Boolean> monoFromFlux = flux.any(it -> it.equals(1));
        Mono<Integer> integerFromFlux = flux.elementAt(1);

        Flux.range(1, 5);
        Flux.fromIterable(Arrays.asList(1, 2, 3));

        Flux
                .<String>generate(sink -> sink.next("hello"))
                .delayElements(Duration.ofMillis(500))
                .take(10);

        Flux
                .generate(
                        () -> 2354,
                        (state, sink) -> {
                            if (state > 2366) {
                                sink.complete();
                            } else {
                                sink.next("Step: " + state);
                            }
                            return state + 3;
                        })
                .subscribe(System.out::println);

        Thread.sleep(4000);
    }
}
