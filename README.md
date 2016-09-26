# _Sales Tracker_

### _Epicodus Java, Week 4 Advanced Java Topics: Monday &amp; Tuesday_

#### By _[**Caleb Stevenson**](https://github.com/CGrahamS) and [**Chance Neff**](https://github.com/crneff84)_

## Description

A webpage to tracks store inventory details and purchases.

## Specs

| BEHAVIOR                                         | INPUT                                                                                | OUTPUT                                                                              |
|--------------------------------------------------|--------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------|
| Program creates product entries                  | Product: Sunglasses  * Price: $50 * Description: Polarized-Waterproof * Quantity: 20 | Product: Sunglasses * Price: $50 * Description: Polarized-Waterproof * Quantity: 20 |
| Program updates product entries                  | Product: Sunglasses* Price: $40* Description: Polarized* Quantity: 20                | Product: Sunglasses* Price: $40* Description: Polarized* Quantity: 20               |
| Program deletes product entries                  | DELETE: Sunglasses                                                                   |                                                                                     |
| Program reduces quantity of product when bought. | Product: Sunglasses* Price: $40* Description: Polarized* Quantity: 20                | Product: Sunglasses* Price: $40* Description: Polarized* Quantity: 19               |

## Setup/Installation Requirements

* In your first terminal window:
  * Start postgres: `$ postgres`
* In your second terminal window:
  * Start psql: `$ psql`
  * Create database: `# CREATE DATABASE database_name;`
* In your third terminal window:
  * Clone this repository to your desktop: `$ cd Desktop; git clone https://github.com/CGrahamS/reponame`
  * Navigate to the hair-salon directory: `$ cd dir-name`
  * Create database schema from hair_salon.sql: `$ psql database_name < database_name.sql`
* Back in your second terminal window:
  * Confirm the database has been restored correctly:
    * Connect to hair_salon database: `# \c database_name;`
    * Print out database tables: `# \dt;`
    <br>
    NOTE: You should see `stylists` and `clients` tables in the `database_name` database.
* Back in your third terminal window:
  * Run the server: `$ gradle run`
* In the browser of your choosing, navigate to "localhost:4567" (tested in Chrome).

## Known Bugs

none

## Support and contact details

Caleb Stevenson: _cgrahamstevenson@gmail.com_
Chance Neff: _crneff84@gmail.com_

## Technologies Used

_Java,
Spark,
Velocity,
SQL_

### License

This webpage is licensed under the GPL license.

Copyright &copy; 2016 **_Caleb Stevenson and Chance Neff_**
