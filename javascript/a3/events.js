/* I, Sukhmanjeet Singh Student ID 000838215, verify that this is my own work and i did not copy from somewhere else */

document.addEventListener('DOMContentLoaded', function() {                  // to make sure html code is loaded before javascript code is exceuted
const cats = ['images/cat1.jpg', 'images/cat2.jpg', 'images/cat3.jpg'];     // list of cats images
const dogs = ['images/dog1.jpg', 'images/dog2.jpg', 'images/dog3.jpg'];     // list of dogs images
const stars = ['images/star1.jpg', 'images/star2.jpg', 'images/star3.jpg']; // list of stars images
const imagesGroup = [cats, dogs, stars];                                    // array containing all the images
const maxImageLength = cats.length;                                         // max length of each image list

const images = document.querySelectorAll(".image");                         // to select all the html element containing .image class

const imageCounter = document.getElementById("imageCounter");               // html element for image counter  
const timerInput = document.getElementById("timer_input");                  // html element for timer input
const countDown = document.getElementById("countDown");                     // html element for count down
const manualRefresh = document.getElementById('reset_timer');               // html element for reset timer

timerInput.value = 10000;        // intialize timerInput value on page load
let timeInSeconds = 2.5;         //initialize timer
let imageUpdater = 0;            // initialize image update counter
let maxTime = timeInSeconds / 3; // the maximum value after which the color changes

/**
 * display random images
 */
function displayRandomImages() {

    // loop over all the images 
    for (var i = 0; i < maxImageLength; i++) {

        // randomly select the images
        images[i].src = imagesGroup[i][Math.floor(Math.random() * maxImageLength)];    
    }
        
    imageUpdater = imageUpdater + 3;  // update image counter by 3
    imageCounter.textContent = `Images updated by ${imageUpdater} times`; // update the displayed text
}

/**
 * start the countdown based on users input
 */
function startCountDown() {            
    
    timeInSeconds = (timerInput.value / 1000);   // convert milliseconds to seconds for ease of calculation    
    maxTime = 2 * timeInSeconds / 3;               // set the maxTime after which to change the background color of timer
    countDown.textContent = `${timeInSeconds}s`;   // set the timer to intial value of timerInput.value
    countDown.style.background = "green";          // set the beginning color to green everytime startCountDown starts
    countDown.style.color = "white";               // and the color to white
    
    countDownIntervalId = setInterval(function() { // countdown by 1/10th time
        
        timeInSeconds -= 0.1;                      // decrease the country by 0.1 or 1/10th of a second
        
        if (timeInSeconds >= 0) {                  // as long as timer is greater than 0 display the counter
            
            // update the countdown text
            countDown.textContent = `${(Math.round(timeInSeconds * 10) / 10).toFixed(1)}s`;
            
            // once timeInSeconds hit maxTime change the color to yellow
            if (timeInSeconds <= maxTime && timeInSeconds > maxTime / 2) {
                countDown.style.background = "yellow";    
                countDown.style.color = "black";
            } else if (timeInSeconds <= maxTime / 2) { // if less than maxTime set the background to red
                countDown.style.background = "red";
                countDown.style.color = "white";
            } 
        } else {     
            clearInterval(countDownIntervalId);  // clear the countDownIntervalId before starting a new setInterval() function                                     
            displayRandomImages();      // display random images
            startCountDown();           // start startCountDown() again        
        }
    }, 1000 / 10);  // countdown on every 1/10th of a second
}

/**
 * update image everytime user click on any image
 * 
 * @param {HTMLElement} image - html image id to be updated
 * @param {NodeListOf<HTMLImageElement>} imagesClass list of images used to update the image id html element
 */
function updateImage(image, imagesClass) {
    
    image.classList.add('clicked');     // add clicked class to image class in html
    clearInterval(countDownIntervalId); // clear the internval
    startCountDown();                   // start the timer

    imageUpdater = imageUpdater + 1;    // update the image counter
    imageCounter.textContent = `Images updated by ${imageUpdater} times`; // update imageCounter text
    image.src = imagesClass[Math.floor(Math.random() * maxImageLength)]; // Replace the image source here

    setTimeout(() => { // Remove the clicked class after the animation ends
    image.classList.remove('clicked');
    }, 1000);
}

// if reset button is pressed reset the timer, display random images
manualRefresh.addEventListener('click', () => {    
    clearInterval(countDownIntervalId); // clear the interval before starting startCountDown() function
    startCountDown();       // execute startCountDown() function on every refresh
    displayRandomImages();  // display random images
});

timerInput.addEventListener('input', () => {    // everytime user enters the input call this function
    var value = parseInt(timerInput.value);     // convert the value to integer
    if (value < 500 || value > 10000) {         // if user enters less than 500 or greater than 10000
        timerInput.value = value < 500 ? 500 : 10000; // check again if between 500 and 10000 and set timerInput.value
    }
    clearInterval(countDownIntervalId); // clear the interval
    startCountDown();                   // exceute startCountDown() everytime user enters something
});

images.forEach((image) => { // loop over all the images array
    image.addEventListener('click', (event) => { // check if any image is been clicked

      // check what is the id of that image
      const imagesClass = event.target.id === 'image1' ? imagesGroup[0] : event.target.id === 'image2' ? imagesGroup[1] : imagesGroup[2];
      updateImage(event.target, imagesClass);    // update that image by randomly using from an array
    });
});

displayRandomImages();  // display randomized images of page load
startCountDown();       // once page loaded start the countdown
});