/* This code add javascript to the webpage */

/* Author information*/
/* I, Sukhmanjeet Singh Student ID 000838215, verify that this is my own work and i did not copy from somewhere else */


// Wait for the HTML content to load before executing JavaScript code
document.addEventListener('DOMContentLoaded', function() {

    // Define the API endpoint URL
    const apiUrl = 'https://csunix.mohawkcollege.ca/~adams/10259/a6_responder.php';
    
    // Store the previous Divs
    let previousDiv1 = null;
    let previousDiv = [];
    let previousRow = [];
    
    // Button 1: fetch data from the API endpoint
    document.querySelector('#btn1').addEventListener('click', async () => {
    const response = await fetch(apiUrl);
    if (response.ok) { // only if response is okay
        if (previousDiv1) {
            previousDiv1.remove();
        }
        // Parse the response text and create a new h1 element with the text content
        const text = await response.text();
        const h1 = document.createElement('h1');
        h1.textContent = text + ' (#000838215)'; // Add a student ID to the text content
        h1.style.textAlign = 'center'; // make it center
        
        const container = document.createElement('div'); // div element for storing h1
        container.appendChild(h1);
        
        // Append the new div container to the #results element in the HTML document
        document.querySelector('#results').appendChild(container);
        previousDiv1 = container;
        } else {
            console.error('AJAX error:', response.status);
        }
    });
    
    // Button 2: fetch and display data as images from the API endpoint
    const inputElement = document.querySelector('#input1');
    const button2 = document.querySelector('#btn2');
    const copyright = document.createElement('p');
    
    // Button 2: Eventlistner
    button2.addEventListener('click', async () => {
    let input = inputElement.value.toLowerCase(); // convert input value to lowercase
    button2.disabled = true; // disable the button until the fetch request is finished
    
    // Create the URL with the input value as a parameter
    const url = `https://csunix.mohawkcollege.ca/~adams/10259/a6_responder.php?choice=${input}`;

    // Send the AJAX request with fetch()
    fetch(url)
    .then(response => response.json()) // Parse the response as JSON
    .then(data => {
        if (previousDiv.length != 0) {
            previousDiv.forEach(element => {
            element.remove();
            })
        }
        
        // Calculate the width of each div
        const divWidth = Math.floor(100 / data.length);        
        
        // Loop through the data and create a div for each element
        data.forEach(item => {
            
            // Create a new div element and set its width and text alignment styles
            const div = document.createElement('div');
            div.style.width = `${divWidth}%`;
            div.style.textAlign = "center";
            
            // Create a new h2 element and set its text content to the "series" value of the current item
            const h2 = document.createElement('h2');
            h2.textContent = item.series;
            div.appendChild(h2);
            console.log(item.series);
            
            // Create a new img element and set its src, alt, width, and height attributes
            const img = document.createElement('img');
            img.src = item.url;
            img.alt = item.name;
            img.style.width = '98%';
            img.style.height = 'auto';
            div.appendChild(img);
            
            // Create the p element and add the name text
            const p = document.createElement('p');
            p.textContent = item.name;
            div.appendChild(p);
            
            // Add the div to the container            
            document.querySelector('#results1').appendChild(div);
            previousDiv.push(div);
        });
        
        // Set the copyright notice based on input entered
        if (input === 'mario') {
            copyright.textContent = 'Game trademarks and copyrights are properties of their respective owners. Nintendo properties are trademarks of Nintendo. © 2019 Nintendo.';
        } else if (input === 'starwars') {
            copyright.textContent = 'Star Wars © & TM 2022 Lucasfilm Ltd. All rights reserved. Visual material © 2022 Electronic Arts Inc.';
        }
        document.querySelector('#section1').appendChild(copyright); // append copyright element to the div element with id section1
        button2.disabled = false; // re-enable the button
    })
    .catch(error => { // catch any error during fetch request
        console.log(error); // print them on browser console
        button2.disabled = false; // re-enable the button
    });
});

//Button 3 code
const button3 = document.getElementById("btn3"); // button 3 
const inputElement2 = document.querySelector('#input2'); // get input element
const tableBody = document.getElementById('tbody'); // body of the table
const tableHead = document.getElementById('thead'); // head of the table element
const copyright2 = document.createElement('p'); // create paragraph tag 

// Eventlistner to listen to button 3
button3.addEventListener("click", function() {

    // Check the input value and make it lowercase evertime button is pressed
    let input2 = inputElement2.value.toLowerCase();

    // disable the button until the fetch request is not finished
    button3.disabled = true;

    // url to submit the post request to
    const url = `https://csunix.mohawkcollege.ca/~adams/10259/a6_responder.php?choice=${input2}`;

    // parameter for the post request
    const data = new FormData();  			
    data.append('choice', inputElement2.value);

    // fetch request
    fetch(url, {
        method: "POST",
        credentials: 'include',
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: data
    })
    .then(response => response.json()) // once promise is resolved with response convert data to json format
    .then(data => { // process the data

        // Remove previous table element everytime button 3 is pressed if exist
        if (previousRow.length != 0) {
            previousRow.forEach(element => {
                element.remove();
            })
        }

        // Create a row head for the table element
        let rowHead = document.createElement('tr'); // table row
        let col_1_1 = document.createElement('th'); // table head
        let col_1_2 = document.createElement('th'); // table head
        let col_1_3 = document.createElement('th'); // table head
        col_1_1.appendChild(document.createTextNode('Series')); // add cell data
        col_1_2.appendChild(document.createTextNode('Name')); // add cell data
        col_1_3.appendChild(document.createTextNode('Link')); // add cell data
        
        // append column cells to the row head
        rowHead.append(col_1_1);
        rowHead.append(col_1_2);
        rowHead.append(col_1_3);
        tableHead.append(rowHead);
        previousRow.push(rowHead);

        // loop over each element in data of type of json (contaning bunch of dictonaries)
        data.forEach(item => {
            let row = document.createElement('tr'); // create table row
            
            // create table columns
            let col_1_1 = document.createElement('td');
            let col_1_2 = document.createElement('td');
            let col_1_3 = document.createElement('td');

            // add data cells to the table columns 
            col_1_1.appendChild(document.createTextNode(item.series));
            col_1_2.appendChild(document.createTextNode(item.name));
            col_1_3.appendChild(document.createTextNode(item.url));

            // append colmuns with data to the row
            row.append(col_1_1);
            row.append(col_1_2);
            row.append(col_1_3);
            tableBody.append(row); // add everything to the table body
            previousRow.push(row);  // insert everything into table tag
        })

        // change the copyright notice based on input entered
        if (input2 === 'mario') {
            copyright2.textContent = 'Game trademarks and copyrights are properties of their respective owners. Nintendo properties are trademarks of Nintendo. &copy; 2019 Nintendo.';
        } else if (input2 === 'starwars') { // if entered starwars
            copyright2.textContent = 'Star Wars © & TM 2022 Lucasfilm Ltd. All rights reserved. Visual material © 2022 Electronic Arts Inc.';
        }

        // append copyright element to the html div element with id section2
        document.querySelector('#section2').appendChild(copyright2);

        // Now is the time to enable the button for further requests 
        button3.disabled = false;
    })
    .catch(error => { // catch any error during fetch request
        console.log(error); // show them to the browser console
        button3.disabled = false; // if fetch request gives error re-enable the button
    })
});
})