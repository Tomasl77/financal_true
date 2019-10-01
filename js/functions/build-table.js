import { request } from "./request.js";

const buildTable = (contacts) => {
    const { content, first, last } = contacts;

    const prev = document.getElementById("prev");
    const next = document.getElementById("next");

    first ? prev.style.display = "none" : prev.style.display = "inline-block";
    last ? next.style.display = "none" : next.style.display = "inline-block";

    const tbody = document.querySelector('tbody');

    tbody.innerHTML = "";

    content.forEach((contact) => {
        const { id, firstName, lastName, infoEmail } = contact;

        const tr = document.createElement("tr");
        
        const td1 = document.createElement('td');
        td1.textContent = id;
        const td2 = document.createElement('td');
        td2.textContent = firstName;
        const td3 = document.createElement('td');
        td3.textContent = lastName;
        const td4 = document.createElement('td');
        td4.textContent = infoEmail;
        const td5 = document.createElement('td');
        td5.innerHTML = `<button id="btn-${id}" class="btn btn-danger">Supprimer</button>`;

        tr.append(td1, td2, td3, td4, td5);
        tbody.append(tr);

        document.getElementById(`btn-${id}`).addEventListener("click", () => {
            request("DELETE", `http://localhost:8080/contacts/${id}`).then(() => {
                tr.remove();
            })
        }) 
    });

}

export default buildTable;