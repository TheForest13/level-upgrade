import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
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

//        Thread.sleep(4000);

        Flux<Object> telegramProducer = Flux
                .generate(
                        () -> 2354,
                        (state, sink) -> {
                            if (state > 2366) {
                                sink.complete();
                            } else {
                                sink.next("Step: " + state);
                            }
                            return state + 3;
                        });

        Flux    //also push
                .create(sink ->
//                        telegramSubscribe(telegramProducer, sink)
                        sink.onRequest(it -> sink.next("DB returns: " + telegramProducer.blockFirst()))
                )
                .subscribe(System.out::println);
    }

    private static void telegramSubscribe(Flux<Object> telegramProducer, FluxSink<Object> sink) {
        telegramProducer.subscribe(new BaseSubscriber<Object>() {
            @Override
            protected void hookOnNext(Object value) {
                sink.next(value);
            }

            @Override
            protected void hookOnComplete() {
                sink.complete();
            }
        });
    }
}
