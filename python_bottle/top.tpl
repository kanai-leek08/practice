<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <title>プロフィール</title>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
</head>

<body>
  <nav class="navbar bg-light">
    プロフィール
  </nav>
  <br />
  <div class="container">
    <table class="table">
      <tbody>
        <tr>
          <td>名前</td>
          <td>{{user['name']}}</td>
        </tr>
        <tr>
          <td>会社</td>
          <td>{{user['company_name']}}</td>
        </tr>
        <tr>
          <td>出身</td>
          <td>{{user['birth_place']}}</td>
        </tr>
        <tr>
          <td>在住</td>
          <td>{{user['address']}}</td>
        </tr>
        <tr>
          <td>趣味</td>
          <td>{{user['hobby']}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</body>

</html>