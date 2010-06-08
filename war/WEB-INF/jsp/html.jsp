
<%@page import="resume.shared.data.Profile"%>
<html>
<head>

<style>
body {
	font-family: Arial;
	font-size: 12px;
	margin-left: 50px;
	margin-right: 100px;
	margin-left: 50px;
}


h1 {
	font-size: 13px;
}

hr{
	border: 1px solid #000000;
}

.bio h1{
	padding: 10px 0 10px 0;
}

.bio p{
	padding: 0 0 10px 0;
}

.skills{
	margin-bottom: 20px;
}

.skills h1{
	padding: 7px 0 7px 0;
}



.experience h1{
	padding: 7px 0 7px 0;
}

.category {
	border-top: 1px solid #666666;
	border-right: 1px solid #666666;
	width: 100px;
	float: left;
	padding: 5px;
	margin-right: 10px;
}

.qualifications {
	border-top: 1px solid #666666;
	padding: 5px;
}

/*.qualifications:last-child {
	border-bottom: 1px solid #666666;
}*/


</style>

</head>

<body>

<div class="name">
	<h1><jsp:getProperty property="name" name="profile" /></h1>
</div>

<hr/>

<div class="bio">
	<h1>Associate Profle</h1>
	<p><jsp:getProperty property="story" name="bio" /></p>
</div>

<hr/>

<div class="skills">
	<h1>Skills</h1>
	<c:for
	<div class="category">Languages</div>
	<div class="qualifications">Groovy, C++, Java, Scala</div>
</div>

<hr/>

<div class="experience">
	<h1>Experience</h1>
	<div>Centric Consulting</div>
	<div>Developer</div>
	<div>September 2004 - Present</div>
</div>



</body>
</html>