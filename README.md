Przykład zastosowania relacji many-to-many wraz z dodawaniem i edycją obiektów
przykład:
- Każde miasto 'City' posiada nazwę 'Name' i może posiadać wiele kodów 'Codes',a każdy kod 'Code' o nazwie 'Code'może być przypisany do wielu miast.
- W formularu podaję nazwę miasta w polu input, a kody w polu textarea oddzielone przecinkami
- link Edycji przenosi na stronę edit dla wybranego miasta, a w formularzu wyświetlają sie aktualne warości dla nazwy miasta i kodów
- edycja nazwy i wysłanie formularza nadpisze rekord w bazie
- aby zmniejszyć liczbę kodów należy przesłać puste pole, a żeby dodać - wpisać kolejny po przecinku w istniejącym polu

TBD:
- edycja kodów w polu textarea ?
