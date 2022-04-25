import { React, useContext, useEffect } from "react";
import AppContext from "../../context/app-context";
import "./Main.css";

const Main = () => {
  const appContext = useContext(AppContext);

  useEffect(() => {}, [appContext]);

  return (
    <main className="main">
      <div className="main-card">
        <section className="user-info"></section>
      </div>
    </main>
  );
};

export default Main;
