<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<body>

<div class="dropdown">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Sort By
    </button>

    <button type="button" class="btn btn-outline-primary" href="/home?page=${currentPage - 1}"><a href="/home?page=${currentPage - 1}">Prev</a></button>
    <button type="button" class="btn btn-outline-primary" href="/home?page=${currentPage + 1}"><a href="/home?page=${currentPage + 1}">Next</a></button>
    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        <a class="dropdown-item" href="/home?page=${currentPage}">Default</a>
        <a class="dropdown-item" href="/home?sort=date,desc&page=${currentPage}">By Date Descending</a>
        <a class="dropdown-item" href="/home?sort=answer,desc&page=${currentPage}">Unanswered </a>
        <a class="dropdown-item" href="/home?sort=solution,desc&page=${currentPage}"">No Solution</a>
    </div>
</div>
<div class="card" style="width: 80rem; float: none; margin: 0 auto 10px;">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Content</th>
            <th scope="col">Date</th>
            <th scope="col">Answer</th>
            <th scope="col">Solution</th>
        </tr>
        </thead>
        <tbody>
        <#list posts as post>
            <tr>
                <td>${post.id}</td>
                <td>${post.name}</td>
                <td>${post.content}</td>
                <td>${post.date}</td>
                <td>${post.answer?c}</td>
                <td>${post.solution?c}</td>
            </tr>
        </#list>

        </tbody>
    </table>
</div>


</body>
</html>