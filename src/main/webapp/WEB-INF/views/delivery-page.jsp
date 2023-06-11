<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Progress Bar</title>
    <style>
        <%-- CSS Styles --%>
        <%-- Colours --%>
        <%@include file="../../static/css/styles.css" %>
    </style>
    <script>
        <%-- JavaScript Code --%>
        <%@include file="../../static/js/delivery.js" %>
    </script>
</head>
<body>
<div id="app" class="${progressClasses}">
    <div class="progress__bg"></div>
    <c:forEach var="step" items="${steps}" varStatus="status">
        <div class="${stepClasses(status.index)}">
            <div class="progress__indicator">
                <i class="fa fa-check"></i>
            </div>
            <div class="progress__label">
                    ${step.label}
            </div>
        </div>
    </c:forEach>

    <div class="progress__actions">
        <div class="btn" onclick="nextStep(false)">Back</div>
        <div class="btn" onclick="nextStep()">Next</div>
        <div>
            etape: ${currentStep ? currentStep.label : "est complete"}
        </div>
    </div>
</div>
</body>
</html>
