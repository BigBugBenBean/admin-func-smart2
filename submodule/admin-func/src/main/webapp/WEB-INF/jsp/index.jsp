<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Smartics2(JSP) - Administrative Functions</title>
</head>
<body>
<div id="root"></div>

<script src="/admin_func/main/js/bundle.js"></script>
  <%
    if (request.getRequestURI().indexOf("/main/") > -1 ) {
    String moduleStr = request.getRequestURI().split("//")[1];
    moduleStr = moduleStr.split("/")[1];
  %>
  <script src="/admin_func/<%= moduleStr %>/js/bundle.js"></script>
  <div>Current module = <%= moduleStr %> </div>
  <%
    }
  %>
</body>
</html>