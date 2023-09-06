<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body>
<div class="container">
  <form action="updateStudent?id=${student.id}" method="post">
    <div class="form-row">
      <div class="form-group col-md-6">
        <label for="name" >Name</label>
        <input name="name" value="${student.name}" type="text" class="form-control" id="name" placeholder="Nhập tên" required>
      </div>
      <div class="form-group col-md-6">
        <label for="birthDay">Date of Birth</label>
        <input name="birthDay" value="${student.birthDay}" type="date" class="form-control" id="birthDay" required>
      </div>
    </div>
    <div class="form-group">
      <label for="address">Address</label>
      <input name="address" value="${student.address}" type="text" class="form-control" id="address" placeholder="Nhập địa chỉ" required>
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <input name="email" value="${student.email}" type="text" class="form-control" id="email" placeholder="Vui lòng nhập Email" required>
    </div>
    <div class="form-row">
      <div class="form-group col-md-4">
        <label for="classid">Class</label>
        <select name="classid" id="classid" class="form-control" required>
          <option value="1">c02</option>
          <option value="2">c03</option>
          <option value="3">c04</option>
          <option value="4">c05</option>
        </select>
      </div>
    </div>
    <div class="form-group">
    </div>
    <div class="row justify-content-between">
      <button type="submit" class="btn btn-primary">Update Student</button>
    </div>
  </form>
</div>
</body>
</html>
