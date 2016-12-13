SELECT Country.CountryID, Country.Name, SUM(City.Population) FROM Country
LEFT JOIN City ON City.CountryID = Country.CountryID
GROUP BY Country.CountryID
HAVING SUM(City.Population) > 400

SELECT Country.Name, COUNT(Building.BuildingID) FROM Country
LEFT JOIN City ON City.CountryID = Country.CountryID
LEFT JOIN Building ON Building.CityID = City.CityID
GROUP BY Country.CountryID
HAVING COUNT(Building.BuildingID) = 0
