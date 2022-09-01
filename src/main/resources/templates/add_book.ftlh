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
                                                <label class="form-label required" for="name_input">Имя автора</label>
                                                <input name="name" type="text" id="name_input"
                                                       class="form-control form-control-lg" placeholder="Имя автора"
                                                       required="required"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <label class="form-label required" for="name_input">Название
                                                    книги</label>
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
                                                       required/>
                                            </div>
                                        </div>
                                    </div>

<#--                                    <div class="row">-->
<#--                                        <div class="col-md-6 mb-4">-->
<#--                                            <label class="form-label required" for="color_input">Баркод</label>-->
<#--                                            <div class="form-outline">-->
<#--                                                <input name="book.barcode" type="text"-->
<#--                                                       id="barcode_input"-->
<#--                                                       class="form-control form-control-lg" placeholder="Баркод"-->
<#--                                                       required/>-->

<#--                                            </div>-->

<#--                                        </div>-->
<#--                                        <div class="col-md-6 mb-4">-->
<#--                                            <div class="form-outline">-->
<#--                                                <button id="barcode" type="button">Сгенерировать баркод</button>-->
<#--                                            </div>-->
<#--                                        </div>-->
<#--                                    </div>-->

                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label required" for="password_input">Баркод</label>
                                            <div class="form-outline">
                                                <input name="barcode"  type="text"
                                                       id="barcode_input" class="form-control form-control-lg"
                                                        placeholder="Баркод" />
                                            </div>
                                        </div>
<#--                                        <div class="col-md-6 mb-4">-->
<#--                                            <button class="mt-5" id="barcode" type="button">Сгенерировать баркод</button>-->
<#--                                        </div>-->
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label required" for="categories">Жанр</label>
                                            <select class="form-control" name="category.id" id="categories">
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
                                                       required/>
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
                                                       required/>
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
    <script>
        const inputBarcode = document.getElementById("barcode_input")
        const barcode = document.getElementById("barcode")
        barcode.addEventListener("click", function () {
            inputBarcode.value = generateBarcode()
        })

        function generateBarcode() {
            let length = 8,
                charset = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz~!@-#$";
            if (window.crypto && window.crypto.getRandomValues) {
                return Array(length)
                    .fill(charset)
                    .map(x => x[Math.floor(crypto.getRandomValues(new Uint32Array(1))[0] / (0xffffffff + 1) * (x.length + 1))])
                    .join('');
            } else {
                let res = '';
                for (let i = 0, n = charset.length; i < length; ++i) {
                    res += charset.charAt(Math.floor(Math.random() * n));
                }
                return res;
            }
        }
    </script>
</@main.renderWith>