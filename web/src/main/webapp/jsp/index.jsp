<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Rent A Car</title>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet">
    <style>
        /* NOTE: The styles were added inline because Prefixfree needs access to your styles and they must be inlined if they are on local disk! */
        @import url(https://fonts.googleapis.com/css?family=Montserrat:400,700|Josefin+Sans:400,600,700,400italic,600italic);
    </style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
</head>

    <body>
        <div class="hero">
             <div class="hero-inner">
                  <div class="hero-title">
                      <h1 class="text-light title font-2">Rent A Car</h1>
                             <p class="text-capitalize text-light">here starts awesomeness</p>
                  </div>
                           <a href="#" class="sd">Let's GO!</a>
             </div>

        </div>

         <%@ include file="header.jsp" %>
          <img src="${pageContext.request.contextPath}/img/way.jpg" class="img-fluid" alt="Wild Landscape"/>

          <script src='https://achtungthemes.com/gnoli/js/lib/scripts.js'></script>
          <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js'></script>
          <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery-mousewheel/3.1.13/jquery.mousewheel.min.js'></script>
          <script src='https://cdnjs.cloudflare.com/ajax/libs/smoothscroll/1.4.0/SmoothScroll.min.js'></script>

            <script src="${pageContext.request.contextPath}/js/index.js"></script>


    </body>
        <%@ include file="footer.jsp" %>
</html>







