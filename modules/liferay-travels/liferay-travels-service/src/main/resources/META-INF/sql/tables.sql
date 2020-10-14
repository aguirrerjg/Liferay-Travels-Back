create table LiferayTravels_Stage (
	uuid_ VARCHAR(75) null,
	stageId LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	place VARCHAR(75) null,
	image VARCHAR(75) null,
	tripId LONG
);

create table LiferayTravels_Trip (
	uuid_ VARCHAR(75) null,
	tripId LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	startingDate DATE null,
	image VARCHAR(75) null
);