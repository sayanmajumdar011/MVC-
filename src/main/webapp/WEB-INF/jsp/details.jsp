<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>BMI Calculator</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
</head>
<body>
<c:choose>
    <c:when test="${mode=='MODE_HOME'}">
        <div align="center" style="padding-top: 10%; padding-bottom: 10%">
            <form action="/results" method="POST">
                <h4>BMI Calculator</h4>
                <label>Enter Your Weight (in kg) </label>
                <input id="weight" required="required" type="text" name="weight" placeholder="Your weight in kilograms"/>
                <br/>
                <br/>
                <label>Enter Your Height (in cm) </label>
                <input id="height" required="required" type="text" name="height" placeholder="Your height in centimeters"/>
                <br/>
                <br/>
                <input type="submit" value="Check BMI"/>
            </form>
        </div>
    </c:when>
</c:choose>
</body>
</html>