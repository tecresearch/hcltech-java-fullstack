let btn = document.querySelector("#btn");
let content = document.querySelector("#content");
let vgif = document.querySelector("#voice");

const speak = (text) => {
    let text_speak = new SpeechSynthesisUtterance(text);
    window.speechSynthesis.speak(text_speak);
};
