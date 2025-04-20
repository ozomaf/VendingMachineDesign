# 🎯 Use Cases

---

## UC001 — Purchase Product

**Actor**: Customer  
**Precondition**: Machine is powered on, products are loaded.

### Main Flow:

1. Customer selects product (`selectProduct`).
2. System displays price (`showProductInfo`).
3. Customer inserts money (`insertMoney`).
4. System validates payment (`validateCashPayment`).
5. If funds are sufficient, system dispenses product (`dispenseProduct`).
6. System returns change (`returnChange`).
7. System reset session (`resetSession`).

### Alternative Flow:

- Insufficient funds → system shows error message.
- Product unavailable → system shows error message.

---

## UC002 — Restock Products

**Actor**: Administrator  
**Precondition**: Admin is authenticated.

### Main Flow:

1. Admin accesses control panel (`authenticate`).
2. Selects product to restock (`restock`).
3. Enters quantity.
4. System updates inventory.

### Alternative Flow:

- Invalid password → access denied.

---

## UC003 — Process Card Payment

**Actor**: Customer  
**Precondition**: Product selected, card payment supported.

### Main Flow:

1. Customer selects "Card Payment".
2. System processes payment (`processCardPayment`).
3. If successful → product is dispensed.
4. System reset session (`resetSession`).

### Alternative Flow:

- Card declined → system shows error message.

---

## UC004 — Collect Earnings

**Actor**: Administrator

### Main Flow:

1. Admin authenticates.
2. Selects "Collect Money" (`collectCash`).
3. System outputs amount and resets reserve.

### Alternative Flow:

- No money available → system notifies admin.