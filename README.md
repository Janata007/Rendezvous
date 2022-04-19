# Rendezvous

## Spring based application made with love and care.

### Authors: Jana Markovikj, Bojan Dabevski, Marko Markovikj

## STACK
|SPRING (JAVA) |REACT|CSS|
|--------------|-----|---|

The project is built as two applications which communicate with each other. The backend is written in Spring Boot with repository, service and web layers. The frontend is written in React. 
It communicates with BE through APIs which all accept and send json data.
### Entity models:
Korisnik - the main user entity
Hobbies - based on HobbiesEnum which the user has ManyToMany relationship (unidirectional)
Locations - based on LocationsEnum which the user has ManyToMany relationship (unidirectional)
Sports -  based on SportsEnum which the user has ManyToMany relationship (unidirectional)
MusicGenres -  based on MusicGenresEnum which the user has ManyToMany relationship (unidirectional)
Likes - entity made for keeping records of which user liked/plus ultra liked/disliked which user

### Repository:
there are repositories for all entity models defined above

### Service:
there are services for all entity models defined above
MatchService - additional service meant for calculating the percent of which one user matches with another user based on the hobbies, locations, sports and music genres they overlap

### Web
there are rest controllers for all entity models defined above
MatchController - additional controller for getting the percent of a match for users
