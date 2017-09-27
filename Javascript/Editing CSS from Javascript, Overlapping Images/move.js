var y_pos = document.getElementById('block').style.bottom;

function makeYellow() {
    var elem = document.getElementById('block');
    elem.style.background = 'Yellow';
}

function makeRed() {
    var elem = document.getElementById('block');
    elem.style.background = "Red"
}

function moveUp() {
    var elem = document.getElementById('block');
    elem.style.bottom = 90;
}

function moveDown() {
    var elem = document.getElementById('block');
    elem.style.bottom = 70;
}
