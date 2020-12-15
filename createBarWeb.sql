create database barWeb;

Use barWeb;
create table drinkers(userId INT NOT NULL AUTO_INCREMENT,
   firstName VARCHAR(40) NOT NULL,
   lastName VARCHAR(40) NOT NULL,
   createdDate DATE NOT NULL,
   PRIMARY KEY (userId)
);

Use barWeb;
create table beers(beerId INT NOT NULL AUTO_INCREMENT,
	userId INT NOT NULL,
	dateDrank DATE NOT NULL,
    PRIMARY KEY (beerId),
    FOREIGN KEY (userId) REFERENCES drinkers(userId)
);

Use barWeb;
create table poolGames(gameId INT NOT NULL AUTO_INCREMENT,
	shooterOne INT NOT NULL,
    shooterTwo INT NOT NULL,
    winner INT NOT NULL,
    gameDate DATE NOT NULL,
    PRIMARY KEY (gameId),
    FOREIGN KEY (shooterOne) REFERENCES drinkers(userId),
    FOREIGN KEY (shooterTwo) REFERENCES drinkers(userId),
    FOREIGN KEY (winner) REFERENCES drinkers(userId)
);