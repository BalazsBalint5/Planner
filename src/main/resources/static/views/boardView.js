"use strict";

class BoardView {
  #columnFormAddBtn = document.querySelectorAll(".create-form__button");
  #activeForm;

  constructor() {
    this.#columnFormAddBtn.forEach((btn) => {
      btn.addEventListener("click", (e) => {
        const textarea = btn.parentElement.previousElementSibling;
        e.preventDefault();
        if (textarea.value.trim().length > 0) {
          this.createCardElement(textarea.value, textarea.dataset.cardType);
        }
      });
    });
  }

  createCardElement(cardLabel, cardType) {
    const cardList = this.#getElementList(cardType);

    cardList.insertAdjacentHTML(
      "beforeend",
      this.#generateCardElement(cardLabel, cardType)
    );

    this.switchFormAndButton(cardType);
  }

  #generateCardElement(cardLabel, cardType) {
    return `<li class="card-element card-element--${cardType}">
              <p class="card-element__text">${cardLabel}</p>
              <p class="card-element__date">${
                new Date().toISOString().split("T")[0]
              }</p>
          </li>`;
  }

  #getElementList(cardType) {
    return document.querySelector(
      `.card-column__card-elements[data-list-type="${cardType}"]`
    );
  }

  switchFormAndButton(cardType) {
    if (this.#activeForm === undefined) {
      this.#toggleForm(cardType);
      this.#activeForm = cardType;
    } else {
      this.#toggleForm(this.#activeForm);
      this.#activeForm = cardType;
      this.#toggleForm(cardType);
    }
  }

  #toggleForm(cardType) {
    document
      .querySelector(`.card-column__create-form[data-form-type="${cardType}"]`)
      .classList.toggle("hidden");

    document.querySelector(
      `.create-form__textarea[data-card-type="${cardType}"]`
    ).value = "";

    document
      .querySelector(
        `.card-column__open-form-button[data-column-add-button="${cardType}"]`
      )
      .classList.toggle("hidden");
  }
  addHandlerCreateCard() {}
}

export default new BoardView();
