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

/*     fetch("http://localhost:8080/api/tasks", {
      method: "POST",
      body: JSON.stringify({
        taskLabel: taskLabel,
      }),
      headers: {
        "Content-type": "application/json; charset=UTF-8",
      },
    }); */
