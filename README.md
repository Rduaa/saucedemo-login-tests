# 🧪 Saucedemo Login Tests (Java + Selenium + TestNG)

![Java](https://img.shields.io/badge/Java-17-blue)
![Selenium](https://img.shields.io/badge/Selenium-4.25.0-green)
![TestNG](https://img.shields.io/badge/TestNG-7.10.2-orange)
![Maven](https://img.shields.io/badge/Maven-3.9+-yellow)
![Build Passing](https://img.shields.io/badge/Build-Passing-brightgreen)

---

## 📋 Project Overview
This project automates the login functionality testing of [SauceDemo](https://www.saucedemo.com/) using **Java 17**, **Selenium WebDriver**, **TestNG**, and **Maven**.

The framework follows the **Page Object Model (POM)** design pattern to ensure better readability, maintainability, and scalability of the test code.

---

## 🧱 Project Structure

saucedemo-login-tests/
├── pom.xml
├── testng.xml
├── README.md
├── src
│ ├── main
│ │ └── java
│ │ ├── driver
│ │ │ └── DriverManager.java
│ │ └── pages
│ │ ├── LoginPage.java
│ │ └── InventoryPage.java
│ └── test
│ └── java
│ └── tests
│ ├── BaseTest.java
│ └── LoginTests.java
└── target/
---


---

## ⚙️ Technologies Used
- **Language:** Java 17
- **Build Tool:** Maven
- **Testing Framework:** TestNG
- **Automation Framework:** Selenium WebDriver
- **Design Pattern:** Page Object Model (POM)

---

## 🔧 Setup & Execution

### Prerequisites
Make sure you have installed:
- Java 17+
- Maven 3.9+
- Latest version of Google Chrome and Mozilla Firefox

---

### Steps to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Rduaa/saucedemo-login-tests
   cd saucedemo-login-tests
   
Run tests via Maven:
mvn clean test

🧩 TestNG Configuration

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Saucedemo Login Suite" parallel="tests" thread-count="2">

    <test name="Chrome">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="tests.LoginTests"/>
        </classes>
    </test>

    <test name="Firefox">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name="tests.LoginTests"/>
        </classes>
    </test>

</suite>


✅ Implemented Test Cases

UC1: Verify error message when username and password fields are empty.

UC2: Verify error message when password is missing.

UC3: Verify successful login with valid credentials.

All test assertions are implemented using AssertJ, and logging is handled with SLF4J.

📊 Example Output

===============================================
Saucedemo Login Suite
Total tests run: 12, Passes: 12, Failures: 0, Skips: 0
===============================================
⚠️ Warnings

WARNING: Unable to find CDP implementation matching 141
This is not an error — it’s a Selenium informational message about Chrome DevTools version mismatch.
It has no impact on test execution or results.

👤 Author
Ruslan Duadze
📍 Batumi, Georgia
💬 Telegram: @ruslandua

📧 Email: ruslankavaziduadze@gmail.com

⭐ Check out more projects on [my GitHub profile](https://github.com/Rduaa)


