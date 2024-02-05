"use strict mode";

const testAPi = function () {
  fetch("http://localhost:8080/api/tasks")
    .then(function (response) {
      return response.json();
    })
    .then(function (data) {
      console.log(data);
    });
};

testAPi();
