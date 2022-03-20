# Lab1 - Kalkulator

## Założenia aplikacji:
    - wybieramy dwie liczby (wpisane na sztywno w liście rozwyjanej typu Spinner)
    - otrzymanie wyniku po kliknięicu przycisku
    - użycia zasobów łańcuchowych i tablic
    - użycie elementów: Spinner, Button, Text View

## Widok aplikacji

![](assets/screenshots/screen1.png)


__Wybór liczby - użycie Spinnera__

![](assets/screenshots/screen2.png)

__Po wybraniu liczb i naciśnięciu przycisku "+", "-", "÷", "×" symbol wybranej operacji wyświetla się przy "Działanie:"__

![](assets/screenshots/screen3.png)

__Po wybraniu "=" wykonane zostanie działanie, a wynik wyświetlony obok "Wynik:". Wynik operacji dodawania:__

![](assets/screenshots/screen4.png)

__Odejmowanie:__

![](assets/screenshots/screen6.png)

__Dzielenie:__

![](assets/screenshots/screen7.png)

__Mnożenie:__

![](assets/screenshots/screen8.png)

__Po kliknięciu "C" czyszczone jest pole wyniku oraz działania__

![](assets/screenshots/screen9.png)

__Widok układu:__

![](assets/screenshots/screen10.png)

__Przyciski "+", "-", "÷", "×" wywołują metodę "operationBtnOnClick" przy kliknięciu__

![](assets/screenshots/screen11.png)

![](assets/screenshots/screen12.png)

__Przycisk "=" wywołuje metodę "equalBtnOnClick", a "C" "clearBtnOnClick":__

![](assets/screenshots/screen13.png)

__Użycie zasobów łańcuchowych i tablic:__

![](assets/screenshots/screen14.png)

__"operationBtnOnClick" ustawia text w TextView działania na symbol klikniętego przycisku__

__"cleanBtnOnClick" zmienia wartość stringa przechowującego aktualną operację na pustą i czyści TextView wyniku oraz działania__

![](assets/screenshots/screen15.png)

__"equalBtnOnClick" pobiera wartości z obu Spinnerów i parsuje je na double, potem w zależności od zmiennej globalnej "operation" wykonuje działanie. Sprawdza też czy nie występuje dzielenie przez 0. Wynik wypisuje w TextView__

![](assets/screenshots/screen16.png)