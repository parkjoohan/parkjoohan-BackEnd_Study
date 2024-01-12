import dummy from "./data.json";
import $ from "jquery";

function makeLi() {
  $(".title").on("click", function (e) {
    console.log(dummy);
  });
}

export default makeLi;
