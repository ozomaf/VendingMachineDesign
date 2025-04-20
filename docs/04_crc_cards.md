# 🧩 CRC Cards

---

## VendingMachine

| **Responsibility**              | **Collaborators** |
|---------------------------------|-------------------|
| Product management              | Product           |
| Handling financial transactions | PaymentProcessor  |
| Interaction with user           | User              |
| Administration                  | AdminPanel        |

---

## Product

| **Responsibility**   | **Collaborators** |
|----------------------|-------------------|
| Storing product data | -                 |
| Availability check   | VendingMachine    |

---

## User

| **Responsibility**           | **Collaborators** |
|------------------------------|-------------------|
| Interaction with the machine | VendingMachine    |
| Making payments              | PaymentProcessor  |

---

## AdminPanel

| **Responsibility**   | **Collaborators**       |
|----------------------|-------------------------|
| Stock management     | Product, VendingMachine |
| Financial operations | VendingMachine          |
| Viewing statistics   | VendingMachine          |

---

## PaymentProcessor

| **Responsibility**      | **Collaborators** |
|-------------------------|-------------------|
| Payment validation      | -                 |
| Change calculation      | VendingMachine    |
| Card payment processing | -                 |