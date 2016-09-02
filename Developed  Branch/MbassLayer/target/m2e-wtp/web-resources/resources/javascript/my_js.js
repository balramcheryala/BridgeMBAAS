// Validating Empty Field
function check_empty() {
	var name=document.getElementById('name').value
if (name == "") 
{
	//document.write("1");
alert("Fill All Fields !");
} 
else 
{
	
	//document.write("2");
	 //var value=null;
//	 var item=document.getElementById('name').values;
	 //alert(name);
	// document.write(name);
	// document.write("4");
	 
//	 value=name_exist(name);
//	 alert(value);
	 //document.write("5");
     /*document.getElementById('form').submit();*/
	/* this.firstName = name;
	 document.write(document.getElementById('name').value);*/

	/* console.log('hhhjhjh');*/
	 //window.location.assign("http://www.google.com");
//	if(value == null)
//	{
	 //alert("Project Name not available.Choose a new name ");
	/*alert("new")*/
     window.location.assign("http://localhost:8086/MbassLayer/project?name="
             + name)
             //document.write("5555555555555555555555555555");     
            // alert("result from mysql:"+result);
//	}
//	else
//	{
//		alert("Project Name not available.Choose a new name ");
//	}
//	Promise.all(result).then(function(values){
//		console.log("values: "+values);
//	})
//alert("Form Submitted Successfully...");
}
}

function check_emptypackagenames()
{   //var rc=index;
    //alert(rc);
	/*var products_per_page = document.getElementById("ppp").value;
	alert("gvdgvdjh")*/
	var packagename=document.getElementById('usrnm').value
	/*alert("g")*/
	//var packagename1=document.getElementById('myfield')[0].getAttribute('value');
	/*alert(packagename)*/
	if (packagename == "") 
	{
		//document.write("1");
	alert("Fill All Fields !");
	} 
	else 
	{
		window.location.assign("http://localhost:8086/MbassLayer/addmbaas?packagename="
	             + packagename)
	             alert("now")
	             alert("hellobe")
	/*alert("movies name"+ schema_name)
	window.location.assign("http://localhost:8086/MbassLayer/downloadFileServlet?schemaname="+ schema_name)*/
	}
	//check_downloadfile();
}
function check_downloadfile()
{
	/*alert("hi")
	alert("movies name"+ schema_name)*/
	window.location="http://localhost:8086/MbassLayer/downloadFileServlet?schemaname="+ schema_name
}
//function name_exist(name)
//{
//	alert("inside 3 function:"+name);
////	document.write("3");
//	var mysql = require("mysql");
//	var con = mysql.createConnection({
//		  host: "localhost:3306",
//		  user: "root",
//		  password: "bridgeit",
//		  database: "bridgelabz"
//		});
//	alert(con);
//	con.connect();
//	document.write('\n'+con);
//	con.query('SELECT * FROM bridgelabz.totalprojectfire where projectName LIKE '%'+now+'%'',function(err,rows){
//		  if(err) throw err;
//		  alert("err"+err);
//		  alert("rows"+rows);
//		  return "data not present in database";
//		  
//		});
//}
//Function To Display Popup
function div_show()
{
	//alert('Already exist')
	//alert("Project Name not available.Choose a new name ");
	document.getElementById('abc').style.display = "block";
	document.getElementById('xyz').className = "blurr";
}
function name_show()
{
	//alert('Already exist')
	
	document.getElementById('abc').style.display = "block";
	document.getElementById('xyz').className = "blurr";
	alert("Project name already taken.Please choose a new name.");
}
//Function to Hide Popup
function div_hide()
{
document.getElementById('abc').style.display = "none";
}
/*jQuery*/

$(function(){
	var ink, d, x, y;
	$(".ripplelink").click(function(e){
    if($(this).find(".ink").length === 0){
        $(this).prepend("<span class='ink'></span>");
    }
         
    ink = $(this).find(".ink");
    ink.removeClass("animate");
     
    if(!ink.height() && !ink.width()){
        d = Math.max($(this).outerWidth(), $(this).outerHeight());
        ink.css({height: d, width: d});
    }
     
    x = e.pageX - $(this).offset().left - ink.width()/2;
    y = e.pageY - $(this).offset().top - ink.height()/2;
     
    ink.css({top: y+'px', left: x+'px'}).addClass("animate");
});
});