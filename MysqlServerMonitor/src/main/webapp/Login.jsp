<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://fonts.googleapis.com/css2?family=Nunito+Sans&display=swap" rel="stylesheet">
	<style>
			*{
				padding: 0;
				margin: 0;
				box-sizing: border-box;
			}
            body{
                display: flex;
				justify-content: center;
				align-items: center;
				height: 100vh;
                background-image:url("https://media.istockphoto.com/id/1191184417/vector/vector-white-background.jpg?s=612x612&w=0&k=20&c=XZMWqfLdZ3ImrVgeFYzKs8-f_cr_GcD7X5F7cUqAkC8=");
	            background-repeat: no-repeat;
	            background-size: 100% 100%;
	            font-family: 'Poppins', sans-serif;
            }
		
			.Loginpage{
			box-shadow: rgba(17, 17, 26, 0.1) 0px 4px 16px, rgba(17, 17, 26, 0.1) 0px 8px 24px, rgba(17, 17, 26, 0.1) 0px 16px 56px;
	           /*border: 1px solid gray;*/
	          background-color: #ffffff;
	           width: 55%;
	           padding: 30px 35px 30px;  
	       
			}
            #btn-box button{
                font-size: 18px;
            }
            #btn-box button:hover{
                background-color: rgba(0, 0, 0, 0.6);
                
            }
            button{
                cursor: pointer;
            }
			.InputBox{
				width: 100%;
				margin: 15px 0px 20px;
				padding: 7px;
				border-radius: 10px;
				border: 1px solid gray;
				outline: none;
	
			}
			#LoginButton{
				text-align: center;
				background: black;
				color: white;
				cursor: pointer;
				/*border-radius: 10px;*/
			}
			.AppMan{
				text-align: center;
				margin: 10px 10px 40px;
				/*font-size: 30px;*/
			}
			#LoginButton{
				margin: 20px 0px 20px;
				font-size:15px ;
                transition: 0.5s;
			}
			#LoginButton:hover{
				background-color: #444;
			}
			
		    #Div{
       color:red;
       font-size:20px;
       text-align:center
         }
      #signIn{
        display:none;
      }
    .BackButton{
/* font-size:20px; */
padding:2px 5px;
border-radius:4px;
}
#total-box{
    width: 1000px;
    height: 450px;
    display: flex;
    border-radius: 20px;
     overflow: hidden; 
    box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px, rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;
}

#img{
    padding: 80px 40px;
    width: 60%;
	height: 450px;
    box-shadow: 0 0 10px 2px rgba(0,0,0,0.3);
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: rgb(184,185,186);
    overflow: hidden; 
    border-radius: 10px;
}
#img img{
    width: 500px;
    height: 300px;
}
#inner-img{
    border: 1px solid black;
}
#image{
    width: 100%;
    height: 100%;
    overflow: hidden;
    border-radius: 10px;
}

#btn-box{
    padding: 0px 90px;
}

#Div button{
    border: none;
    outline: none;
    background-color: rgba(0, 0, 0, 0.6);
    color: white ;
    transition: 0.5s;
    font-size: 16px;
    padding: 5px;
}
#Div button:hover{
    background-color: rgba(0, 0, 0, 0.9);
}

.img {
            display: flex;
            width: 100%;
            height: 100%;
            transition: 1s;
            border-radius: 10px;
           
        }

        .i {
            height: 100%;
            width: 100%;
            flex-shrink: 0; 
            background-repeat: no-repeat;
            background-size: 100% 100%;
        }

        .dot {
            color: rgba(0, 0, 0, 0);
           
            text-decoration: none;
            width: 20px;
            height: 20px;
            background-color: rgba(255, 255, 255, 0.9);
            text-align: center;
            border-radius: 50%;
            position: fixed;
            bottom: 33vh;
            border: 1px solid black;
            margin-left: 45%;
        }

      /*   #imgcon {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100%; */
            /* height: 700px; */
            /* border: 1px solid red; */
     /*    } */

        .im1 {
            border-radius: 20px;
            background-image: url("https://www.manageengine.com/products/applications_manager/images/index-webinar-banner.jpg");
        }

        .im2 {
            border-radius: 10px;
            background-image: url("https://servaplex.com/wp-content/uploads/2023/02/onw.png");
        }

        .im3 {
            border-radius: 10px;
            background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKkaM6cnL-3H2CWL1sL2f-l9fooMgXTE3k5g&usqp=CAU");
        }


        #img {
            width: 100%;
            height: 100%;
            transition: 2s;
            border-radius: 10px;
        }


        .dot1 {
            left: -70px;
        }

        .dot0 {
            left: -150px;
        }

        .dot2 {
            left: -110px;
        }


        .dot0:focus~.img {
            transform: translate(0%);

        }

        .dot1:focus~.img {
            transform: translate(-200%);
        }

        .dot2:focus~.img {
            transform: translate(-100%);
        }
        input{
            background-color: rgb(245,245,245);
        }
	</style>
	
</head>
<body>
    <div id="total-box">
        <div id="img">
            <!-- <div id="inner-img">
            <img src="https://www.manageengine.com/products/applications_manager/images/index-webinar-banner.jpg"/>
        </div> -->
        <section id="image">
            <a class="dot dot0" href="#">+</a>
            <a class="dot dot1" href="#">+</a>
            <a class="dot dot2" href="#">+</a>
            <div class="img">
                <button type="button" id="firstimg" class="i im1"></button>
                <button type="button" class="i im2"></button>
                <button type="button" class="i im3"></button>
            </div>
        </section>
        </div>

	<!-- <div class="LoginFirstPage"> -->
	<div class="Loginpage" id="signIn">

	 <h1 class="AppMan">Login</h1>
	<form action="Login"method="post">
	 <h3>UserName</h3>
	<input type="text" class="InputBox" required  name="nameSignIn"/>
	 <h3>Password</h3>
	<input type="password"  class="InputBox" required  name="passSignIn"/>
    <div id="btn-box">
	<button type="submit"  name="type" value="SignIn" class="InputBox" id="LoginButton">SignIn</button>
</div>	</form>
	<div id="Div">
	<% 
	 HttpSession message = request.getSession(); 
   String result1 = (String)message.getAttribute("ResultsignIn");

   if(result1==null){
	   
	   out.println(result1);
	   
   }
    
  
    
    %>
    <div>Create a new account?</div>
     <button type="button" id="SignInBut"  class="BackButton" onclick="InBut()">Click me</button>
    </div>
	
	</div>
	<div class="Loginpage" id="signUp">

	 <h1 class="AppMan">SignUp</h1>
	 	<form action="Login"method="post">
	 <h3>UserName</h3>
	<input type="text" required name="nameSignUp" class="InputBox"/>
	 <h3>Password</h3>
	 <input type="password" required  name="passSignUp" class="InputBox"/>
     <div id="btn-box">
   	<button type="submit"  name="type" value="SignUp" class="InputBox" id="LoginButton">SignUp</button>
</div>
	</form>
	

 
      <div id="Div">
   
 <% 
    
    String check = (String)message.getAttribute("check");
   String result = (String)message.getAttribute("Result");
   System.out.println("check"+check);
   System.out.println("Result"+result);
 
   if(result!=null){
	   
	   
	   
	   out.println(result);
	   
   }

     %> 
     <div>Do you have account?</div>
     <button type="button" id="SignOutBut" class="BackButton" onclick="OutBut()">Click me</button>
    </div>
      </div>
      <!-- </div> -->
    </div>
    </body>
    <script>
    console.log("hello");
    let signUp =  document.getElementById("signUp");
    let signIn = document.getElementById("signIn");
    function InBut(){
    	signIn.style.display = "none";
    	signUp.style.display = "block"
    }
    function OutBut(){
    	signIn.style.display = "block";
        signUp.style.display = "none"
      }
    </script>
</html>