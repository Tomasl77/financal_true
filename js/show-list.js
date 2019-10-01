const buildTable = (contacts) => {
    const { content, first, last } = contacts;

    const prev = document.getElementById("previous");
    const next = document.getElementById("next");

    first ? prev.style.display = "none" : prev.style.display = "inline-block";
    last ? next.style.display = "none" : next.style.display = "inline-block";

    const tbody = document.getElementById('tbody');

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
        const td6 = document.createElement('td');
        td6.setAttribute("class", "test");
        const btn = document.createElement("a");
        btn.setAttribute("id", "update" + id);
        btn.setAttribute("class", "btn btn-danger modal-trigger");
        btn.innerHTML = "Modifier"
        td6.appendChild(btn);

        tr.append(td1, td2, td3, td4, td5, td6);
        tbody.append(tr);

        document.getElementById(`btn-${id}`).addEventListener("click", () => {
            request("DELETE", `http://localhost:8080/contacts/${id}`).then(() => {
                tr.remove();
            })
        })

        document.getElementById(`update${id}`).addEventListener("click", (a) => {
            document.getElementById('modal1').style.display = "block";
            document.getElementById('h4modal').innerHTML = "Modifier " + lastName + " " + firstName;
            document.getElementById('pmodal').innerHTML = `
            <form id="update-contact">
                <fieldset>
                    <label for="lastName">Last Name</label>
                    <input type="text" name="lastName" id="lastName" required>
                    <label for="firstName">First Name</label>
                    <input type="text" name="firstName" id="firstName" required>
                    <label for="email">E mail</label>
                    <input type="email" name="email" id="email" required>
                    <label for="phone">Phone</label>
                    <input type="text" name="phone" id="phone" required>
                    <label for="mobile">Mobile</label>
                    <input type="text" name="mobile" id="mobile" required>
                    <input id="modify-contact" type="button" class="btn waves-effect waves-light" value="Submit">
                </fieldset>
            </form>`;
            document.getElementById("modify-contact").addEventListener("click", () => {

                const form = document.getElementById("update-contact");
                const data = new FormData(form);
                const json = JSON.stringify(Object.fromEntries(data));
                console.log(json);
            
                request("PUT", `http://localhost:8080/contacts/${id}`, json).then(() => {
                    console.log("Contact modifier");
                    document.getElementById('update-contact').reset();
                    document.getElementById('modal1').style.display = "none";
                }).catch(error => {
                    console.log(error);
                })
            })
        })
    });

}
