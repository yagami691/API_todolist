
# 📘 Todolist API Documentation

## Base URL

```
http://localhost:8080/api/todolist
```

---

## 📋 Endpoints

### ▶️ 1. GET — Lire toutes les tâches

**URL**
```
GET /api/todolist
```

**Description**  
Récupère la liste complète des tâches.

**Réponse**
```json
[
  {
    "id": 1,
    "titre": "Réviser Lombok",
    "description": "Faire fonctionner les annotations avec IntelliJ",
    "status": "EN_COURS"
  },
  "..."
]
```

---

### 🔍 2. GET — Filtrer par statut

**URL**
```
GET /api/todolist/status?status=EN_COURS
```

**Paramètre**
- `status` (String) — `A_FAIRE`, `EN_COURS`, `TERMINE`

**Réponse**
```json
[
  {
    "id": 1,
    "titre": "Réviser Lombok",
    "description": "Faire fonctionner les annotations avec IntelliJ",
    "status": "EN_COURS"
  }
]
```

---

### ➕ 3. POST — Ajouter une nouvelle tâche

**URL**
```
POST /api/todolist
```

**Content-Type**
```
application/json
```

**Corps de la requête**
```json
{
  "titre": "Faire les courses",
  "description": "Acheter du lait, du pain et des œufs",
  "status": "A_FAIRE"
}
```

**Réponse**
```json
{
  "message": "Todolist added successfully"
}
```

---

### ✏️ 4. PUT — Mettre à jour une tâche

**URL**
```
PUT /api/todolist/{id}
```

**Paramètres (query)**
- `title` (facultatif)
- `description` (facultatif)
- `status` (facultatif)

**Exemple**
```
PUT http://localhost:8080/api/todolist/6
Content-Type: application/json

{
  "title": "Appeler le médecin",
  "description": "Prendre un rendez-vous pour un contrôle de routine",
  "status": "EN_COURS"
}
```

**Réponse**
```
200 OK
```

---

### ❌ 5. DELETE — Supprimer une tâche

**URL**
```
DELETE /api/todolist/{id}
```

**Exemple**
```
DELETE /api/todolist/5
```

**Réponse**
```
200 OK
```

---

## 🧾 Modèle de données

```json
{
  "id": Long,
  "titre": String,
  "description": String,
  "status": "A_FAIRE" | "EN_COURS" | "TERMINE"
}
```

---

## ℹ️ Notes

- Le champ `status` correspond à une énumération `Status`.
- La mise à jour (`PUT`) ne modifie que les champs fournis.
- Utilisez [Swagger UI](http://localhost:8080/swagger-ui/index.html) pour explorer l'API graphiquement.

---

### ✍️ Auteur
Projet réalisé par 

## Nkounga Moise
Projet réalisé avec Spring Boot, JPA, Lombok 
