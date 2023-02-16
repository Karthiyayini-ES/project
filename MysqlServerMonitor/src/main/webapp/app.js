/*const SQLLOGINDISPLAY = document.querySelector(".MysqlPage");
const SQLLOGO = document.querySelector(".iconDabbas");
const SQLDETAILS = document.querySelector("#startStop");
const WHOLESQLCONTAINER = document.querySelector(".wholesqlContainer");
const SELECTOPTION = document.querySelector("#cars");
const IPBTN = document.querySelector("#getIpBtn");
const IPINPUTBOX = document.getElementsByName("ipAddress")
const TOMDABBA = document.querySelector(".tom");
const SQLDABBA = document.querySelector(".sqlDb");
const NETSERDABBA = document.querySelector(".netSer");*/
/*const NETSERCONTAINER = document.querySelector(".selectNetSer");
*//*const WHOLENSCON = document.querySelector(".wholeNetContainer");
const WHOLEINNSCON = document.querySelector(".wholeinnerNetSerContainer");
const SERVERALONE = document.querySelector(".wholeServer");
const a = document.querySelector(".ipAd");
const b = document.querySelector("#t");
const NETIP = document.querySelector("#conIp")*/
/*const startStopPage = document.querySelector("#startStop");*/
/*const FILLIPDET = document.querySelector(".networkForm");
const NETDET = document.querySelector(".NetworkDetails");
function _(ele){
	return document.getElementById(ele);
}
let DispName = _("displayName").value;
let IpAddress = _("ipAddress").value;
let UserName = _("userName").value;
let Password = _("pass").value;
let Port = _("portNum").value;
let statusDiv = _("mysqlStatus");



let sqltype = "";

function clickSql(ele){
	sqltype = ele.innerText; 
	console.log(sqltype);

	SQLLOGO.style.display="none";
	WHOLESQLCONTAINER.style.display="flex";
	SQLLOGINDISPLAY.style.display="flex";

}

function clickTestAndSubmit(){
	SQLLOGINDISPLAY.style.display="none";
	SQLDETAILS.style.display = "block";
	let x = new XMLHttpRequest();
	x.onreadystatechange = function(){
		if(x.readyState == 4 && x.status == 200){
			let result = JSON.parse(x.responseText);
			let ans = result["MysqlStatus"]
			statusDiv.innerText = ans;
		}
		
		
	}
	x.open("GET","mysqlServer?UserName="+UserName+"&Password="+Password+"&IpAddress="+IpAddress+"&sqltype="+sqltype);
	x.send()
/*	SQLLOGINDISPLAY.style.display="none";
	WHOLESQLCONTAINER.style.display="flex";
	SQLDETAILS.style.display="flex";
*/
/*}*/

/*function clickHome(){
	WHOLESQLCONTAINER.style.display="none";
	SQLLOGINDISPLAY.style.display="none";
	SQLDETAILS.style.display="none";
	SQLLOGO.style.display="block";
	WHOLENSCON.style.display="none";
	

}


function hideGetIp (){
	if(SELECTOPTION.value=="Remote machine"){
		IPBTN.style.visibility="hidden";
	}
	else{
		IPBTN.style.visibility="visible";
	}
}
SELECTOPTION.addEventListener("change",hideGetIp);



function clickAppServer(){
	TOMDABBA.style.display="flex";
	SQLDABBA.style.display="none";
	NETSERDABBA.style.display="none";

}


function clickDbServer(){
	TOMDABBA.style.display="none";
	SQLDABBA.style.display="flex";
	NETSERDABBA.style.display="none";

}

function clickNetServer(){
	TOMDABBA.style.display="none";
	SQLDABBA.style.display="none";
	NETSERDABBA.style.display="flex";

}


function clickNetworkDabba(){
	SQLLOGO.style.display="none";
	WHOLENSCON.style.display="flex";
	FILLIPDET.style.display="flex";
	
}

function clickNetTestCred(){
	FILLIPDET.style.display="none";
	NETDET.style.display="block";
	
}
*/

/*function clickNetSerDabba(){
	NETSERCONTAINER.style.display="flex";
	// WHOLESQLCONTAINER.style.display="none";
	// SQLLOGINDISPLAY.style.display="none";
	// SQLDETAILS.style.display="none";
	SQLLOGOCLIQ.style.display="none";
	WHOLENSCON.style.display="flex";

}


function clickNetworkDabba(){
	NETSERCONTAINER.style.display="none";
	WHOLEINNSCON.style.display="flex";
	NETALONE.style.display="flex"

}


function clickNetworkDabba(){
	NETSERCONTAINER.style.display="none";
	// NETALONE.style.display="none"
	WHOLEINNSCON.style.display="flex";
	SERVERALONE.style.display="flex";


}*/



/*function getIpAddress(){
	event.preventDefault()

	var xhttp = new XMLHttpRequest();
		
	xhttp.onreadystatechange = function(){
	if(xhttp.readyState ==4&&xhttp.status==200  ){
		let result = JSON.parse(xhttp.responseText)
			a.value = result["ipAdd"]
			NETIP.value = result["ipAdd"]
		}
		
	
	}
	xhttp.open("GET","sqlLogin",true);	
	xhttp.send();
	
}

IPBTN.addEventListener("click",getIpAddress);
b.addEventListener("click",getIpAddress);*/
