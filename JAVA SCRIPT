console.log("JS file connected successfully");

function loginValidate() {

    window.location.href = "index.html";

    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    var emailError = document.getElementById("emailError");
    var passError = document.getElementById("passError");

    emailError.innerText = "";
    passError.innerText = "";

    var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (email === "") {
        emailError.innerText = "Email is required";
        return false;
    }
    if (!emailPattern.test(email)) {
        emailError.innerText = "Invalid email format";
        return false;
    }

    if (password === "") {
        passError.innerText = "Password is required";
        return false;
    }
    if (password.length < 6) {
        passError.innerText = "Password must be at least 6 characters";
        return false;
    }

    alert("Login Successful!");
    return true;
}
