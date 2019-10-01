import { request } from './functions/request.js';

document.getElementById("test").addEventListener("click", () => {

    const form = document.getElementById("create-contact");
    const data = new FormData(form);
    const json = JSON.stringify(Object.fromEntries(data));

    request("POST", "http://localhost:8080/contacts", json).then(() => {
        console.log("Contact Ajouté");
        
    }).catch(error => {
        console.log(error);
    })
})