# Project PAO

This project simulates the activity of a car dealearship.

An individual client or a legal entity can buy cars from different dealearship stores. These clients can get a discount if they already own some cars from this dealearship.

A client can add and remove cars from the shopping cart and they can see the current price of the cars in the cart.

After they decide on which cars they want to buy, if they have enough money the cars will be removed from the store and moved to the client. Also a receipt will be printed for them with all the cars information, the total cost, the discount they get and other details.

## Structure

This project contains the following packages and classes:
* `car` package:
    * Car - contains `CarModel`, and other details about a car. It has overrided the `equals` method for checking if a car is or not in store;
    * CarModel - contains String name and model. This Class was implemented so there are no duplicates cars in the database. (Ie. There can be multiple Audi A4 with multiples color, or horsepower.);
* `client` package:
    * Client - Contains details about the client in general;
    * Individual - it extends the `client` class to calculate the Discount in a different way;
    * LegalEntity - it extends the `client` class to calculate the Discount in a different way;
* `services` package:
    * Receipt - contains a container with all the objects needed for a receipt and an Override `toString` method;
    * Review - contains a container with an object `Car`, an Object `client`, an integer for the number of stars, and a String for the actual review;
* `io` package:
    * `files` package:
        
        Contains all the csv files.

            * car, carModel, client are the files that provide the original input for the program;
            * receipt, review, log are the files the program writes to;
            The log file contains all the actions the user has made and a timestamp.
    * ReadCSV - is a `singleton` class used in the Service to read all the data for the main program to use;
    * WriteCSV - is a `singleton` class used in the Service to write all the data the user has requested;
    * LogCSV - get's a string with the information to write in the log.csv alon with the current date;
* ShoppingCart - contains an `Array of Cars` that the client added to the `Cart`;
* Store - contains an `Array of Cars` that are in the `Store` sorting them by the cost;
* ClientService - here the user can give a review or buy his cart;
* ShoppingService - contains all the actions an user can make to his cart;
* Service - contains all the action. Here are added the cars to the stores, are defined clients and shoping carts, from here you can add, remove to and from the `Store` and `Cart`. You can leave reviews for the cars or you can buy the cars in the shopping cart;

## Note

This is the second part of a three part project.
