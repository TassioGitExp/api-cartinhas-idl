# Players documention

# Get All Players

Obter dados de todos os jogadores

**URL** : `/player/get-all`

**Método** : `GET`

### Sucesso

**Código** : `200 OK`

**Conteúdo** : É retornado uma lista contendo os dados de todos os 
jogadores disponíveis

**Obs**: Número de vitórias e derrotas dos times estão desatualizados

```json
[
  {
    "id": "b0f8daae",
    "name": "Leonardo Souza",
    "nickname": "Robo",
    "country": "Brazil",
    "role": "TOP",
    "team": {
      "id": "30b4923e",
      "name": "LOUD",
      "wins": 21, //DESATUALIZADO
      "loses": 9, //DESATUALIZADO
      "playerList": [
        "b0f8daae",
        "a472573e",
        "26335127",
        "bb98d084",
        "c414044e",
        "c29c608b"
      ]
    }
  },
  {...},
]
```

# Get Player by ID

Obter dados de um jogador específico

**URL** : `/player/get/{player-id}`

**Método** : `GET`

### Sucesso

**Código** : `200 OK`

**Conteúdo** : É retornado os dados de um jogador específico

**Obs**: Número de vitórias e derrotas dos times estão desatualizados

```json
{
  "id": "b0f8daae",
  "name": "Leonardo Souza",
  "nickname": "Robo",
  "country": "Brazil",
  "role": "TOP",
  "team": {
    "id": "30b4923e",
    "name": "LOUD",
    "wins": 21, //DESATUALIZADO
    "loses": 9, //DESATUALIZADO
    "playerList": [
      "b0f8daae",
      "a472573e",
      "26335127",
      "bb98d084",
      "c414044e",
      "c29c608b"
    ]
  }
}
```

# Get Player Ratings by Player ID

Obter os pontos de um jogador específico

**URL** : `/player/get-all-player-ratings-by-player-id/{playerId}`

**Método** : `GET`

### Sucesso

**Código** : `200 OK`

**Conteúdo** : É retornado os dados de um jogador específico

**Obs**: Número de vitórias e derrotas dos times estão desatualizados

```json
{
  "playerId": "b0f8daae",
  "playerNick": "Robo",
  "team": {
    "id": "30b4923e",
    "name": "LOUD",
    "wins": 21,
    "loses": 9,
    "playerList": [
      "b0f8daae",
      "a472573e",
      "26335127",
      "bb98d084",
      "c414044e",
      "c29c608b"
    ]
  },
  "playerPoints": [76, 68, 69, 85, 67, 66, 78],
  "avgPoints": 72
}
```

# Get All Players Ratings of Team

Obter os pontos de todos os jogadores em todas as semanas

**URL** : `/player/get-all-player-ratings-by-player-id/{teamId}`

**Método** : `GET`

### Sucesso

**Código** : `200 OK`

**Conteúdo** : É retornado uma lista contendo as pontuações de todos os jogadores em todas as semanas, organizados por time

```json
[
  {
    "weekNumber": 1,
    "teams": [
      {
        "teamId": "2d0edcd2",
        "teamName": "Fluxo",
        "players": [
          {
            "playerId": "d05bec17",
            "playerNick": "Kiari",
            "playerCountry": "Brazil",
            "playerRole": "TOP",
            "playerPoints": 93,
            "playerAvgPoints": 93
          },
          {...},
        ]
      },
      {...},
    ]
  }
]
```

# Get All Players Ratings of All Weeks

Obter os pontos de todos os jogadores em todas as semanas

**URL** : `/player/get-ratings-from-every-week`

**Método** : `GET`

### Sucesso

**Código** : `200 OK`

**Conteúdo** : É retornado uma lista contendo as pontuações de todos os jogadores em todas as semanas, organizados por time

```json
[
  {
    "weekNumber": 1,
    "teamList": {
      "LOUD": [
        {
          "playerId": "a472573e",
          "playerNick": "Croc",
          "playerCountry": "South Korea",
          "playerRole": "JUNGLE",
          "playerPoints": 78,
          "playerAvgPoints": 78,
          "playerMaxPoints": {
            "weekNumber": 4,
            "points": 80
          },
          "playerMinPoints": {
            "weekNumber": 7,
            "points": 50
          }
        },
        {...},
      ],
      "TEAM": [...],
    }
  },
  {...},
]
```

# Get All Players Ratings of Week

Obter os pontos de todos os jogadores em uma semana específica

**URL** : `/player/get-ratings-from-week/{weekNumber}`

**Método** : `GET`

### Sucesso

**Código** : `200 OK`

**Conteúdo** : É retornado uma lista contendo as pontuações de todos os jogadores em uma semana específica, organizados por time

```json
{
  "weekNumber": 1,
  "teamList": {
    "LOUD": [
      {
        "playerId": "a472573e",
        "playerNick": "Croc",
        "playerCountry": "South Korea",
        "playerRole": "JUNGLE",
        "playerPoints": 78,
        "playerAvgPoints": 78,
        "playerMaxPoints": {
          "weekNumber": 4,
          "points": 80
        },
        "playerMinPoints": {
          "weekNumber": 7,
          "points": 50
        }
      },
      {...},
    ],
    "TEAM": [...],
  }
}
```

