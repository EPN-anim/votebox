# votusOperandi API

## Install and launch

Launch `org.votusoperandi.Application` from your IDE or `mvn spring-boot:run` from command line.

### API Doc

#### /election endpoint

##### `GET` : Retrieves the list of all elections

```json
[
  {
    "id": 1,
    "subject": "Quel est votre couleur préférée ?",
    "options": [
      {
        "id": 1,
        "description": "noir",
        "new": false
      },
      {
        "id": 2,
        "description": "marron",
        "new": false
      }
    ],
    "new": false
  },
  {
    "id": 2,
    "subject": "Quel est votre candidat-e préféré-e ?",
    "options": [
      {
        "id": 5,
        "description": "Jacques",
        "new": false
      },
      {
        "id": 6,
        "description": "Nadine",
        "new": false
      }
    ],
    "new": false
  }]
  
``` 

#####`POST` : creates an election

* Body:
```json
  {"subject": "Comment ça va ?", 
  "options": 
    [{"description": "bien"},
    {"description": "bienbien"}
    ] }
```

* Result:
```json
  {"subject": "Comment ça va ?", 
  "options": 
    [{"description": "bien"},
    {"description": "bienbien"}
    ],
    "id": 42}
```
