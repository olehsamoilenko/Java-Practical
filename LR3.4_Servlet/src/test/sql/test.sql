SELECT * FROM Shedule
JOIN Bus ON Bus.id = Shedule.Bus
JOIN Route ON Route.id = Shedule.Route;