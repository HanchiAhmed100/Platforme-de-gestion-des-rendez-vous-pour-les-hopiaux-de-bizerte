<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/jquery-ui.min.css">
</head>
<body>
<input id="iDate">
</body>
<script src="js/jquery-2.1.1.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script type="text/javascript">
var unavailableDates = ["9-3-2012", "14-3-2012", "15-3-2012"];

function unavailable(date) {
    dmy = date.getDate() + "-" + (date.getMonth() + 1) + "-" + date.getFullYear();
    if ($.inArray(dmy, unavailableDates) == -1) {
        return [true, ""];
    } else {
        return [false, "", "Unavailable"];
    }
}

$(function() {
    $("#iDate").datepicker({
        defaultDate: new Date("3-1-2012"),
        dateFormat: 'dd MM yy',
        beforeShowDay: unavailable,
        minDate: new Date(2012, 1 - 1, 15)
    });

});

</script>
</html>