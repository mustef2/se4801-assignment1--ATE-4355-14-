
# se4801-assignment1--ATE-4355-14


Mustefa Meka
ATE/4355/14



##  What This Project Does

The system allows you to:

###  Manage Products

* Add new products
* View all products
* Get a product by ID
* Delete a product

###  Manage Orders

* Create an order with multiple products
* Automatically calculate the total price
* Generate a unique order number
* View all orders
* Get a specific order by ID
* Update order status (e.g., CONFIRMED, SHIPPED)



##  How It Is Built

The project follows a clean structure:

* **Controller Layer** → Handles API requests
* **Service Layer** → Contains business logic
* **Repository Layer** → Communicates with the database
* **DTO Layer** → Ensures clean API responses
* **Model Layer** → Defines database entities

---

##  Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* H2 Database (in-memory)
* Maven

---

##  How to Run the Project

1. Open the project in IntelliJ IDEA
2. Make sure Maven dependencies are installed
3. Run the main class:
   `ShopwaveApplication.java`
4. The application will start on:
   `http://localhost:8080`



##  Testing the API

You can use Postman to test the endpoints.

### Example Flow:

1. Create a product
2. Get all products
3. Create an order using product IDs
4. Retrieve orders
5. Update order status

---

##  Example Endpoints

### Products

* `POST /products`
* `GET /products`
* `GET /products/{id}`
* `DELETE /products/{id}`

### Orders

* `POST /orders`
* `GET /orders`
* `GET /orders/{id}`
* `PUT /orders/{id}/status?status=CONFIRMED`

---

## ⚠ Notes

* The system uses DTOs to avoid infinite JSON loops.
* Prices are handled using `BigDecimal` for accuracy.
* Basic exception handling is implemented for cleaner error responses.

Final Thoughts

This project helped me understand how a real backend system works, including how data flows between different layers and how APIs are designed.

---




>>>>>>> 14a5723 (every thing is tested and working without any error and bug)
