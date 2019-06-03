# Requirements
For building and running the application you need:

1. JDK 1.8
2. Maven 3
3. mysql 8.0.16

# add Sql Script
sql schema in location - **ProductDiscount/src/main/resources/db/SQL-Script.sql**


# Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.discount.ProductDiscount.ProductDiscountApplication class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

mvn spring-boot:run

# API specifications 
Check End-points in Postman

**a). Add Groups** 

/addGroup?groupName=Affiliated&percentage=10

**b). Add User**

   /addUser

add in Body, select type JSON(application/json) -

{"userName":"XYZ","type":"non-grocery","bill":"200","groupName":"Employee"}

**c). get discount by giving userName**

    /getDiscount/{userName}









