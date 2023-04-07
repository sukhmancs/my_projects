/* I, Sukhmanjeet Singh Student ID 000838215, verify that this is my own work and i did not copy from somewhere else */
document.addEventListener('DOMContentLoaded', function() { // Only run this javascript once html is loaded

const gameBoard = document.getElementById('game-board'); // Svg game board for the game
const speedElement = document.getElementById('speed'); // Input element representing pointer to set the speed or the difficulty level
const scoreElement = document.getElementById('scoreElement'); // To store and display the score of every successful hit
const radius = 30; // Radius of balloon or dark circle
const rangeLabel = document.getElementById("rangeLabel"); // To display the difficulty level 10 means Hard, 5 means medium, and 0 means easy difficulty level 
const hollowCircleRadius = 27; // Circle radius for hollow circle ripple

var score = 0; // current score of the player
var x = getRandomInt(radius, gameBoard.clientWidth - radius); // Horizontal position on svg element 
var y = getRandomInt(radius, gameBoard.clientHeight - radius); // Verticle position on svg element

/**
 * Better method to randomize the values
 * @function getRandomInt
 * @param {number} min - The minimum value of the range.
 * @param {number} max - The maximum value of the range.
 * @returns {number} A random integer between min and max (inclusive).
 */
function getRandomInt(min, max) {
  
  // Generate a random integer between min and max (inclusive).
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

/**
* Pop the balloon and increase the score.
* @function popBalloon
* @param {Event} event - The event object.
*/
function popBalloon(event) {

   // Prevent the default behavior of the right-click event
   event.preventDefault();
  
  // Remove the balloon from the game board.
  event.target.remove();
  
  // Increase the score by 1.
  score++;
  
  // Update the score element with the new score.
  scoreElement.innerHTML = `Score ${score}`;
}

/**
* Animate the balloon by adding it to the game board, setting a timeout, and adding an event listener.
* @function animateBalloon
*/
function animateBalloon() {
  
  // Create a new balloon element.
  const balloon = document.createElementNS('http://www.w3.org/2000/svg', 'circle');
  
  // Calculate the duration of the balloon animation based on the current speed setting.
  const duration = 2000 / speedElement.value;
  
  // Set the x, y, and radius attributes of the balloon.
  balloon.setAttribute('cx', x);
  balloon.setAttribute('cy', y);
  balloon.setAttribute('r', radius);
  
  // Generate new random x and y positions for the next balloon.
  x = getRandomInt(radius, gameBoard.clientWidth - radius);
  y = getRandomInt(radius, gameBoard.clientHeight - radius);
  
  // Add the balloon to the game board.
  gameBoard.appendChild(balloon);
  
  // Add a click event listener to the balloon to pop it.
  balloon.addEventListener('click', popBalloon);

  // Add right click mouse event
  balloon.addEventListener('contextmenu', popBalloon);
  
  // Remove the balloon after the animation duration has elapsed.
  setTimeout(() => {
      balloon.remove();
  }, duration);
}

/**
* Add a ripple effect to the balloon.
* @function rippleEffect
*/
function rippleEffect() {

  const balloonRipple = document.getElementById('balloonRipple');
  
  // Set the x, y, and radius attributes of the balloon ripple effect.
  balloonRipple.setAttribute('cx', x);
  balloonRipple.setAttribute('cy', y);
  balloonRipple.setAttribute('r', hollowCircleRadius);
  
  // Add balloon ripple animation to this hollow circle
  balloonRipple.style.opacity = '1';
  balloonRipple.style.animation = 'lds-ripple 0.9s cubic-bezier(0, 0.2, 0.8, 1) infinite';
  
  // Intialize a new sheet
  const sheet = new CSSStyleSheet();

  // Insert a new @keyframes rule with the name lds-ripple.
  sheet.insertRule('@keyframes lds-ripple { }');

  // Access the first rule in our stylesheet (which we just added above) using the cssRules
  const keyframes = sheet.cssRules[0];

  // Add new rules to our @keyframes rule (or which in our case set up opacity)
  keyframes.appendRule('0% { opacity: 1; }');
  keyframes.appendRule('100% { opacity: 0; }');

  // Add style sheet to the document
  document.adoptedStyleSheets = [sheet];

  // Add the balloon ripple effect to the game board.
  gameBoard.appendChild(balloonRipple);
}

// Play balloon ripple effect every second in sync with 1s animation.
setInterval(rippleEffect, 1000);

// Animate balloon after 2 seconds (or 1 second after balloon ripple effect).
setInterval(animateBalloon, 2000);

gameBoard.addEventListener('contextmenu', function(event) {
  event.preventDefault();
})

// Set the difficulty level based the pointer position
speedElement.addEventListener('click', () => {
    const value = parseInt(speedElement.value);

    // When pointer is at start
    if (value <= 3) {
      rangeLabel.textContent = 'Difficulty Easy';
    } else if (value <= 7) { // When pointer is at middle
      rangeLabel.textContent = 'Difficulty Medium';
    } else { // else or at the end
      rangeLabel.textContent = 'Difficulty Hard';
    }
})
});