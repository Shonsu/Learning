package pl.shonsu.streams;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsApp {
        public static void main(String[] args) {

                List<Czlowiek> ludzie = getPeople();
                List<Double> test = new ArrayList<>();
                test.add(12.2);
                test.add(12.76);
                test.add(12.34);
                test.add(2.2);
                test.add(212.09);
                test.add(102.38);
                test.add(45.76);
                test.add(12.15);
                test.add(3.223);
                test.add(2.432);
                test.add(2.432);
                List<Double> testReversed = test.stream().sorted(Comparator.comparingDouble((Double o) -> o - Math.floor(o)).reversed()).toList();
                testReversed.forEach(  (Double o) -> System.out.println(o));

                System.out.println("Before sorting:");
                ludzie.forEach(czlowiek -> System.out
                                .println(czlowiek.getImie() + "\t" + czlowiek.getWiek() + "\t" + czlowiek.getAdres()));

                System.out.println("After sorting by city and street from adress:");
                Comparator<Czlowiek> czlowiekComparatorByNameAndAge = Comparator
                                .<Czlowiek, String>comparing(Czlowiek::getImie)
                                .thenComparing(Comparator.comparing(c -> c.getWiek()));

                Comparator<Czlowiek> czlowiekComparatorByAdress = Comparator
                                .<Czlowiek, String>comparing(c -> c.getAdres().getMiejscowosc())
                                .thenComparing(c -> c.getAdres().getUlica());

                ludzie.sort(czlowiekComparatorByAdress);

                ludzie.forEach(czlowiek -> System.out
                                .println(czlowiek.getImie() + "\t" + czlowiek.getWiek() + "\t" + czlowiek.getAdres()));

                Comparator<Czlowiek> byCity = new Comparator<Czlowiek>() {
                        @Override
                        public int compare(Czlowiek a1, Czlowiek a2) {
                                return a1.getAdres().getMiejscowosc().compareTo(a2.getAdres().getMiejscowosc());
                        }
                };

                System.out.println("After sorting by city from adress:");
                ludzie.sort(byCity);
                ludzie.forEach(czlowiek -> System.out.println(czlowiek.getImie() + "\t" + czlowiek.getAdres()));

                System.out.println("After sorting with Comparator by imie:");
                Comparator<Czlowiek> czlowiekComparator = Comparator.comparing(Czlowiek::getImie);
                Collections.sort(ludzie, czlowiekComparator);
                ludzie.forEach(czlowiek -> System.out.println(czlowiek.getImie() + "\t" + czlowiek.getWiek()));

                System.out.println("After sorting with lambda by wiek:");
                ludzie.sort((Czlowiek c1, Czlowiek c2) -> c1.getWiek() - c2.getWiek());
                ludzie.forEach(czlowiek -> System.out.println(czlowiek.getImie() + "\t" + czlowiek.getWiek()));

                System.out.println("People with age less then 23:");
                ludzie.stream().filter(czlowiek -> czlowiek.getWiek() < 23)
                                .forEach(czlowiek -> System.out.println(czlowiek.getImie()));

                System.out.println("Reverse collection");
                Collections.reverse(ludzie);
                for (Czlowiek cz : ludzie) {
                        System.out.println(cz.getImie() + "\t" + cz.getWiek());
                }

                ludzie.sort((c1, c2) -> c1.getAdres().getMiejscowosc()
                                .compareTo(c2.getAdres().getMiejscowosc()));
                ludzie.forEach(czlowiek -> System.out
                                .println(czlowiek.getImie() + "\t" + czlowiek.getAdres().getMiejscowosc()));

                QuadFunction<String, Integer, List<Czlowiek>, Adres, Czlowiek> czlowiekConstructor = Czlowiek::new;
                Czlowiek cz1 = czlowiekConstructor.apply("Paweł", 40, Collections.singletonList(ludzie.get(0)),
                                new Adres("05-400", "Otwock", "Szkolna 1"));
                System.out.println(cz1);

                Stream.of("one", "two", "three", "four")
                                .filter(e -> e.length() > 3)
                                .peek(e -> System.out.println("Filtered value: " + e))
                                .map(String::toUpperCase)
                                .peek(e -> System.out.println("Mapped value: " + e))
                                .collect(Collectors.toList());

        }

        public static List<Czlowiek> getPeople() {

                List<Czlowiek> result = new ArrayList<Czlowiek>();
                Czlowiek stefan = new Czlowiek("Stefan", 29, null, new Adres("96-124", "Maków", "Kasztanowa 1"));
                Czlowiek brajan = new Czlowiek("Brajan", 5, null, new Adres("96-124", "Maków", "Brzosty 1"));
                Czlowiek dzesika = new Czlowiek("Dzesika", 6, null, new Adres("96-124", "Maków", "Brzosty 1"));
                Czlowiek janusz = new Czlowiek("Janusz", 36, Collections.singletonList(brajan),
                                new Adres("96-124", "Maków", "Kasztanowa 1"));
                Czlowiek dariusz = new Czlowiek("Dariusz", 39, Collections.singletonList(dzesika),
                                new Adres("96-100", "Skierniewice", "Tuwima 3"));
                Czlowiek grazyna = new Czlowiek("Grazyna", 31, Arrays.asList(dzesika, brajan),
                                new Adres("96-124", "Maków", "Kasztanowa 1"));
                Czlowiek mariola = new Czlowiek("Mariola", 22, Collections.EMPTY_LIST,
                                new Adres("96-666", "Koluszki", "Dworcowa 1"));

                result.add(stefan);
                result.add(brajan);
                result.add(dzesika);
                result.add(janusz);
                result.add(dariusz);
                result.add(grazyna);
                result.add(mariola);

                return result;

        }

        @FunctionalInterface
        interface QuadFunction<A, B, C, D, R> {

                R apply(A a, B b, C c, D d);

                default <V> QuadFunction<A, B, C, D, V> andThen(Function<? super R, ? extends V> after) {
                        Objects.requireNonNull(after);
                        return (A a, B b, C c, D d) -> after.apply(apply(a, b, c, d));
                }
        }
}
