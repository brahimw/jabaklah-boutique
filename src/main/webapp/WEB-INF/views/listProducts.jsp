<div class="container">

    <div class="row">

        <!-- Would be to display sidebar -->
        <div class="col-md-3">
            <%@include file="share/sidebar.jsp" %>

        </div>

        <!-- to display the actual products -->
        <div class="col-md-9">

            <!-- Added breadcrumb component -->
            <div class="row">

                <div class="col-lg-12">
                    <c:if test="${userClickAllProducts == true}">
                        <script>
                            window.categoryId = '';
                        </script>

                        <ol class="breadcrumb">
                            <li><a href="/home">Acceuil</a></li>
                            <li class="active"><span>Tous les produits</span></li>
                        </ol>

                    </c:if>

                    <c:if test="${userClickCategoryProducts == true}">
                        <script>
                            window.categoryId = '${category.id}';
                        </script>
                        <ol class="breadcrumb">
                            <li><a href="/home">Acceuil</a></li>
                            <li class="active"><a href="#">Categorie</a></li>
                            <li class="active"><span>${category.name }</span></li>

                        </ol>
                    </c:if>
                </div>
            </div>


            <div class="row">

                <div class="col-xs-12">
                    <div class="container-fluid">
                        <div class="table-responsive">

                            <table id="productListTable"
                                   class="table table-striped table-borderd">

                                <thead>
                                <tr>
                                    <th></th>
                                    <th>nom</th>
                                    <th>Marque</th>
                                    <th>Prix</th>
                                    <th>Qte Disponible</th>
                                    <th></th>
                                </tr>
                                </thead>

                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
