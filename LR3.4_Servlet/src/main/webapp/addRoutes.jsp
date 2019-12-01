<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="/showRoutes" method="post">
        <h3>Creating new route</h3>
        Enter the start of route:
        <input type="text" name="startCity" /><br>
        Enter the end of route:
        <input type="text" name="endCity" /><br>
        Enter the distance:
        <input type="text" name="distance" /><br>
        <input type="submit" value="Submit" />
    </form>

    <form action="/showBusOnRoute">
        <button type="submit">Back</button>
    </form>
</body>
</html>