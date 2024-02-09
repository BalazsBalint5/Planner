"use strict mode";

const taskColumn = document.querySelector(".task-column");
const addTaskBtns = document.querySelectorAll(".task-column__add-button");
const inputContainers = document.querySelectorAll(
  ".task-column-input-container"
);

let activeInputContainer;
let hiddenAddButton;
let activeTextarea;

const testAPi = function () {
  fetch("http://localhost:8080/api/tasks")
    .then(function (response) {
      return response.json();
    })
    .then(function (data) {
      console.log(data);
    });
};

//testAPi();

const toggleButtonAndInputContainer = function (inputContainer, button) {
  inputContainer.classList.toggle("hidden");
  button.classList.toggle("hidden");
};

const switchActiveInputContainer = function (event) {
  if (hiddenAddButton === undefined) {
    hiddenAddButton = event.target;
    activeInputContainer = hiddenAddButton.previousElementSibling;

    toggleButtonAndInputContainer(hiddenAddButton, activeInputContainer);
  } else if (event.target !== hiddenAddButton) {
    toggleButtonAndInputContainer(hiddenAddButton, activeInputContainer);
    hiddenAddButton = event.target;
    activeInputContainer.firstElementChild.value = "";
    activeInputContainer = hiddenAddButton.previousElementSibling;

    toggleButtonAndInputContainer(hiddenAddButton, activeInputContainer);
  }
};

const closeActiveInputContainer = function (event) {
  if (
    !activeInputContainer.contains(event.target) &&
    hiddenAddButton !== undefined
  ) {
    toggleButtonAndInputContainer(activeInputContainer, hiddenAddButton);
    activeInputContainer.firstElementChild.value = "";
    activeInputContainer = undefined;
    hiddenAddButton = undefined;
  }
};

const init = function () {
  addTaskBtns.forEach((btn) => {
    btn.addEventListener("click", function (e) {
      switchActiveInputContainer(e);
    });
  });
};

init();

document.addEventListener("click", function (e) {
  if (
    hiddenAddButton !== undefined &&
    e.target !== activeInputContainer &&
    e.target !== hiddenAddButton
  ) {
    closeActiveInputContainer(e);
  }
});
