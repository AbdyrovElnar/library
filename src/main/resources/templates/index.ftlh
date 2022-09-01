<#import "partials/navbar.ftlh" as main />
<@main.renderWith >
    <div class="row row-cols-1 row-cols-md-2 g-4">
     <#list books as book>
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">${book.title}</h5>
                    <p class="card-text">${book.description}</p>
                    <img src="/barcode/${book.barcode}" width="200" height="50">
                </div>
            </div>
            </#list>
        </div>
</@main.renderWith>