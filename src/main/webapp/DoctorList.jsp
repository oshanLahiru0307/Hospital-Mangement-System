<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
    <title>Document</title>
</head>

<body>
    <div class="container">
        <div class="topic">
            <h1>Doctor Details</h1>
        </div>
        <div>
            <button type="button" class="btn btn-primary my-3">
                <a class="text-light" href="user-form.jsp">Add user</a>
            </button>
            <table class="table table-hover">
                <thead class="table-primary">
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Type</th>
                        <th scope="col">Email</th>                        
                        <th scope="col">Phone</th>
                        <th scope="col">Password</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="doctor" items="${doctors}">
                        <tr>
                            <th scope="row">${doctor.name}</th>
                            <td>${doctor.name}</td>
							<td>${doctor.type}</td>
                            <td>${doctor.phone}</td>
                            <td>${doctor.email}</td>
							<td>${doctor.regid}</td>
                            <td>${doctor.phone}</td>
                            <td>
                                <button type="button" class="btn btn-primary">
                                    <a class="text-light" href="userController?action=edit&userId=${doctor.id}">Edit</a>
                                </button>
                                <button type="button" class="btn btn-danger">
                                    <a class="text-light" href="userController?action=delete&userId=${doctor.id}">Delete</a>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
