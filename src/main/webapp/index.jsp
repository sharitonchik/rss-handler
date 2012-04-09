<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Rss</title>
    <script type="text/javascript" src="javascripts/jquery-1.7.min.js">//</script>
    <script type="text/javascript" src="javascripts/rss.js">//</script>
</head>
<body>
<form action="/rss">
    <ul style="float:left;">
        <li>
            <label> Yahoo News
                <input type="radio" name="news" value="yahoo.news"/>
            </label>
        </li>
        <li>
            <label> Google Business
                <input type="radio" name="news" value="google.business"/>
            </label>
        </li>
        <li>
            <label> Google Tech
                <input type="radio" name="news" value="google.tech"/>
            </label>
        </li>
        <li>
            <label> Onliner
                <input type="radio" name="news" value="onliner.news"/>
            </label>
        </li>
        <li>
            <label> Habr
                <input type="radio" name="news" value="habr.news"/>
            </label>
        </li>
        <li>
            <label> Creep
                <input type="radio" name="news" value="creep.news"/>
            </label>
        </li>
        <li>
            <label> Pogoda Minsk
                <input type="radio" name="news" value="pogoda.news"/>
            </label>
        </li>
        <li>
            <label> Cnn
                <input type="radio" name="news" value="cnn.news"/>
            </label>
        </li>
        <li>
            <label> Championat
                <input type="radio" name="news" value="championat.news"/>
            </label>
        </li>
    </ul>
</form>
<iframe id="rssContent" src="" style="width:80%; height:800px; overflow:auto;"></iframe>
</body>
</html>
