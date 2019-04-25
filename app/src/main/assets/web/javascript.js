window.androidObj = function AndroidClass(){};

var textContainer = document.createElement("p");
var nativeText = document.createTextNode("Android Text");
textContainer.appendChild(nativeText);

var inputContainer = document.createElement("p");
var input = document.createElement("INPUT");
input.setAttribute("type", "text");
inputContainer.appendChild(input);

var buttonContainer = document.createElement("p");
var button = document.createElement("button");
button.innerHTML = "this is webview";
button.style.width = "150px";
button.style.height = "30px";
button.addEventListener ("click", function() {
  window.androidObj.textToAndroid(input.value);
});
buttonContainer.appendChild(button);

var buttonContainer2 = document.createElement("p");
var button2 = document.createElement("button");
button2.innerHTML = "move to 2ndpage";
button2.style.width = "150px";
button2.style.height = "30px";
button2.addEventListener ("click", function() {
  document.location.href = "file:///android_asset/web/test2.html";
});
buttonContainer2.appendChild(button2);

document.body.appendChild(textContainer);
document.body.appendChild(inputContainer);
document.body.appendChild(buttonContainer);
document.body.appendChild(buttonContainer2);

function updateFromAndroid(message){
    nativeText.nodeValue = message;
}
