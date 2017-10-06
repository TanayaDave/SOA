Group Number 9
Srikant Jesu A20391864
Manish Viswakarma A20392409
Tanaya Dave A20355619

Entities 

1. Trucks
2. Drivers
3. Maintenance records
4. Tickets
5. Payments
6. Vehicles
7. Customer
8. Locations
9. Orders
10. Invoices
11. Pricing
12. Comments
13. Transactions
14. Employees
15. Expenses

Cardinality

Truck - Driver  	1:M
Truck - Maintenance	1:M
Driver - Tickets	1:M
Order - Location	1:1
Customer - Order	1:M
Location - Pricing	1:1
Order - Invoice		1:1
Order - Payment		1:1
Truck - Order		1:M
Order - Vehicle		1:M
Driver - Employee	1:1
Customer - Comment	1:1