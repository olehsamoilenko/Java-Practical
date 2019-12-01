<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="/showBuses" method="post">
        <h3>Creating new bus</h3>
        Enter a numberplate:
        <input type="text" name="numberplate" />
        <input type="submit" value="Submit" />
    </form>

    <form action="/showBusOnRoute">
        <button type="submit">Back</button>
    </form>
</body>
</html>