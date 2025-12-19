# Product Requirements Document (PRD): AutoAr

**Version:** 0.1 (MVP)  
**Status:** Draft / Initial Version

---

## 1. Product Goal

The goal of **AutoAr** is to digitize and automate internal HR and operational processes within small to medium-sized enterprises. The system empowers employees with self-service tools for task management and career documentation while providing management with centralized control over schedules and requests.

---

## 2. Problem Statement

Manual handling of employee requests and work assignments leads to several critical issues:

- **Information Silos:** Shift and leave communications are scattered across emails, messengers, and paper notes.
- **Efficiency Gaps:** Employees spend excessive time manually formatting CVs for internal reviews or role changes.
- **Lack of Transparency:** Employees cannot track request statuses in real time, resulting in repeated follow-ups.

---

## 3. Target Audience

- Small and medium-sized service businesses (cafes, logistics companies, retail stores)
- HR managers and department supervisors
- Operational employees working with flexible shifts or task-based schedules

---

## 4. User Roles

### Employee (Worker)
- Views available tasks and shifts
- Claims tasks from the job calendar
- Submits administrative requests (time off, internal requests)
- Generates and downloads a professional CV

### Manager / Admin
- Manages tasks and job calendar
- Reviews and approves employee requests
- Monitors overall workflow and task distribution

---

## 5. Core User Scenarios

### Task Acquisition
An employee logs into the system, opens the Jobs Calendar, selects an available task, and assigns it to themselves.

### Request Management
An employee submits a time-off request through the dashboard and receives an updated status once it is reviewed by a manager.

### CV Generation
An employee fills out a form with professional experience and skills and instantly downloads a formatted PDF CV.

---

## 6. Functional Requirements

| ID | Feature | Description |
|----|--------|-------------|
| FR-01 | User Authentication | Secure login for employees and managers |
| FR-02 | Jobs Calendar | Visual interface for viewing and claiming available tasks |
| FR-03 | Message / Request Center | Dashboard to submit requests and track their status |
| FR-04 | PDF CV Generator | Form-based CV creation with downloadable PDF output |
| FR-05 | Status Notifications | Visual indicators for new or updated requests |

---

## 7. Non-Functional Requirements

- **Usability:** Responsive UI accessible via modern web browsers
- **Performance:** PDF generation must complete in under 2 seconds
- **Security:** Users can only access their own data and requests
- **Reliability:** Tasks must be assigned atomically to prevent double booking

---

## 8. MVP Scope (Version 0.1)

- Employee and Manager dashboards
- Interactive job calendar with task assignment
- Request/message history with status filtering
- CV generation with PDF export (jsPDF)
- Light and dark theme support

---

## 9. Out of Scope (Future Backlog)

- AI-assisted CV text enhancement
- Mobile push notifications (SMS/Email planned for v2.0)
- Advanced analytics and payroll calculations
- Multi-language support

---

## 10. Acceptance Criteria

### Job Calendar
1. Users can view all available tasks  
2. Clicking “Take Task” updates the task status to `TAKEN` in the database  
3. Taken tasks are no longer visible to other employees  

### Message / Request Center
1. Users can filter requests by status (Pending, Approved, Rejected)  
2. New requests appear immediately after submission  

### CV Generator
1. The generated PDF contains all submitted form data  
2. The PDF filename includes the employee’s surname  
3. Text content wraps correctly without layout overflow  

---

