var toDoList= new Array();
var helloVasya=null;

function addToList(inValue)
{
	var toDoListLength=toDoList.length;
	if(inValue!='')
	{
			toDoList.push({deleted:false, value:inValue});

		var listBlock=document.getElementById('listBlock');
		var listBlockContent=listBlock.innerHTML;

		listBlockContent+='<div><input type="checkbox" id="checkbox'+toDoListLength+'" onclick="console.log(\'checkbox'+toDoListLength+'\');onClickHandler(\''+toDoListLength+'\');" value="">';
		listBlockContent+='<label for="checkbox'+toDoListLength+'" id="label'+toDoListLength+'" class="">'+toDoList[toDoListLength].value+'</label></div>';
	}
	else{
		var listBlock=document.getElementById('listBlock');
		var listBlockContent='';
		for(var k=0;k<toDoList.length;k++){
			console.log('k='+k+' deleted='+toDoList[k].deleted);
			if(toDoList[k].deleted==true){
				listBlockContent+='<div><input type="checkbox" id="checkbox'+k+'" checked onclick="console.log(\'checkbox'+k+'\');onClickHandler(\''+k+'\');" value="">';
				listBlockContent+='<label for="checkbox'+k+'" id="label'+k+'" class="deleted-text">'+toDoList[k].value+'</label></div>';
				console.log('delete');
			}
			else{
				listBlockContent+='<div><input type="checkbox" id="checkbox'+k+'" onclick="console.log(\'checkbox'+k+'\');onClickHandler(\''+k+'\');" value="">';
				listBlockContent+='<label for="checkbox'+k+'" id="label'+k+'" class="">'+toDoList[k].value+'</label></div>';
				console.log('undelete');
			};
		}
	}
	listBlock.innerHTML=listBlockContent;
		
}

function onClickHandler(inval)
{
	//console.log('Pressed='+inval+' toDoList.length='+toDoList.length);
			//var checkBox=document.getElementById("checkbox"+element);
			//var checkBox=document.getElementById(inval);
		console.log('inval='+inval);
		if(inval<toDoList.length){
			console.log('toDoList['+inval+'].deleted='+toDoList[inval].deleted);
			if(toDoList[inval].deleted==true){
				toDoList[inval].deleted=false;
			}
			else{
				toDoList[inval].deleted=true;
			};
			console.log('toDoList['+inval+'].deleted='+toDoList[inval].deleted);
		}
	addToList('');
	
};

function clear()
{
	//document.getElementById('reminderField').value='';
	var reminderField=document.getElementById('reminderField');
	console.log('Checked=reminderField');
	addToList(reminderField.value);
	reminderField.value='';
};

function saveToLocalStorage(pname,pvalue){
	localStorage.setItem(pname, JSON.stringify(pvalue));
};

function loadFromLocalStorage(pname){
	return JSON.parse(localStorage.getItem(pname));
};

function userRegistration(userEmail,userPassword,userPasswordConfirm,userName)
{
	if (userEmail&&userPassword&&userPasswordConfirm&&userName) {

		if (userPassword!=userPasswordConfirm) {
			document.getElementById('serverResponse').innerHTML='Passwords do not match.';
		}
		else{
			var msg='json_data='+JSON.stringify({action:'register',username:userName,email:userEmail,password:userPassword});
			askPHP(msg);
		};
	}
	else{
		document.getElementById('serverResponse').innerHTML='Not all parameters present';
	}
}

function userAuthentication(userEmail,userPassword)
{
	if(userEmail&&userPassword){

		if(userPassword==''){
			document.getElementById('serverResponse').innerHTML='Please enter e-mail and password.';
		}
		else{
			var msg='json_data='+JSON.stringify({action:'auth',username:'',email:userEmail,password:userPassword});
			askPHP(msg);
		}
	}
	else{
		document.getElementById('serverResponse').innerHTML='Not all parameters present';
	}
}

function askPHP(msg)//userEmail,userPassword,userName
{

	//var data = "json_data=" +JSON.stringify({email:userEmail,password:userPassword,username:(userName==undefined?'':userName)});
	var xhr;

	if (window.XMLHttpRequest) { // Mozilla, Safari, ...
		xhr = new XMLHttpRequest();
	} else if (window.ActiveXObject) { // IE 8 and older
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xhr.open("POST", "todo.php", true); 
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");                  
	xhr.send(msg);

	xhr.onreadystatechange = display_data;
	function display_data() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				//alert(xhr.responseText);	   
				//document.getElementById("suggestion").innerHTML = xhr.responseText;
				console.log("server response="+xhr.responseText);
				
				var response=JSON.parse(xhr.responseText);
				
				if(response['result']=='success'){
					document.getElementById("helloVasya").innerHTML='Wellcome <b>'+response['username']+'</b>';
					document.getElementById("todolist").style.display = 'block'; 
					
				}
				else{
					document.getElementById("helloVasya").innerHTML='';
					document.getElementById("todolist").style.display = 'none'; 
					document.getElementById("serverResponse").innerHTML=response['show'];

				}
				return xhr.responseText;

			} else {
				alert('There was a problem with the request.');
			}
		}
	}
};


	var addButton = document.getElementById('addButton');
	//addButton.addEventListener("click", clear);
	//if(document.getElementById('addButton'))
	document.getElementById('addButton').addEventListener("click", clear);
	var buttonSave= document.getElementById('buttonSave');
	//buttonSave.addEventListener("click", function(){console.log("saving");var jsn=JSON.stringify(toDoList);setCookie("TODO",jsn,1000);});
	//buttonSave.addEventListener("click", function(){console.log("saving");saveToLocalStorage("toDoList",toDoList);});
	document.getElementById('buttonSave').addEventListener("click", function(){console.log("saving");saveToLocalStorage("toDoList",toDoList);});
	var buttonLoad= document.getElementById('buttonLoad');
	//buttonLoad.addEventListener("click", function(){console.log("loading");toDoList=getCookie("TODO");addToList('');});
	//buttonLoad.addEventListener("click", function(){console.log("loading");toDoList=loadFromLocalStorage("toDoList");addToList('');});
	 document.getElementById('buttonLoad').addEventListener("click", function(){console.log("loading");toDoList=loadFromLocalStorage("toDoList");addToList('');});
	
	document.getElementById('userregisterbutton').addEventListener("click", function(){console.log("reg");userRegistration(document.getElementById('useremailreg').value,document.getElementById('userpasswordreg').value,document.getElementById('userpasswordconfirm').value,document.getElementById('usernamereg').value);});
	//document.getElementById('userauthbutton').addEventListener("click", function(){console.log("auth");authenticateUser(document.getElementById('useremailauth').value,document.getElementById('userpasswordauth').value,);});
document.getElementById('userauthbutton').addEventListener("click", function(){console.log("auth");userAuthentication(document.getElementById('useremailauth').value,document.getElementById('userpasswordauth').value);});
window.onload = function() {
    document.getElementById("todolist").style.display = 'none';
  };

/*

	function setCookie(c_name,value,exdays)
	{
	  var exdate=new Date();
	  exdate.setDate(exdate.getDate() + exdays);
	  var c_value=escape(value) + 
	    ((exdays==null) ? "" : ("; expires="+exdate.toUTCString()));
	  document.cookie=c_name + "=" + c_value;



	  var ARRcookies=document.cookie.split(";");
	   console.log("0ARRcookies.length="+ARRcookies.length);
	  console.log('saving cookie');
	   document.cookie="name" + "=" + "c_value";
	   console.log('getting cookies');
	   ARRcookies=document.cookie.split(";");
	   console.log("1ARRcookies.length="+ARRcookies.length);
	   var date = new Date(new Date().getTime() + 60 * 1000);
document.cookie = "name=value; path=/; expires=" + date.toUTCString();
	   //console.log(ARRcookies[0]);
	   alert( document.cookie );
	}

	function getCookie(c_name)
	{
	 var i,x,y,ARRcookies=document.cookie.split(";");
	 for (i=0;i<ARRcookies.length;i++)
	 {
	  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
	  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
	  x=x.replace(/^\s+|\s+$/g,"");
	  if (x==c_name)
	  {
	   var temp=JSON.parse(unescape(y));
	   return temp;
	  }
	 }
	};

	function checkRegisterData(userName,userEmail,userPassword,userPasswordConfirm)
	{
		if(userPassword!=userPasswordConfirm){
			console.log("Password values are different:"+userPassword+' != '+userPasswordConfirm);
		}
		else
		{
			registerUser(userName,userEmail,userPassword);
		}
	};

	function registerUser(userName,userEmail,userPassword){

		firebase.auth().createUserWithEmailAndPassword(userEmail,userPassword).catch(function(error) {
			  // Handle Errors here.
			  var errorCode = error.code;
			  var errorMessage = error.message;
			  // ...
		});
		 //writeUserData(10, userName, userEmail);
	};

	function writeUserData(userId, name, email) {
		firebase.database().ref('users/' + userId).set({
			username: name,
			email: email
			//,profile_picture : imageUrl
		});
	}

	function authenticateUser(userEmail,userPassword){
		firebase.auth().signInWithEmailAndPassword(userEmail,userPassword).catch(function(error) {
		  // Handle Errors here.
		  var errorCode = error.code;
		  var errorMessage = error.message;
		  // ...
		});
		writeUserData(10, 'uname', userEmail);
	};


*/