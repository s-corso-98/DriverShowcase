# DriverShowcase
Vehicles and other stuffs e-commerce.

## HOW TO
To test the website you have to:
1) Connect to MySQL server in localhost using user:"root" pwd:"0000"
2) Create a database named "dbdrivershowcase"
3) Double click on the name of the database
4) Open a query tab(if is not opened)
5) Copy the queries contained in each .sql file and paste them in the query tab

## WEBSITE EXPLANATION
PAYMENT INTERFACE IS NOT IMPLEMENTED YET!
DATABASE IS NOT CRYPTED YET!

Not logged user:
- Check the marketplace
- Add something to the cart
- Proceed to the payment(^)

Logged user/company:
- Check the marketplace
- Add something to the cart
- Proceed to the payment(^)
- Add his products to the marketplace
- Delete one or more of his products (^)
- Check all of his products
- Receive news via email(^)

Admin:
- Check the marketplace
- Add something to the cart
- Proceed to the payment(will be implemented as soon as possible!)
- Add his products to the marketplace
- Delete one or more of his products(will be implemented as soon as possible!)
- Check all of his products
- Ban users

Filter system actually works only in 2 ways:
1. By using the "fascia di prezzo"(price range) option 
2. Starting from "marca"(brand) the filter starts to fill,checking the existing products with the selected parameters, the options 
till "anno"(year).
