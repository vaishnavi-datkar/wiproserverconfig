function checkEmail(){
    let email=document.getElementById("email").value;
     let error = document.getElementById("emailerror");
      if (email.trim() === "") {
            error.textContent = "Email cannot be empty";
        } else if (email.indexOf("@") === -1 || email.indexOf(".") === -1) {
            error.textContent = "Invalid email format";
        } else {
            error.textContent = "";
        }
    }
         function validatePassword() {
        let password = document.getElementById("password").value;
        let error = document.getElementById("passworderror");

        if (password.trim() === "") {
            error.textContent = "Password cannot be empty";
        } else {
            error.textContent = "";
        }
    }

     function validatePassword() {
        let password = document.getElementById("password").value;
        let error = document.getElementById("passworderror");
      function handleLogin() {
        checkEmail();
        validatePassword();
    }
}