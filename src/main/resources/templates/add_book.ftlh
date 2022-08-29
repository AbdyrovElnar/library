<#import "partials/navbar.ftlh" as main />
<@main.renderWith >
    <form action="/add/book" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <main class="main-color">
            <section class="h-100">
                <div class="container py-5 h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col">
                            <div class="card card-registration my-4">
                                <div class="card-body p-md-5 text-black">
                                    <h3 class="mb-4 text-uppercase text-center">Добавить книгу</h3>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <label class="form-label required" for="name_input">Название книги</label>
                                                <input name="title" type="text" id="name_input"
                                                       class="form-control form-control-lg" placeholder="Название книги"
                                                       required="required"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label required" for="price_input">Год</label>
                                            <div class="form-outline">
                                                <input name="year" type="number"
                                                       id="price_input"
                                                       class="form-control form-control-lg" placeholder="Год"
                                                       required="required"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label required" for="color_input">Описание</label>
                                            <div class="form-outline">
                                                <input name="description" type="text"
                                                       id="color_input"
                                                       class="form-control form-control-lg" placeholder="Описание"
                                                       required />
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label required" for="color_input">Баркод</label>
                                            <div class="form-outline">
                                                <input name="barcode" type="text"
                                                       id="color_input"
                                                       class="form-control form-control-lg" placeholder="Баркод"
                                                       required />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <select class="form-control" name="category.id" id="currency">
                                                <#list categories as с>
                                                    <option value="${с.id}">${с.name}</option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label required" for="color_input">Логин</label>
                                            <div class="form-outline">
                                                <input name="booking.username" type="text"
                                                       id="color_input"
                                                       class="form-control form-control-lg" placeholder="Логин"
                                                       required />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label required" for="color_input">Телефон</label>
                                            <div class="form-outline">
                                                <input name="booking.phone" type="number"
                                                       id="color_input"
                                                       class="form-control form-control-lg" placeholder="Телефон"
                                                       required />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="button">
                                        <button type="submit" class="btn btn-primary">Добавить</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>
    </form>
</@main.renderWith>