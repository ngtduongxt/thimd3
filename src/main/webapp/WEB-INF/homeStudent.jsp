<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5`.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"></script>
    <style>
        .nav-color {
            background-color: #0827e3;
        }

        .color-white {
            color: white;
        }

        .custom-btn {
            background-color: #03e88a;
            color: black;
        }

        .custom-btn:hover {
            background-color: yellow;
            border-color: yellow;
            color: black;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <nav class="navbar navbar-expand-lg nav-color">
                <a class="navbar-brand color-white" href="#">Logo</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link color-white" href="addStudent">Create <span
                                    class="sr-only">(current)</span></a>
                        </li>
                    </ul>
                    <form action="sortByName" method="get" class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="text" name="name" placeholder="Search by Name" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0 custom-btn" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
        <div class="col-12 mt-5">
            <table class="table table-striped na">
                <thead>
                <tr class="nav-color color-white">
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Date of Birth</th>
                    <th scope="col">Address</th>
                    <th scope="col">Email</th>
                    <th scope="col">Classroom</th>
                    <th scope="col">Acction</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${students}" var="s" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${s.name}</td>
                        <td>${s.birthDay}</td>
                        <td>${s.address}</td>
                        <td>${s.email}</td>
                        <td>${s.idClassroom.name}</td>
                        <td><a class="btn btn-warning" href="updateStudent?id=${s.id}">Update</a></td>
                        <td><a href="deleteStudent?id=${s.id}" onclick="return confirm('bạn có chắc chắn muốn xóa?')" class="btn btn-danger">Xóa</a></td>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
