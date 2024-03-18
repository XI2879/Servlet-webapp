<html>
<body>
 <h2>Feedback Form</h2>
    <form action="submit-feedback" method="post">
        <label for="name">Your Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="book">Book Name:</label>
        <input type="text" id="book" name="book" required><br>

        <label for="feedback">Feedback:</label><br><br>
        <textarea id="feedback" name="feedback" rows="5" cols="20" required></textarea><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
