# Room Manager API
Project for Digital Innovation One's Java Developer Bootcamp.

Este repositório foi criado inteiramente com Java e Spring Boot, tendo como objetivo a implementação de uma api de controle e gerenciamento de salas.
A ideia inicialmente se tratava de salas físicas para alocação, mas adaptei para salas virtuais, onde existem diversas salas marcadas no horário.

Ainda pretendo implementar link para o Zoom e talvez um mecanismo de Session, para que possa guardar os eventos por pessoa. Então mais coisa vem por aí.
#Ok, mas o que eu posso fazer com isso?

A API ela possui a arquitetura essencial de uma API CRUD, me atrevi a fazer o deployment no Heroku, pra ter uma fácil implementação e deixar disponível.
A URL da API é:
```
https://dc143c-room-manager.herokuapp.com/api/v1/rooms
```
e é por ela, que nossa API funciona em maior parte das requisições.
A criação é realizada por um ```POST```, que tem em seu corpo o seguinte formato:

```
{
	"name": "Zoom Meeting Room",
	"date": "23/09/2021",
	"startHour": "20h15",
	"endHour": "22h35"
}
```

A atualização é realizada por um ```PUT```, que tem em seu corpo o seguinte formato:
```
{
  "id": 1,
	"name": "Zoom Meeting Room",
	"date": "23/09/2021",
	"startHour": "20h15",
	"endHour": "22h35"
}
```
Tendo o id também sendo passado como parâmetro na URL.

A deleção é realizada por um ```DELETE```, que tem como parâmetro, o id em URL.

A filtragem é realizada por um ```POST``` como:
```https://dc143c-room-manager.herokuapp.com/api/v1/rooms/1```
que tem como parâmetro, o id em URL.

Mas esse projeto não acaba por aqui! ^^
Este projeto tem um front!
```
https://github.com/dc143c/room-manager-front
```
