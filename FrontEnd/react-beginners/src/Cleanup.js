import { useEffect, useState } from "react";

function Cleanup() {
    const [showing, setShowing] = useState(false);
    const onClick = () => setShowing((prev) => !prev);

    function Hello() {
        useEffect(() => { 
            console.log("created :)");
            return () => console.log("destroyed :(");
        }, [])
        return <h1>Hello</h1>
    }

    return (
        <div>
            {showing ? <Hello /> : null}
            <button onClick={onClick}>{ showing ? "Hide" : "Show" }</button>
        </div>
    );
}

export default Cleanup;