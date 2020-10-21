create index IX_479687A4 on LiferayTravels_Stage (tripId);
create index IX_49421204 on LiferayTravels_Stage (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_216F4986 on LiferayTravels_Stage (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_943D8C93 on LiferayTravels_Trip (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_2AD61BD5 on LiferayTravels_Trip (uuid_[$COLUMN_LENGTH:75$], groupId);