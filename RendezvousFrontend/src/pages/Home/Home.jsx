import { React, useContext, useEffect } from "react";
import AppContext from "../../context/app-context";
import "../Pages.css";
import "./Home.css";
import Authenticated from "./Authenticated";
import Unauthenticated from "./Unauthenticated";

const Home = () => {
  const appContext = useContext(AppContext);

  useEffect(() => {}, [appContext]);

  return (
    <div className="home page">
      {appContext.isLoggedIn ? <Authenticated /> : <Unauthenticated />}
    </div>
  );
};

export default Home;
