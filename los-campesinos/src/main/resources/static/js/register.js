const register = () =>{
    const nombre = document.getElementById("nombres").value;
    const username = document.getElementById("username").value;
    const password = document.getElementById("contraseña").value;
    const correo = document.getElementById("correo").value;
    console.log(username)

    const body = {
        "nombre" : nombre,
        "username" : username,
        "password" : password,
        "correo" : correo
    };

    postToLogin(body);
};

const postToLogin = async (bodyObject) => {
    const url = "/api/registro";
    const response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(bodyObject),
        headers: {
            "Content-Type": "application/json"
        }
    });

    if (response.ok) {
        const user = await response.json();

        // localStorage.setItem("loggedUser", JSON.stringify(user));
        
        alert("Usuario Creado!");
        
        await new Promise(r => setTimeout(r, 1500));

        window.location.href = "/";
    } else {
        const message = await response.text();
        showError(message);
    }
};

const showError = (message) => {
    alert(message, "danger");
}

const alert = (message, type) => {
    document.getElementById("errorBox").innerHTML = [
        `<div class="alert alert-${type} alert-dismissible" role="alert" style="color:black;">`,
        `   <div>${message}</div>`,
        '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
        '</div>'
    ].join('')
}