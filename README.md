# CRM Campaign Management Platform 🚀

A full-stack CRM platform designed to manage marketing campaigns, customer segmentation, and delivery flow — built for the Xeno assignment.

## 🌐 Tech Stack

- **Backend:** Spring Boot, Spring Security, Spring Data JPA, Kafka
- **Frontend:** React (Vite + TailwindCSS)
- **Authentication:** Google OAuth2
- **Database:** MySQL
- **Messaging Queue:** Apache Kafka
- **State Management:** React Hooks & Context
- **Build Tool:** Maven

---

## ✨ Features

- ✅ Google Login with OAuth2
- ✅ Create marketing campaigns
- ✅ Segment customers based on rules (future scope)
- ✅ Kafka-based delivery pipeline
- ✅ Real-time logging of delivery outcomes (`SENT`, `FAILED`)
- ✅ Responsive UI
- ✅ Secure endpoints

---

## 📸 Screenshots

> Add 1–2 screenshots of login page and dashboard

---

## 🚀 Running the App

### 🧱 Backend Setup

1. Clone the repo
2. Create a MySQL database named `crm`
3. Update `application.yml` if needed:
   ```yaml
   spring.datasource.username=root
   spring.datasource.password=root
