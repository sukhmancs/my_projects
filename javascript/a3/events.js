document.addEventListener('DOMContentLoaded', function() {
const cats = ['images/cat1.jpg', 'images/cat2.jpg', 'images/cat3.jpg'];
const dogs = ['images/dog1.jpg', 'images/dog2.jpg', 'images/dog3.jpg'];
const stars = ['images/star1.jpg', 'images/star2.jpg', 'images/star3.jpg'];

const image1 = document.getElementById("image1");
const image2 = document.getElementById("image2");
const image3 = document.getElementById("image3");

const imageCounter = document.getElementById("imageCounter");
let timerInput = document.getElementById("timer_input");
const countDown = document.getElementById("countDown");
const manualRefresh = document.getElementById('reset_timer');

let timeInSeconds = 0;
let imageUpdater = 0;

function displayRandomImages() {

    // get random elements taking math.random() from 0 to the length of list and converting floating point to integers
    image1.src = cats[Math.floor(Math.random() * cats.length)];
    image2.src = dogs[Math.floor(Math.random() * dogs.length)];
    image3.src = stars[Math.floor(Math.random() * stars.length)];
    
    // update image counter by 3
    imageUpdater = imageUpdater + 3;
    imageCounter.textContent = `Images updated by ${imageUpdater}`;
}

function startCountDown() {
    timeInSeconds = timerInput.value / 1000;
    
    countDownIntervalId = setInterval(function() {
        timeInSeconds--;

        if (timeInSeconds > 0) {
            countDown.textContent = `${timeInSeconds} seconds`;
        } else {
            countDown.textContent = '0 seconds';
            displayRandomImages();
            timeInSeconds = timerInput.value / 1000;
        }
    }, 1000);   
    
    setInterval(function() {
        const randomColor = '#' + Math.floor(Math.random()*16777215).toString(16);
        countDown.style.backgroundColor = randomColor;
      }, timeInSeconds/3 * 1000);
}

manualRefresh.addEventListener('click', () => {
    timeInSeconds = timerInput.value / 1000;
    displayRandomImages(); 
});

image1.addEventListener('click', () => {

})

displayRandomImages();
startCountDown();
});