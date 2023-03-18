DROP DATABASE IF EXISTS carrentingapp;
create database carrentingapp;
use carrentingapp;

DROP TABLE IF EXISTS Insurance;
CREATE TABLE Insurance(
   contractNumber INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   coverage VARCHAR(50),
   conditions VARCHAR(50),
   price DOUBLE
);   

INSERT INTO Insurance (coverage, conditions, price) VALUES ("", "", 50);

DROP TABLE IF EXISTS Locations;
CREATE TABLE Locations(
   locationId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   name VARCHAR(50),
   image VARCHAR(250)
);   

INSERT INTO Locations (name, image) VALUES ("Paris", "/carrentingapp/img/Paris.png");
INSERT INTO Locations (name, image) VALUES ("London", "/carrentingapp/img/London.png");
INSERT INTO Locations (name, image) VALUES ("New York", "/carrentingapp/img/New_York.png");

DROP TABLE IF EXISTS Reviews;
CREATE TABLE Reviews(
   reviewId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   message VARCHAR(500),
   rental INT NOT NULL,
   user VARCHAR(100) NOT NULL,
   FOREIGN KEY(rental) REFERENCES Rental(rentalId),
   FOREIGN KEY(user) REFERENCES Users(email)
);   

INSERT INTO Reviews (message, rental, user) VALUES ("", 0, "balthazar.lebreton@gmail.com");

DROP TABLE IF EXISTS Rental;
CREATE TABLE Rental(
   rentalId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   startingDate DATE,
   endingDate DATE,
   mileage INT,
   validationOfficer VARCHAR(100) NOT NULL,
   car VARCHAR(50) NOT NULL,
   pickUpLocation INT NOT NULL,
   returnLocation INT NOT NULL,
   insurance INT,
   renter VARCHAR(100) NOT NULL,
   FOREIGN KEY(validationOfficer) REFERENCES Employees(email),
   FOREIGN KEY(car) REFERENCES Cars(registrationNumber),
   FOREIGN KEY(pickUpLocation) REFERENCES Locations(locationId),
   FOREIGN KEY(returnLocation) REFERENCES Locations(locationId),
   FOREIGN KEY(insurance) REFERENCES Insurance(contractNumber),
   FOREIGN KEY(renter) REFERENCES Users(email)
);   

INSERT INTO Rental (startingDate, endingDate, mileage, validationOfficer, car, pickUpLocation, returnLocation, insurance, renter) VALUES ("", "", 350, "balthazar.lebreton@gmail.com", "AC234RF", 0, 0, 0, "balthazar.lebreton@gmail.com");

DROP TABLE IF EXISTS Users;
CREATE TABLE Users(
   email VARCHAR(100),
   password VARCHAR(100) NOT NULL,
   firstName VARCHAR(100),
   lastName VARCHAR(100),
   PRIMARY KEY(email)
);   

INSERT INTO Users (email, password, firstName, lastName) VALUES ("balthazar.lebreton@gmail.com", "Baltha14", "Balthazar", "Lebreton");

DROP TABLE IF EXISTS Employees;
CREATE TABLE Employees(
   email VARCHAR(100),
   baseSalary DOUBLE,
   jobTitle VARCHAR(50),
   PRIMARY KEY(email),
   FOREIGN KEY(email) REFERENCES Users(email)
);   

INSERT INTO Employees (email, baseSalary, jobTitle) VALUES ("balthazar.lebreton@gmail.com", 1000000, "CEO");

DROP TABLE IF EXISTS Model;
CREATE TABLE Model(
   model VARCHAR(50),
   brand VARCHAR(50),
   dailyRate DOUBLE,
   numOfSeats INT,
   bootVolume INT,
   milePrice DOUBLE,
   additionalMilePrice DOUBLE,
   transmissionType VARCHAR(1),
   horsePower VARCHAR(50),
   type VARCHAR(50),
   PRIMARY KEY(model, brand)
);   

INSERT INTO Model (model, brand, dailyRate, numOfSeats, bootVolume, milePrice, additionalMilePrice, transmissionType, horsePower, type) VALUES ("Clio", "Renault", 100, 5, 350, 5, 25, "m", 75, "Compact");

DROP TABLE IF EXISTS Membership;
CREATE TABLE Membership(
   membershipType VARCHAR(50),
   price DOUBLE,
   additionalDiscount VARCHAR(50),
   PRIMARY KEY(MembershipType)
);   

INSERT INTO Membership (membershipType, price, additionalDiscount) VALUES ("Premium +", 49.99, 0.5);

DROP TABLE IF EXISTS DriverLicense;
CREATE TABLE DriverLicense(
   driverLicenseNumber VARCHAR(50),
   driver VARCHAR(100) NOT NULL,
   PRIMARY KEY(driverLicenseNumber),
   UNIQUE(driver),
   FOREIGN KEY(driver) REFERENCES Users(email)
);   

INSERT INTO DriverLicense (driverLicenseNumber, driver) VALUES ("000000000000", "balthazar.lebreton@gmail.com");

DROP TABLE IF EXISTS Members;
CREATE TABLE Members(
   email VARCHAR(100),
   discountLevel DOUBLE,
   membership VARCHAR(50),
   PRIMARY KEY(email),
   FOREIGN KEY(email) REFERENCES Users(email),
   FOREIGN KEY(membership) REFERENCES membership(membershipType)
);   

INSERT INTO Members (email, discountLevel, membership) VALUES ("balthazar.lebreton@gmail.com", 0.05, "Premium +");

DROP TABLE IF EXISTS Cars;
CREATE TABLE Cars(
   registrationNumber VARCHAR(50),
   mileage INT,
   location INT,
   model VARCHAR(50) NOT NULL,
   brand VARCHAR(50) NOT NULL,
   PRIMARY KEY(registrationNumber),
   FOREIGN KEY(location) REFERENCES Locations(locationId),
   FOREIGN KEY(model, brand) REFERENCES Model(model, brand)
);   

INSERT INTO Cars (registrationNumber, mileage, location, model, brand) VALUES ("AC234RF", 15000, 0, "Clio", "Renault");

DROP TABLE IF EXISTS Transaction;
CREATE TABLE Transaction(
   transactionId VARCHAR(50),
   status VARCHAR(50),
   amount DOUBLE,
   paidAmount DOUBLE,
   rental INT,
   debtor VARCHAR(100) NOT NULL,
   PRIMARY KEY(transactionId),
   FOREIGN KEY(rental) REFERENCES Rental(rentalId),
   FOREIGN KEY(debtor) REFERENCES Users(email)
);   

INSERT INTO Transaction (transactionId, status, amount, paidAmount, rental, debtor) VALUES ("ABC1234567", "Paid", 230, 230, 0, "balthazar.lebreton@gmail.com");

DROP TABLE IF EXISTS Photos;
CREATE TABLE Photos(
   accessLink VARCHAR(100),
   car VARCHAR(50) NOT NULL,
   PRIMARY KEY(accessLink),
   FOREIGN KEY(car) REFERENCES Cars(registrationNumber)
);   

INSERT INTO Photos (accessLink, car) VALUES ("AC234RF.png", "AC234RF");

DROP TABLE IF EXISTS Work;
CREATE TABLE Work(
   employee VARCHAR(100),
   location INT,
   PRIMARY KEY(employee, location),
   FOREIGN KEY(employee) REFERENCES Employees(email),
   FOREIGN KEY(location) REFERENCES Locations(locationId)
);   

INSERT INTO Work (employee, location) VALUES ("balthazar.lebreton@gmail.com", 0);

DROP TABLE IF EXISTS Move;
CREATE TABLE Move(
   employee VARCHAR(100),
   car VARCHAR(50),
   oldLocation INT,
   newLocation INT,
   moveDate DATE,
   PRIMARY KEY(employee, car, oldLocation, newLocation),
   FOREIGN KEY(employee) REFERENCES Employees(email),
   FOREIGN KEY(car) REFERENCES Cars(registrationNumber),
   FOREIGN KEY(oldLocation) REFERENCES Locations(locationId),
   FOREIGN KEY(newLocation) REFERENCES Locations(locationId)
);   

INSERT INTO Move (employee, car, oldLocation, newLocation, moveDate) VALUES ("balthazar.lebreton@gmail.com", "AC234RF", 0, 0, "");

DROP TABLE IF EXISTS Discount;
CREATE TABLE Discount(
   employee VARCHAR(100),
   car VARCHAR(50),
   discountLevel DOUBLE,
   startingDate DATE,
   endingDate DATE,
   PRIMARY KEY(employee, car),
   FOREIGN KEY(employee) REFERENCES Employees(email),
   FOREIGN KEY(car) REFERENCES Cars(registrationNumber)
);   

INSERT INTO Discount (employee, car, discountLevel, startingDate, endingDate) VALUES ("balthazar.lebreton@gmail.com", "AC234RF", 0.7, "", "");