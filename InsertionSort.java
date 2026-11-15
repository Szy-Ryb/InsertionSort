import java.math.BigDecimal; // klasa do dokładnych liczb dziesiętnych (bez utraty precyzji)
import java.util.Scanner;

public class InsertionSort { // główna klasa programu w Javie

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // utworzenie obiektu scanner do inputu z klawiatury

        System.out.println("Copyright Szymon Rybikowski"); // copyright

        System.out.print("Podaj liczby dziesiętne oddzielone spacją (np. 5.75 -0.1 1e-5 3): "); // prośba o wpisanie liczb

        String[] wejscie = scanner.nextLine().trim().split("\\s+"); // pobranie całej linii i podział na pojedyncze liczby (jako tekst)

        {
            try {
                BigDecimal[] liczby = new BigDecimal[wejscie.length]; // tablica na dokładne liczby dziesiętne

                for (int i = 0; i < wejscie.length; i++) { // przejście po wszystkich wpisanych wyrazach
                    liczby[i] = new BigDecimal(wejscie[i].replace(',', '.')); // przecinek zamieniony na kropkę, tekst zamieniony na BigDecimal
                }

                int n = liczby.length; // liczba elementów w tablicy

                for (int i = 1; i < n; i++) { // pętla od drugiego elementu: lewa część tablicy (przed i) jest już posortowana

                    BigDecimal klucz = liczby[i]; // element, który wstawiamy w odpowiednie miejsce lewej części
                    int j = i - 1; // indeks ostatniego elementu posortowanej części

                    while (j >= 0 && liczby[j].compareTo(klucz) > 0) { // dopóki element po lewej jest większy od klucza (compareTo zamiast operatora >)
                        liczby[j + 1] = liczby[j]; // przesunięcie większego elementu o jedno miejsce w prawo
                        j--; // przejście do kolejnego elementu po lewej
                    }

                    liczby[j + 1] = klucz; // wstawienie klucza w wolne miejsce
                }

                System.out.print("Posortowane rosnąco: "); // nagłówek wyniku (bez przejścia do nowej linii)

                for (int i = 0; i < n; i++) { // przejście po posortowanej tablicy
                    System.out.print(liczby[i].toPlainString()); // wyświetlenie liczby (bez notacji naukowej)
                    if (i < n - 1) { // jeśli to nie ostatnia liczba
                        System.out.print(" "); // spacja między liczbami
                    }
                }

                System.out.println(); // przejście do nowej linii po wypisaniu wszystkich liczb

            } catch (NumberFormatException e) { // wyjątek gdy input to inne znaki niż liczby
                System.out.println("Błąd!! To nie jest poprawna liczba!");
            }
        }

        scanner.close(); // zamknięcie skanera w celu zwolnienia zasobów systemowych
    }
} // Copyright Szymon Rybikowski