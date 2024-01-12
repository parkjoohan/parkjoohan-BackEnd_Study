import "./App.css";
import $ from "jquery";
import dummy from "./data.json";
import mapping from "./mapping.js";

const datas = dummy;

function makeLi() {
  $(".title").on("click", function () {
    datas.map((a, a1) =>
      $(".list_top").before("<li key={a1}>`(${ a[0] })`</li>")
    );
  });
}

function App() {
  return (
    <div>
      <h3 className="title" onClick={makeLi}>
        프로젝트 1
      </h3>
      <ul className="list_top"></ul>
    </div>
  );
}

export default App;
