# 🌐 DNS System Design Simulator (Java)

A **Java-based simulation of the Domain Name System (DNS)** designed to demonstrate how domain names are resolved into IP addresses using a hierarchical architecture.

This project is built for **learning system design concepts** such as caching, distributed lookup, and request flow across multiple layers.

---

## 🚀 Overview

The Domain Name System (DNS) is the backbone of the internet, translating human-readable domain names like:

```
google.com → 142.250.183.14
```

This project simulates the **complete DNS resolution process**, including:

* Recursive DNS Resolver
* Root Server
* TLD Server
* Authoritative Server
* DNS Cache

---

## 🧠 How It Works

### 🔁 DNS Resolution Flow

```
Client → DNS Resolver → Root Server → TLD Server → Authoritative Server → IP Address
```

### Step-by-Step:

1. User requests a domain (`google.com`)
2. Resolver checks local cache
3. If not found:

    * Queries Root Server
    * Queries TLD Server (.com)
    * Queries Authoritative Server
4. Retrieves IP address
5. Stores result in cache
6. Returns IP to user

---

## 🏗️ Project Structure

```
dns-simulator/
 ├── DNSResolver.java
 ├── RootServer.java
 ├── TLDServer.java
 ├── AuthoritativeServer.java
 ├── DNSCache.java
 └── Main.java
```

---

## 💻 Implementation Details

### 🔹 DNS Resolver

* Handles the full resolution process
* Checks cache before querying servers

### 🔹 Root Server

* Redirects request to appropriate TLD server

### 🔹 TLD Server

* Routes request to authoritative server

### 🔹 Authoritative Server

* Stores actual domain → IP mappings

### 🔹 DNS Cache

* Stores resolved domains for faster lookup

---

## ▶️ Sample Output

```
First Request:
Cache Miss!
Root Server: Redirecting to TLD server...
TLD Server: Redirecting to Authoritative server...
Authoritative Server: Returning IP...
IP: 142.250.183.14

Second Request:
Cache Hit!
IP: 142.250.183.14
```

---

## ⚡ Key Concepts Demonstrated

* DNS Hierarchy (Root → TLD → Authoritative)
* Recursive Resolution
* Caching Mechanism
* Reduced Latency via Cache Hits
* Basic System Design Simulation

---

## 🧪 How to Run

### 1. Clone the Repository

```
git clone https://github.com/JosephKorivi/system-design.git
```

### 2. Compile the Code

```
javac *.java
```

### 3. Run the Program

```
java Main
```

---

## 📈 Future Improvements

Enhance this project with advanced features:

* ⏳ TTL-based cache expiration
* 🔀 Load balancing (multiple IPs per domain)
* 🧵 Multithreading support
* 🌐 REST API using Spring Boot
* 📊 Logging and monitoring
* 🧠 Distributed DNS simulation

---

## 🎯 Learning Outcomes

By building this project, you will understand:

* How DNS works internally
* How large-scale systems reduce latency
* Importance of caching in distributed systems
* Basics of system design architecture

---

## 🤝 Contributing

Feel free to fork this repository and improve the implementation. Contributions are welcome!

---

## 📢 Author

**Your Name**

* GitHub: [GITHUB](https://github.com/JosephKorivi)
* LinkedIn: [LINKEDIN](https://www.linkedin.com/in/josephkorivi/)

---

## ⭐ If You Found This Useful

Give this repo a star ⭐ and share it with others learning system design!
