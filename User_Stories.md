# User Stories - AutoAr

## Story 1: Task Acquisition
**As an** Employee, **I want to** browse and claim available shifts in a calendar, **so I can** manage my own work schedule independently.

**Acceptance Criteria:**
- The calendar must display tasks with statuses: `AVAILABLE`, `TAKEN`, or `COMPLETED`.
- Clicking a "Take Task" button must instantly update the task status in the database.
- A claimed task must display the current user's name as the assignee.
- Users cannot claim a task that has already been taken by another employee.

## Story 2: Request Submission & Tracking
**As an** Employee, **I want to** submit digital requests for time off or support, **so I can** avoid using paper forms and track the approval progress.

**Acceptance Criteria:**
- There must be a form to select request type (e.g., Time Off, Expense) and add a description.
- Submitted requests must appear in a personal "All Messages" table.
- Each request must display a status badge: `PENDING`, `APPROVED`, or `REJECTED`.
- Users must be able to filter their request history by status.

## Story 3: Professional CV Generation
**As an** Employee, **I want to** generate a formatted PDF resume from my profile data, **so I can** easily apply for internal promotions or roles.

**Acceptance Criteria:**
- The system must provide a form to enter/edit skills, experience, and education.
- There must be an "Improve with AI" option to polish the professional summary.
- Clicking "Generate CV" must trigger an immediate download of a PDF file.
- The PDF layout must be professional, including contact info and experience sections.

## Story 4: Request Approval (Manager View)
**As a** Manager, **I want to** review pending employee requests, **so I can** approve or reject them based on company needs.

**Acceptance Criteria:**
- The manager dashboard must highlight "Pending" requests.
- Each request must have clear "Approve" and "Reject" actions.
- Changing a status must trigger a notification or visual update for the requesting employee.

## Story 5: Mobile Accessibility
**As a** Worker on the move, **I want to** access the portal via my smartphone, **so I can** check my tasks or submit requests from anywhere.

**Acceptance Criteria:**
- The UI layout must be responsive (adjusting from desktop to mobile screens).
- Navigation menus must be easily clickable on touchscreens.
- PDF generation must function on mobile browser environments.
