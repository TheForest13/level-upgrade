import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Main2 {
    public static void main(String[] args) {
//        monoPrintln();
//        fluxPrintln();
//        fluxMap();
//        fluxZip();
        fluxOnError();
    }

    private static void fluxOnError() {
        Flux<String> fluxCalc = Flux.just(-1, 0, 1)
                .map(i -> "10 / " + i + " = " + (10 / i));

        fluxCalc.subscribe(value -> System.out.println("Next: " + value),
                error -> System.err.println("Error: " + error));
    }

    private static void fluxZip() {
        Flux<String> fluxFruits = Flux.just("apple", "pear", "plum");
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        Flux<Integer> fluxAmounts = Flux.just(10, 20, 30);
        Flux.zip(fluxFruits, fluxColors, fluxAmounts).subscribe(System.out::println);
    }

    private static void fluxMap() {
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        fluxColors.map(color -> color.charAt(0)).subscribe(System.out::println);
    }

    private static void fluxPrintln() {
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
//        fluxColors.subscribe(System.out::println);
        fluxColors.log().subscribe(System.out::println);
    }

    private static void monoPrintln() {
        Mono<String> monoColors = Mono.just("one");
//        monoColors.subscribe(System.out::println);
        monoColors.log().subscribe(System.out::println);
    }
}
