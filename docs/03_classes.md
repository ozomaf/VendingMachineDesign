# 🧩 Core Classes

---

## VendingMachine

**Description**: Main controller of the system

**Attributes**:

- `products: List<Product>` - list of products
- `balance: double` - user inserted money
- `cashReserve: double` - machine's cash reserve
- `selectedProduct: Product` - selected product
- `paymentProcessor: PaymentProcessor` - payment processor

**Methods**:

- `selectProduct(id: int): void`
- `insertMoney(amount: double): void`
- `dispenseProduct(): Product`
- `returnChange(): double`
- `showProductInfo(id: int): String`
- `resetSession(): void`

---

## Product

**Description**: Product in the vending machine

**Attributes**:

- `id: int` - unique identifier
- `name: String` - product name
- `price: double` - price
- `quantity: int` - quantity available

**Methods**:

- `isAvailable(): boolean`

---

## User

**Description**: System user

**Attributes**:

- `machine: VendingMachine` - reference to the vending machine

**Methods**:

- `chooseProduct(productId: int): void`
- `pay(amount: double): void`
- `takeProduct(): Product`
- `takeChange(): double`

---

## AdminPanel

**Description**: Administrator panel

**Attributes**:

- `password: String`
- `machine: VendingMachine`

**Methods**:

- `authenticate(password: String): boolean`
- `addProduct(newProduct: Product): void`
- `restock(productId: int, amount: int): void`
- `addCash(amount: double): void`
- `collectCash(): double`
- `viewStatistics(): String`

---

## PaymentProcessor

**Description**: Payment handler

**Attributes**:

- `acceptedCash: List<Double>`
- `cardPaymentEnabled: boolean`

**Methods**:

- `validateCashPayment(amount: double): boolean`
- `processCardPayment(price: double): boolean`
- `calculateChange(price: double, inserted: double): double`