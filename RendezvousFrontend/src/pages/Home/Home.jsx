import { React, useContext, useEffect } from "react";
import AppContext from "../../context/app-context";
import Authenticated from "./Authenticated";
import Unauthenticated from "./Unauthenticated";
import "../Pages.css";
import "./Home.css";

const Home = () => {
  const appContext = useContext(AppContext);

  useEffect(() => {}, [appContext.isLoggedIn]);

  return (
    <div
      className={`home page ${appContext.isLoggedIn ? "home-loggedIn" : ""}`}
    >
      {appContext.isLoggedIn ? <Authenticated /> : <Unauthenticated />}
    </div>
  );
};

export default Home;
