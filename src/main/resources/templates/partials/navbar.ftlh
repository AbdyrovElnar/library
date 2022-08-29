<#macro renderWith title="" scripts=[] styles=[]>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
              crossorigin="anonymous">
        <link rel="stylesheet" href="/css/style.css">
        <title>Главная</title>
    </head>
    <body>

    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand">Книги</a>
            <div class="test">
                <div class="child2">
                    <a class="buttons-link" href="/">
                        <button class="buttons">Все книги</button>
                    </a>
                    <a class="buttons-link" href="/add/book">
                        <button class="buttons">Добавить книгу</button>
                    </a>
                </div>
            </div>
        </div>
    </nav>
    <#nested>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    </body>
    </html>
</#macro>