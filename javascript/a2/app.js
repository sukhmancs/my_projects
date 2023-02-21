// I, Sukhmanjeet Singh Student id: 000838215, acknowledge that this file contains my own code and I did not copied from other source
/** 
 * Calculate if the number is inside particular range
*/
function checkInput() {
    let input = document.getElementById("g1_q1_input");
    const output = document.getElementById("g1_q1_output");
    
    // check if it is a number
    if (isNaN(input.value)) {
      output.value = "Not a number";
    } else if ((parseInt(input.value) === 0 ) || (input.value >= 13 && input.value <= 17)) {
      output.value = "In range";
    } else {
      output.value = "Out of range";
    }
}

/**
 *  Calculate the area of the square and the primeter
*/
function calculateArea() {
    const input = document.getElementById("g1_q3_input");
    const output = document.getElementById("g1_q3_output");

    // validate the input is not NaN and is greater than or equal to zero
    if (!isNaN(input.value) && input.value >= 0) {
        output.value = "Perimeter: " + 4 * input.value +
                       "\nArea: " + input.value * input.value;
    } else {
        output.value = "Can't calculate."
    }
} 

/** 
 * Check if the input is a vowel
*/
function checkVowel() {
    const input = document.getElementById("g2_q1_input");
    const output = document.getElementById("g2_q1_output");
    let vowels = "aeiou";

    // check if vowel is present
    if (vowels.includes(input.value.toLowerCase())) {
        output.value = "A Vowel";
    } else if (input.value === "y") {
        output.value = "Sometimes";
    } else {
        output.value = "Not a Vowel";
    }
}

/** 
 * Calculate Sum of all the digits of a number
*/
function calculateSum(inputValue=0) {
    let input;
    let output = document.getElementById("g2_q2_output");
    
    // double check inputValue (aka sum) is equal to zero
    if (inputValue === 0) {
        input = document.getElementById("g2_q2_input");
    
        // check input is an integer
        if(isNaN(input.value)) {
            output.value = "Bad Input";
            return;
        }
    } else { // if sum is greater than zero assign input to inputValue (aka sum)
        input = inputValue;
    }

    // convert input to its absolute value
    input = Math.abs(input.value);
    
    // initialize sum
    let sum = 0;

    // add integers by last digit
    while (input > 0) {
        sum += input % 10;
        input = Math.floor(input / 10);
    }

    // if greater than 9 repeat this function
    if (sum > 9) {
        input = sum;
        calculateSum(input);
    }
    
    // display the sum
    output.value = sum;
}

/** 
 * Convert binary numbers to decimal numbers
*/
function binaryToDecimal() {
    const input = document.getElementById("g3_q1_input");
    const output = document.getElementById("g3_q1_output");

    // Verify the input
    if (isNaN(input.value)) {        
        output.value = "NaN value";
        return;
    }
    
    // initialize the variable to store decimal value
    let decimalNumber = 0;

    // validate that the input only contains 0 or 1s
    let pattern = /^[01]+$/;
    if (!pattern.test(String(input.value))) {
        output.value = 0;
        return;
    }

    // if less than 10 or greater than 20 return
    if (input.value.length < 10 || input.value.length > 20) {
        output.value = 0;
        return;
    }

    // get the decimal value
    for (let x = 1; x < input.value.length + 1; x++) {
        decimalNumber += 2**(input.value.length - x) * input.value[x - 1];
    }
    
    // display the result
    output.value = decimalNumber;
}
