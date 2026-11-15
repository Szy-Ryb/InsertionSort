# InsertionSort

Program konsolowy w Javie, który sortuje rosnąco liczby dziesiętne wpisane przez użytkownika metodą sortowania przez wstawianie (insertion sort). Wynik jest wypisany w jednej linii, a liczby są oddzielone spacjami.

Liczby są przechowywane w klasie `BigDecimal`, dlatego nie są wcześniej zaokrąglane przez `double`, a porównywane są ich dokładne wartości. Algorytm sortowania jest napisany ręcznie, bez użycia `Arrays.sort()` ani `List.sort()`.

## Opis działania

1. Program prosi o podanie liczb dziesiętnych oddzielonych spacją (kropka lub przecinek jako separator, dozwolona notacja naukowa, np. `1e-5`). Wczytywana jest cała linia.
2. Dzieli wpisany tekst na pojedyncze wyrazy (dowolna liczba spacji między nimi).
3. Zamienia przecinek na kropkę i zamienia każdy wyraz na `BigDecimal` (dokładna wartość, bez utraty precyzji). Jeśli którykolwiek wyraz nie jest liczbą, wyświetla komunikat o błędzie.
4. Sortuje tablicę metodą przez wstawianie: lewa część tablicy jest zawsze posortowana, a każdy kolejny element (klucz) jest wstawiany w odpowiednie miejsce tej części.
5. Do wstawienia klucza program przesuwa o jedno miejsce w prawo wszystkie większe od niego elementy z lewej części, a następnie wpisuje klucz w zwolnione miejsce.
6. Wypisuje posortowane liczby w jednej linii, bez notacji naukowej (`toPlainString()`).

W przypadku błędnych danych program wyświetla komunikat o błędzie.

## Złożoność

| Przypadek                                 | Złożoność czasowa | Złożoność pamięciowa |
| ----------------------------------------- | ----------------- | -------------------- |
| Najgorszy (tablica posortowana odwrotnie) | O(n²)             | O(1) dodatkowej      |
| Średni                                    | O(n²)             | O(1) dodatkowej      |
| Najlepszy (tablica już posortowana)       | O(n)              | O(1) dodatkowej      |

Algorytm jest stabilny (równe elementy zachowują kolejność z wejścia), bo przesuwane są tylko elementy ściśle większe od klucza. Działa w miejscu, a dla danych prawie posortowanych jest szybki.

## Wykorzystane elementy Javy

- klasa `Scanner`
- klasa `BigDecimal` (m.in. `compareTo()`, `toPlainString()`)
- `String.split()`, `trim()` i `replace()` (wyrażenie regularne `\\s+` do podziału po spacjach)
- tablice, pętle `for` i `while`
- obsługa wyjątku `NumberFormatException`

`compareTo()` jest użyte zamiast operatora `>`, bo `BigDecimal` nie obsługuje operatorów porównania, oraz zamiast `equals()`, które uznaje `2.0` i `2.00` za różne liczby.

## Uruchomienie

```
javac InsertionSort.java
java InsertionSort
```

Wymagana jest Java 8 lub nowsza.

## Przykłady

| Wejście            | Wyjście                    |
| ------------------ | -------------------------- |
| `5,75 -0.1 1e2 3`  | `-0.1 3 5.75 100`          |
| `3 2 1`            | `1 2 3`                    |
| `1e-5 0 -2,5`      | `-2.5 0 0.00001`           |
| `1,5 1.50 1.5`     | `1.5 1.50 1.5`             |
| `7`                | `7`                        |
| `1 abc 3`          | komunikat o błędzie        |

## Uwagi

- Przecinek jest automatycznie zamieniany na kropkę, więc `5,75` i `5.75` oznaczają to samo.
- Liczby równe pod względem wartości (np. `1.5` i `1.50`) są traktowane jako równe i zachowują swoją kolejność z wejścia, ale każda jest wypisywana w takiej postaci, w jakiej ją wpisano.
- `-0` jest traktowane jak zwykłe `0` (w przeciwieństwie do projektu IEEE754Extended, gdzie jest błędem).
- Pusta linia lub wyraz, który nie jest liczbą, kończy się komunikatem `Błąd!! To nie jest poprawna liczba!`, a nie częściowym wynikiem.
- Dla bardzo dużych zbiorów danych lepszy jest `Arrays.sort()`, bo insertion sort ma złożoność O(n²). Ten program służy głównie do nauki.

## Autor

Szymon Rybikowski
