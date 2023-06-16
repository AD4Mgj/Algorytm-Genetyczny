# ProjektGenetyczny
Projekt zaliczeniowy na Sztuczną inteligencję 

Problem wyboru odpowiedniego miejsca na mapie, w którym zaludnienie jest najwyższe.
Poziom zaludnienia dla odpowiednich współrzędnych reprezentuje funkcja:

**𝑇(𝑥, 𝑦) = −(475 − 𝑥)2 − (500 − 𝑦)2 + 600000**

gdzie 𝑥, 𝑦 ∈ [0,1023] to liczby całkowite. Szukanym rozwiązaniem jest para liczb całkowitych
(𝑥, 𝑦) ∈ {0,1, … ,1023}, dla których poziom zaludnienia jest najwyższy.

a) (20) Zaimplementować operator mutowania odpowiedni do rozwiązywanego problemu. W ramach
mutacji zostaje zanegowany jeden losowo wybrany bit genotypu. Zaimplementuj nowy operator
mutowania dla postawionego problemu. W razie potrzeby sprawdź także inne wariaty operatora
mutowania.

b) (20) Zaimplementować operator krzyżowania odpowiedni do rozwiązywanego problemu. W wyniku
krzyżowania powstają dwa genotypy. Miejsce krzyżowania jest ustalane „w połowie” chromosomu.
Jeżeli genotyp składa się z kilku chromosomów to należy każdą parę odpowiadających sobie
chromosomów skrzyżować w połowie. W razie potrzeby zaimplementuj także inne warianty operatora
krzyżowania.

c) (20) Zaimplemnetować interface IIindividual dla osobnika reprezentującego parę współrzędnych na
mapie.

d) (20) Użyć CAG do rozwiązania postawionego problemu.

e) (20) Wykonać przy założeniu, że zaadaptowano algorytm genetyczny do postawionego problemu.
