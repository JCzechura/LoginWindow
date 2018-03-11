# LoginWindow

Login window (the user has to choose enviroment and username and then enter password) - project in JavaFX.

Projekt okienka logowania, zawierającego listę wyboru z możliwością wyboru środowiska: produkcyjnego, testowego, deweloperskiego, listę wyboru identyfikatora użytkownika z możliwością edycji, pole edycji na wprowadzenia hasła oraz przyciski Logon i Anuluj. Całośc projektu wykonano przy użyciu JavaFX.

Szczegółowy opis funkcjonalności oliekna:
1. Wybór środowiska (Deweloperskie, Testowe, Produkcyjne) powoduje zmianę listy użytkowników. 
2. Użytkownik może także wpisać swój identyfikator ręcznie. 
3. Przycisk logowania jest aktywny tylko wtedy, gdy wszystkie pola są wypełnione. 
4. Do wykonania okienka posłużyła klasa  javafx.scene.control.Dialog. 
5. Dodatkowo, okienko zamiast domyślnej wartości (jaką jest ButtonType) zwraca parę wartości (Środowisko, NazwaUżytkownika), co pozwala na finalne wyświetlenie komunikatu o poprawnym zalogowaniu danego użytnownika bądź błędnych danych.

Pliki żródłowe znajdują się w src/application/
