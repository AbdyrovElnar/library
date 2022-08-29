<#import "partials/navbar.ftlh" as main />
<@main.renderWith >
    <div class="row row-cols-2 row-cols-xl-4 row-cols-lg-3 row-cols-md-2 row-cols-sm-1 g-4">
<#--        <#list books as book>-->
            <div class="col">
                <div class="card h-100">
                    <img src="images/" class="card-img-top" alt="">
                    <div class="card-body buttons text-center">
                        <button type="button" class="btn btn-primary text-uppercase buttons">Graphics</button>
                        <h5 class="card-title text-uppercase sub-title-3 text-center">Round Icons Design</h5>
                    </div>
                </div>
            </div>
<#--        </#list>-->
    </div>
</@main.renderWith>