# Project PAO

This project simulates the activity of a car dealearship.

An individual client or a legal entity can buy cars from different dealearship stores. These clients can get a discount if they already own some cars from this dealearship.

A client can add and remove cars from the shopping cart and they can see the current price of the cars in the cart.

After they decide on which cars they want to buy, if they have enough money the cars will be removed from the store and moved to the client. Also a receipt will be printed for them with all the cars information, the total cost, the discount they get and other details.

## Structure

This project contains the following classes:
* car.Car - contains `car.CarModel`, and other details about a car. It has overrided the `equals` method for checking if a car is or not in store;
* car.CarModel - contains String name and model. This Class was implemented so there are no duplicates cars in the database. (Ie. There can be multiple Audi A4 with multiples color, or horsepower.);
* client - Contains details about the client in general;
    * client.Individual - it extends the `client` class to calculate the Discount in a different way;
    * client.LegalEntity - it extends the `client` class to calculate the Discount in a different way;
* Receipt - contains a container with all the objects needed for a receipt and an Override `toString` method;
* Review - contains a container with an object `car.Car`, an Object `client`, an integer for the number of stars, and a String for the actual review;
* ShoppingCart - contains an `Array of Cars` that the client added to the `Cart`;
* Store - contains an `Array of Cars` that are in the `Store` sorting them by the cost;
* Service - contains all the action. Here are added the cars to the stores, are defined clients and shoping carts, from here you can add, remove to and from the `Store` and `Cart`. You can leave reviews for the cars or you can buy the cars in the shopping cart;

## Note

This is the first of a three stage project.
