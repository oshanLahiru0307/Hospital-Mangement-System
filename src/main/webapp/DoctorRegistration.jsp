<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Document</title>
    <style>
    
       body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        form {
            width: 100%;
            max-width: 400px;
            padding: 20px;
            background-color: #f8f9fa;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 15px;
        }
        .btn-center {
            display: flex;
            justify-content: center;
        }
    </style>
</head>
<body>

        <form action="userController" method="post">

            <div class="form-group">
              	<label for="exampleInputName">Name</label>
              	<input type="text" class="form-control" id="exampleInputName"  placeholder="Enter name" name="name" value="${user.name}" required>
            </div>
            
           <div class="form-group">
              	<label for="exampleType">Type</label></br>
              		<select class="form-select" id="exampleType" aria-label="Default select example">
  						<option selected>Open this select menu</option>
						<option name="Gynecologist">Gynecologist</option>
  						<option name="Psychiatrist ">Psychiatrist</option>
  						<option name="Ophthalmologist">Ophthalmologist</option>
  						<option name="Oncologist">Oncologist</option>
  						<option name="Dermatologist">Dermatologist</option>
  						<option name="Family physician">Family physician</option>
  						<option name=Endocrinologist>Endocrinologist</option>
				</select>
            </div>
            
            <div class="form-group">
              	<label for="exampleInputEmail1">Email address</label>
              	<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email" value="${user.email}" required>
              	<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>   

            <div class="form-group">
              	<label for="exampleInputEmail1">Registraion ID</label>
              	<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter your registration number" name="email" value="${user.email}" required>
              	<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>                    
        
            <div class="form-group">
              	<label for="exampleInputPhone">Phone number</label>
              	<input type="tel" class="form-control" id="exampleInputPhone" placeholder="Enter Phone number" name="phone" value="${user.phone}" required>
            </div>
            
            <div class="form-group">
              	<label for="exampleInputPassword1">Password</label>
              	<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password" value="${user.password}" required>
            </div>

        	<div class="btn-center">
            	<button type="submit" class="btn btn-primary" name="submit">Sign up</button>
        	</div>
        	
         </form>

</body>
</html>