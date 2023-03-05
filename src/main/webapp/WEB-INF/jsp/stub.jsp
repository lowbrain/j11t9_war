<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" session="false" %>
<!doctype html>
<html lang="jp" class="h-100">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="./css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
  <title>Stub Page</title>
</head>
<body class="d-flex h-100">
  <div class="container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="mb-auto">
      <div>
        <h3 class="float-md-start mb-0">スタブページ</h3>
      </div>
    </header>
    <main class="px-3 row g-3">
      <div class="col-md-6">
        <label for="inputEmail4" class="form-label">Email</label>
        <input type="email" class="form-control" id="inputEmail4">
      </div>
      <div class="col-md-6">
        <label for="inputPassword4" class="form-label">Password</label>
        <input type="password" class="form-control" id="inputPassword4">
      </div>
      <div class="col-12">
        <label for="inputAddress" class="form-label">Address</label>
        <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
      </div>
      <div class="col-12">
        <label for="inputAddress2" class="form-label">Address 2</label>
        <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
      </div>
      <div class="col-md-6">
        <label for="inputCity" class="form-label">City</label>
        <input type="text" class="form-control" id="inputCity">
      </div>
      <div class="col-md-4">
        <label for="inputState" class="form-label">State</label>
        <select id="inputState" class="form-select">
          <option selected>Choose...</option>
          <option>...</option>
        </select>
      </div>
      <div class="col-md-2">
        <label for="inputZip" class="form-label">Zip</label>
        <input type="text" class="form-control" id="inputZip">
      </div>
      <div class="col-12">
        <div class="form-check">
          <input class="form-check-input" type="checkbox" id="gridCheck">
          <label class="form-check-label" for="gridCheck">
            Check me out
          </label>
        </div>
      </div>
      <button id="login" type="button" class="btn btn-primary">Stub Login</button>
    </main>
    <footer class="mt-auto">
      <form id="stub">
        <input id="item1" name="item1" type="hidden" value=""/>
        <input id="item2" name="item2" type="hidden" value=""/>
      </form>
    </footer>
  </div>
  <script>
    const loginBtn = document.getElementById("login");
    loginBtn.addEventListener("click", () =>{
      const item1 = document.getElementById("item1");
      item1.value="true";

      const item2 = document.getElementById("item2");
      item2.value='<?xml version="1.0" encoding="UTF-8"?><authtoken><userid>ユーザID</userid><timestamp>2023-03-05T18:27:41.904912347</timestamp></authtoken>';

      const stubForm = document.getElementById("stub");
      stubForm.action = "response";
      stubForm.method = "post";
      stubForm.submit();
    });
  </script>
</body>
</html>