# AutoAr — Employee Portal MVP

## 📝 Product Overview

**AutoAr** is an internal corporate platform designed to streamline interaction between employees and administration. The portal allows employees to manage work schedules, request time off, generate professional CVs, and track the status of their requests in real time.

---

## 🎯 Problem & Solution

### The Problem

In small and medium-sized companies, HR processes are often fragmented and inefficient:

- Time-off requests get lost in emails or messengers
- Employees do not have a unified task or job calendar
- Creating up-to-date CVs for internal mobility is time-consuming

### The Solution

AutoAr centralizes these workflows by providing:

- **Unified Dashboard** — all notifications and request statuses in one place
- **Job Calendar** — transparent task and shift selection for employees
- **CV Engine** — instant PDF resume generation based on profile data

---

## 👥 Target Users

- **Employees (Workers)**  
  Select tasks from the calendar, submit requests, and generate CVs.

- **Managers / Admins**  
  Review and approve requests, manage tasks and schedules.

---

## 💻 Tech Stack

- **Backend:** Java 17+, Spring Boot 3.4.1, Spring Security
- **Frontend:** HTML5, Tailwind CSS (CDN), Vanilla JavaScript
- **Database:** H2
- **PDF Generation:** jsPDF (client-side)
- **Icons:** Google Material Symbols

---

## 🚀 Local Setup

### System Requirements

- Java JDK 17 or higher
- Maven 3.6+
- Modern web browser (Chrome, Firefox, Edge)

### Installation & Run

1. **Clone the repository**
```bash
git clone https://github.com/your-username/autoar.git
cd autoar

2. **Configure application properties
spring.datasource.url=jdbc:h2:mem:autoardb
spring.h2.console.enabled=true

mvn spring-boot:run

http://localhost:8080

mvn test

http://localhost:8080/swagger-ui.html

autoar/
├── src/
│   ├── main/
│   │   ├── java/com/autoar/        # Controllers, Services, Models
│   │   ├── resources/
│   │   │   ├── static/             # JS, CSS, assets
│   │   │   ├── templates/          # HTML pages
│   │   │   └── application.properties
│   └── test/                       # Unit & integration tests
├── docs/                           # Project documentation
├── pom.xml                         # Maven configuration
└── README.md


