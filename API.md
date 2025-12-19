```markdown
# API Specification - AutoAr System

## Base URL
`http://localhost:8080/api`

---

## 1. User Authentication

### Endpoint: /auth/login
**Method:** POST  
**Purpose:** Authenticate user and retrieve session token and role.  
**Request Body:**
```json
{
  "username": "worker_user",
  "password": "password123"
}

```

**Response:**

```json
{
  "status": "success",
  "token": "eyJhbGciOiJIUzI1Ni...",
  "role": "EMPLOYEE",
  "userId": 5
}

```

**Error Codes:**

* **401:** Unauthorized (Invalid credentials).

---

## 2. Jobs Calendar (Tasks)

### Endpoint: /tasks

**Method:** GET

**Purpose:** Retrieve a list of tasks.

**Parameters:** - `status` (optional): Filter by `AVAILABLE`, `TAKEN`, or `COMPLETED`.

**Response:**

```json
[
  {
    "id": 101,
    "title": "Evening Shift - Cashier",
    "taskDate": "2023-10-25",
    "status": "AVAILABLE",
    "description": "Handle customer transactions and closing reports."
  }
]

```

### Endpoint: /tasks/{id}/take

**Method:** POST

**Purpose:** Assign a specific task to the currently authenticated employee.

**Request Body:** None (Uses ID from URL and current session).

**Response:**

```json
{
  "message": "Task successfully assigned",
  "taskId": 101,
  "assignedTo": "worker_user"
}

```

**Error Codes:**

* **404:** Task not found.
* **409:** Conflict (Task is already taken by another user).

---

## 3. Requests Management

### Endpoint: /requests

**Method:** POST

**Purpose:** Submit a new administrative request (Time Off, Expense, IT Support).

**Request Body:**

```json
{
  "requestType": "Time Off",
  "description": "Doctor's appointment",
  "dateRequested": "2023-11-01"
}

```

**Response:**

```json
{
  "requestId": "REQ-007",
  "status": "PENDING",
  "submissionDate": "2023-10-20"
}

```

**Error Codes:**

* **400:** Bad Request (Missing required fields).

### Endpoint: /requests/my

**Method:** GET

**Purpose:** Retrieve all requests submitted by the current authenticated user.

**Response:**

```json
[
  {
    "requestId": "REQ-001",
    "type": "Time Off",
    "submittedDate": "2023-10-15",
    "status": "APPROVED"
  },
  {
    "requestId": "REQ-002",
    "type": "Expense Report",
    "submittedDate": "2023-10-18",
    "status": "PENDING"
  }
]

```

---

## 4. CV & Profile Data

### Endpoint: /profile/me

**Method:** GET

**Purpose:** Fetch the user's stored professional data to pre-fill the CV Generation form.

**Response:**

```json
{
  "firstName": "Alex",
  "lastName": "Johnson",
  "email": "alex.j@autoar.com",
  "phone": "+77071234567",
  "skills": ["Team Leadership", "Logistics"],
  "experience": "Previous work at Logistics Center for 2 years."
}

```

### Endpoint: /profile/update

**Method:** PUT

**Purpose:** Update user's professional information.

**Request Body:**

```json
{
  "skills": ["Customer Service", "POS Systems"],
  "experience": "Updated professional experience text..."
}

```

**Response:**

```json
{
  "status": "success",
  "message": "Profile updated successfully"
}

```
