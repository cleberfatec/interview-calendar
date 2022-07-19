<h4 align="center"> 
	🚧    🚀 Under construction...  🚧
</h4>

# Getting Started

Run the application as java application throw br.com.interview.InterviewApplication 

When starting Spring Boot, devtools is enable which means that in developing environment is not necessary to stop start all the time.

The configured port is 8080.

The project is set to create the table and run the file data.sql in order to populate the database.

### Business

In order to register the slot, it´s important the the user being register first

1) First register candidate or interviewer by passing Persons id and name
2) Register the slot by passing the following:
{
	"personId": 2,
	"initTime": "13:00",
	"endTime": "14:00",
	"slotDate": "2022-07-23",
	"repeat": false,
	"repeatEveryday" : false,
	"repeatEveryweek" : false
}

Check swagger api documentation to learn more about it.

3) query possible interviews  

### Features

- [x] Register Candidate
- [x] Register Interviewer
- [x] Register Slot
- [  ] Query possible interviews


### API Documentation with Swagger 


* [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html/)

### Database H2 Console

* [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

### Postman collection

You can import postman collection throw the file in postman folder: interview calendar api.postman_collection.json

### Unit test

Unit test was implemented for all some EndPoints