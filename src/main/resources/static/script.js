import boardView from "./views/boardView.js";

const openColumnFormBtn = document.querySelectorAll(
  ".card-column__open-form-button"
);

const init = function () {
  openColumnFormBtn.forEach((btn) => {
    btn.addEventListener("click", function () {
      boardView.switchFormAndButton(btn.dataset.columnAddButton);
    });
  });
};

init();
