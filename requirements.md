SONGIFY: APLIKACJA DO ZARZĄDZANIA ALBUMAMI, ARTYSTAMI I PIOSENKAMI

1. ~~można dodać artystę (nazwa artysty)~~
2. ~~można dodać gatunek muzyczny (nazwa gatunku)~~
3. ~~można dodać album (tytuł, data wydania, ale musi być w nim przynajmniej jedna piosenka)~~
4. ~~można dodać piosenkę (tytuł, czas trwania, data wydania)~~
5. ~~można usunąć artystę (usuwamy wtedy jego piosenki oraz albumy, ale jeśli było więcej niż jeden artysta w albumie, to usuwamy tylko artystę z albumu i samego artystę)~~
6. ~~można dodać artystę od razu z albumem i piosenką (domyślne wartości)~~
7. można usunąć gatunek muzyczny (ale nie może istnieć piosenka z takim gatunkiem)
8. można usunąć album (ale dopiero wtedy kiedy nie ma już żadnej piosenki przypisanej do albumu)
9. ~~można usunąć piosenkę, ale nie usuwamy albumu i artystów gdy była tylko 1 piosenka w albumie~~
10. ~~można edytować piosenki artysty, oraz jego nazwę~~
11. można edytować nazwę gatunku muzycznego
12. można edytować album (dodawać piosenki, arytstów, zmieniac names albums)
13. można edytować piosenkę (czas trwania, artystę, nazwę piosenki)
14. można przypisać piosenki tylko do albumów
15. można przypisać piosenki do artysty (poprzez album)
16. ~~można przypisać artystów do albumów (album może mieć więcej artystów, artysta może mieć kilka albumów)~~
17. można przypisać tylko jeden gatunek muzyczny do piosenki
18. gdy nie ma przypisanego gatunku muzycznego do piosenki, to wyświetlamy "defalut"
19. ~~można wyświetlać wszystkie piosenki~~
20. można wyświetlać wszystkie gatunki
21. ~~można wyświetlać wszystkich artystów~~
22. można wyświetlać wszystkie albumy
23. ~~można wyświetlać konkretne albumy z artystami oraz piosenkami w albumie~~
24. można wyświetlać konkretne gatunki muzyczne wraz z piosenkami
25. można wyświetlać konkretnych artystów wraz z ich albumami
26. chcemy mieć trwałe dane


HAPPY PATH (User creates "Eminem"'s album with songs "Till I Collapse", "Lose Yourself", genre Rap)

Given there is no songs, artists, albums and genres created before

1. when I go to /song then I can see no songs
2. when I post to /song with Song "Till I collapse" then Song "Till I Collapse" is returned with id 1
3. when I post to /song with Song "Lose Yourself" then Song "Lose Yourself" is returned with id 2
4. when I go to /genre then I can see no genres
5. when I post to /genre with Genre "Rap" then Genre "Rap" is returned with id 1
6. when I go to /song/1 then I can see default genre
7. when I put to /song/1/genre/1 then Genre with id 1 ("Rap") is added to Song with id 1 ("Till I Collapse")
8. when I go to /song/1 then I can see "Rap" genre
9. when I put to /song/2/genre/1 then Genre with id 1 ("Rap") is added to Song with id 2 ("Lose Yourself")
10. when I go to /album then I can see no albums
11. when I post to /album with Album "EminemAlbum1" and Song with id 1 then Album "EminemAlbum1" is returned with id 1
12. when I go to /album/1 then I can see song with id 1 added to it
13. when I put to /album/1/song/1 then Song with id 1 ("Till I Collapse") is added to Album with id 1 ("EminemAlbum1")
14. when I put to /album/1/song/2 then Song with id 2 ("Lose Yourself") is added to Album with id 1 ("EminemAlbum1")
15. when I go to /album/1/song then I can see 2 songs (id 1, id 2)
16. when I post to /artist with Artist "Eminem" then Artist "Eminem" is returned with id 1
17. when I put to /album/1/artist/2 then Artist with id 1 ("Eminem") is added to Album with id 1 ("EminemAlbum1")