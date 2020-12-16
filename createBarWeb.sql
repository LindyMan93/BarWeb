create database barWeb;

Use barWeb;
create table Drinkers(userId INT NOT NULL AUTO_INCREMENT,
   firstName VARCHAR(40) NOT NULL,
   lastName VARCHAR(40) NOT NULL,
   createdDate DATE NOT NULL,
   PRIMARY KEY (userId)
);

Use barWeb;
create table Beers(beerId INT NOT NULL AUTO_INCREMENT,
	userId INT NOT NULL,
	dateDrank DATE NOT NULL,
    PRIMARY KEY (beerId),
    FOREIGN KEY (userId) REFERENCES Drinkers(userId)
);

Use barWeb;
create table PoolGames(gameId INT NOT NULL AUTO_INCREMENT,
	shooterOne INT NOT NULL,
    shooterTwo INT NOT NULL,
    winner INT NOT NULL,
    gameDate DATE NOT NULL,
    PRIMARY KEY (gameId),
    FOREIGN KEY (shooterOne) REFERENCES Drinkers(userId),
    FOREIGN KEY (shooterTwo) REFERENCES Drinkers(userId),
    FOREIGN KEY (winner) REFERENCES Drinkers(userId)
);