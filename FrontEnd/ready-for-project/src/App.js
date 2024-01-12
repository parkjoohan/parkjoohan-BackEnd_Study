import "./App.css";
import dummy from "./data.json";
import mapping from "./mapping.js";

function App() {
  const makeLi = (dummy) => {
    dummy.map((a, a1) => <li key={a1}></li>);
  };

  return (
    <div>
      <h3 id="title">프로젝트 1</h3>
      <ul id="list_top"></ul>
    </div>
  );
}

export default App;
