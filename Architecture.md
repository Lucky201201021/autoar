# System Architecture - AutoAr

## 1. Architecture Style
**Chosen architecture style:** Layered (N-Tier) Architecture.

**Reason for this choice:** This style allows for a clear separation of concerns. By dividing the system into Presentation (UI), Business Logic (Services), and Data Access layers, we ensure the code is maintainable, testable, and easy to upgrade in the future.

## 2. System Components
**Short description of each component:**
- **Front end:** A responsive web interface built with HTML5, Tailwind CSS, and Vanilla JavaScript. It handles user interactions, form validations, and client-side PDF generation via jsPDF.
- **Back end:** A Spring Boot application (Java) that provides RESTful APIs. It handles business logic, security/authentication, and coordinates data between the UI and the database.
- **Database:** H2 (In-memory) for the MVP phase. It stores user profiles, job tasks, and request statuses. (Can be easily migrated to PostgreSQL for production).
- **External services:** - Google Fonts & Material Symbols (UI styling).
    - Future integration: Groq API or Google Gemini for AI-driven text enhancement.

## 3. Component Diagram
**Short description of how components interact:**
The User interacts with the **Front end** browser. The Front end sends JSON requests via Fetch API to the **Back end** (REST Controllers). The Back end processes these requests, communicates with the **Database** via Spring Data JPA, and returns the appropriate response. For CV generation, the Front end processes the data locally to create the PDF file.

## 4. Data Flow
**Explanation of data movement:**
1. **User Action:** User clicks "Take Task" on the Jobs Calendar.
2. **Request:** The Front end sends a POST request with the Task ID and Auth headers to the API.
3. **Processing:** The Back end validates the session, checks if the task is still available in the Database, and updates the task status to `TAKEN`.
4. **Response:** The Back end sends a 200 OK status back to the Front end.
5. **UI Update:** The Front end updates the table dynamically and shows a success notification (Toast).

## 5. Database Schema
**Main entities and relations:**
- **User:** Stores credentials and roles (Employee/Manager).
- **Task:** Stores job details (Title, Date, Description) and a Foreign Key to the User who claimed it.
- **Request:** Stores administrative requests (Type, Status, Submission Date) linked to a specific User.
- **Relation:** One-to-Many between User and Tasks; One-to-Many between User and Requests.

## 6. Technology Decisions
**Chosen technologies with short justification:**
- **Spring Boot:** Rapid development of production-ready APIs with built-in security.
- **Tailwind CSS:** Allows for fast UI development with a modern "utility-first" approach without writing custom CSS.
- **jsPDF:** Enables instant PDF generation on the client side, reducing server load and latency.
- **H2 Database:** Zero-configuration database for fast prototyping and easy testing during the MVP stage.

## 7. Future Extensions
**Possible future improvements:**
- **Persistent Database:** Moving from H2 to PostgreSQL for data durability.
- **AI Integration:** Implementing Groq Cloud API to automatically improve CV text quality.
- **File Storage:** Integration with AWS S3 for storing user-uploaded profile pictures.
- **Real-time Updates:** Using WebSockets for instant task status updates across different users.
