# 📌 Vending Machine Requirements

---

## Functional Requirements

### Product Management

- The system shall allow adding new products (AdminPanel).
- The system shall allow restocking existing products (AdminPanel).
- The system shall display product information (VendingMachine).

### Payment Operations

- The system shall accept cash payments (PaymentProcessor).
- The system shall support card payments (PaymentProcessor).
- The system shall return change (VendingMachine).

### User Interaction

- The user shall be able to select a product (User → VendingMachine).
- The user shall be able to insert money (User → VendingMachine).
- The user shall receive purchased products (VendingMachine → User).
- The user shall receive change (VendingMachine → User).

### Administration

- The administrator shall access sales statistics (AdminPanel).
- The administrator shall top up cash reserve (AdminPanel).
- The administrator shall collect money from the machine (AdminPanel).

---

## Non-Functional Requirements

### Performance

- Product dispensing operation shall complete within **3 seconds**.
- Card payment processing shall complete within **3 seconds**.

### Security

- Admin panel access shall be password-protected.
- Payment data shall be stored encrypted.

### Reliability

- The system shall maintain state after reboot (persist product/money data).
- Money input errors shall not cause financial loss.

### Usability

- The interface shall be intuitive.
- Error messages shall be clear (e.g., "Insufficient funds").