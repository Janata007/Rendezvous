# Rendezvous

## Spring based application made with love and care.

### Authors: Jana Markovikj(181112), Bojan Dabevski(181115), Marko Markovikj(181097)

## STACK
|SPRING (JAVA) |REACT|CSS|
|--------------|-----|---|

The project is built as two applications which communicate with each other. The backend is written in Spring Boot with repository, service and web layers. The frontend is written in React. 
It communicates with BE through APIs which all accept and send json data.
### Entity models:
- Korisnik - the main user entity
- Hobbies - based on HobbiesEnum which the user has ManyToMany relationship (unidirectional)
- Locations - based on LocationsEnum which the user has ManyToMany relationship (unidirectional)
- Sports -  based on SportsEnum which the user has ManyToMany relationship (unidirectional)
- MusicGenres -  based on MusicGenresEnum which the user has ManyToMany relationship (unidirectional)
- Likes - entity made for keeping records of which user liked/disliked which user

### Repository:
There are repositories for all entity models defined above.

### Service:
There are services for all entity models defined above.
- MatchService - additional service meant for calculating the percent of which one user matches with another user based on the hobbies, locations, sports and music genres they overlap.

### Web
There are rest controllers for all entity models defined above.
- MatchController - additional controller for getting the percent of a match for users.

### Video example:
https://www.youtube.com/watch?v=3xVkutVFPrQ
