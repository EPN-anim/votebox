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
    "propositions": [
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
    "propositions": [
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

##### `POST` : creates an election

* Body:
```json
  {"subject": "Comment ça va ?", 
  "propositions": 
    [{"description": "bien"},
    {"description": "bienbien"}
    ] }
```

* Result:
```json
  {"subject": "Comment ça va ?", 
  "propositions": 
    [{"description": "bien"},
    {"description": "bienbien"}
    ],
    "id": 42}
```


#### /election/{id} endpoint

`GET` and `PUT` method allowed.

#### /election/{id}/result endpoint

Retrieves an object describing election result. `items` is a map associating a `proposition id` to corresponding result:
- `majorityVoteResult`: sum of citizens who gave "true" to this proposition
- `scoringVoteResult`: sum of all scores for this proposition.

```json
{
  "items": {
    "1": {
      "majorityVoteResult": 1,
      "scoringVoteResult": 5
    }
  },
  "users": [
    "John"
  ]
}
```


#### Vote

##### `POST`: store votes for an user

```json
[
  {
      "selectedProposition": {
        "id": 1
       },
      "userName": "Filip",
      "majorityVote": "true",
      "scoreVote": 5
    },
    {
      "selectedProposition": {
        "id": 2
      },
      "userName": "Filip",
      "majorityVote": "false",
      "scoreVote": 2
    }
]
```

