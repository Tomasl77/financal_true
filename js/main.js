//Add a contact
document.getElementById("add-contact").addEventListener("click", () => {

    const form = document.getElementById("create-contact");
    const data = new FormData(form);
    const json = JSON.stringify(Object.fromEntries(data));

    request("POST", "http://localhost:8080/contacts", json).then(() => {
        console.log("Contact Ajouté");
        form.reset();
    }).catch(error => {
        console.log(error);
    })
})

//List contacts
let currentPage = 0;
let elements = 5;
let filter = "id";
document.getElementById("button-list-contact").addEventListener('click', function () {
    request("GET", `http://localhost:8080/contacts?p=${currentPage}&s=${elements}&by=${filter}`)
        .then((contacts) => {
            buildTable(contacts);
        });
})

document.getElementById("next").addEventListener("click", () => {
    currentPage++;

    request("GET", `http://localhost:8080/contacts?p=${currentPage}&s=${elements}&by=${filter}`)
        .then((contacts) => {
            buildTable(contacts);
        })
})

document.getElementById("previous").addEventListener("click", () => {
    currentPage--;

    request("GET", `http://localhost:8080/contacts?p=${currentPage}&s=${elements}&by=${filter}`)
        .then((contacts) => {
            buildTable(contacts);
        })
})

