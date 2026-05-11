# 🩸 Blood Donation Management System

> A Java-based desktop application for managing blood donors, recipients, and emergency requests — built with core Data Structures & Algorithms concepts.

![Java](https://img.shields.io/badge/Java-17%2B-red?style=flat-square&logo=java)
![SQLite](https://img.shields.io/badge/Database-SQLite-blue?style=flat-square&logo=sqlite)
![Swing](https://img.shields.io/badge/GUI-Java%20Swing-orange?style=flat-square)
![DSA](https://img.shields.io/badge/DSA-HashMap%20%7C%20Queue%20%7C%20LinkedList-green?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-lightgrey?style=flat-square)

---

## 📌 Overview

The **Blood Donation Management System** is a desktop application that streamlines the process of connecting blood donors with recipients. It features real-time blood type compatibility matching, emergency request prioritization, and donor eligibility validation — all powered by fundamental DSA concepts implemented from scratch.

---

## 🧠 Data Structures & Algorithms Used

| DSA Concept | Where It's Applied |
|---|---|
| `HashMap` | Blood type compatibility mapping (O(1) lookup) |
| `Queue (LinkedList)` | Emergency request handling (FIFO prioritization) |
| `LinkedList` | Donor donation history tracking |
| `ArrayList` | Dynamic donor & recipient listings from DB |

---

## ✨ Features

- 🔐 **Login System** — Secure authentication before accessing the dashboard
- 👤 **Donor Management** — Add, view, and track blood donors with full history
- 🏥 **Recipient Management** — Register and manage blood recipients
- 🔬 **Blood Compatibility Matching** — Instantly find compatible donors for any recipient using HashMap
- 🚨 **Emergency Queue** — Prioritize urgent blood requests using a Queue (FIFO)
- ✅ **Eligibility Checker** — Enforces the 90-day donation rule automatically
- 🗃️ **SQLite Persistence** — All data stored locally with no external server required
- 🖥️ **Modern Swing GUI** — Clean tabbed dashboard with a crimson-themed interface

---

## 🗂️ Project Structure

```
blood-donation-management-system/
├── src/
│   ├── main/
│   │   └── Main.java                  # Entry point, initializes DB tables
│   ├── model/
│   │   ├── Donor.java                 # Donor entity with LinkedList history
│   │   ├── Recipient.java             # Recipient entity
│   │   └── DonationRecord.java        # Donation record model
│   ├── dao/
│   │   ├── DBConnection.java          # SQLite connection handler
│   │   ├── DonorDAO.java              # Donor CRUD operations
│   │   └── RecipientDAO.java          # Recipient CRUD operations
│   ├── service/
│   │   ├── BloodCompatibility.java    # HashMap-based compatibility logic
│   │   ├── EmergencyQueue.java        # Queue-based emergency handling
│   │   └── EligibilityChecker.java    # 90-day donation rule checker
│   └── gui/
│       ├── LoginFrame.java            # Login screen
│       ├── ModernDashboard.java       # Main tabbed dashboard
│       ├── DonorPanel.java            # Donor management UI
│       ├── RecipientPanel.java        # Recipient management UI
│       ├── BloodMatchPanel.java       # Blood matching UI
│       └── EmergencyPanel.java        # Emergency queue UI
└── database/
    └── blood_bank.db                  # Auto-generated SQLite database
```

---

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- SQLite JDBC Driver (`sqlite-jdbc-3.x.x.jar`)
- IntelliJ IDEA (recommended) or any Java IDE

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/blood-donation-management-system.git
   cd blood-donation-management-system
   ```

2. **Open in IntelliJ IDEA**
   - File → Open → select the project folder
   - The `.idea/` config is included for convenience

3. **Add SQLite JDBC dependency**
   - Already configured under `.idea/libraries/sqlite_jdbc_3_49_1_0.xml`
   - If needed, download from [sqlite-jdbc releases](https://github.com/xerial/sqlite-jdbc/releases)

4. **Run the application**
   - Run `src/main/Main.java`
   - The SQLite database and tables are created automatically on first launch

---

## 🔬 DSA Implementation Details

### HashMap — Blood Compatibility (`BloodCompatibility.java`)
```java
compatibilityMap.put("AB+", Arrays.asList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"));
```
Blood type compatibility is stored in a `HashMap<String, List<String>>` for O(1) average-case lookup, making real-time matching efficient even at scale.

### Queue — Emergency Requests (`EmergencyQueue.java`)
```java
private Queue<String> emergencyRequests = new LinkedList<>();
```
Emergency blood requests are handled using a FIFO Queue to ensure the oldest/most critical requests are processed first.

### LinkedList — Donation History (`Donor.java`)
```java
private LinkedList<String> donationHistory = new LinkedList<>();
```
Each donor maintains a dynamic linked list of past donations, allowing efficient insertion and traversal.

---

## 📸 Screenshots

> _Add screenshots of your Login screen, Dashboard, and Blood Matching panel here._

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| GUI | Java Swing |
| Database | SQLite |
| DB Driver | sqlite-jdbc |
| IDE | IntelliJ IDEA |

---

## 🎓 Academic Context

This project was developed as a **Data Structures & Algorithms (DSA)** course project, demonstrating practical application of:
- Hash Maps for constant-time lookups
- Queues for priority-based request management
- Linked Lists for dynamic data management
- DAO design pattern for database abstraction

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

## 🙋‍♂️ Author

**Your Name**
- GitHub: [@your-username](https://github.com/vijayk176)
- LinkedIn: [your-linkedin](www.linkedin.com/in/vijay-kumar-682825315)

---

> _"Every drop counts. Every line of code matters."_ 🩸
